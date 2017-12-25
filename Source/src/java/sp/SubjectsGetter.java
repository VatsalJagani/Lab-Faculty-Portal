/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp;

import gen.Subject;
import hibernate.HibernateUtil;
import hibernate.pojos.SemesterWiseSubjects;
import hibernate.pojos.SubjectsMaster;
import java.util.*;
import javax.servlet.ServletContext;
import org.hibernate.Query;
import org.hibernate.Session;

public class SubjectsGetter {

    private LinkedHashMap<String, ArrayList<Subject>> subjectsMap;
    String whichSem;
    ServletContext sc;
    Session session;

    public SubjectsGetter(ServletContext sc) {
        this.sc = sc;
    }

    public SubjectsGetter(String sem, ServletContext sc) {

        this(sc);
        whichSem = sem;
    }

    public LinkedHashMap fetchSubjects(int depID) {

        if (whichSem == null) {
            whichSem = (new SubjectPreferenceSettingsInfo(sc)).getCurrentSettings(depID);
        }

        if (!whichSem.equalsIgnoreCase("null")) {
            subjectsMap = new LinkedHashMap();
            ArrayList<Subject> subjects = new ArrayList();
            ArrayList<Integer> semesters = new ArrayList();
            int remainder = 0;

            //System.out.println("SemType = " + whichSem);
            if (whichSem.equalsIgnoreCase("Odd")) {
                remainder = 1;
            } else {
                remainder = 0;
            }

            try {
                int status = 1;
                //rs = stmt.executeQuery("select * from semester_wise_subjects where SemNo % 2= " + remainder);
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("From SemesterWiseSubjects where semNo % 2 = :rem");
                query.setParameter("rem", remainder);
                List<SemesterWiseSubjects> l = query.list();

                for (SemesterWiseSubjects rs : l) {
                    Subject sub = new Subject();
                    sub.setSubId(rs.getId().getSubId());
                    sub.setOffered(rs.getOffered());
                    sub.setSemester(rs.getSemNo());
                    subjects.add(sub);
                }
                for (int i = 0; i < subjects.size(); i++) {
                    Subject s = subjects.get(i);
                    int id = s.getSubId();
                    //rs = stmt.executeQuery("select * from subjects_master where SubID= " + id);
                    SubjectsMaster sm = (SubjectsMaster) session.get(SubjectsMaster.class, id);

                    if (sm != null) {
                        s.setSubName(sm.getSubName().trim());
                        s.setSubShortName(sm.getSubShortName().trim());
                        s.setSubCode(sm.getSubCode());
                    }
                    subjects.set(i, s);

                }
            } catch (Exception e) {
                System.out.println(e);
            }

            //System.out.println(subjects);
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("From SemesterWiseSubjects where semNo % 2 = :rem GROUP BY semNo");
                query.setParameter("rem", remainder);
                List<SemesterWiseSubjects> l = query.list();
                //rs = stmt.executeQuery("select distinct SemNo from semester_wise_subjects where SemNo % 2= " + remainder);

                for (SemesterWiseSubjects ss : l) {
                    semesters.add(ss.getSemNo());
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                session.close();
            }

            for (int j = 0; j < semesters.size(); j++) {
                String semName = null;
                ArrayList<Subject> semSubjects = new ArrayList();
                int semNo = semesters.get(j);

                if (semNo == 9 || semNo == 10) {
                    semName = "M.Tech. " + (semNo - 8);
                } else {
                    semName = "B.Tech. " + semNo;
                }
                //System.out.print(semName+"::");
                for (Subject s : subjects) {

                    if (s.getSemester() == semNo) {
                        semSubjects.add(s);
                        //System.out.print(s.getSubCode());
                    }
                }
                //System.out.println();
                subjectsMap.put(semName, semSubjects);
            }
        }

        return subjectsMap;
    }

    public ArrayList getAllSubjects(int depID) {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        LinkedHashMap<Integer, ArrayList<Subject>> hm = fetchSubjects(depID);
        for (Map.Entry<Integer, ArrayList<Subject>> entry : hm.entrySet()) {
            ArrayList<Subject> value = entry.getValue();
            subjects.addAll(value);
        }
        return subjects;
    }
}

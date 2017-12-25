/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp;

import hibernate.HibernateUtil;
import hibernate.pojos.SemesterWiseSubjects;
import hibernate.pojos.SlotPreference;
import hibernate.pojos.SubjectPreferenceSettings;
import hibernate.pojos.SubjectPreferences;
import hibernate.pojos.SubjectPreferencesId;
import hibernate.pojos.SubjectsMaster;
import hibernate.pojos.Users;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class SubjectPreferenceSettingsInfo {

    ServletContext sc = null;
    Session session;

    public SubjectPreferenceSettingsInfo(ServletContext sc) {
        this.sc = sc;
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public String getCurrentSettings(int depID) {
        String sem = null;
        if (session != null) {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                SubjectPreferenceSettings rs = (SubjectPreferenceSettings) session.get(SubjectPreferenceSettings.class, depID);
                //rs = stmt.executeQuery("select * from subject_preference_settings where Status=1");

                if (rs != null) {
                    sem = rs.getSemType();
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                session.close();
            }
        }
        return sem;
    }

    public ArrayList<Integer> getSelectedSubjectIds(int userId) {
        ArrayList<Integer> subIds = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from SubjectPreferences where userID=:userID");
            query.setParameter("userID", userId);
            List<SubjectPreferences> list = query.list();
            //ResultSet rs = stmt.executeQuery("select SubName from subjects_master where SubID in (select SubID from subject_preferences where UserID=" + userId + ")");
            subIds = new ArrayList<Integer>();
            for (SubjectPreferences sp : list) {
                subIds.add(sp.getId().getSubId());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return subIds;
    }

    public ArrayList<SubjectsMaster> getSelectedSubjects(int userId) {
        ArrayList<SubjectsMaster> subjects = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from SubjectsMaster where subID in (select id.subId from SubjectPreferences where userID=:userID)");
            query.setParameter("userID", userId);
            List<SubjectsMaster> list = query.list();
            //ResultSet rs = stmt.executeQuery("select SubName from subjects_master where SubID in (select SubID from subject_preferences where UserID=" + userId + ")");
            subjects = new ArrayList<SubjectsMaster>(list);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return subjects;
    }

    public LinkedHashMap<String, ArrayList<String>> getTheList(String reportType, int depId) {
        LinkedHashMap<String, ArrayList<String>> listMap = new LinkedHashMap<String, ArrayList<String>>();
        int remainder = -1;
        String semType = null;

        try {
            semType = getCurrentSettings(depId);
            if (semType != null) {
                if (semType.equalsIgnoreCase("Odd")) {
                    remainder = 1;
                } else if (semType.equalsIgnoreCase("Even")) {
                    remainder = 0;
                } else {
                    remainder = 5; /* for closed module any random no. */

                }

                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                //System.out.println(remainder);
                if (reportType.equalsIgnoreCase("sub")) {
                    Criteria cr = session.createCriteria(SubjectsMaster.class);
                    List<SubjectsMaster> sl = cr.list();
                    List<SubjectsMaster> subjectList = new ArrayList<SubjectsMaster>();
                    for (SubjectsMaster sm : sl) {
                        Query query = session.createQuery("from SemesterWiseSubjects where subID=:subID");
                        query.setParameter("subID", sm.getSubId());
                        List<SemesterWiseSubjects> sws = query.list();
                        if (sws != null) {
                            SemesterWiseSubjects s = (SemesterWiseSubjects) sws.get(0);
                            if (s != null) {
                                if (s.getOffered() == 1 && s.getSemNo() % 2 == remainder) {
                                    subjectList.add(sm);
                                }
                            }
                        }
                    }
                    for (SubjectsMaster sm : subjectList) {
                        ArrayList<String> userList = new ArrayList<String>();
                        Query query = session.createQuery("from SubjectPreferences where subID=:subID");
                        query.setParameter("subID", sm.getSubId());
                        List<SubjectPreferences> spList = query.list();
                        for (SubjectPreferences sp : spList) {
                            Criteria cr1 = session.createCriteria(Users.class);
                            cr1.add(Restrictions.eq("userId", sp.getId().getUserId()));
                            Users u = null;
                            try {
                                u = (Users) cr1.list().get(0);
                            } catch (Exception e) {
                                // no user found
                            }

                            if (u != null) {
                                userList.add(u.getInitials());
                            }
                        }
                        if (userList.isEmpty()) {
                            userList.add("---");
                        }
                        listMap.put(sm.getSubShortName(), userList);
                    }

                } else if (reportType.equalsIgnoreCase("faculty")) {
                    Criteria cr = session.createCriteria(Users.class);
                    List<Users> ul = cr.list();
                    List<Users> userList = new ArrayList<Users>();
                    for (Users u : ul) {
                        Query query = session.createQuery("from SubjectPreferences where userID=:userID");
                        query.setParameter("userID", u.getUserId());
                        List<SubjectPreferences> spList = query.list();
                        ArrayList<String> subjectList = new ArrayList<String>();
                        for (SubjectPreferences sp : spList) {
                            Query q = session.createQuery("from SemesterWiseSubjects where subID=:subID");
                            q.setParameter("subID", sp.getId().getSubId());
                            List<SemesterWiseSubjects> sws = q.list();
                            if (sws != null) {
                                SemesterWiseSubjects s = (SemesterWiseSubjects) sws.get(0);
                                if (s != null) {
                                    if (s.getOffered() == 1 && s.getSemNo() % 2 == remainder) {
                                        subjectList.add(((SubjectsMaster) session.get(SubjectsMaster.class, s.getId().getSubId())).getSubShortName());
                                    }
                                }
                            }
                        }
                        if (subjectList.isEmpty()) {
                            subjectList.add("---");
                        }
                        listMap.put(u.getInitials(), subjectList);
                    }
                } else if (reportType.equalsIgnoreCase("slot")) {
                    Query query = session.createQuery("select SP.slot from SlotPreference SP group by SP.slot");
                    List<String> slotList = query.list();
                    for (String sp : slotList) {
                        //System.out.print(sp+": ");
                        Query q = session.createQuery("select SP.userId from SlotPreference SP where SP.slot=:slot");
                        q.setParameter("slot", sp);
                        List<Integer> userList = q.list();
                        //System.out.println(userList);
                        ArrayList<String> users = new ArrayList<String>();
                        for (Integer user : userList) {
                            Criteria cr1 = session.createCriteria(Users.class);
                            cr1.add(Restrictions.eq("userId", user));
                            Users u = null;
                            try {
                                u = (Users) cr1.list().get(0);
                            } catch (Exception e) {
                                // no user found
                            }

                            if (u != null) {
                                users.add(u.getInitials());
                            }
                        }
                        if (users.isEmpty()) {
                            users.add("---");
                        }
                        listMap.put(sp, users);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }
        //System.out.println(listMap);
        return listMap;
    }

    public String getSlotPreference(int userID) {
        String slot = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            SlotPreference rs = (SlotPreference) session.get(SlotPreference.class, userID);
            //ResultSet rs = stmt.executeQuery("select Slot from slot_preference where UserID="+userID);
            if (rs != null) {
                slot = rs.getSlot();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return slot;
    }

    public boolean updatePreference(String[] selectedSubjects, int userID, String slotPreference) {
        Transaction tr = null;
        boolean flag = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();

            Query q = session.createQuery("delete SubjectPreferences where userID=:userID");
            q.setParameter("userID", userID);
            q.executeUpdate();

            for (String subjectId : selectedSubjects) {
                SubjectPreferences sp = new SubjectPreferences(new SubjectPreferencesId(userID, Integer.parseInt(subjectId)));
                session.save(sp);
            }

            SlotPreference sp = (SlotPreference) session.get(SlotPreference.class, userID);
            sp.setSlot(slotPreference);
            session.saveOrUpdate(sp);
            flag = true;

        } catch (Exception e) {
            System.out.println("While Updating SP:" + e.getMessage());
        } finally {
            tr.commit();
            session.close();
        }
        return flag;
    }
}

/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import hibernate.pojos.EmpLeaveRequest;
import hibernate.pojos.LeaveInfo;
import hibernate.pojos.LoadArrangement;
import hibernate.pojos.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class LoadArrangementRequest {
    private LoadArrangement loadArrangement;
    private String facultyName;
    private String leaveType;
    
    public LoadArrangementRequest(LoadArrangement l,Session sess){
        loadArrangement=l;
        EmpLeaveRequest emp = (EmpLeaveRequest) sess.get(EmpLeaveRequest.class, l.getId().getEmpLeaveId());
        // facultyName
        Criteria cr = sess.createCriteria(Users.class);
        cr.add(Restrictions.eq("userId", emp.getUserId()));
        Users u = (Users) cr.list().get(0);
        if(u!=null){
            facultyName=u.getInitials();
        }
        // leave type
        LeaveInfo lInfo=(LeaveInfo) sess.get(LeaveInfo.class, emp.getLeaveType());
        leaveType=lInfo.getLeaveName();
    }
    
    public LoadArrangement getLoadArrangement(){
        return loadArrangement;
    }
    
    public String getFacultyName(){
        return facultyName;
    }
    
    public String getLeaveType(){
        return leaveType;
    }
}

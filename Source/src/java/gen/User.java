/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import gen.security.MyDigest;
import hibernate.HibernateUtil;
import hibernate.pojos.Employees;
import hibernate.pojos.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class User {
    
    private int userID;
    private int depID;
    private String userName;
    private String userType;
    private String gender;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }    
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }    
    
    // Original
    public boolean verify(String uname, String password)
    {
        boolean result = false;
        Session session = null;
        
        try {
           
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria cr=session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userName", uname));
            Users u=null;
            try{
                u=(Users) cr.list().get(0);
            }
            catch(Exception e){
                // no user found
            }
            
            if(u!=null){
                String pass = u.getPassword();
                MyDigest md = new MyDigest();
                
                if (md.verifyPassword(password, pass)) {
                    result = true;   
                    this.userID=u.getUserId();
                    this.userType=u.getUserType();
                }
            }
            if(result)
            {
                Employees e=(Employees) session.get(Employees.class, this.userID);
                if(e!=null){
                    String fname = e.getFirstName();
                    String lname = e.getLastName();
                    String name = fname+" "+lname;
                    this.depID=e.getDepId();
                    if (name != null) {
                        this.userName = name;
                    }
                    this.gender=e.getGender();
                }
            }
            
           
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            
        }
        return result;
    }
}
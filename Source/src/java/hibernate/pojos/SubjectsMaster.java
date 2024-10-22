package hibernate.pojos;
// Generated Mar 22, 2017 6:14:24 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SubjectsMaster generated by hbm2java
 */
@Entity
@Table(name="subjects_master"
    ,catalog="faculty_portal"
)
public class SubjectsMaster  implements java.io.Serializable {


     private Integer subId;
     private String subName;
     private String subCode;
     private String subShortName;

    public SubjectsMaster() {
    }

	
    public SubjectsMaster(String subName, String subShortName) {
        this.subName = subName;
        this.subShortName = subShortName;
    }
    public SubjectsMaster(String subName, String subCode, String subShortName) {
       this.subName = subName;
       this.subCode = subCode;
       this.subShortName = subShortName;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="SubID", unique=true, nullable=false)
    public Integer getSubId() {
        return this.subId;
    }
    
    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    
    @Column(name="SubName", nullable=false, length=50)
    public String getSubName() {
        return this.subName;
    }
    
    public void setSubName(String subName) {
        this.subName = subName;
    }

    
    @Column(name="SubCode", length=10)
    public String getSubCode() {
        return this.subCode;
    }
    
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    
    @Column(name="SubShortName", nullable=false, length=15)
    public String getSubShortName() {
        return this.subShortName;
    }
    
    public void setSubShortName(String subShortName) {
        this.subShortName = subShortName;
    }




}



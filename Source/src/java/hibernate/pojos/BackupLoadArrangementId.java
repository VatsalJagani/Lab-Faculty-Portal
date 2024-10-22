package hibernate.pojos;
// Generated Mar 22, 2017 6:14:24 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BackupLoadArrangementId generated by hbm2java
 */
@Embeddable
public class BackupLoadArrangementId  implements java.io.Serializable {


     private String year;
     private int empLeaveId;
     private Date date;
     private String time;

    public BackupLoadArrangementId() {
    }

    public BackupLoadArrangementId(String year, int empLeaveId, Date date, String time) {
       this.year = year;
       this.empLeaveId = empLeaveId;
       this.date = date;
       this.time = time;
    }
   


    @Column(name="Year", nullable=false, length=10)
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }


    @Column(name="EmpLeaveID", nullable=false)
    public int getEmpLeaveId() {
        return this.empLeaveId;
    }
    
    public void setEmpLeaveId(int empLeaveId) {
        this.empLeaveId = empLeaveId;
    }


    @Column(name="Date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }


    @Column(name="Time", nullable=false, length=10)
    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BackupLoadArrangementId) ) return false;
		 BackupLoadArrangementId castOther = ( BackupLoadArrangementId ) other; 
         
		 return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && (this.getEmpLeaveId()==castOther.getEmpLeaveId())
 && ( (this.getDate()==castOther.getDate()) || ( this.getDate()!=null && castOther.getDate()!=null && this.getDate().equals(castOther.getDate()) ) )
 && ( (this.getTime()==castOther.getTime()) || ( this.getTime()!=null && castOther.getTime()!=null && this.getTime().equals(castOther.getTime()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
         result = 37 * result + this.getEmpLeaveId();
         result = 37 * result + ( getDate() == null ? 0 : this.getDate().hashCode() );
         result = 37 * result + ( getTime() == null ? 0 : this.getTime().hashCode() );
         return result;
   }   


}



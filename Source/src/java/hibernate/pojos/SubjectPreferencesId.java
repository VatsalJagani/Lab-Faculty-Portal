package hibernate.pojos;
// Generated Mar 22, 2017 6:14:24 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubjectPreferencesId generated by hbm2java
 */
@Embeddable
public class SubjectPreferencesId  implements java.io.Serializable {


     private int userId;
     private int subId;

    public SubjectPreferencesId() {
    }

    public SubjectPreferencesId(int userId, int subId) {
       this.userId = userId;
       this.subId = subId;
    }
   


    @Column(name="UserID", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name="SubID", nullable=false)
    public int getSubId() {
        return this.subId;
    }
    
    public void setSubId(int subId) {
        this.subId = subId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SubjectPreferencesId) ) return false;
		 SubjectPreferencesId castOther = ( SubjectPreferencesId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && (this.getSubId()==castOther.getSubId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + this.getSubId();
         return result;
   }   


}



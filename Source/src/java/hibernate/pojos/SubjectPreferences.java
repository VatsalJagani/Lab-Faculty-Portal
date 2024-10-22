package hibernate.pojos;
// Generated Mar 22, 2017 6:14:24 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SubjectPreferences generated by hbm2java
 */
@Entity
@Table(name="subject_preferences"
    ,catalog="faculty_portal"
)
public class SubjectPreferences  implements java.io.Serializable {


     private SubjectPreferencesId id;

    public SubjectPreferences() {
    }

    public SubjectPreferences(SubjectPreferencesId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="userId", column=@Column(name="UserID", nullable=false) ), 
        @AttributeOverride(name="subId", column=@Column(name="SubID", nullable=false) ) } )
    public SubjectPreferencesId getId() {
        return this.id;
    }
    
    public void setId(SubjectPreferencesId id) {
        this.id = id;
    }




}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

public class Subject {
      
    private int subId;
    private String subName;
    private String subCode;
    private String subShortName;
    private int semester;
    private int offered;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
    
    public String getSubShortName() {
        return subShortName;
    }

    public void setSubShortName(String subShortName) {
        this.subShortName = subShortName;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getOffered() {
        return offered;
    }

    public void setOffered(int offered) {
        this.offered = offered;
    }
    
    @Override
    public String toString()
    {
        return this.subName;
    }
}

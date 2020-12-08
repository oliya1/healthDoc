/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicico.model;

import nicico.utility.Common;

/**
 *
 * @author Hamed
 */
public class Sick {
    private String fname;
    private String lname;
    private Integer personnelNo;
    private String nationalCode;
    private String createBy;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getPersonnelNo() {
        return personnelNo;
    }

    public void setPersonnelNo(Integer personnelNo) {
        this.personnelNo = personnelNo;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCreateBy() {
        return createBy;
    }
    
    public Sick(String fname, String lname, Integer personnelNo, String nationalCode) {
        this.fname = fname;
        this.lname = lname;
        this.personnelNo = personnelNo;
        this.nationalCode = nationalCode;
        this.createBy = Common.getLoginedUserName();
    }

    public Sick() {
    }    
}

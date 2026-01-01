package com.klu.model;

import javax.persistence.*;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptid;

    private String deptname;   // ✅ changed to String

    public int getDeptId() {
        return deptid;
    }

    public void setDeptId(int deptid) {
        this.deptid = deptid;
    }

   
    public String getDeptName() {
        return deptname;
    }

    public void setDeptName(String deptname) {
        this.deptname = deptname;
    }
}
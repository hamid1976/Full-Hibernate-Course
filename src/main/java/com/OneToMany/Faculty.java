package com.OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Faculty {
    @Id
    private int facId;
    private String faculty;

    @OneToMany(mappedBy = "faculty")
    private List<Department1> department;

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }




    public List<Department1> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department1> department) {
        this.department = department;
    }
    public Faculty(){
        super();
    }
    public Faculty(int facId, String faculty, List<Department1> department) {
        super();
        this.facId = facId;
        this.faculty = faculty;
        this.department = department;
    }
}

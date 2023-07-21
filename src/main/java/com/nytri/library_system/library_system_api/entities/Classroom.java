package com.nytri.library_system.library_system_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @Column(name = "classroom_id", nullable = false)
    private Integer id;

    @Column(name = "section_name", length = 48)
    private String sectionName;

    @OneToOne
    @JoinColumn(name = "adviser")
    private Employee adviser;

    @OneToOne(mappedBy = "classroom")
    private Student studentClassroom;

    public Employee getAdviser() {
        return adviser;
    }

    public void setStudentClassroom(Student studentClassroom) {
        this.studentClassroom = studentClassroom;
    }

    public void setAdviser(Employee adviser) {
        this.adviser = adviser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

}
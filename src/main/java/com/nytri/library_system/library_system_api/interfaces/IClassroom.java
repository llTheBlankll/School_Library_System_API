package com.nytri.library_system.library_system_api.interfaces;

import com.nytri.library_system.library_system_api.entities.Classroom;

import java.util.List;

public interface IClassroom {
    void addClassroom(Classroom classroom);
    void updateClassroom(Classroom classroom);
    void deleteClassroom(Classroom classroom);
    List<Classroom> searchClassroomBySectionName(String sectionName);
    List<Classroom> searchClassroomByAdviserFirstName(String adviserFirstName);
    List<Classroom> searchClassroomByAdviserLastName(String adviserLastName);
    List<Classroom> searchClassroomAdviserByEmailAddress(String emailAddress);
    Classroom getClassroomById(Integer classroomId);
    List<Classroom> getAllClassrooms();
}

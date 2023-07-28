package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Classroom;
import com.nytri.library_system.library_system_api.interfaces.IClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import com.nytri.library_system.library_system_api.repository.ClassroomRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ClassroomService implements IClassroom {

    private final ClassroomRepository classroomRepository;
    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        Assert.notNull(classroomRepository, "ClassroomRepository must not be null");
        this.classroomRepository = classroomRepository;
    }

    public boolean process(Classroom classroom) {
        // Returns true if it is Empty, false otherwise.
        return classroom.getSectionName().isEmpty();
    }

    @Override
    public List<Classroom> searchClassroomBySectionName(String sectionName) {
        return classroomRepository.findBySectionNameContains(sectionName);
    }

    @Override
    public List<Classroom> searchClassroomByAdviserFirstName(String adviserFirstName) {
        return classroomRepository.findByAdviserFirstName(adviserFirstName);
    }

    @Override
    public List<Classroom> searchClassroomByAdviserLastName(String adviserLastName) {
        return classroomRepository.findByAdviserLastName(adviserLastName);
    }

    @Override
    public List<Classroom> searchClassroomAdviserByEmailAddress(String emailAddress) {
        return classroomRepository.findByAdviserEmail(emailAddress);
    }

    @Override
    public void addClassroom(Classroom classroom) {
        if (this.process(classroom)) {
            classroomRepository.save(classroom);
        }
    }

    @Override
    public void updateClassroom(Classroom classroom) {
        if (this.process(classroom)) {
            classroomRepository.save(classroom);
        }
    }

    @Override
    public void deleteClassroom(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    @Override
    public Classroom getClassroomById(Integer classroomId) {
        return classroomRepository.findById(classroomId).orElse(new Classroom());
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
}

package com.nytri.library_system.library_system_api.services;

import com.nytri.library_system.library_system_api.entities.Classroom;
import com.nytri.library_system.library_system_api.interfaces.IClassroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.nytri.library_system.library_system_api.repository.ClassroomRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ClassroomService implements IClassroom {

    private final Logger logger = LoggerFactory.getLogger(ClassroomService.class);
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
    public Classroom getClassroomById(Integer classroom_id) {
        return classroomRepository.findById(classroom_id).orElse(new Classroom());
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
}

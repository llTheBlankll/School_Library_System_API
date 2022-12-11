package com.nytri.library_system.library_system_api.controllers;


import com.nytri.library_system.library_system_api.entities.Classroom;
import com.nytri.library_system.library_system_api.repository.ClassroomRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/administrator/classrooms")
@RestController
public class ClassroomController {

    private final ClassroomRepository classroomRepository;

    public ClassroomController ( ClassroomRepository classroomRepository ) {
        this.classroomRepository = classroomRepository;
    }


    @GetMapping("/all")
    public List<Classroom> getAll() {
        return this.classroomRepository.findAll();
    }


}

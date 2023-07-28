package com.nytri.library_system.library_system_api.controllers.librarian;

import com.nytri.library_system.library_system_api.entities.Classroom;
import com.nytri.library_system.library_system_api.services.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api_v1/librarian/classrooms")
public class ClassroomsController {

    private final Logger logger = LoggerFactory.getLogger(ClassroomsController.class);
    private final ClassroomService classroomService;

    @Autowired
    public ClassroomsController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @PutMapping("/add")
    public void addClassroom(@RequestBody Classroom classroom) {
        classroomService.addClassroom(classroom);
        logger.info("Classroom " + classroom.getSectionName() + " was added successfully");
    }

    @PutMapping("/update")
    public void updateClassroom(@RequestBody Classroom classroom) {
        classroomService.updateClassroom(classroom);
        logger.info("Classroom " + classroom.getSectionName() + " was updated successfully");
    }

    @DeleteMapping("/delete")
    public void deleteClassroom(@RequestBody Classroom classroom) {
        classroomService.deleteClassroom(classroom);
        logger.info("Classroom " + classroom.getSectionName() + " was deleted successfully");
    }

    @GetMapping("/classrooms/{id}")
    public Classroom getClassroomById(@PathVariable int id) {
        return classroomService.getClassroomById(id);
    }
}

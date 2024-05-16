package org.example.studentrestapi.controller;

// StudentController.java

import org.example.studentrestapi.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    ArrayList<Student> _studentList = new ArrayList<>();

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student _student = new Student(1, "chayan", 35);
        return ResponseEntity.ok().header("custom-header","ramesh").body(_student);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudentList() {
        _studentList.add(new Student(1, "chayan", 35));
        _studentList.add(new Student(2, "John", 20));
        _studentList.add(new Student(3, "Mark", 60));
        _studentList.add(new Student(4, "Sundar", 70));
        return ResponseEntity.ok(_studentList);
    }

    // Springboot  rest api with path variable
    // URi template variable

    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudentById( @PathVariable int id) {
        Student _st= new Student(id,"chayan", 35);
        return ResponseEntity.ok(_st);
    }

    // Springboot  rest api with Multiple path variable

    @GetMapping("students/{id}/{name}/{age}")
    public  ResponseEntity<Student> getStudentByMultiplePAthVariable( @PathVariable("id") int id,@PathVariable("name") String _name, @PathVariable("age") int _age) {
        Student _st= new Student(id,_name, _age);
        return ResponseEntity.ok(_st);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return ResponseEntity.ok(student);
    }


    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentid){
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Delete student");
    }

}


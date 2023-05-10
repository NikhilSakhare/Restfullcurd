package com.RestFirstApp.RestfullCurd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestFirstApp.RestfullCurd.Service.StudentServiceI;
import com.RestFirstApp.RestfullCurd.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;

	// save Record
	@PostMapping(value ="/saveStudent", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student saveStudent = studentServiceI.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
	}

	// Save All Record
	@PostMapping(value = "/saveStudents", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Student>  saveAllStudent(@RequestBody List<Student> students) {
		Student saveAllStudent = (Student) studentServiceI.saveAllStudents(students);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAllStudent);
	}

	// Update Record
	@PutMapping(value = "/updateStudent/{rollno}", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Student> updateStudent(@PathVariable int rollno, @RequestBody Student updatedStudent) {
		Optional<Student> student = studentServiceI.getStudentByRollno(rollno);
		if (student.isPresent()) {
			updatedStudent.setRollno(rollno);
			Student savedStudent = studentServiceI.saveStudent(updatedStudent);
			return ResponseEntity.status(HttpStatus.OK).body(savedStudent);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Update All Record
	@PutMapping(value = "/updateStudents", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<List<Student>> updateAllStudents(@RequestBody List<Student> updatedStudents) {
		List<Student> savedStudents = studentServiceI.updateStudents(updatedStudents);
		return ResponseEntity.status(HttpStatus.OK).body(savedStudents);
	}

	// Get All Records
	@GetMapping(value = "/getAllStudents", produces = { "application/json" })
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = studentServiceI.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(allStudents);
	}

	// Get Record by rollno (Path Variable)
	@GetMapping(value = "/getStudentByRollno/{rollno}", produces = { "application/json" })
	public ResponseEntity<Student> getStudentByRollno(@PathVariable int rollno) {
		Optional<Student> student = studentServiceI.getStudentByRollno(rollno);
		if (student.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(student.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Get Record by rollno (Query Parameter)
	@GetMapping(value = "/getStudentByRollno", produces = {"application/json"})
    public ResponseEntity<Student> getStudentByRollnoQueryParam(@RequestParam int rollno) {
        Optional<Student> student = studentServiceI.getStudentByRollno(rollno);
        if (student.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(student.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	 //delete record by rollno
    @DeleteMapping(value="/deleteStudent/{rollno}")
    public ResponseEntity<Void> deleteStudentByRollno(@PathVariable int rollno) {
    	studentServiceI.deleteStudentByRollno(rollno);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//delete all records
    @DeleteMapping(value="/deleteAllStudents")
    public ResponseEntity<Void> deleteAllStudents() {
    	studentServiceI.deleteAllStudents();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

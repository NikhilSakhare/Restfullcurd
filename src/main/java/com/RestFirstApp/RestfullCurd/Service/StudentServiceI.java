package com.RestFirstApp.RestfullCurd.Service;

import java.util.List;
import java.util.Optional;

import com.RestFirstApp.RestfullCurd.model.Student;

public interface StudentServiceI {

	public Student saveStudent(Student student);

	public List<Student> saveAllStudents(List<Student> students);

	public List<Student> getAllStudents();

	public Optional<Student> getStudentByRollno(int rollno);

	public Optional<Student> getStudentBypathparam(int rollno);

	public Optional<Student> getStudentByQuaryParam(int rollno);

	public Student updateStudent(int rollno, Student updatedStudent);

	public List<Student> updateStudents(List<Student> updatedStudents);

	public void deleteStudentByRollno(int rollno);

	public void deleteAllStudents();
}

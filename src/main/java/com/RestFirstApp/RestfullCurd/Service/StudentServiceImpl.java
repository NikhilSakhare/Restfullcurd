package com.RestFirstApp.RestfullCurd.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestFirstApp.RestfullCurd.model.Student;
import com.RestFirstApp.RestfullCurd.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		Student save = studentRepository.save(student);
		return save;
	}

	@Override
	public List<Student> saveAllStudents(List<Student> students) {
		List<Student> saveAll = studentRepository.saveAll(students);
		return saveAll;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> findAll = studentRepository.findAll();
		return findAll;
	}

	@Override
	public Optional<Student> getStudentByRollno(int rollno) {
		Optional<Student> findById = studentRepository.findById(rollno);
		if (findById.isPresent()){
			return findById;
		}
		return findById.empty();
	}
	
	@Override
	public Optional<Student> getStudentBypathparam(int rollno) {
		Optional<Student> findById = studentRepository.findById(rollno);
		if (findById.isPresent()){
			return findById;
		}
		return findById.empty();

	}

	@Override
	public Optional<Student> getStudentByQuaryParam(int rollno) {
		Optional<Student> findById = studentRepository.findById(rollno);
		if (findById.isPresent()){
			return findById;
		}
		return findById.empty();
	}

	@Override
	public Student updateStudent(int rollno, Student updatedStudent) {
		Student student = studentRepository.save(updatedStudent);
		return student;
	}

	@Override
	public List<Student> updateStudents(List<Student> updatedStudents) {
		List<Student> saveAll = studentRepository.saveAll(updatedStudents);
		return saveAll;
	}

	@Override
	public void deleteStudentByRollno(int rollno) {

		studentRepository.deleteById(rollno);
	}

	@Override
	public void deleteAllStudents() {

		studentRepository.deleteAll();
	}

	
	
	
}

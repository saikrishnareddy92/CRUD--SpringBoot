package com.Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.dao.studentDAO;
import com.Springboot.model.student;
import com.Springboot.utils.Response;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    studentDAO studentDAO;
	@Override
	public Response addStudent(student student) {
		return studentDAO.addStudent(student);
	}
	@Override
	public List<student> list() {
		return studentDAO.list();
		
	}
	@Override
	public Response deleteStudent(int id) {
		
		return studentDAO.deleteStudent(id);
	}
	@Override
	public student getStudent(int id) {
		
		return studentDAO.getStudent(id);
	}
	@Override
	public Response updateStudent(student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

}

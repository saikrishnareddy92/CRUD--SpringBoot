package com.Springboot.service;

import java.util.List;

import com.Springboot.model.student;
import com.Springboot.utils.Response;

public interface StudentService {
	public Response addStudent(student student);
	public List<student> list();
	public Response deleteStudent(int id);
	public student getStudent(int id);
	public Response updateStudent(student student);

}

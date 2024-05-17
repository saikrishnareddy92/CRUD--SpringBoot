package com.Springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.model.student;
import com.Springboot.service.StudentService;
import com.Springboot.utils.Response;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	@SuppressWarnings("rawtypes")
	ResponseEntity responseObject = null;
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Response> addStudent( @RequestBody student student) {
		ResponseEntity<Response> responseObject = null;
		try {
			Response response = studentService.addStudent(student);
			responseObject = new ResponseEntity<Response>(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
			
		}
		catch(Exception error) {
			System.out.println(error);
			Response response = new Response();
			response.setMessage(error.getMessage());
			response.setOperation(true);
			response.setStatusCode(500);
			responseObject = new ResponseEntity<Response>(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
			
		}
		return responseObject;
		 }
	
	@GetMapping("/list")
	public ResponseEntity getStudents(){
		ResponseEntity responseObject = null;
		try {
			responseObject = new ResponseEntity<List<student>>(studentService.list(),HttpStatus.OK);
			//throw new Exception("Simulation error");
		}
		catch(Exception exception) {
			Response response = new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject = new ResponseEntity(response,HttpStatus.OK);
			System.out.println(exception);
		}
		return responseObject;
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity getStudent(@PathVariable int id){
		try {
			student student = studentService.getStudent(id);
	        responseObject =  new ResponseEntity(student,HttpStatus.OK);
			
		}catch(Exception exception) {
			Response response = new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject = new ResponseEntity(response,HttpStatus.OK);
			System.out.println(exception);
			
		}
		return responseObject;
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Response> deleteStudent(@PathVariable int id){
		try {
			System.out.println("id : "  + id);
			Response response =studentService.deleteStudent(id);
			responseObject =  new ResponseEntity<Response>(response,response.getOperation()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
			} catch(Exception exception) {
				Response response = new Response();
				response.setMessage(exception.getMessage());
				response.setOperation(false);
				response.setStatusCode(500);
				responseObject = new ResponseEntity(response,HttpStatus.OK);
				System.out.println(exception);
				
			}
		   return responseObject;
		
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/update")
	public ResponseEntity<Response> updateStudent(@RequestBody student student){
		try {
			Response response = studentService.updateStudent(student);
			 return new ResponseEntity<Response>(response,response.getOperation()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
			
		}catch(Exception exception) {
			Response response = new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject = new ResponseEntity(response,HttpStatus.OK);
			System.out.println(exception);
			
		}
		 return responseObject;
		
	}

}

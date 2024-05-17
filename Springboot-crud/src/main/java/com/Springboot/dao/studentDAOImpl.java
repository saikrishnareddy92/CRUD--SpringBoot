package com.Springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Springboot.model.student;
import com.Springboot.utils.Response;
@Repository
public class studentDAOImpl implements studentDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Response addStudent(student student) {
		
		Response response = new Response();
		Session session =  sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		 @SuppressWarnings("deprecation")
		int  i =(int) session.save(student);
		 if(i!=0) {
			 response.setMessage("student added successfully");
			 response.setOperation(true);
			 response.setStatusCode(201);
		 }
		 else {
			 response.setMessage(" adding student failed");
			 response.setOperation(false);
			 response.setStatusCode(500);
			 }
		 tx.commit();
		return response;
	}

	@Override
	public List<student> list() {
		Session session =  sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Query<student> query = session.createQuery("from student s");
		
		return query.getResultList();
	}

	@Override
	public Response deleteStudent(int id) {
		Session session =  sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		student student = session.get(student.class, id);
		Response response = new Response();
		  
		  try {
			  session.remove(student);
			  tx.commit();
			  response.setMessage("deleted successfully");
			  response.setOperation(true);
			  response.setStatusCode(200);
		  }
		  catch(Exception error) {
			  System.out.println("error" +error.getMessage());
			  response.setMessage(error.getMessage());
			  response.setOperation(false);
			  response.setStatusCode(200);
		  }
		
		return response;
	}

	@Override
	public student getStudent(int id) {
		Session session =  sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		student student = session.get(student.class, id);
		return student;
	}

	@Override
	public Response updateStudent(student student) {
		Session session =  sessionFactory.openSession();
		 Transaction tx= session.beginTransaction();
		 Response response = new Response();
		 
		 try{
			 session.update(student);
			 tx.commit();
			  response.setMessage("updated successfully");
			  response.setOperation(true);
			  response.setStatusCode(200);
		 }
		 catch(Exception error) {
			 System.out.println("error" +error.getMessage());
			  response.setMessage("updation failed");
			  response.setOperation(false);
			  response.setStatusCode(200);
			 
		 }
		
		return response;
	}

}

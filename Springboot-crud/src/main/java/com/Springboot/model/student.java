package com.Springboot.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class student {
	@Id @GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String course;
	@Column
	private String currentmodule;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCurrentmodule() {
		return currentmodule;
	}
	public void setCurrentmodule(String currentmodule) {
		this.currentmodule = currentmodule;
	}
	

}

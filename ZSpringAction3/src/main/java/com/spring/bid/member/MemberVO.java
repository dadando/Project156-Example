/*
create table smember(
    ID VARCHAR2(15) primary key,
    PASSWORD VARCHAR2(10),
    NAME VARCHAR2(15), 
    AGE NUMBER,       
    GENDER VARCHAR2(5),  
    EMAIL VARCHAR2(30));
*/

package com.spring.bid.member;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

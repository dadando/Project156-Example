/*
create table tab_mybatis(
    id varchar2(15) primary key,
    name varchar2(15),
    email varchar2(50),
    phone varchar2(15)
);
*/
package com.spring.springmybatis;

import org.springframework.stereotype.Component;

@Component //@Component를 붙이면 프로젝트 실행시 자동으로 MemberVO에 대한 Bean객체를 생성한다.
public class MemberVO {
	private String id;
	private String name;
	private String email;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

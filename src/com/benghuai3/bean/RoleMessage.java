package com.benghuai3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="rolemessage")
public class RoleMessage {
	private Integer id;
	private String message1;
	private String message2;
	private String message3;
	private String message4;
	private String message5;
	private String message6;
	private RoleInfo roleid;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	
	@Column
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	
	@Column
	public String getMessage3() {
		return message3;
	}
	public void setMessage3(String message3) {
		this.message3 = message3;
	}
	
	@Column
	public String getMessage4() {
		return message4;
	}
	public void setMessage4(String message4) {
		this.message4 = message4;
	}
	
	@Column
	public String getMessage5() {
		return message5;
	}
	public void setMessage5(String message5) {
		this.message5 = message5;
	}
	
	@Column
	public String getMessage6() {
		return message6;
	}
	public void setMessage6(String message6) {
		this.message6 = message6;
	}
	
	@OneToOne
	@JoinColumn(name="roleid",referencedColumnName="id")
	public RoleInfo getRoleid() {
		return roleid;
	}
	public void setRoleid(RoleInfo roleid) {
		this.roleid = roleid;
	}
	
}

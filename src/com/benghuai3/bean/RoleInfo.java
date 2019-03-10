package com.benghuai3.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class RoleInfo {
	private Integer id;
	private String name;
	private String fightType;
	private String type;
	private String englishname;
	private String leftpic;
	private String rightpic;
	private String pic;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getFightType() {
		return fightType;
	}
	public void setFightType(String fightType) {
		this.fightType = fightType;
	}
	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	@Column
	public String getLeftpic() {
		return leftpic;
	}
	public void setLeftpic(String leftpic) {
		this.leftpic = leftpic;
	}
	@Column
	public String getRightpic() {
		return rightpic;
	}
	public void setRightpic(String rightpic) {
		this.rightpic = rightpic;
	}
	@Column
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

}

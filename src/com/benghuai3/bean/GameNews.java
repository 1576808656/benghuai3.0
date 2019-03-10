package com.benghuai3.bean;

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
@Table
public class GameNews {
	private Integer id;
	private GameMessage gamemessageid;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn(name="gamemessageid",referencedColumnName="id")
	public GameMessage getGamemessageid() {
		return gamemessageid;
	}
	public void setGamemessageid(GameMessage gamemessageid) {
		this.gamemessageid = gamemessageid;
	}
	
}

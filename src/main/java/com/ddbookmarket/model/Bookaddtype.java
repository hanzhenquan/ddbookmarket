package com.ddbookmarket.model;

import java.io.Serializable;
import java.sql.Date;

public class Bookaddtype implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int sid;
	private String name;
	private int zishu;
	private double money;
	private String author;
	private String authorhome;
	private Date publishdate;
	private String jianjie;
	private String photo;
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

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

	public int getZishu() {
		return zishu;
	}

	public void setZishu(int zishu) {
		this.zishu = zishu;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorhome() {
		return authorhome;
	}

	public void setAuthorhome(String authorhome) {
		this.authorhome = authorhome;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public Bookaddtype() {
		// TODO Auto-generated constructor stub
	}

}

package com.vshop.entity;

/**
 * 系统设置信息实体类
 * @author alison
 * @version 1.0
 *
 */
public class Sys {
	
	public Sys() {
	}
	
	private int id;
	
	private int user_level;
	
	private int user_min;
	
	private int user_max;
	
	private float user_money;
	
	private long created_time;
	
	private String creator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	public int getUser_min() {
		return user_min;
	}

	public void setUser_min(int user_min) {
		this.user_min = user_min;
	}

	public int getUser_max() {
		return user_max;
	}

	public void setUser_max(int user_max) {
		this.user_max = user_max;
	}

	public float getUser_money() {
		return user_money;
	}

	public void setUesr_money(float user_money) {
		this.user_money = user_money;
	}

	public long getCreated_time() {
		return created_time;
	}

	public void setCreated_time(long created_time) {
		this.created_time = created_time;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
}

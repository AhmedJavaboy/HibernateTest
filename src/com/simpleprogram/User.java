package com.simpleprogram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class User {
	private int id;
	private String name;
	private ProteinData proteinData=new ProteinData();
	private List<UserHistory> history= new ArrayList<UserHistory>();
	
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

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public List<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	public void addHistory(UserHistory item){
		item.setUser(this);
		history.add(item);
		
	}
}

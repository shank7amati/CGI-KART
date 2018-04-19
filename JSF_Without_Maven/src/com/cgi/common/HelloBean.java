package com.cgi.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {


	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name+" CGI ";
	}
	
	public String getSayWelcome(){
		//check if null?
		if("".equals(name) || name ==null){
			return "Empty name";
		}else{
			return "Ajax message : Welcome " + name;
		}
	}
	

}
package com.knf.dev.demo.springbootazuresqlcrud.entity;

 

public class Login {

    private String user_id;
    private String password;


    public Login() {
		super();
	}

    public Login(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;
		 
	}

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

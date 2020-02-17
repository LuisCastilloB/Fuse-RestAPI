package com.test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User_Req extends User {

	@JsonIgnore
	private Integer id;
	
}

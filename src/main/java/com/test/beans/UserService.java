package com.test.beans;

import org.apache.camel.Exchange;

import com.test.models.ResponseStructure;
import com.test.models.User;
import com.test.models.UserPhones;
import com.test.models.User_Req;

public class UserService {

	
		public void getUser(Exchange exchange) {
			
			String type = exchange.getIn().getHeader("type", String.class);
			int document = exchange.getIn().getHeader("document", Integer.class);
			
			User user = new User();
			user.setId(1234);
			user.setType(type);
			user.setDocument(document);
			user.setName("Pere");
			user.setLastName("Perez");
			
			UserPhones userPhones = new UserPhones();
			userPhones.setHomePhone("366 45 12");
			userPhones.setMobilePhone("300 123 4544");
			userPhones.setOfficePhone("400 12 47");
		
			user.setUserPhones(userPhones);			
			exchange.getIn().setBody(user);
			
		}
		
		
		public void updateUser(Exchange exchange) {
			
			User u = exchange.getIn().getBody(User.class);			
			exchange.getIn().setBody(u);
		}
		
		
		public void insertUser(Exchange exchange) {
			
			
			User_Req u = exchange.getIn().getBody(User_Req.class);
			
			User user = new User();
			user.setId(123456);
			user.setType(u.getType());
			user.setDocument(u.getDocument());
			user.setName(u.getName());
			user.setLastName(u.getLastName());
			
			UserPhones userPhones = new UserPhones();
			userPhones.setHomePhone(u.getUserPhones().getHomePhone());
			userPhones.setMobilePhone(u.getUserPhones().getMobilePhone());
			userPhones.setOfficePhone(u.getUserPhones().getOfficePhone());
		
			user.setUserPhones(userPhones);			
			exchange.getIn().setBody(user);
		}
		
		
		public void deleteUser(Exchange exchange) {
			
			int id = exchange.getIn().getHeader("id", Integer.class);
			
			ResponseStructure rs = new ResponseStructure();
			rs.setStatus("OK");
			rs.setMessage("User "+id+" removed");
			
			exchange.getIn().setBody(rs);
		}
		
}

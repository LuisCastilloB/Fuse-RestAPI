package com.test.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.test.models.User;

public class UserProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		User u = exchange.getIn().getBody(User.class);
		int id = u.getId();
		
		if (id <= 0) {
			throw new Exception("Id invalid");
		}
	}
}

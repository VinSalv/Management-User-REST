package com.example.client;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.User;

public class ClientWSTester {

	private static String REST_SERVICE_URL = "http://localhost:8080/REST-UserManagement/rest/UserService/users";

	public static void main(String[] args) {
		httpGETCollectionExample();
	}

	private static void httpGETCollectionExample() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(REST_SERVICE_URL);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		String users = invocationBuilder.get(String.class);
		System.out.println(response.getStatus());
		System.out.println(users);

		Form form = new Form();
		form.param("id", "1");
		form.param("name", "ciao");
		form.param("profession", "ciao2");

		Response callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_XML));

		System.out.println("Test case name: testUpdateUser, Result: " + callResult);
	}
}
package com.sensing;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.sensing.entity.TemperatureEntity;

@WebServlet(name = "HelloAppEngine", urlPatterns = { "/hello" })
public class MainServlet extends HttpServlet {

	static {
		ObjectifyService.register(TemperatureEntity.class);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		TemperatureEntity test = new TemperatureEntity(14, new Date(), 42.0, 42.0);
//		ofy().save().entity(test).now();
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print("Hello App Engine!\r\n");
	}
}
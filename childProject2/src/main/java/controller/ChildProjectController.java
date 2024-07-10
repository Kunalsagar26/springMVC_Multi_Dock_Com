package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import jakarta.servlet.http.HttpServletResponse;
import service.Userservice;


@Controller
@CrossOrigin(origins = "*")
public class ChildProjectController {
	 
	@Autowired
	Userservice userServ;
	
	@Autowired
	User user;
	
	 RestTemplate rest = new RestTemplate();
	 String REST_URI="http://localhost:8080/childOneApi/";
	 String REST_URI_CONTAINER="http://host.docker.internal:8080/childOneApi/";
	 
	 
	//http://localhost:8080/springmvcwithbatch	 
	@RequestMapping(value="/getUser")
	public ModelAndView test(HttpServletResponse response) throws IOException
	{
		User user = userServ.getUsers();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/updateUser")
	public ModelAndView method(HttpServletResponse response) throws IOException
	{
		User user = userServ.getUsers();
		return new ModelAndView("index");
	}
	
	

	

	@RequestMapping(value="/childTwoApi",method = RequestMethod.GET)
	@ResponseBody
	public String method23()throws IOException,InterruptedException 
	{
		
		String resp=rest.getForObject(REST_URI+"Kunal",String.class);
		System.out.println("Resp from one "+resp+"\n");
		return "This is SECOND Child Api"+ resp;
		
	}
	
	

}

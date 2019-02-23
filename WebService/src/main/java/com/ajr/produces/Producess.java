package com.ajr.produces;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produces")
public class Producess {

	static List list = new ArrayList();
	static {
		ProducessPojo pojo = new ProducessPojo();
		pojo.setEid(10);
		pojo.setName("sekhar");
		pojo.setAddress("amerpeet");
		list.add(pojo);

		ProducessPojo pojo1 = new ProducessPojo();
		pojo1.setEid(11);
		pojo1.setName("sekhar");
		pojo1.setAddress("amerpeet");
		list.add(pojo1);

		ProducessPojo pojo2 = new ProducessPojo();
		pojo2.setEid(12);
		pojo2.setName("sekhar");
		pojo2.setAddress("amerpeet");
		list.add(pojo2);

	}

	@GET
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String add() {
		return "hello sekhar";
	}

	@POST
	@Path("/sub")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sub(ProducessPojo pojo) {
		list.add(pojo);
		Response build = Response.status(200).entity(list).build();
		return build;
	}
	
	@POST
	@Path("/inses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inses(ProducessPojo pojo) {
		list.add(pojo);
		Response build = Response.status(200).entity(list).build();
		return build;
	}
	
	@PUT
	@Path("ins/{number}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("number") int eno,ProducessPojo pojo){
		
		for(Object al : list){
			ProducessPojo pojo2=(ProducessPojo)al;
			int eid = pojo2.getEid();
			if(eid == eno){
				pojo2.setName(pojo.getName());
				pojo2.setAddress(pojo.getAddress());
			}
			
		}
		
		return Response.status(200).entity(list).build();
	}

}

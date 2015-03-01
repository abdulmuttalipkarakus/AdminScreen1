package com.adminscreen.controller;
import java.util.List;
import java.util.UUID;

import javax.swing.text.html.parser.Entity;

import org.apache.jasper.tagplugins.jstl.core.Remove;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.adminscreen.controller.*;
 
public class mongodboperations  {
	
	private ApplicationContext ctx ;
	private MongoOperations mongoOperation;
	    private MongoTemplate mongoTemplate;
	     
	    public static final String COLLECTION_NAME = "person";
	     
	   
	
	public mongodboperations()
	{ 
		ctx = new AnnotationConfigApplicationContext(dbconfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}
 
	public String CreateUser(String name,String surname,String telephone ) {

		
		dbUser user = new dbUser();
		user.username=name;
		user.usersurname=surname;
		user.telephone=telephone;
		user.id=UUID.randomUUID().toString();

		// save
	   this.mongoOperation.save(user);
	   return user.id;
	}

	
public void UpdateUser(String id,String name,String surname,String telephone ) {

		
		Query searchUserQuery = new Query(Criteria.where("id").is(id));
		
		Update updateUser=new Update();
		
		
		updateUser.addToSet("id",id);
		if(name!=null)
			updateUser.addToSet("name",name);
		if(surname!=null)
			updateUser.addToSet("surname",surname);
		if(telephone!=null)
			updateUser.addToSet("telephone",telephone);
		this.mongoOperation.findAndModify(searchUserQuery, updateUser, dbUser.class);
		}

public void RemoveUser(String id) {

	
	Query searchUserQuery = new Query(Criteria.where("id").is(id));
	dbUser user=new dbUser();
	user.id=id;
	
	
	this.mongoOperation.findAndRemove(searchUserQuery, dbUser.class);
	}


public List<dbUser> UserList() {

	
	List<dbUser> userList = null;
	// save
	userList=this.mongoOperation.findAll(dbUser.class);
   return userList;
}


public dbUser FindUser(String id) {

	Query searchUserQuery = new Query(Criteria.where("id").is(id));
	dbUser user = null;
	// save
	user=this.mongoOperation.findOne(searchUserQuery, dbUser.class);
   return user;
}
}

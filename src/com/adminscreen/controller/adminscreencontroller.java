package com.adminscreen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
 

import com.adminscreen.controller.*;
    
@Controller   
public class adminscreencontroller {  
    
    @Autowired
    private mongodboperations dbService;
     
    @RequestMapping(value = "/user", method = RequestMethod.GET)  
    public String UserList(ModelMap model) {  
        model.addAttribute("userList", dbService.UserList());  
        return "output";  
    }  
     
     
    
    @RequestMapping(value = "/user/save", method = RequestMethod.GET)  
    public View createUser(@ModelAttribute dbUser user, ModelMap model) {
    	{
        	dbService.CreateUser(user.username, user.usersurname, user.telephone);
        }
        return new RedirectView("/index");  
    }
         
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)  
    public View deleteUser(@ModelAttribute dbUser user, ModelMap model) {  
    	dbService.RemoveUser(user.id);  
        return new RedirectView("/index");  
    }   
    
    @RequestMapping(value = "/user/update", method = RequestMethod.GET)  
    public View updateUser(@ModelAttribute dbUser user, ModelMap model) {
    	if(StringUtils.hasText(user.getId())) {
        	dbService.UpdateUser(user.id, user.username, user.usersurname, user.telephone);
        }
        return new RedirectView("/index");  
    }
    
    @RequestMapping(value = "/create")  
    public void  admincreate() {
    	//return new  ModelAndView("createuser");
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)  
    public ModelAndView  adminupdate(@ModelAttribute String id,ModelMap model) {
    	 model.addAttribute("user", dbService.FindUser(id));
    		return new ModelAndView ("/adminscreen/updateuser");
    	
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)  
    public ModelAndView  admindelete(@ModelAttribute String id,ModelMap model) {

        model.addAttribute("user", dbService.FindUser(id));
    	return new ModelAndView ("/adminscreen/deleteuser");
    	
    }

    private dbUser FindUser(String id) {
    	return dbService.FindUser(id);
    }
    
    
}
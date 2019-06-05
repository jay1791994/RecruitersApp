package com.jay.app.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jay.app.controller.repo.UserRepo;
import com.jay.app.model.*;

@RestController
@RequestMapping("api")
public class UserController {
 
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("first")
	  User testing1() {
		User user = new User();
		user.setName("Yitao");
		user.setAge(23);
		user.setEmail("this@this.com");
		user.setExperience(8);
		user.setExpertise("Java");
		user.setOpentorelocation(true);
		user.setVisaStatus("OPT");
	    user.setCurrentLocation("NJ");
		List<String> li = new ArrayList<>();
		li.add("NJ");
		li.add("NY");
		
		user.setPreffredLocation(li);
		
		return user;
		 
	  }
	
	
  @RequestMapping("test")
  String testing() {
	  
	  String[] locations = {"NJ","NY","PA","DE","VA","DC","MA","CA","AK","AR","TX","CT","OH"};
	  String[] expertise = {"JAVA",".NET","BA","QA","DATA SCIENCE","ML/AI","ANDROID"};
	  String[] visastatus = {"OPT","CPT","GREEN CARD","US CITIZEN","H1B","H4 EAD"};
	  Random rand = new Random();
	  for(int i=0; i < 200 ; i++) {
		  
		  User user = new User();
		  
		  user.setAge(rand.nextInt(50)+12);
		  user.setCurrentLocation(locations[rand.nextInt(10)]);
		  user.setEmail("user"+i+"@yahoo.com");
		  user.setExperience(rand.nextInt(6)+1);
		  user.setName(locations[rand.nextInt(10)]+locations[rand.nextInt(10)]+locations[rand.nextInt(10)]+"USER");
		  user.setExpertise(expertise[rand.nextInt(7)]);
		  user.setOpentorelocation(rand.nextBoolean());
		  user.setVisaStatus(visastatus[rand.nextInt(6)]);
		  
		  int size = rand.nextInt(10)+1;
		  List<String> list = new ArrayList<String>();
		  list.add(locations[size]);
		  list.add(locations[size+1]);
		  list.add(locations[size+2]);
		  
		  
		  user.setPreffredLocation(list);
		  user.setUserId(User.getRandomeUserId());
		  while(userRepo.existsById(user.getUserId())) {
	    		 user.changeMyId();
	      }
		  
		  userRepo.save(user);
	  }
	  
	  
	  
	  
	  return "datagerated";
  }
 
   @GetMapping("user/page/{pageNumber}")
   Page<User> getUsers(@PathVariable int pageNumber) {
    	  
	   Pageable pageWithTenelements = PageRequest.of(pageNumber,10);
	   Page<User> page = userRepo.findAll(pageWithTenelements);
	   return page;

   }
   
   @GetMapping("user/page/sortbyexperience/{pageNumber}")
   Page<User> getUserSortedByExperience(@PathVariable int pageNumber){
	   
	   Pageable pagewithTenelementssortedbyexperience = PageRequest.of(pageNumber,10, Sort.by("experience"));
	   Page<User> page = userRepo.findAll(pagewithTenelementssortedbyexperience);
	   return page;
   }
   
   
   
   
    @GetMapping("user/{userId}")
   // @CrossOrigin(origins = { "http://localhost:4200"})
  	User getUser(@PathVariable String userId){
  		  
    	 System.out.println(userId);
       
    	 Optional<User> user = userRepo.findById(userId);
    	 if(user.isPresent()) {
    		 return user.get();
    	 }
    	 return null;
  	}
	
    @PostMapping(path= "user")
   // @CrossOrigin(origins = { "http://localhost:4200"})
    User createUser(@RequestBody User user){
  		
    	 System.out.println("came here");
    	 while(userRepo.existsById(user.getUserId())) {
    		 user.changeMyId();
    	 }
    	 
    	 userRepo.insert(user);
    	 return user;
  	}
    
    @PutMapping("user")
   // @CrossOrigin(origins = { "http://localhost:4200"})
    User  updateUser(@RequestBody User user){
  		
       
    	
    	 userRepo.save(user);
    	 return user;
  	}
    
    @DeleteMapping("user/{id}")
   // @CrossOrigin(origins = { "http://localhost:4200"})
    User delateUser(@PathVariable String id){
  		 System.out.println("delete method called");
    	  System.out.println(id);
    	  Optional<User> u = userRepo.findById(id);
          if(u.isPresent()) {
        	  userRepo.deleteById(id);
        	  System.out.println(u.get().getUserId());
        	  return u.get();
        	  
          }
          return null;
          
  	}
	
    
	 
}

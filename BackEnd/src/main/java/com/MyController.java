
package com;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin("http://localhost:4200")
@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class MyController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/ItemId/{id}")
	public MyEntity GetInfo(@PathVariable("id") Integer id) {
		System.out.println(" GetInfo id="+id);
		return itemService.GetItemById(id);
	}
	
	
	//@GetMapping("/ItemId")
	@GetMapping("/users")
	public String GetInfo1() {
		System.out.println(" method running ");
		return "method running";
	}
	
	//@PostMapping("/ItemId")
	@PostMapping("/users")
	public void PostInfo(@RequestBody MyEntity myEntity) {
		System.out.println(" PostInfo myEntity="+myEntity.toString());
		 itemService.PostItem(myEntity);
	}
	
	
	//@GetMapping("/ItemIdAll")
	@GetMapping("/adduser")
	public List <MyEntity> GetAllInfo() {
		return itemService.GetAllItemById();
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public void DeleteInfo(@PathVariable int id) {
		itemService.DeleteById(id);
	}
	
	@PutMapping("/updateItem")
	public void UpdateInfo(@RequestBody MyEntity myEntity) {
		itemService.UpdateItem(myEntity);
	}
	public MyController() {
		super();
		System.out.println(" MyController ");
	}
	
	
}


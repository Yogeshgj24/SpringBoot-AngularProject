package com;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
@Transactional
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	//@Autowired
	//MyEntity myEntity;
	
	public MyEntity GetItemById(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	public MyEntity PostItem(MyEntity myEntity) {
		return itemRepository.save(myEntity);
	}			
	
	public List <MyEntity> GetAllItemById() {
		List<MyEntity> info = new ArrayList<MyEntity>();
		itemRepository.findAll().forEach(info1 -> info.add(info1));		
		return info;
	}
	
	public void DeleteById(Integer id) {
		 itemRepository.deleteById(id);
	}
	
	public void UpdateItem(MyEntity myEntity) {
		itemRepository.save(myEntity);
	}

}


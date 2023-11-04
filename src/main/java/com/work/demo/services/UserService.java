package com.work.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.demo.DTO.UserDTO;
import com.work.demo.domain.User;
import com.work.demo.repository.UserRepository;
import com.work.demo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findByID(String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto Não encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}

}

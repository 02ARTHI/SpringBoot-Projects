package com.learning.arthiFirstWebApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.arthiFirstWebApp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    
	public List<Todo> findByUsername(String username);
}

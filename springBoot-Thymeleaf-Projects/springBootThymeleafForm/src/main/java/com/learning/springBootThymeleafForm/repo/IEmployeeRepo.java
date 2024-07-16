package com.learning.springBootThymeleafForm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springBootThymeleafForm.model.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}

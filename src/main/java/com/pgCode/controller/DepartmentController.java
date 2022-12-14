package com.pgCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgCode.entity.Department;
import com.pgCode.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public Department createDepartment(@RequestBody Department department) {

		Department savedDepartmanet = departmentService.saveDepartmanet(department);
		return savedDepartmanet;

	}

	@GetMapping("/departments")
	public List<Department> getDepartments() {

		return departmentService.getDepartment();
	}

	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id) {

		Department department = departmentService.findDepartmentById(id);

		return department;

	}
	
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable("id") Long id) {

		departmentService.deleteDepartment(id);
		
		return "Record Deleted Succesfully";
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
		
		Department updatedDepartment = departmentService.updateDepartment(id,department);
		
		return updatedDepartment;
	}
	
	

}

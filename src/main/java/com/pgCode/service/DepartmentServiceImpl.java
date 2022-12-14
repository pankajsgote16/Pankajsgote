package com.pgCode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgCode.entity.Department;
import com.pgCode.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	//Creating Department
	@Override
	public Department saveDepartmanet(Department department) {
			
		Department savedDept = departmentRepository.save(department);
		
		return savedDept;
	}
	
	
	//Getting All Departments
	@Override
	public List<Department> getDepartment() {

		List<Department> allDepartments = departmentRepository.findAll();
		return allDepartments;
	}


	
	//Getting Department By Id
	@Override
	public Department findDepartmentById(Long id) {
		
		 Department department = departmentRepository.findById(id).get();
		
		return department;
	}

	
	//Deleting Department
	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);

	}

	
	// Updating Department
	public Department updateDepartment(Long id,Department department) {
		
		Department deptDB = departmentRepository.findById(id).get();
		deptDB.setDeptName(department.getDeptName());
		deptDB.setDeptAddress(department.getDeptAddress());
		deptDB.setDeptCode(department.getDeptCode());
		
		Department updatedDept = departmentRepository.save(deptDB);
		
		return updatedDept;
		
	}
}

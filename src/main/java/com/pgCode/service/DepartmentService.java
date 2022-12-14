package com.pgCode.service;

import java.util.List;

import com.pgCode.entity.Department;

public interface DepartmentService {

	Department saveDepartmanet(Department department);

	List<Department> getDepartment();
	

	Department findDepartmentById(Long id);

	void deleteDepartment(Long id);

	Department updateDepartment(Long id, Department department);

}

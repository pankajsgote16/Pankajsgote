package com.pgCode.service;

import com.pgCode.entity.Department;
import com.pgCode.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceImplTest {


    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;


    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().deptId(1L).deptName("Mechanical").deptAddress("Pune").deptCode("C002").build();
    }


    @Test
    void saveDepartmanet() {
        //  Department department = new Department(1L,"Mechanical","New Sangavi","C003");
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        assertEquals(department, departmentService.saveDepartmanet(department));

    }

    @Test
    void getDepartment() {

        departmentService.getDepartment();
        Mockito.verify(departmentRepository).findAll();
    }

    @Test
    void findDepartmentById() {

        // Department department = new Department(4L,"IT","Benglore","B944");
        Mockito.when(departmentRepository.findById(4L)).thenReturn(Optional.of(department));
        assertEquals(department, departmentService.findDepartmentById(4L));
    }

    @Test
    void deleteDepartment() {

    }

    @DisplayName("Junit test for Update Department Method")
    @Test
    void updateDepartment() {

        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        department.setDeptName("IT");
        department.setDeptAddress("Benglore");

        Department updatedDepartment1 = departmentService.updateDepartment(department.getDeptId(), department);
        assertEquals("IT", updatedDepartment1.getDeptName());
        assertEquals("Benglore", updatedDepartment1.getDeptAddress());


    }
}

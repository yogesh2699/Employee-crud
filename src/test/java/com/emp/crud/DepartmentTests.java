package com.emp.crud;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.crud.model.DepartmentEntity;
import com.emp.crud.model.EmployeeEntity;
import com.emp.crud.service.DepartmentService;
import com.emp.crud.service.EmployeeService;

@SpringBootTest
public class DepartmentTests {

	@Autowired
	private DepartmentService departmentService;
	

	@Test
    public void getAllDepartmentTest()
    {
        List<DepartmentEntity> list = new ArrayList<DepartmentEntity>();
        DepartmentEntity deptOne = new DepartmentEntity((long) 1,"Security","Delhi");
        DepartmentEntity deptTwo = new DepartmentEntity((long) 2,"R&D","Delhi");
        DepartmentEntity deptThree = new DepartmentEntity((long) 3,"Dev-ops","Delhi");
         
        list.add(deptOne);
        list.add(deptTwo);
        list.add(deptThree);
         
        when(departmentService.getAllDepartments()).thenReturn(list);
         
        //test
        List<DepartmentEntity> deptList = departmentService.getAllDepartments();
         
        assertEquals(3, deptList.size());
        verify(departmentService, times(1)).getAllDepartments();
    }

}
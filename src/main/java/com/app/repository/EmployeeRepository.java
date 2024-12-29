package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select * from employee e where e.employee_id = ?1", nativeQuery = true)
	public Employee getEmployeeByEmployeeId(Integer employeeId);
	
	@Query(value = "select * from employee e where e.designation = ?1", nativeQuery =  true)
	public List<Employee> getEmployeesByDesignation(String desination);
	
	@Query(value = "select e.employee_name from employee e", nativeQuery = true)
	public List<String> getAllEmployees();
	
	@Query(value = "select e.employee_id, e.employee_name from employee e", nativeQuery = true)
	public List<Object[]> getAllEmployeeIdsAndEmployeeNames();
	
	@Query(value = "from Employee e where e.employeeId in (?1)")
	public List<Employee> getEmployeeByIds(List<Integer> employeeIdList);
	
	@Query(value = "from Employee e where e.employeeCode in (:employeeCode)")
	public List<Employee> getEmployeeByEmployeeCode(@Param("employeeCode") List<String> employeeCodeList);
	
}

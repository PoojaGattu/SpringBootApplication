package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Employee;

//No need to provide @Repository because JpaRepository internally provides @Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

package com.examples.empapp.dao;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class EmployeeDaoJpaImpl implements  EmployeeDao {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean create(Employee employee) throws ApplicationException {
//        entityManager.getTransaction().begin();
        entityManager.persist(employee);
//        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        int empId = employee.getEmpId();

        Employee empForUpdate = entityManager.find(Employee.class, empId);
        empForUpdate.setName(employee.getName());
        empForUpdate.setAge(employee.getAge());
        empForUpdate.setDepartment(employee.getDepartment());
        empForUpdate.setDesignation(employee.getDesignation());
        empForUpdate.setCountry(employee.getCountry());
        entityManager.persist(empForUpdate);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Employee empForDelete = entityManager.find(Employee.class, id);
        entityManager.remove(empForDelete);
        return true;
    }

    @Override
    public Employee get(int empId) {
        Employee emp = entityManager.find(Employee.class, empId);
        return emp;
    }

    @Override
    public List<Employee> getAll() {
        List empList =  entityManager.createQuery("FROM EMPLOYEE").getResultList();
        return empList;
    }
}

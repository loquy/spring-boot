package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "A", "a@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "B", "b@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "C", "c@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "D", "d@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "E", "e@qq.com", 1, new Department(105, "后勤部")));
    }

    public static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}

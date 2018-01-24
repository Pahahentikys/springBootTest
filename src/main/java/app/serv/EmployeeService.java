package app.serv;


import app.dom.Employee;

import java.util.List;

public interface EmployeeService {

    void deleteEmployee(Long id);

    void updateEmployee(Long id, Employee employee);

    void addEmployee(Employee employee);

    List<Employee> getAllEmlpoyyes();

    Employee getEmployee(Long id);

}

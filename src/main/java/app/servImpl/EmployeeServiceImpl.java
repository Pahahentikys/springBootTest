package app.servImpl;

import app.dom.Employee;
import app.repo.EmployeeRepository;
import app.serv.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmlpoyyes() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository
                .findAll()
                .forEach(employees::add);
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findOne(id);
    }
}

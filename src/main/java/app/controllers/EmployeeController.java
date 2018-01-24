package app.controllers;

import app.dom.Employee;
import app.servImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/employyes")
    public List<Employee> getAllEmlpoyyes() {
            return employeeService.getAllEmlpoyyes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employyes/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employyes")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employyes/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employyes/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}

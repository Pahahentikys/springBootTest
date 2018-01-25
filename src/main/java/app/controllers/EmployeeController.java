package app.controllers;

import app.dom.Employee;
import app.servImpl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    public List<Employee> getAllEmlpoyyes() {
        log.info("Выполняется получение всех пользователей!");
        return employeeService.getAllEmlpoyyes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        log.info("Выполняется получение пользователя по id: {}", id);
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        log.info("Выполняется добавление пользователя: {}", employee);
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        log.info("Выполнено обновление данных о пользователе с id: {}. Новое имя: {},  новая фамилия: {}", id, employee.getName(), employee.getSurname());
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("Выполняется удаление пользователя по id: {}", id);
        employeeService.deleteEmployee(id);
    }
}

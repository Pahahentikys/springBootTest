package app.servImpl;

import app.dom.Employee;
import app.repo.EmployeeRepository;
import app.serv.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

     private List<Employee> employees  = new ArrayList<>(
Arrays.asList(
                new Employee(1L, "Petr", "Sergeevich"),
                new Employee(2L, "Petr", "Petrovich"),
                new Employee(3L, "Petr", "Pavlovich")
        )
     );

    @Override
    public void deleteEmployee(Long id) {

//        employees.removeIf(employee -> employee.getId().equals(id));

        employeeRepository.delete(id);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
//        for (int i = 0; i < employees.size(); i++) {
//            Employee empl = employees.get(i);
//            if(empl.getId().equals(id)){
//                employees.set(i, employee);
//                return;
//            }
//        }

//        employees = employees.stream()
//                 .map(e -> e.getId().equals(id) ? employee : e)
//                 .collect(Collectors.toList());

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmlpoyyes(){

//        return employees;

        List<Employee> employees = new ArrayList<>();
        employeeRepository
                .findAll()
                .forEach(employees::add);
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
//        employees.add(employee);

        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {

//       return employees.stream()
//                .filter(employee -> employee.getId().equals(id))
//                .findFirst()
//                .get();

       return employeeRepository.findOne(id);
    }
}

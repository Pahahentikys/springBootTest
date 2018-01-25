package unitTesting;

import app.controllers.EmployeeController;
import com.google.common.collect.ImmutableList;
import app.dom.Employee;
import app.servImpl.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerUT {
    @Mock
    EmployeeServiceImpl employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    public void testGetAllEmployees() throws Exception{

        when(employeeService.getAllEmlpoyyes()).thenReturn(ImmutableList.of());

        List<Employee> employees = employeeController.getAllEmlpoyyes();

        verify(employeeService).getAllEmlpoyyes();
    }
}

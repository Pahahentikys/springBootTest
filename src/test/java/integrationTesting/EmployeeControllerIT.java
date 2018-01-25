package integrationTesting;

import app.dom.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class EmployeeControllerIT {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testGetAllEmployees() throws Exception {

        ResponseEntity<List<Employee>> re =
                restTemplate.exchange("http://localhost:8080/employyes", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });

        List<Employee> validData = re.getBody();

        assertThat(validData.size(), is(3));

        validData.stream()
                .map(Employee::getId)
                .collect(Collectors.toList());

        assertThat(validData, containsInAnyOrder(1L, 2L, 3L));
    }
}

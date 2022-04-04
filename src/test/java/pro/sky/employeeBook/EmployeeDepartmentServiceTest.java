package pro.sky.employeeBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeeBook.Impl.EmployeeDepartmentsServiceImpl;
import pro.sky.employeeBook.Impl.EmployeeServiceImpl;
import pro.sky.employeeBook.Service.EmployeeDepartmentsService;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class EmployeeDepartmentServiceTest {

    private Employee employee = new Employee("Волков", "Мирослав", 148_005.0, 3);
    private Employee employee1 = new Employee("Анисимова", "Данна", 114_430.0, 3);

    @Mock
    private EmployeeService employeeService = new EmployeeServiceImpl();


    @InjectMocks
    private EmployeeDepartmentsService employeeDepartmentsService = new EmployeeDepartmentsServiceImpl(employeeService);


    @Test
    public void getMaxSalaryDepartment() {


        Mockito.when(employeeService.getEmployees()).thenReturn(List.of(employee));
        Employee maxSalary = employeeDepartmentsService.getMaxSalaryDepartment(3);

        assertEquals(maxSalary, employee);
    }

    @Test
    public void getMinSalaryDepartment() {
        Mockito.when(employeeService.getEmployees()).thenReturn(List.of(employee1));
        Employee minSalary = employeeDepartmentsService.getMinSalaryDepartment(3);

        assertEquals(minSalary, employee1);
    }

    @Test
    public void getAllEmployeeDepartment() {

        List<Employee> actual = new ArrayList<Employee>(List.of(employee, employee1));

        Mockito.when(employeeService.getEmployees()).thenReturn(actual);

        List<Employee> expected = employeeDepartmentsService.getAllEmployeeDepartment(3);

        actual.sort(Comparator.comparing(Employee::getEmployeeLastName));
        expected.sort(Comparator.comparing(Employee::getEmployeeLastName));

        assertEquals(expected, actual);
    }
}

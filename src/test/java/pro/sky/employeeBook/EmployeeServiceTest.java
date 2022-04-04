package pro.sky.employeeBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.employeeBook.Exception.EmployeeIsInArrayException;
import pro.sky.employeeBook.Exception.NotFoundEmployeeException;
import pro.sky.employeeBook.Impl.EmployeeServiceImpl;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;
    private Employee employee7;
    private Employee employee8;
    private Employee employee9;
    private Employee employee10;
    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {

        employee1 = new Employee("Крылов", "Тихон", 105_853.0, 1);
        employee2 = new Employee("Маслова", "Милиса", 105_853.0, 1);
        employee3 = new Employee("Яковлев", "Леонид", 83_012.0, 2);
        employee4 = new Employee("Полякова", "Божена", 119_540.0, 2);
        employee5 = new Employee("Волков", "Мирослав", 148_005.0, 3);
        employee6 = new Employee("Анисимова", "Данна", 114_430.0, 3);
        employee7 = new Employee("Соловьёв", "Ефрем", 38_911.0, 4);
        employee8 = new Employee("Меркушева", "Глория", 52_291.0, 4);
        employee9 = new Employee("Никитин", "Адам", 66_058.0, 5);
        employee10 = new Employee("Кудрявцева", "Галина", 47_832.0, 5);

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void addNewEmployee() {
        Employee employee11 = new Employee("Иванов", "Иван", 100_000.0, 3);
        Employee employee12 = new Employee("Петров", "Петров", 120_000.0, 5);

        employeeService.addNewEmployee("Иванов", "Иван", 100_000.0, 3);
        employeeService.addNewEmployee("Петров", "Петров", 120_000.0, 5);

        List<Employee> expected = employeeService.getEmployees();

        List<Employee> actual;
        actual = new ArrayList<Employee>(List.of(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10));

        actual.add(employee11);
        actual.add(employee12);

        actual.sort(Comparator.comparing(Employee::getEmployeeLastName));
        expected.sort(Comparator.comparing(Employee::getEmployeeLastName));

        assertEquals(expected, actual);
        assertThrows(EmployeeIsInArrayException.class, null);
    }

    @Test
    public void getAllEmployees() {

        List<Employee> expected = employeeService.getEmployees();
        expected.sort(Comparator.comparing(Employee::getEmployeeLastName));

        List<Employee> actual = new ArrayList<Employee>();

        actual.add(employee10);
        actual.add(employee9);
        actual.add(employee8);
        actual.add(employee7);
        actual.add(employee6);
        actual.add(employee5);
        actual.add(employee4);
        actual.add(employee3);
        actual.add(employee2);
        actual.add(employee1);

        actual.sort(Comparator.comparing(Employee::getEmployeeLastName));

        assertEquals(expected, actual);
        assertThrows(EmployeeIsInArrayException.class, null);
    }

    @Test
    public void removeEmployee() {
        employeeService.removeEmployee("Яковлев", "Леонид");
        employeeService.removeEmployee("Маслова", "Милиса");

        List<Employee> expected = employeeService.getEmployees();
        expected.sort(Comparator.comparing(Employee::getEmployeeLastName));

        List<Employee> actual;
        actual = new ArrayList<Employee>(List.of(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10));
        actual.remove(employee3);
        actual.remove(employee2);

        actual.sort(Comparator.comparing(Employee::getEmployeeLastName));

        assertEquals(expected,actual);
        assertThrows(NotFoundEmployeeException.class, null);
    }

    @Test
    public void findEmployee() {

        List<Employee> expected = employeeService.getEmployees();
        Employee findExpected = employeeService.findEmployees("Маслова", "Милиса");

        List<Employee> actual;
        actual = new ArrayList<Employee>(List.of(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10));
        Employee findActual = actual.get(1);

        assertEquals(findExpected,findActual);
        assertThrows(NotFoundEmployeeException.class, null);
    }
}

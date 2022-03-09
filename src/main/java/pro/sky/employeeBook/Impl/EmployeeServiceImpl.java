package pro.sky.employeeBook.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeBook.Exception.EmployeeIsInArrayException;
import pro.sky.employeeBook.Exception.NotFoundEmployeeException;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "Тихон Крылов", new Employee("Крылов", "Тихон"),
            "Маслова Милиса", new Employee("Маслова", "Милиса"),
            "Яковлев Леонид" ,new Employee("Яковлев", "Леонид"),
            "Полякова Божена", new Employee("Полякова", "Божена"),
            "Волков Мирослав" ,new Employee("Волков", "Мирослав"),
            "Анисимова Данна", new Employee("Анисимова", "Данна"),
            "Соловьёв Ефрем", new Employee("Соловьёв", "Ефрем"),
            "Меркушева Глория", new Employee("Меркушева", "Глория"),
            "Никитин Адам", new Employee("Никитин", "Адам"),
            "Кудрявцева Галина", new Employee("Кудрявцева", "Галина")
    ));

    @Override
    public String addNewEmployee(String nameEmployee, Employee employee) {
        if (employees.containsValue(employee)){
            throw new EmployeeIsInArrayException("Такой сотрудник уже существует", null);
        } else {
            employees.put(nameEmployee, employee);
        }
        return String.valueOf(employees.get(nameEmployee));
    }

    @Override
    public void removeEmployee(String nameEmployee) {
        if (employees.containsKey(nameEmployee)) {
            throw new NotFoundEmployeeException("Удаляемый сотрудник не найден", null);
        } else {
            employees.remove(nameEmployee);
        }
    }

    @Override
    public String findEmployees(String nameEmployee) {
        String employee = null;
        if (employees.containsKey(nameEmployee)) {
            employee = String.valueOf(employees.get(nameEmployee));
        } else {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        }
        return employee;
    }

    @Override
    public String getEmployees() {
        return String.valueOf(employees.values());
    }
}

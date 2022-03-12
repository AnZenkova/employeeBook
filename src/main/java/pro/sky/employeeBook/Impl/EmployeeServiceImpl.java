package pro.sky.employeeBook.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeBook.Exception.EmployeeIsInArrayException;
import pro.sky.employeeBook.Exception.NotFoundEmployeeException;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.data.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "Тихон Крылов", new Employee("Крылов", "Тихон", 105_853.0, 1),
            "Маслова Милиса", new Employee("Маслова", "Милиса", 105_853.0, 1),
            "Яковлев Леонид" ,new Employee("Яковлев", "Леонид", 83_012.0, 2),
            "Полякова Божена", new Employee("Полякова", "Божена", 119_540.0, 2),
            "Волков Мирослав" ,new Employee("Волков", "Мирослав", 148_005.0, 3),
            "Анисимова Данна", new Employee("Анисимова", "Данна", 114_430.0, 3),
            "Соловьёв Ефрем", new Employee("Соловьёв", "Ефрем", 38_911.0, 4),
            "Меркушева Глория", new Employee("Меркушева", "Глория", 52_291.0, 4),
            "Никитин Адам", new Employee("Никитин", "Адам", 66_058.0, 5),
            "Кудрявцева Галина", new Employee("Кудрявцева", "Галина", 47_832.0, 5)
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
    public Employee findEmployees(String nameEmployee) {
        Employee employee = null;
        if (employees.containsKey(nameEmployee)) {
            employee = employees.get(nameEmployee);
        } else {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public double calculateCostOfSalary() { // сумма затрат на зарплаты
        Double sum = employees.values().stream()
                .mapToDouble(value -> value.getEmployeeSalary())
                .sum();
        return sum;
    }

    @Override
    public OptionalDouble findMinSalary() { // найти сотрудника с минимальной зарплатой
        OptionalDouble min = employees.values().stream()
                .mapToDouble(value -> value.getEmployeeSalary())
                .min();
        return min;
    }

    @Override
    public OptionalDouble findMaxSalary() { // найти сотрудника с максимальной зарплатой
        OptionalDouble max = employees.values().stream()
                .mapToDouble(value -> value.getEmployeeSalary())
                .max();
        return max;
    }

    @Override
    public OptionalDouble findAverageSalary() { // средняя зарплата сотрудников
        OptionalDouble average = employees.values().stream()
                .mapToDouble(value -> value.getEmployeeSalary())
                .average();
        return average;
    }

    public DoubleStream indexationSalaryAllEmployees(Integer percent) { // индексация всех зарплат на %
        DoubleStream employeeSalaryPercent = employees.values().stream()
                .mapToDouble(value -> value.getEmployeeSalary() + value.getEmployeeSalary() * percent / 100);
        return employeeSalaryPercent;
        }
    }


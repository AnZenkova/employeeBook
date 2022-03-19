package pro.sky.employeeBook.data;

import java.util.Objects;

public class Employee {
        private String employeeName;
        private String employeeLastName;
        private Double employeeSalary;
        private Integer department;




        public Employee(String employeeLastName, String employeeName, Double employeeSalary, Integer department) {
            this.employeeName = employeeName;
            this.employeeLastName = employeeLastName;
                this.employeeSalary = employeeSalary;
                this.department = department;
        }

        public Double getEmployeeSalary() {
                return employeeSalary;
        }

        public void setEmployeeSalary(Double employeeSalary) {
                this.employeeSalary = employeeSalary;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getEmployeeLastName() {
            return employeeLastName;
        }

        public String toString() {
            return employeeLastName + " " + employeeName + ": зарплата: " + getEmployeeSalary();
        }

        public Integer getDepartment() {
                return department;
        }

        public void setDepartment(Integer department) {
                this.department = department;
        }
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employee employee = (Employee) o;
                return Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeeLastName, employee.employeeLastName) && Objects.equals(employeeSalary, employee.employeeSalary) && Objects.equals(department, employee.department);
        }

        @Override
        public int hashCode() {
                return Objects.hash(employeeName, employeeLastName, employeeSalary, department);
        }
}

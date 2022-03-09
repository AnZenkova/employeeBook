package pro.sky.employeeBook.data;

import java.util.Objects;

public class Employee {
        private String employeeName;
        private String employeeLastName;

        public Employee( String employeeLastName, String employeeName) {
            this.employeeName = employeeName;
            this.employeeLastName = employeeLastName;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getEmployeeLastName() {
            return employeeLastName;
        }


        public String toString() {
            return "Фамилия: " + employeeLastName + "; Имя: " + employeeName + ";";
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Employee employee = (Employee) other;
            return employeeName.equals(employee.employeeName) && employeeLastName.equals(employee.employeeLastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(employeeName, employeeLastName);
        }
}

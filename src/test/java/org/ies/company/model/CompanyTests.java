package org.ies.company.model;

import org.ies.company.exception.DepartmentNotFoundException;
import org.ies.company.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CompanyTests {


    @Test
    public void findEmployeeTest() throws EmployeeNotFoundException {
        var company = createTestCompany();

        var employee = company.findEmployee("1X");

        var expected = new Employee("1X", "Bob", "Esponja", "Programador");

        Assertions.assertEquals(expected, employee);
    }

    @Test
    public void findEmployeeNotFoundTest() {
        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> {
                    var company = createTestCompany();
                    company.findEmployee("lkjsdflkj");
                }
        );
    }

    @Test
    public void findDepartmentTest() throws DepartmentNotFoundException {
        var company = createTestCompany();

        var departament = company.findDepartment("Inf");

        var expected = new Department(
                "Inf",
                List.of(
                        new Employee("1X", "Bob", "Esponja", "Programador"),
                        new Employee("2X", "Peppa", "Pig", "UX")
                )
        );

        Assertions.assertEquals(expected, departament);
    }

    @Test
    public void findDepartmentNotFoundTest() {
        Assertions.assertThrows(
                DepartmentNotFoundException.class,
                () -> {
                    var company = createTestCompany();
                    company.findDepartment("Fake");
                }
        );
    }

    @Test
    public void findEmployeesTest() throws DepartmentNotFoundException {
        var company = createTestCompany();
        var employees = company.getDepartmentEmployees("Inf");

        var expected = List.of(
                new Employee("1X", "Bob", "Esponja", "Programador"),
                new Employee("2X", "Peppa", "Pig", "UX")
        );

        Assertions.assertEquals(expected, employees);
    }

    @Test
    public void findEmployeesDepartmentNotFoundTest() {
        Assertions.assertThrows(
                DepartmentNotFoundException.class,
                () -> {
                    var company = createTestCompany();
                    company.getDepartmentEmployees("Fake");
                }
        );
    }

    private Company createTestCompany() {

        Map<String, Department> departmentsByName = Map.of(
                "Inf",
                new Department(
                        "Inf",
                        List.of(
                                new Employee("1X", "Bob", "Esponja", "Programador"),
                                new Employee("2X", "Peppa", "Pig", "UX")
                        )
                ),
                "RRHH",
                new Department(
                        "RRHH",
                        List.of(
                                new Employee("3X", "George", "Pig", "Jefe")
                        )
                )
        );

        return new Company("Bob Esponja SA", "D94834594D", departmentsByName);
    }
}
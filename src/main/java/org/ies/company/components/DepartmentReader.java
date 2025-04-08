package org.ies.company.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.company.model.Department;
import org.ies.company.model.Employee;

import java.util.ArrayList;
import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class DepartmentReader implements Reader<Department> {
    private final Scanner scanner;
    private final EmployeeReader employeeReader;

    @Override
    public Department read() {
        log.info("DATOS DEL DEPARTAMENTO");
        log.info("Introduce el nombre del departamento: ");
        String name = scanner.nextLine();

        log.info("¿Cuántos empleados quieres buscar?");
        var employees = new ArrayList<Employee>();
        int numEmployees = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numEmployees; i++) {
            employees.add(employeeReader.read());
        }

        return new Department(
                name,
                employees
        );
    }
}

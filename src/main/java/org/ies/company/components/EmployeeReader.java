package org.ies.company.components;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.company.model.Employee;

import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class EmployeeReader implements Reader<Employee> {
    private final Scanner scanner;


    @Override
    public Employee read() {
        log.info(" DATOS DEL EMPLEADO");
        log.info("Introduce el nif: ");
        String  nif = scanner.nextLine();

        log.info("Introduce el nombre : ");
        String name = scanner.nextLine();

        log.info("Introduce el apellido");
        String surname = scanner.nextLine();

        log.info("Introduce el puesto de trabajo: ");
        String rol = scanner.nextLine();

        return new Employee(
                nif,
                name,
                surname,
                rol
        );








    }
}

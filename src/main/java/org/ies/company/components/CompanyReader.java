package org.ies.company.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.company.model.Company;
import org.ies.company.model.Department;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@AllArgsConstructor
@Log4j

public class CompanyReader implements Reader<Company> {
    private final Scanner scanner;
    private final DepartmentReader departmentReader;

    @Override
    public Company read() {
        log.info("DATOS DE LA EMPRESA");
        log.info("Introdice el nombre: ");
        String name = scanner.nextLine();

        log.info("Introduce el CIF: ");
        String cif = scanner.nextLine();

        log.info("Introduce cuantos departamentos quieres buscar: ");
        String option;
        // creamos un mapa
        Map<String, Department> departmentByName = new HashMap<>();

        // guardar el departamento en una variable
        var department = departmentReader.read();
        do{
            // Meter el department ern una varible y luego hacer put   companyName.put();
            departmentByName.put(department.getName(), department);
            log.info("¿Quieres seguir introduciendo departamentos? S/n");
            option = scanner.nextLine();
        }while (option.equalsIgnoreCase("n"));

        return new Company(
                name,
                cif,
                departmentByName
        );

    }
}

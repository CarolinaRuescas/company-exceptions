package org.ies.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.company.exception.DepartmentNotFoundException;
import org.ies.company.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

@Log4j
@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String,Department> departmentsByName;

    // Metodo que muestre todos los departamentos de la empresa
    public void showDepartment(){
        for (var deparment : departmentsByName.values()) {
            log.info(deparment.toString());
        }
    }


    // Dado un nombre de departamento, devuelve los empleados del departamento.
    // En caso de que el departamento  no exista lanza la excepcion DepartmentNotFoundException
    public List<Employee> getDepartmentEmployees(String departmentName) throws DepartmentNotFoundException {
        return findDepartment(departmentName).getEmployees();
    }


    // Dado un nombre de departamento, devuelve el Department con ese nombre.
    // En caso de que el departamento no exista lanza la excepción DepartmentNotFoundException
    public Department findDepartment(String departmentName) throws DepartmentNotFoundException {
        if (departmentsByName.containsKey(departmentName)) {
            return departmentsByName.get(departmentName);
        } else {
            throw new DepartmentNotFoundException(departmentName);
        }
    }


    // Devuelve los datos de un empleado a partir de un NIF.
    // En caso de que el empleado no exista lanza la excepción EmployeeNoFoundException

    public Employee findEmployee(String nif) throws EmployeeNotFoundException {
        return departmentsByName
                .values()
                .stream()
                .flatMap(d -> d.getEmployees().stream())
                .filter(e -> e.getNif().equals(nif))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(nif));

    }

}

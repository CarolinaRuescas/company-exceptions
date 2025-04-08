package org.ies.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.plaf.BorderUIResource;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String,Department> departmentsByName;

    // Metodo que muestre todos los departamentos de la empresa
    public void showDepartment(){

    }



    // Dado un nombre de departamento, devuelve los empleados del departamento.
    // En caso de que el departamento  no exista lanza la excepcion DepartmentNotFoundException




    // Dado un nombre de departamento, devuelve el Department con ese nombre.
    // En caso de que el departamento no exista lanza la excepción DepartmentNotFoundException





    // Devuelve los datos de un empleado a partir de un NIF.
    // En caso de que el empleado no exista lanza la excepción EmployeeNoFoundException








}

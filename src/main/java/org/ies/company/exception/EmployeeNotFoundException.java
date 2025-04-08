package org.ies.company.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends Exception {
    private final String nif;


    public EmployeeNotFoundException(String nif) {
        super("No se ha encontrado al empleado : " + nif);
        this.nif = nif;

    }
}

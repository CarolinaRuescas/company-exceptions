package org.ies.company.exception;

import lombok.Getter;


@Getter
public class DepartmentNotFoundException extends Exception {
    private final String name;

    public DepartmentNotFoundException(String name) {
        super("No se ha encontrado el departamento " + name );
        this.name = name;
    }
}

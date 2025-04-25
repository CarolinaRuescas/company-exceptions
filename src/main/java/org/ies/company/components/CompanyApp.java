package org.ies.company.components;

import lombok.AllArgsConstructor;
import org.ies.company.model.Company;

import java.util.Scanner;

@AllArgsConstructor
public class CompanyApp {
    private final Scanner scanner;
    private final Reader<Company> companyReader;

    public void run() {
        var company = companyReader.read();

    }
}

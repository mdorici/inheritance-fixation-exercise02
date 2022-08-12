package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int taxPayers = sc.nextInt();

        for(int i = 0; i < taxPayers; i++) {
            System.out.printf("Tax payer #%d data: %n", i+1);
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if(type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for(TaxPayer taxPayer : list) {
            System.out.printf(taxPayer.getName()
                    + ": $ "
                    + String.format("%.2f%n", taxPayer.tax()));
            sum += taxPayer.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", sum);

        sc.close();
    }
}

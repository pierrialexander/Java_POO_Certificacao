package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Lê a linha do arquivo
            String employeeCsv = br.readLine();

            // Enquanto for diferente de nulo inclui na lista
            while (employeeCsv != null) {

                String[] fields = employeeCsv.split(",");

                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                // Lê proxima linha
                employeeCsv = br.readLine();
            }

            // Ordena a Lista por ordem alfabética
            Collections.sort(list);

            // Lê a lista e imprime na tela
            for (Employee emp : list) {
                System.out.println(emp.getName() + ", " + emp.getSalary());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
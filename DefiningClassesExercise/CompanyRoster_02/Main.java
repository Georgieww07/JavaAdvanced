package DefiningClassesExercise.CompanyRoster_02;

import DefiningClassesExercise.CompanyRoster_02.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> departments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            String email;
            int age;

            Employee employee = null;
            if (tokens.length == 5){
                if (tokens[4].matches("\\d+")){
                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }else {
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }else if (tokens.length == 6){
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }else if (tokens.length == 4){
                employee = new Employee(name, salary, position, department);
            }

            if (!departments.containsKey(department)){
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            }else {
                departments.get(department).add(employee);
            }
            employeeList.add(employee);

        }

        String maxAverageSalaryDepartment = departments
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverage(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);

        employeeList = employeeList.stream().filter(employee -> employee.getDepartment().equals(maxAverageSalaryDepartment)).collect(Collectors.toList());
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        employeeList.stream().forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));



    }
    public static double getAverage(List<Employee> employees){
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}

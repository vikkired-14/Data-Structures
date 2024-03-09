import java.util.List;

public class Test {

    private int getSecondHighestSalaryEmployee(List<Employee> employeeList){

      return employeeList.stream().mapToInt(Employee::getSalary)
                .filter(salary-> salary< employeeList.stream().mapToInt(Employee::getSalary).max().orElse(0))
                .max()
                .orElseThrow();
                
    }
}

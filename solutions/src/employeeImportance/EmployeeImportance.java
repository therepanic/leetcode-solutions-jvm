package employeeImportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        int[] sum = new int[1];

        bypass(employeeMap.get(id), employeeMap, sum);

        return sum[0];
    }

    public void bypass(Employee employee, Map<Integer, Employee> employeeMap, int[] answer) {
        answer[0]+=employee.importance;

        for (int id : employee.subordinates) {
            bypass(employeeMap.get(id), employeeMap, answer);
        }
    }
}

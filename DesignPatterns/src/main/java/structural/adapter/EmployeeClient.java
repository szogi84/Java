package structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class EmployeeClient {

    public List<Employee> getEmployeeList(){
        List<Employee> employees = new ArrayList<Employee>();

        Employee employeeFromDB = new EmployeeDB("1234","John","Wick","jw@gmail.com");
        employees.add(employeeFromDB);

        //Employee employeeFromLdap = new EmployeeLdap("1","Rambo", "John", "John.Rambo@gmail.com");
        EmployeeLdap employeeFromLdap = new EmployeeLdap("1","Rambo", "John", "John.Rambo@gmail.com");

        //First adapter
        employees.add(new EmployeeAdapterLdap(employeeFromLdap));

        //Second adapter
        EmployeeCSV employeeFromCsv = new EmployeeCSV("567,Sherlock, Holmes, Sherlock@Holmes.com");
        employees.add(new EmployeeAdapterCsv(employeeFromCsv));

        return employees;
    }
}

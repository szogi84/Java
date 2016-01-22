package structural.adapter;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class EmployeeAdapterCsv implements Employee {

    private EmployeeCSV instance;

    public EmployeeAdapterCsv(EmployeeCSV instance) {
        this.instance = instance;
    }

    public String getId() {
        return instance.getId()+"";
    }

    public String getFirstName() {
        return instance.getFirstname();
    }

    public String getLastName() {
        return instance.getLastname();
    }

    public String getEmail() {
        return instance.getEmailAddress();
    }
}

package structural.adapter;

/**
 * Created by sczerwinski on 2016-01-21.
 */
public class EmployeeAdapterLdap implements Employee {

    private EmployeeLdap instance;

    public EmployeeAdapterLdap(EmployeeLdap instance) {
        this.instance = instance;
    }

    public String getId() {
        return instance.getCn();
    }

    public String getFirstName() {
        return instance.getGivenName();
    }

    public String getLastName() {
        return instance.getSurname();
    }

    public String getEmail() {
        return instance.getMail();
    }

    public String toString(){
        return "ID: " + instance.getCn();
    }
}

package messenger.hfad.com.karvyfinal.customerlist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class itemPOJO {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customers")
    @Expose
    private List<Object> customers = null;
    @SerializedName("customer_categories")
    @Expose
    private List<CustomerCategory> customerCategories = null;
    @SerializedName("service_enagegements")
    @Expose
    private List<ServiceEnagegement> serviceEnagegements = null;
    @SerializedName("meetings_agenda")
    @Expose
    private List<MeetingsAgenda> meetingsAgenda = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Object> customers) {
        this.customers = customers;
    }

    public List<CustomerCategory> getCustomerCategories() {
        return customerCategories;
    }

    public void setCustomerCategories(List<CustomerCategory> customerCategories) {
        this.customerCategories = customerCategories;
    }

    public List<ServiceEnagegement> getServiceEnagegements() {
        return serviceEnagegements;
    }

    public void setServiceEnagegements(List<ServiceEnagegement> serviceEnagegements) {
        this.serviceEnagegements = serviceEnagegements;
    }

    public List<MeetingsAgenda> getMeetingsAgenda() {
        return meetingsAgenda;
    }

    public void setMeetingsAgenda(List<MeetingsAgenda> meetingsAgenda) {
        this.meetingsAgenda = meetingsAgenda;
    }

    @Override
    public String toString() {
        return "itemPOJO{" +
                "status='" + status + '\'' +
                ", customers=" + customers +
                ", customerCategories=" + customerCategories +
                ", serviceEnagegements=" + serviceEnagegements +
                ", meetingsAgenda=" + meetingsAgenda +
                '}';
    }
}

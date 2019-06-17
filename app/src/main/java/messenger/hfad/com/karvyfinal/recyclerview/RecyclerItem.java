package messenger.hfad.com.karvyfinal.recyclerview;

public class RecyclerItem {

    private String customer_name;
    private String customer_category;
    private String contact_number;

    public RecyclerItem(String customer_name,String customer_category,String contact_number) {
        this.customer_name=customer_name;
        this.customer_category=customer_category;
        this.contact_number=contact_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_category() {
        return customer_category;
    }

    public void setCustomer_category(String customer_category) {
        this.customer_category = customer_category;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
}

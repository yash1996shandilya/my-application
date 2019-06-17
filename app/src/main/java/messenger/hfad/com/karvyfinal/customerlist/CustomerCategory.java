package messenger.hfad.com.karvyfinal.customerlist;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerCategory {

    @SerializedName("name")
    @Expose
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerCategory{" +
                "name='" + name + '\'' +
                '}';
    }
}

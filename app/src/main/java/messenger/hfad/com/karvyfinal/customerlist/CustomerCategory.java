package messenger.hfad.com.karvyfinal.customerlist;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerCategory {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("require_employee_accompanied")
    @Expose
    private String requireEmployeeAccompanied;
    @SerializedName("options_type")
    @Expose
    private String optionsType;
    @SerializedName("options")
    @Expose
    private List<Object> options = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequireEmployeeAccompanied() {
        return requireEmployeeAccompanied;
    }

    public void setRequireEmployeeAccompanied(String requireEmployeeAccompanied) {
        this.requireEmployeeAccompanied = requireEmployeeAccompanied;
    }

    public String getOptionsType() {
        return optionsType;
    }

    public void setOptionsType(String optionsType) {
        this.optionsType = optionsType;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "CustomerCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requireEmployeeAccompanied='" + requireEmployeeAccompanied + '\'' +
                ", optionsType='" + optionsType + '\'' +
                ", options=" + options +
                '}';
    }
}

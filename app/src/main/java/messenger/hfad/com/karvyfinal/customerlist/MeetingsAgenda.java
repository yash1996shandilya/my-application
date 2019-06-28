package messenger.hfad.com.karvyfinal.customerlist;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MeetingsAgenda {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

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

    @Override
    public String toString() {
        return "MeetingsAgenda{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

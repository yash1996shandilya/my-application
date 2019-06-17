package messenger.hfad.com.karvyfinal.customerlist;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MeetingsAgenda {

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
        return "MeetingsAgenda{" +
                "name='" + name + '\'' +
                '}';
    }
}

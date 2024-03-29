package messenger.hfad.com.karvyfinal.getUser;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private List<UserList> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<UserList> getData() {
        return data;
    }

    public void setData(List<UserList> data) {
        this.data = data;
    }
}

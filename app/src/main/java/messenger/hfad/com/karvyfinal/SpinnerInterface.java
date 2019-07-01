package messenger.hfad.com.karvyfinal;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpinnerInterface {
    String JSONURL = "http://ims.karvyinnotech.com/NBA/api/";

    @GET("v1/users/index")
    Call<String> getJSONString();
}

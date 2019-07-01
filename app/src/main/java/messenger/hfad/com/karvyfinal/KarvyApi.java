package messenger.hfad.com.karvyfinal;

//import messenger.hfad.com.karvyfinal.model.Customers.Example;

import messenger.hfad.com.karvyfinal.auth.authPOJO;
import messenger.hfad.com.karvyfinal.auth.resetPassPOJO;
import messenger.hfad.com.karvyfinal.auth.sendotpPOJO;
import messenger.hfad.com.karvyfinal.customerlist.itemPOJO;
import messenger.hfad.com.karvyfinal.customerlist.submitPOJO;
import messenger.hfad.com.karvyfinal.getUser.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Path;


public interface KarvyApi {

String BASE_URL="http://ims.karvyinnotech.com/NBA/api/";

@FormUrlEncoded
@POST("v1/auth")
    Call<authPOJO> postAuth(
            @Field("employee_id") String employee_id,
            @Field("password") String password,
            @Field("role") String role);



    @FormUrlEncoded
    @POST("v1/users/send_otp?employee_id=12342")
    Call<sendotpPOJO> sendOTP(@Field("employee_id") String employee_id);

    @FormUrlEncoded
    @POST("v1/users/set_password")
    Call<resetPassPOJO> resetPass(@Field("employee_id") String employee_id,
                                  @Field("password") String password,
                                  @Field("otp_code") String otp_code);

    //get customer list
    
    @GET("v1/customers?user_id=88113&version=1.6&source=android")
    Call<String> getItems();

    @GET("v1/users/index")
    Call<User> getUserList();

    @FormUrlEncoded
    @POST("v1/customers")
    Call<submitPOJO> SUBMIT_POJO_CALL(@Field("employee_id") String employee_id,
                               @Field("password") String password,
                               @Field("otp_code") String otp_code);



/*
<include layout="@layout/toolbar"
        android:id="@+id/toolbar"
        />
 */


}





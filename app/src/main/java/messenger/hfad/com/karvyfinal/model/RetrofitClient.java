package messenger.hfad.com.karvyfinal.model;

import messenger.hfad.com.karvyfinal.KarvyApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "http://ims.karvyinnotech.com/NBA/api/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null)
            mInstance=new RetrofitClient();
        return mInstance;

    }
    public KarvyApi getApi(){
        return retrofit.create(KarvyApi.class);
    }
}

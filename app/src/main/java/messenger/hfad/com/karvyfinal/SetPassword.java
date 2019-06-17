package messenger.hfad.com.karvyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import messenger.hfad.com.karvyfinal.auth.authPOJO;
import messenger.hfad.com.karvyfinal.auth.sendotpPOJO;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPassword extends AppCompatActivity {
    private EditText empId;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);


        empId=findViewById(R.id.input_username);
        button=findViewById(R.id.btn_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOTP();
                startActivity(new Intent(SetPassword.this,ResetPassword.class));
            }
        });
    }
    private void sendOTP(){
        String employee_id=empId.getText().toString().trim();
        Call<sendotpPOJO> call= RetrofitClient
                .getInstance().getApi().sendOTP(employee_id);
        call.enqueue(new Callback<sendotpPOJO>() {
            @Override
            public void onResponse(Call<sendotpPOJO> call, Response<sendotpPOJO> response) {
                sendotpPOJO pojo=response.body();
                if(pojo.getStatus().equalsIgnoreCase("success")){
                    Toast.makeText(SetPassword.this,pojo.getMessage(),Toast.LENGTH_LONG).show();


                }else
                    Toast.makeText(SetPassword.this,pojo.getMessage(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<sendotpPOJO> call, Throwable t) {

            }
        });


    }
}

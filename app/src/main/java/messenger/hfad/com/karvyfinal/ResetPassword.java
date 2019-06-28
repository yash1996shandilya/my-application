package messenger.hfad.com.karvyfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import messenger.hfad.com.karvyfinal.auth.resetPassPOJO;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPassword extends AppCompatActivity {
    private EditText empId,enterOtp,Password,ConfirmPassword;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        empId=findViewById(R.id.input_username);
        enterOtp=findViewById(R.id.input_otp);
        Password=findViewById(R.id.input_password);
        ConfirmPassword=findViewById(R.id.input_confirmpassword);
        submit=findViewById(R.id.btn_login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });


    }

    private void resetPassword(){
        String employee_id=empId.getText().toString().trim();
        String password=Password.getText().toString().trim();
        String otp_code=enterOtp.getText().toString().trim();

        final Call<resetPassPOJO> resetPassPOJOCall= RetrofitClient.getInstance().getApi().resetPass(employee_id,password,otp_code);

        resetPassPOJOCall.enqueue(new Callback<resetPassPOJO>() {
            @Override
            public void onResponse(Call<resetPassPOJO> call, Response<resetPassPOJO> response) {
                resetPassPOJO pojoCall=response.body();

                if(!pojoCall.getStatus().equalsIgnoreCase("failure")){
                    Toast.makeText(ResetPassword.this,pojoCall.getMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ResetPassword.this,pojoCall.getMessage(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<resetPassPOJO> call, Throwable t) {

            }
        });

    }
}

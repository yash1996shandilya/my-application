package messenger.hfad.com.karvyfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;




import messenger.hfad.com.karvyfinal.auth.authPOJO;

import messenger.hfad.com.karvyfinal.databaselogin.Users;
import messenger.hfad.com.karvyfinal.databaselogin.UsersDao;
import messenger.hfad.com.karvyfinal.databaselogin.UsersViewModel;
import messenger.hfad.com.karvyfinal.getUser.User;
import messenger.hfad.com.karvyfinal.getUser.UserList;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;

import java.util.List;


public class MainActivity extends AppCompatActivity {



    private static final String TAG = "MainActivity";
     public static final String BASE_URL = "http://ims.karvyinnotech.com/NBA/api/auth";



    private EditText editTextEmpId, editTextPassword;
    private TextView signUp;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         btnLogin =  findViewById(R.id.btn_login);
        editTextEmpId =  findViewById(R.id.input_username);
        editTextPassword =  findViewById(R.id.input_password);

         signUp = findViewById(R.id.link_signup);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();


            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SetPassword.class));
            }
        });
    }

    private void userLogin(){
        String empId=editTextEmpId.getText().toString().trim();
        String pass=editTextPassword.getText().toString().trim();
        String role = "executive".trim();

        Call<authPOJO> call=RetrofitClient
                .getInstance().getApi().postAuth(empId,pass,role);
        call.enqueue(new Callback<authPOJO>() {
            @Override
            public void onResponse(Call<authPOJO> call, Response<authPOJO> response) {
                authPOJO pojo = response.body();
                if(pojo.getStatus().equalsIgnoreCase("success")){
                    //Success case
                    Toast.makeText(MainActivity.this,pojo.getMessage(),Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,CustomerListFinal.class));


                    //Intent intent=new Intent(MainActivity.this,RegistrationActivity.class);
                    //startActivity(intent);

                    //Toast.makeText(MainActivity.this,pojo,Toast.LENGTH_LONG).show();


                }else{
                    //Failure case
                    Toast.makeText(MainActivity.this,pojo.getMessage(),Toast.LENGTH_LONG).show();


                   /* final AlertDialog.Builder invalid=new AlertDialog.Builder(MainActivity.this);
                    invalid.setMessage("Invalid Employee ID or Password")
                            .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });*/


                }
            }

            @Override
            public void onFailure(Call<authPOJO> call, Throwable t) {

            }
        });
    }





}











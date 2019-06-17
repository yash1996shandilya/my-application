package messenger.hfad.com.karvyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import messenger.hfad.com.karvyfinal.auth.authPOJO;
import messenger.hfad.com.karvyfinal.customerlist.CustomerCategory;
import messenger.hfad.com.karvyfinal.customerlist.MeetingsAgenda;
import messenger.hfad.com.karvyfinal.customerlist.ServiceEnagegement;
import messenger.hfad.com.karvyfinal.customerlist.itemPOJO;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DAPForm extends AppCompatActivity {
    //psfs
    public static final String EXTRA_CUSTOMER_NAME="messenger.hfad.com.karvyfinal.EXTRA_CUSTOMER_NAME";
    public static final String EXTRA_CUSTOMER_CATEGORY="messenger.hfad.com.karvyfinal.EXTRA_CUSTOMER_CATEGORY";
    public static final String EXTRA_CONTACT_NUMBER="messenger.hfad.com.karvyfinal.EXTRA_CONTACT_NUMBER";
    private final String TAG="DAPForm";
    private List<CustomerCategory> categoryList=new ArrayList<>();
    private List<ServiceEnagegement> ServiceEngagement=new ArrayList<>();
    private List<MeetingsAgenda> meetingsAgenda=new ArrayList<>();
    private EditText editText1,editText2,editText3,editText4, editText5, editText6, editText7,editText8,editText9,editText10;
    private Spinner spinner,spinner2,spinner3;
    private Button submit;
    private String item1,item2,item3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dapform);
        editText1=findViewById(R.id.edit_text_1);
        editText2=findViewById(R.id.edit_text_2);
        editText3=findViewById(R.id.edit_text_3);
        editText4=findViewById(R.id.edit_text_4);
        editText5=findViewById(R.id.edit_text_5);
        editText6=findViewById(R.id.edit_text_6);
        editText7=findViewById(R.id.edit_text_7);
        editText8=findViewById(R.id.edit_text_8);
        editText9=findViewById(R.id.edit_text_9);
        editText10=findViewById(R.id.edit_text_10);

        submit=findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
        //Retrofit Fetching for Spinner
        //i am fetching the json from postman and showing it with spinner
        //I am asking when you run your application issues with exception right?
        //Show me that exeption in log cat
        //Go to that form in your mobile
        //the form closed on its own.
        //Did you add your code in github ?please share your code let me see once i think that would be better to solve problmems quickly
        //ok sir
        //Add your code in github with some one help and give me code
        //yes sir i will send you after adding it on github.

        Call<itemPOJO> call= RetrofitClient
                .getInstance().getApi().getItems();
        call.enqueue(new Callback<itemPOJO>() {
            @Override
            public void onResponse(Call<itemPOJO> call, Response<itemPOJO> response) {
                System.out.println("response is--->"+response.body());
                 categoryList = response.body().getCustomerCategories();
                 ServiceEngagement = response.body().getServiceEnagegements();
                 meetingsAgenda=response.body().getMeetingsAgenda();
                 setSpinnerData();
            }

            @Override
            public void onFailure(Call<itemPOJO> call, Throwable t) {
                Log.e(TAG,"onFailure: Something went wrong:"+t.getMessage());
                Toast.makeText(DAPForm.this,"Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        //1.Customer Category
        spinner = findViewById(R.id.spinner_1);
        //2.Service Engagement
        spinner2 = findViewById(R.id.spinner_2);
        //3.MeetingsAgenda
        spinner3 = findViewById(R.id.spinner_3);
    }


    /**
     * setSpinnerData
     */
    private void setSpinnerData(){

        try{

            ArrayAdapter<CustomerCategory> adapter=new ArrayAdapter<CustomerCategory>(DAPForm.this,R.layout.spinner_layout,R.id.txt,categoryList);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item1=parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),"Selected :"+item1,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            ArrayAdapter<ServiceEnagegement> adapter1=new ArrayAdapter<ServiceEnagegement>(DAPForm.this,R.layout.spinner_layout,R.id.txt,ServiceEngagement);
            spinner2.setAdapter(adapter1);
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item2=parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(),"Selected :"+item2,Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ArrayAdapter<MeetingsAgenda> adapter2=new ArrayAdapter<MeetingsAgenda>(DAPForm.this,R.layout.spinner_layout,R.id.txt,meetingsAgenda);
            spinner3.setAdapter(adapter2);
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item3=parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),"Selected :"+item3,Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    private void saveNote(){
        String customer_name=editText1.getText().toString();

        String contact_number=editText3.getText().toString();
        String customer_category=item1;

        if(customer_name.trim().isEmpty() || customer_category.trim().isEmpty() || contact_number.trim().isEmpty())
        {
            Toast.makeText(this,"Please insert the fields",Toast.LENGTH_SHORT).show();
            return;

        }

        Intent data=new Intent();
        data.putExtra(EXTRA_CUSTOMER_NAME,customer_name);
        data.putExtra(EXTRA_CUSTOMER_CATEGORY,customer_category);
        data.putExtra(EXTRA_CONTACT_NUMBER,contact_number);
        setResult(RESULT_OK,data);
        finish();



    }

}

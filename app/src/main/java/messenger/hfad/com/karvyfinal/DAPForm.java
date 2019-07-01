package messenger.hfad.com.karvyfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import messenger.hfad.com.karvyfinal.customerlist.CustomerCategory;
import messenger.hfad.com.karvyfinal.customerlist.MeetingsAgenda;
import messenger.hfad.com.karvyfinal.customerlist.ServiceEnagegement;
import messenger.hfad.com.karvyfinal.customerlist.itemPOJO;
import messenger.hfad.com.karvyfinal.databaselogin.Users;
import messenger.hfad.com.karvyfinal.databaselogin.UsersViewModel;
import messenger.hfad.com.karvyfinal.getUser.SpinnerModel;
import messenger.hfad.com.karvyfinal.getUser.SpinnerModel1;
import messenger.hfad.com.karvyfinal.getUser.User;
import messenger.hfad.com.karvyfinal.getUser.UserList;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import static android.R.layout.simple_spinner_item;

public class DAPForm extends AppCompatActivity {
    //date picker
    private DatePickerDialog datePickerDialog;
    //radio buttons
    private RadioButton option1,option2;
    //button for signature pad
    private Button signature;
    private ArrayList<SpinnerModel> goodModelArrayList;
    private ArrayList<String> playerNames = new ArrayList<>();
    private ArrayList<UserList> theUserList1;
    private ArrayList<String> maaw;



    //psfs

    public static final String EXTRA_CUSTOMER_NAME="messenger.hfad.com.karvyfinal.EXTRA_CUSTOMER_NAME";
    public static final String EXTRA_CUSTOMER_CATEGORY="messenger.hfad.com.karvyfinal.EXTRA_CUSTOMER_CATEGORY";
    public static final String EXTRA_CONTACT_NUMBER="messenger.hfad.com.karvyfinal.EXTRA_CONTACT_NUMBER";

    private final String TAG="DAPForm";
    Spinner customSpinner;
    private List<CustomerCategory> categoryList;
    private List<ServiceEnagegement> ServiceEngagement;
    private List<MeetingsAgenda> meetingsAgenda;
    private EditText editText1,editText2,editText3,editText4, editText5, editText6, editText7,editText8,editText9,editText10;
    private Spinner spinner,spinner2,spinner3,spinner4;
    private Button submit;
    private String item1,item2,item3,item4;
   // private UsersDao usersDao;
    private UsersViewModel viewModel;
    List<UserList> theUserList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dapform);
        editText1=findViewById(R.id.edit_text_1);
        editText2=findViewById(R.id.edit_text_2);
        editText3=findViewById(R.id.edit_text_3);
        editText4=findViewById(R.id.edit_text_4);
        //editText5=findViewById(R.id.edit_text_5);
       // editText6=findViewById(R.id.edit_text_6);
        //editText7=findViewById(R.id.edit_text_7);
        //editText8=findViewById(R.id.edit_text_8);
        //editText9=findViewById(R.id.edit_text_9);
        //editText10=findViewById(R.id.edit_text_10);
        editText7=findViewById(R.id.edit_text_7);
        editText7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(DAPForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText7.setText(day+"/"+(month+1)+"/"+year);

                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        if(option1.isChecked()){

        }else if(option2.isChecked()){

        }

        //signature pad
        signature=findViewById(R.id.signaturePad);
        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(SetPassword.this,ResetPassword.class));
                startActivity(new Intent(DAPForm.this,SignatureActivity.class));

            }
        });

        submit=findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
        spinner4 = findViewById(R.id.customIconSpinner);

       //fetchUsers();
        fetchJSON();


/*
        Call<itemPOJO> call= RetrofitClient
                .getInstance().getApi().getItems();
        call.enqueue(new Callback<itemPOJO>() {
            @Override
            public void onResponse(Call<itemPOJO> call, Response<itemPOJO> response) {
                itemPOJO pojo=response.body();
                if(pojo.getStatus()) {
                    //Toast.makeText(DAPForm.this,"Status is false",Toast.LENGTH_SHORT).show();
                    System.out.println("response is--->" + response.body());
                    categoryList = response.body().getCustomerCategories();
                    ServiceEngagement = response.body().getServiceEnagegements();
                    meetingsAgenda = response.body().getMeetingsAgenda();
                    setSpinnerData();



                }








            }

            @Override
            public void onFailure(Call<itemPOJO> call, Throwable t) {
                Log.e(TAG,"onFailure: Something went wrong:"+t.getMessage());
                Toast.makeText(DAPForm.this,"Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });*/
        /*
        //1.Customer Category
        spinner = findViewById(R.id.spinner_1);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
        //2.Service Engagement
        spinner2 = findViewById(R.id.spinner_2);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner2);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
        //3.MeetingsAgenda
        spinner3 = findViewById(R.id.spinner_3);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner3);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }
*/
        //3.MeetingsAgenda
        //spinner4 = findViewById(R.id.customIconSpinner);
        //fetchJSON();




/*

        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner3);

            // Set popupWindow height to 500px
            popupWindow.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }*/
        //ArrayAdapter<UserList> adapter=new ArrayAdapter<UserList>(this,R.layout.spinner_layout,R.id.txt,theUserList);
        //spinner3.setAdapter(adapter);
    }




/*

    private void setSpinnerData(){

        try{



            //mine
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
            ArrayAdapter<UserList> adapter3=new ArrayAdapter<UserList>(DAPForm.this,R.layout.spinner_layout,R.id.txt,theUserList);
            spinner4.setAdapter(adapter3);
            spinner4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    item4=parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),"Selected :"+item4,Toast.LENGTH_SHORT).show();
                }
            });

            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item4=parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),"Selected :"+item4,Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
*/


    private void saveNote(){
        String customer_name=editText1.getText().toString();

        String contact_number=editText3.getText().toString();
        //String customer_category=item1;
        String customer_category=editText2.getText().toString();

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




    private void fetchJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SpinnerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        SpinnerInterface api = retrofit.create(SpinnerInterface.class);

        Call<String> call=api.getJSONString();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring",response.body().toString());
                if(response.isSuccessful()){
                    if(response.body() !=null){
                        Log.i("onSuccess",response.body().toString());
                        String jsonresponse=response.body().toString();
                        spinJSON(jsonresponse);
                    }else{
                        Log.i("onEmptyResponse","Returned empty response");

                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }



    private void spinJSON(String response){

        try {

            JSONObject obj = new JSONObject(response);
            if(obj.getBoolean("status")){

                goodModelArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    SpinnerModel spinnerModel = new SpinnerModel();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    spinnerModel.setName(dataobj.getString("name"));
                    //spinnerModel.setCountry(dataobj.getString("country"));
                    //spinnerModel.setCity(dataobj.getString("city"));
                    //spinnerModel.setImgURL(dataobj.getString("imgURL"));

                    goodModelArrayList.add(spinnerModel);

                }

                for (int i = 0; i < goodModelArrayList.size(); i++){
                    playerNames.add(goodModelArrayList.get(i).getName().toString());
                }

                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(DAPForm.this, simple_spinner_item, playerNames);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                spinner4.setAdapter(spinnerArrayAdapter);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }









}
//
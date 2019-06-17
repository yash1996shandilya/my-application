package messenger.hfad.com.karvyfinal;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import messenger.hfad.com.karvyfinal.Database.Note;
import messenger.hfad.com.karvyfinal.Database.NoteAdapter;
import messenger.hfad.com.karvyfinal.Database.NoteViewModel;
import messenger.hfad.com.karvyfinal.customerlist.CustomerCategory;
import messenger.hfad.com.karvyfinal.customerlist.itemPOJO;
import messenger.hfad.com.karvyfinal.model.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListFinal extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;

    private RecyclerView recyclerView;
    private List<CustomerCategory> listItems;

    //MVVM ARCHITECTURE COMPONENT
    private NoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list_final);
        //Adding a toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Customers List");
        //to bring an arrow on the appbar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Floating Action Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerListFinal.this,DAPForm.class);
                startActivityForResult(intent,ADD_NOTE_REQUEST);
                //startActivity(new Intent(CustomerListFinal.this,DAPForm.class));
            }
        });



        //Recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

         final NoteAdapter adapter=new NoteAdapter();
        recyclerView.setAdapter(adapter);
        //referencing the view model(MVVM ARCHITECTURE)
        noteViewModel = ViewModelProviders.of(CustomerListFinal.this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
















    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_NOTE_REQUEST && resultCode==RESULT_OK)
        {
            String customer_name = data.getStringExtra(DAPForm.EXTRA_CUSTOMER_NAME);
            String customer_category=data.getStringExtra(DAPForm.EXTRA_CUSTOMER_CATEGORY);
            String contact_number=data.getStringExtra(DAPForm.EXTRA_CONTACT_NUMBER);


            //Inserting into our database
            Note note=new Note(customer_name,customer_category,contact_number);
            noteViewModel.insert(note);

            Toast.makeText(this,"Customer saved",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"Customer not saved",Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_save:
                //startActivity(new Intent(MainActivity.this,CustomerListFinal.class));
                startActivity(new Intent(CustomerListFinal.this,MainActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



}

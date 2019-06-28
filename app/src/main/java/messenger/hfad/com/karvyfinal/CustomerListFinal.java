package messenger.hfad.com.karvyfinal;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

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
                adapter.submitList(notes);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                // viewHolder.getAdapterPosition()
                //Swiping operation here
                noteViewModel.delete(adapter.getNodeAt(viewHolder.getAdapterPosition()));
                Toast.makeText(CustomerListFinal.this,"Customer Deleted",Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);
















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

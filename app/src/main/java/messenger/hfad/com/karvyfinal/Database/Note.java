package messenger.hfad.com.karvyfinal.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String customer_name;
    private String customer_category;
    private String contact_number;

    //constructor


    public Note(String customer_name, String customer_category, String contact_number) {
        this.customer_name = customer_name;
        this.customer_category = customer_category;
        this.contact_number = contact_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_category() {
        return customer_category;
    }

    public String getContact_number() {
        return contact_number;
    }
}

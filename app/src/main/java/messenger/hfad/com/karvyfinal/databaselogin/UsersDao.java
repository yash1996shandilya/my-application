package messenger.hfad.com.karvyfinal.databaselogin;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface UsersDao {
    //@Insert
    //    void insert(Note note);
    //
    //    @Update
    //    void update(Note note);
    //
    //    @Delete
    //    void delete(Note note);
    //
    //    @Query("DELETE FROM note_table")
    //    void deleteAllNotes();
    //
    //    @Query("SELECT * FROM note_table ORDER BY id DESC")
    //    LiveData<List<Note>> getAllNotes();
    @Insert
    void insert(Users users);

    @Update
    void update(Users users);

    @Delete
    void delete(Users users);


    @Query("SELECT * from userlist ORDER BY sl_no DESC")
    LiveData<List<Users>> getAllUsers();

    @Query("DELETE FROM userlist")
    void deleteAll();
}

package messenger.hfad.com.karvyfinal.databaselogin;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private UsersRepository repository;
    private LiveData<List<Users>> allUsers;


    public UsersViewModel(@NonNull Application application) {
        super(application);
        repository=new UsersRepository(application);
        allUsers=repository.getAllUsers();
    }
    //reference to repository functions
    public void insert(Users users){
        repository.insert(users);
    }
    public void update(Users users){
        repository.update(users);
    }
    public void delete(Users users){
        repository.delete(users);
    }
    public void deleteAllNotes() {
                repository.deleteAllUsers();
    }
    public LiveData<List<Users>> getAllUsers(){
        return allUsers;
    }


}

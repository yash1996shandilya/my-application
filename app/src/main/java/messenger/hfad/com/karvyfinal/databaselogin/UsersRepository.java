package messenger.hfad.com.karvyfinal.databaselogin;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

//import messenger.hfad.com.karvyfinal.getUser.User;

public class UsersRepository {
    private UsersDao usersDao;
    private LiveData<List<Users>> AllUsers;

    public UsersRepository(Application application){
        UsersRoomDatabase db = UsersRoomDatabase.getInstance(application);
        usersDao = db.usersDao();
        AllUsers = usersDao.getAllUsers();

    }

    public void insert(Users users){
        new InsertUserAsyncTask(usersDao).execute(users);

    }
    public void update(Users users){
        new UpdateUserAsyncTask(usersDao).execute(users);

    }
    public void delete (Users users){
        new DeleteUserAsyncTask(usersDao).execute(users);
    }
    public void deleteAllUsers(){
        new DeleteAllUserAsyncTask(usersDao).execute();
    }
    public LiveData<List<Users>> getAllUsers(){
        return AllUsers;
    }

    private static class InsertUserAsyncTask extends AsyncTask<Users,Void,Void>{
        private UsersDao usersDao;
        private InsertUserAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;

        }

        @Override
        protected Void doInBackground(Users... users) {
            usersDao.insert(users[0]);
            return null;
        }
    }
    private static class UpdateUserAsyncTask extends AsyncTask<Users,Void,Void> {
        private UsersDao usersDao;

        private UpdateUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;

        }

        @Override
        protected Void doInBackground(Users... users) {
            usersDao.update(users[0]);
            return null;
        }
    }
    private static class DeleteUserAsyncTask extends AsyncTask<Users,Void,Void>{
            private UsersDao usersDao;
            private DeleteUserAsyncTask(UsersDao usersDao){
                this.usersDao = usersDao;

            }

            @Override
            protected Void doInBackground(Users... users) {
                usersDao.delete(users[0]);
                return null;
            }
    }

    private static class DeleteAllUserAsyncTask extends AsyncTask<Void,Void,Void>{
        private UsersDao usersDao;
        private DeleteAllUserAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;

        }

        @Override
        protected Void doInBackground(Void... voids) {
            usersDao.deleteAll();
            return null;
        }
    }



}

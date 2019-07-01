package messenger.hfad.com.karvyfinal.databaselogin;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import messenger.hfad.com.karvyfinal.Database.NoteDatabase;

public abstract class UsersRoomDatabase extends RoomDatabase {

    private static UsersRoomDatabase instance;
    public abstract UsersDao usersDao();
    public static synchronized UsersRoomDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    UsersRoomDatabase.class,"userlist_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private UsersDao usersDao;
        private PopulateDbAsyncTask(UsersRoomDatabase db){
            usersDao = db.usersDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            usersDao.insert(new Users(868,"yash-86027"));
            return null;
        }
    }


    //    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
    //        @Override
    //        public void onCreate(@NonNull SupportSQLiteDatabase db) {
    //            super.onCreate(db);
    //            new PopulateDbAsyncTask(instance).execute();
    //        }
    //    };
    //
    //    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
    //
    //        private NoteDao noteDao;
    //        private PopulateDbAsyncTask(NoteDatabase db ){
    //            noteDao = db.noteDao();
    //        }
    //        @Override
    //        protected Void doInBackground(Void... voids) {
    //            noteDao.insert(new Note("ADA","750 accounts","1234545848"));
    //            noteDao.insert(new Note("des","Collection call","9526876667"));
    //
    //            return null;
    //        }
    //    }
}

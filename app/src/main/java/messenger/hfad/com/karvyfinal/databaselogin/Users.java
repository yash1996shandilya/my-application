package messenger.hfad.com.karvyfinal.databaselogin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userlist")
public class Users {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "sl_no")
    private int sl_no;

    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    public Users(@NonNull Integer id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }

    public int getSl_no() {
        return sl_no;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "sl_no=" + sl_no +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

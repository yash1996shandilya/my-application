package messenger.hfad.com.karvyfinal.Database;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import messenger.hfad.com.karvyfinal.R;

public class NoteAdapter extends ListAdapter<Note, NoteAdapter.NoteHolder> {
    //private List<Note> notes = new ArrayList<>();

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();

        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {

            return oldItem.getCustomer_name().equals(newItem.getCustomer_name()) &&
                    oldItem.getCustomer_category().equals(newItem.getCustomer_category()) &&
                    oldItem.getContact_number().equals(newItem.getContact_number());
        }
    };

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item,viewGroup,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder viewHolder, int i) {
        Note currentNote = getItem(i);
        viewHolder.customername.setText(currentNote.getCustomer_name());
        viewHolder.customercategory.setText(currentNote.getCustomer_category());
        viewHolder.contactnumber.setText(currentNote.getContact_number());

    }




    public Note getNodeAt(int position){
        return getItem(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView customername;
        private TextView customercategory;
        private TextView contactnumber;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            customername = itemView.findViewById(R.id.customername);
            customercategory = itemView.findViewById(R.id.customercategory);
            contactnumber = itemView.findViewById(R.id.contactnumber);

        }
    }
}


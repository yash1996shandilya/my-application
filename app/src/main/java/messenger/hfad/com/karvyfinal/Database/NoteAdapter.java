package messenger.hfad.com.karvyfinal.Database;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import messenger.hfad.com.karvyfinal.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item,viewGroup,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder viewHolder, int i) {
        Note currentNote = notes.get(i);
        viewHolder.customername.setText(currentNote.getCustomer_name());
        viewHolder.customercategory.setText(currentNote.getCustomer_category());
        viewHolder.contactnumber.setText(currentNote.getContact_number());

    }


    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
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

package com.cbalt.stressless.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cbalt.stressless.PendingClickListener;
import com.cbalt.stressless.R;
import com.cbalt.stressless.data.Queries;
import com.cbalt.stressless.models.Pending;

import java.util.List;

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder> {

    private List<Pending> pendings = new Queries().pendings();
    private PendingClickListener listener;

    public PendingsAdapter(PendingClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pending, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        Pending pending = pendings.get(i);
        viewHolder.textView.setText(pending.getName());
        viewHolder.checkBox.setChecked(pending.isDone());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition = viewHolder.getAdapterPosition();
                            Pending auxPending = pendings.get(auxPosition);
                            auxPending.setDone(true);
                            auxPending.save();
                            pendings.remove(auxPosition);
                            notifyItemRemoved(auxPosition);

                        }
                    }, 400);
                }
            }
        });

        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pending auxPending = pendings.get(viewHolder.getAdapterPosition());
                listener.clickedID(auxPending.getId() );
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }


    public void update(Pending pending){
        pendings.add(pending);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.pendingCb);
            textView = itemView.findViewById(R.id.pendingTv);
        }
    }
}

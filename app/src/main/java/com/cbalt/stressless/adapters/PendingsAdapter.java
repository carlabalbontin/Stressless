package com.cbalt.stressless.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cbalt.stressless.R;
import com.cbalt.stressless.data.Queries;
import com.cbalt.stressless.models.Pending;

import java.util.List;

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder> {

    private List<Pending> pendings = new Queries().pendings();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pending, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Pending pending = pendings.get(i);
        viewHolder.textView.setText(pending.getName());
        viewHolder.checkBox.setChecked(pending.isDone());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Método cuando checkeo el checkbox
            }
        });

        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Método cuando hago click en el texto
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendings.size();
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

package com.cbalt.stressless.views.main.pendings;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cbalt.stressless.R;
import com.cbalt.stressless.adapters.PendingsAdapter;
import com.cbalt.stressless.models.Pending;
import com.cbalt.stressless.adapters.PendingClickListener;
import com.cbalt.stressless.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingListFragment extends Fragment implements PendingClickListener {

    private PendingsAdapter adapter;

    public PendingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void addPending(Pending pending) {
        adapter.addPending(pending);
    }

    public void updateList(String name){
        Toast.makeText(getContext(), "Search!", Toast.LENGTH_SHORT).show();
        adapter.updateByName(name);
    }

    @Override
    public void clickedID(long id) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

package com.cbalt.stressless.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.cbalt.stressless.R;
import com.cbalt.stressless.models.Pending;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id = getIntent().getLongExtra("id", 0);
        pending = Pending.findById(Pending.class, id);

        getSupportActionBar().setTitle(pending.getName());
        editText = findViewById(R.id.descriptionEt);
    }


    @Override
    protected void onResume() {
        super.onResume();
        String description = pending.getDescription();
        if (description != null) {
            editText.setText(description);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        String description = editText.getText().toString();
        pending.setDescription(description);
        pending.save();
    }
}

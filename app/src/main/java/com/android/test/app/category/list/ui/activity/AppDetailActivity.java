package com.android.test.app.category.list.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.ui.fragment.AppDetailFragment;
import com.android.test.app.category.list.ui.utils.intents.IntentsKeyConstanst;

/**
 * Activity Item details screen
 *
 * @autor Fabian Hoyos
 */
public class AppDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App Details", Snackbar.LENGTH_LONG)
                        .setAction("Details", null).show();
            }
        });


        Bundle arguments = new Bundle();
        arguments.putSerializable(IntentsKeyConstanst.APP_ID_KEY, getIntent().getStringExtra(IntentsKeyConstanst.APP_ID_KEY));
        AppDetailFragment fragment = new AppDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction().add(R.id.item_detail_container, fragment).commit();


    }


}

package com.android.test.app.category.list.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.ui.activity.interfaces.AppView;
import com.android.test.app.category.list.ui.fragment.interfaces.AppFragmentBackEvent;
import com.android.test.app.category.list.ui.fragment.interfaces.AppFragmentEvent;
import com.android.test.app.category.list.presenter.AppPresenter;
import com.android.test.app.category.list.presenter.AppPresenterImpl;
import com.android.test.app.category.list.ui.utils.intents.IntentUtils;
import com.android.test.app.category.list.ui.utils.intents.IntentsKeyConstanst;

import java.util.HashMap;

import io.realm.RealmResults;


/**
 * App Activity screen
 *
 * @author Fabian Hoyos
 */
public class AppActivity extends AppCompatActivity implements AppView, AppFragmentEvent {

    private AppFragmentBackEvent mAppFragmentBackEvent;
    private AppPresenter mAppPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppPresenter = new AppPresenterImpl(this);
        mAppFragmentBackEvent = (AppFragmentBackEvent) getSupportFragmentManager().findFragmentById(R.id.fragment_app);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        mAppPresenter.loadAppList(getIntent().getStringExtra(IntentsKeyConstanst.CATEGORY_ID_KEY));
    }

    @Override
    public void onSelectApp(Item app) {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put(IntentsKeyConstanst.APP_ID_KEY, app.getId().toString());
        IntentUtils.sendIntent(this, AppDetailActivity.class, parameters);
    }

    @Override
    public void showAppList(RealmResults<Item> items) {
        mAppFragmentBackEvent.loadAppList(items);
    }

    @Override
    public void showLoadingScreen(String title) {

    }

    @Override
    public void hideLoadingScreen() {

    }

    @Override
    public void showError(String title, String error) {

    }

    @Override
    public void success() {

    }
}

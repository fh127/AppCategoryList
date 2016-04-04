package com.android.test.app.category.list.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.ui.fragment.AppTabletFragment;
import com.android.test.app.category.list.ui.fragment.interfaces.MainFragmentBackEvent;
import com.android.test.app.category.list.ui.fragment.interfaces.MainFragmentEvent;
import com.android.test.app.category.list.ui.activity.interfaces.MainView;
import com.android.test.app.category.list.presenter.MainPresenter;
import com.android.test.app.category.list.presenter.MainPresenterImpl;
import com.android.test.app.category.list.ui.utils.dialog.DialogUtils;
import com.android.test.app.category.list.ui.utils.intents.IntentUtils;
import com.android.test.app.category.list.ui.utils.intents.IntentsKeyConstanst;

import java.util.HashMap;

import io.realm.RealmResults;


/**
 * Activity main screen
 *
 * @autor Fabian Hoyos
 */
public class MainActivity extends AppCompatActivity implements MainView, MainFragmentEvent {
    private boolean mTwoPane;
    private MainFragmentBackEvent mMainFragmentBackEvent;
    private MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMainFragmentBackEvent = (MainFragmentBackEvent) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.loadCategoryList(this);
        if (findViewById(R.id.app_container) != null) {
            mTwoPane = true;
        }
    }


    @Override
    public void showCategoryList(RealmResults<Category> categories) {
        mMainFragmentBackEvent.loadCategoryList(categories);
    }


    @Override
    public void onSelectCategory(Category category) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putSerializable(IntentsKeyConstanst.CATEGORY_ID_KEY, category.getId());
            AppTabletFragment fragment = new AppTabletFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.app_container, fragment).commit();
        } else {
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put(IntentsKeyConstanst.CATEGORY_ID_KEY, category.getId().toString());
            IntentUtils.sendIntent(this, AppActivity.class, parameters);
        }
    }

    @Override
    public void showError(String title, String error) {
        DialogUtils.showDialog(this, title, error);
    }

    @Override
    public void success() {

    }

    @Override
    public void showLoadingScreen(String title) {

    }

    @Override
    public void hideLoadingScreen() {

    }

}

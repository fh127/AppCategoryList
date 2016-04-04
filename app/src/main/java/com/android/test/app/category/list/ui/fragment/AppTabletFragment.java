package com.android.test.app.category.list.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.app.App;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.activity.interfaces.AppView;
import com.android.test.app.category.list.ui.adapter.AppAdapter;
import com.android.test.app.category.list.ui.adapter.interfaces.OnItem;
import com.android.test.app.category.list.ui.dialog.AppDetailsDialog;
import com.android.test.app.category.list.presenter.AppPresenter;
import com.android.test.app.category.list.presenter.AppPresenterImpl;
import com.android.test.app.category.list.ui.utils.intents.IntentsKeyConstanst;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmList;
import io.realm.RealmResults;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 *
 * @autor Fabian Hoyos
 */
public class AppTabletFragment extends Fragment implements AppView, OnItem {

    private Context context;
    private AppAdapter mAppAdapter;
    private AppPresenter mAppPresenter;
    String categoryId;
    @Bind(R.id.app_recycler_view)
    RecyclerView appRecyclerView;

    public AppTabletFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppPresenter = new AppPresenterImpl(this);
        if (getArguments().containsKey(IntentsKeyConstanst.CATEGORY_ID_KEY)) {
            categoryId = getArguments().getString(IntentsKeyConstanst.CATEGORY_ID_KEY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_app, container, false);
        ButterKnife.bind(this, rootView);
        context = getActivity();
        configureView();
        mAppPresenter.loadAppList(categoryId);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }


    @Override
    public void onItem(Object object) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(IntentsKeyConstanst.APP_ID_KEY, ((Item) object).getId());
        AppDetailsDialog dialogFragment = new AppDetailsDialog();
        dialogFragment.setArguments(arguments);
        dialogFragment.show(getFragmentManager(), App.getStringFromId(R.string.app_name));


    }


    /**
     * this method to configure initial view
     */
    private void configureView() {
        appRecyclerView.setHasFixedSize(true);
        appRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAppAdapter = new AppAdapter(getActivity(), this);

    }

    @Override
    public void showAppList(RealmResults<Item> items) {
        RealmList<Item> appList = new RealmList<>();
        appList.addAll(items.subList(0, items.size()));
        Observable.from(appList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Item>() {
                    @Override
                    public void onCompleted() {
                        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(mAppAdapter);
                        scaleInAnimationAdapter.setDuration(Constants.ITEM_DELAY);
                        appRecyclerView.setAdapter(scaleInAnimationAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Item item) {
                        mAppAdapter.addCategory(item);
                    }
                });
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

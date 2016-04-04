package com.android.test.app.category.list.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.adapter.AppAdapter;
import com.android.test.app.category.list.ui.adapter.interfaces.OnItem;
import com.android.test.app.category.list.ui.fragment.interfaces.AppFragmentBackEvent;
import com.android.test.app.category.list.ui.fragment.interfaces.AppFragmentEvent;

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
public class AppFragment extends Fragment implements AppFragmentBackEvent, OnItem {

    private AppFragmentEvent mCallback;
    private Context context;
    private AppAdapter mAppAdapter;
    @Bind(R.id.app_recycler_view)
    RecyclerView appRecyclerView;

    public AppFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_app, container, false);
        ButterKnife.bind(this, rootView);
        context = getActivity();
        mCallback = (AppFragmentEvent) getActivity();
        configureView();
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @Override
    public void loadAppList(RealmResults<Item> apps) {
        RealmList<Item> appList = new RealmList<>();
        appList.addAll(apps.subList(0, apps.size()));
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
    public void onItem(Object object) {

        mCallback.onSelectApp((Item) object);
    }


    /**
     * this method to configure initial view
     */
    private void configureView() {
        appRecyclerView.setHasFixedSize(true);
        appRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAppAdapter = new AppAdapter(getActivity(), this);
    }

}

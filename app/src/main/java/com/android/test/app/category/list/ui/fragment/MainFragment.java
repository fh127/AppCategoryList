package com.android.test.app.category.list.ui.fragment;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.adapter.CategoryAdapter;
import com.android.test.app.category.list.ui.adapter.interfaces.OnItem;
import com.android.test.app.category.list.ui.fragment.interfaces.MainFragmentBackEvent;
import com.android.test.app.category.list.ui.fragment.interfaces.MainFragmentEvent;
import com.victor.loading.rotate.RotateLoading;

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
public class MainFragment extends Fragment implements MainFragmentBackEvent, OnItem {

    private MainFragmentEvent mCallback;
    private CategoryAdapter mCategoryAdapter;
    @Nullable
    @Bind(R.id.rotate_loading_view)
    RotateLoading rotateLoadingView;
    @Bind(R.id.category_recycler_view)
    RecyclerView categoryRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        mCallback = (MainFragmentEvent) getActivity();
        configureView();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @Override
    public void loadCategoryList(RealmResults<Category> categories) {

        RealmList<Category> categoryList = new RealmList<>();
        categoryList.addAll(categories.subList(0, categories.size()));
        Observable.from(categoryList)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Category>() {
                    @Override
                    public void onCompleted() {

                        categoryRecyclerView.postDelayed(() -> {
                            if (rotateLoadingView != null) {
                                rotateLoadingView.stop();
                                rotateLoadingView.setVisibility(View.GONE);
                            }
                            categoryRecyclerView.setVisibility(View.VISIBLE);
                            ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(mCategoryAdapter);
                            scaleInAnimationAdapter.setDuration(Constants.ITEM_DELAY);
                            categoryRecyclerView.setAdapter(scaleInAnimationAdapter);

                        }, Constants.DEFAULT_DELAY);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Category category) {
                        mCategoryAdapter.addCategory(category);
                    }
                });

    }


    /**
     * this method to configure initial view
     */
    private void configureView() {
        if (rotateLoadingView != null)
            rotateLoadingView.start();
        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCategoryAdapter = new CategoryAdapter(this);
        categoryRecyclerView.setVisibility(View.GONE);

    }

    @Override
    public void onItem(Object object) {
        mCallback.onSelectCategory((Category) object);
    }
}

package com.android.test.app.category.list.ui.dialog;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alexzh.circleimageview.CircleImageView;
import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.fragment.interfaces.AppDetailsView;
import com.android.test.app.category.list.presenter.AppDetailsPresenter;
import com.android.test.app.category.list.presenter.AppDetailsPresenterImpl;
import com.android.test.app.category.list.ui.utils.intents.IntentsKeyConstanst;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * this class to manage a dialog fragment to show app details {@link android.support.v4.app.DialogFragment}
 * @autor Fabian Hoyos
 */
public class AppDetailsDialog extends android.support.v4.app.DialogFragment implements AppDetailsView{


    private AppDetailsPresenter mAppDetailsPresenter;
    String id;
    @Bind(R.id.app_image)
    CircleImageView appImageView;
    @Bind(R.id.summary_text)
    TextView summaryTextView;

    /**
     * constructor for the fragment manager to instantiate the
     * fragment.
     */
    public AppDetailsDialog () {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppDetailsPresenter = new AppDetailsPresenterImpl(this);
        if (getArguments().containsKey(IntentsKeyConstanst.APP_ID_KEY)) {
            id = getArguments().getString(IntentsKeyConstanst.APP_ID_KEY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        ButterKnife.bind(this, rootView);
        mAppDetailsPresenter.loadAppDetails(id);
        ScrollView scrollView=new ScrollView(getActivity());
        return rootView;
    }

    @Override
    public void onShowAppDetails(Item item) {
        if (item != null) {
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(item.getName());
            }
            Picasso.with(getActivity()).load(item.getImages().get(Constants.MEDIUM_IMAGE_POSITION).getUrl()).into(appImageView);
            summaryTextView.setText(item.getSummary());
            appImageView.animate().rotationBy(Constants.ANGLE_ANIMATION_IMAGE).setDuration(Constants.TIME_ANIMATION_IMAGE).setInterpolator(new LinearInterpolator()).start();

        }
    }

    @Override
    public int getTheme() {
        return R.style.MyCustomThemeDialog;
    }


}

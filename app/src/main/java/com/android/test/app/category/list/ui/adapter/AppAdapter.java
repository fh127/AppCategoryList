package com.android.test.app.category.list.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Item;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.adapter.interfaces.OnItem;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmList;

/**
 * App Adapter
 *
 * @author Fabian Hoyos
 */
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    private RealmList<Item> mItems;
    private OnItem mOnItem;
    private Context context;

    /**
     * class constructor
     *
     * @param context
     * @param mOnItem
     */
    public AppAdapter(Context context, OnItem mOnItem) {
        super();
        mItems = new RealmList<Item>();
        this.mOnItem = mOnItem;
        this.context = context;
    }

    /**
     * this method to add item
     *
     * @param item
     */
    public void addCategory(Item item) {
        mItems.add(item);
        notifyDataSetChanged();
    }


    /**
     * this method to remove category
     *
     * @param item
     */
    public void removeData(Item item) {
        int position = mItems.indexOf(item);
        mItems.remove(position);
        notifyDataSetChanged();
    }

    /**
     * this method to clear category list
     */
    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.appTextView.setText(mItems.get(position).getName());
        if(holder.appImageView!=null) Picasso.with(context).load(mItems.get(position).getImages().get(Constants.SMALL_IMAGE_POSITION).getUrl()).into(holder.appImageView);
        if(holder.appImage!=null) Picasso.with(context).load(mItems.get(position).getImages().get(Constants.BIG_IMAGE_POSITION).getUrl()).into(holder.appImage);
        holder.cardView.setOnClickListener(v -> mOnItem.onItem(mItems.get(position)));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * View holder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.app_name)
        TextView appTextView;
        @Nullable @Bind(R.id.app_image)
        CircleImageView appImageView;
        @Nullable @Bind(R.id.app_image_2)
        ImageView appImage;
        @Bind(R.id.app_card_view)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
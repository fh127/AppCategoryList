package com.android.test.app.category.list.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.persistence.entity.Category;
import com.android.test.app.category.list.ui.adapter.interfaces.OnItem;


import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmList;

/**
 * Category Adapter
 * @author Fabian Hoyos
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private RealmList<Category> mItems;
    private OnItem mOnItem;


    /**
     * class constructor
     *
     * @param mOnItem
     */
    public CategoryAdapter(OnItem mOnItem) {
        super();
        mItems = new RealmList<Category>();
        this.mOnItem = mOnItem;
    }

    /**
     * this method to add category
     *
     * @param category
     */
    public void addCategory(Category category) {
        mItems.add(category);
        notifyDataSetChanged();
    }


    /**
     * this method to remove category
     *
     * @param category
     */
    public void removeData(Category category) {
        int position = mItems.indexOf(category);
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
                .inflate(R.layout.category_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.categoryTextView.setText(mItems.get(position).getName());
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
        @Bind(R.id.category_name)
        TextView categoryTextView;
        @Bind(R.id.category_card_view)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
package com.example.newyorktime.newyorktimes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.newyorktime.newyorktimes.Activities.ItemDetailActivity;
import com.example.newyorktime.newyorktimes.Activities.ItemDetailFragment;
import com.example.newyorktime.newyorktimes.Activities.ItemListActivity;

import com.example.newyorktime.newyorktimes.Model.Article;
import com.example.newyorktime.newyorktimes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private List<Article> articleList;
    private boolean mTwoPane;
    private ItemListActivity mParentActivity;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, publishedDate, byline;
        public RelativeLayout item_view;
        public ImageView img_article;

        public MyViewHolder(View view) {
            super(view);

           title = (TextView) view.findViewById(R.id.title);
           byline = (TextView) view.findViewById(R.id.byline);
           publishedDate = (TextView) view.findViewById(R.id.publish_date);
            item_view=(RelativeLayout) view.findViewById(R.id.item_view);
            img_article = (ImageView) view.findViewById(R.id.img_article);
        }
    }


    public ArticleAdapter(List<Article> moviesList) {
        this.articleList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.title.setText(article.getTitle());
       holder.byline.setText(article.getByline());
       holder.publishedDate.setText(article.getPublished_date());
        holder.itemView.setTag(position);
       Picasso.get().load(article.getMedia().get(0).getMedia_metadata().get(0).getUrl()).into(holder.img_article);
        holder.itemView.setOnClickListener(mOnClickListener);
    }
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int item = (int) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
              //  arguments.putString(ItemDetailFragment.ARG_ITEM_ID, articleList.get(item).toString());

                arguments.putSerializable(ItemDetailFragment.ARG_ITEM_ID, articleList.get(item));
                ItemDetailFragment fragment = new ItemDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.test_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
              //  intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, view.getTag().toString());
                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, articleList.get(item));

                context.startActivity(intent);
            }
        }
    };
    @Override
    public int getItemCount() {
        return articleList.size();
    }
}

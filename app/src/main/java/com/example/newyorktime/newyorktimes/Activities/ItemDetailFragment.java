package com.example.newyorktime.newyorktimes.Activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.newyorktime.newyorktimes.Model.Article;
import com.example.newyorktime.newyorktimes.R;

import com.squareup.picasso.Picasso;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends android.support.v4.app.Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Article articleItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            articleItem = (Article) getArguments().getSerializable(ARG_ITEM_ID);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        ((android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar)).setNavigationIcon(R.drawable.ic_back);
        ((android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar)).setTitle("Article Detail");
        ((android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar)).setTitleTextColor(Color.WHITE);
        ((android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        // Show the dummy content as text in a TextView.
        if (articleItem != null) {
            ((TextView) rootView.findViewById(R.id.tv_title)).setText(articleItem.getTitle());
            ((TextView) rootView.findViewById(R.id.tv_byline)).setText(articleItem.getByline());
            ((TextView) rootView.findViewById(R.id.tv_publishedDate)).setText(articleItem.getPublished_date());
            ((TextView) rootView.findViewById(R.id.tv_description)).setText(articleItem.getMedia().get(0).getCaption());
            Picasso.get().load(articleItem.getMedia().get(0).getMedia_metadata().get(0).getUrl()).into(((ImageView) rootView.findViewById(R.id.img_article)));
        }

        return rootView;
    }
}

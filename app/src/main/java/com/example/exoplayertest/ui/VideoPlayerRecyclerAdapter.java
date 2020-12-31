package com.example.exoplayertest.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.exoplayertest.R;
import com.example.exoplayertest.data.model.MainResponseBody;
import com.example.exoplayertest.data.model.MediaObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    public static final String TAG = "AdapterClass";

    View parent;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoPlayerViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_video_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((VideoPlayerViewHolder)viewHolder).onBind(mList.get(i));
        ((VideoPlayerViewHolder) viewHolder).title.setText(mList.get(i).getUserInfo().getUsername());
        Log.d(TAG, "onBindViewHolder: 1 " + mList.get(i));
        Log.d(TAG, "onBindViewHolder: 2 "  +  mList.get(i).getUserInfo());
        Log.d(TAG, "onBindViewHolder: 3 "+  mList.get(i).getUserInfo().getFirst_name());

        Glide.with(((VideoPlayerViewHolder) viewHolder).parent.getContext()).load(mList.get(i).getThum()).into(((VideoPlayerViewHolder) viewHolder).thumbnail);
        String first_name = mList.get(i).getUserInfo().getFirst_name();
        String last_name = mList.get(i).getUserInfo().getLast_name();
        ((VideoPlayerViewHolder) viewHolder).fullname.setText(first_name + " " + last_name);
        ((VideoPlayerViewHolder) viewHolder).likes_image.setImageResource(R.drawable.love_icon);

        ((VideoPlayerViewHolder) viewHolder).likes_count.setText(mList.get(i).getLiked());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateListData(List<MainResponseBody> data) {
        mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();

    }
    @Inject
    public VideoPlayerRecyclerAdapter() {
        mList = new ArrayList<>();

    }
    private ArrayList<MainResponseBody> mList;

}

package com.example.exoplayertest.ui;

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
        ((VideoPlayerViewHolder) viewHolder).title.setText(mList.get(i).getId());
        Glide.with(((VideoPlayerViewHolder) viewHolder).parent.getContext()).load(mList.get(i).getThum()).into(((VideoPlayerViewHolder) viewHolder).thumbnail);

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

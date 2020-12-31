package com.example.exoplayertest.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.exoplayertest.R;
import com.example.exoplayertest.data.model.MainResponseBody;
import com.example.exoplayertest.data.model.MediaObject;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {
    FrameLayout media_container;
    TextView title,fullname,likes_count;
    ImageView thumbnail, volumeControl,profilePic,likes_image;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_control);
        fullname = itemView.findViewById(R.id.name);
        profilePic = itemView.findViewById(R.id.profile_pic);
        likes_image = itemView.findViewById(R.id.likes_image);
        likes_count = itemView.findViewById(R.id.likes_count);
    }

    public void onBind(MainResponseBody mainResponseBody) {
        this.requestManager = requestManager;
        parent.setTag(this);
      //  title.setText(mediaObject.getTitle());
//        this.requestManager
//                .load(mainResponseBody.getThum())
//                .into(thumbnail);


    }
}

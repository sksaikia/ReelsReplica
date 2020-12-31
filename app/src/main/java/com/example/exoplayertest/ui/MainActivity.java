package com.example.exoplayertest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.exoplayertest.R;
import com.example.exoplayertest.data.model.AuthBody;
import com.example.exoplayertest.data.model.MainResponseBody;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private static final String TAG = "MainActivity";

    private VideoPlayerRecyclerView mRecyclerView;

    @Inject
    MainViewModel viewModel;

    @Inject
            VideoPlayerRecyclerAdapter adapter;

    FragmentManager fragmentManager;

    @Inject
    HomeFragment homeFragment;

    ArrayList<MainResponseBody> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidInjection.inject(this);


        mRecyclerView = findViewById(R.id.recycler_view);

        AuthBody authBody = new AuthBody();

        viewModel.getData(authBody);
        initRecyclerView();
        subscribeForData();



    }

    private void subscribeForData() {
        viewModel.getAllData().observe(this, new Observer<ArrayList<MainResponseBody>>() {
            @Override
            public void onChanged(ArrayList<MainResponseBody> mainResponseBodies) {
                mList = mainResponseBodies;

                for(MainResponseBody m : mList){
                    Log.d(TAG, "onChanged: " + m.getVideo() + "  " + m.getId()+" " + m.getThum());
                }

                adapter.updateListData(mList);
                mRecyclerView.setMediaObjects(mList);
            }
        });
    }

//    private void initFrag(Fragment fragment) {
//
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.replace(R.id.frame_layout, fragment);
//        ft.commit();
//
//
//    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        initGlide();
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);

//        ArrayList<MediaObject> mediaObjects = new ArrayList<MediaObject>(Arrays.asList(Resources.MEDIA_OBJECTS));

//        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide());
       mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            mRecyclerView.releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            mRecyclerView.releasePlayer();
        }
    }

}
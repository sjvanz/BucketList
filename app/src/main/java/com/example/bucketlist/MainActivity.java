package com.example.bucketlist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.RecyclerView;


import com.example.bucketlist.Database.BucketAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.RecyclerViewBucketList)
    RecyclerView mBacklogRecyclerView;

    @OnClick(R.id.fab)
    void fabClickHandler(){
        Intent intent = new Intent(this,EditorActivity.class);
        startActivity(intent);
    }
    private List <BucketModel> BucketList = new ArrayList<>();
    private BucketAdapter mAdapter;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        initRecyclerView();
        initViewModel();
    }

    private void initViewModel() {

        final Observer<List<BucketModel>> bucketObserver = new Observer<List<BucketModel>>() {
            @Override
            public void onChanged(@Nullable List<BucketModel> bucketModels) {
                BucketList.clear();
                BucketList.addAll(bucketModels);

                if(mAdapter == null) {
                    mAdapter = new BucketAdapter(BucketList,MainActivity.this);
                    mBacklogRecyclerView.setAdapter(mAdapter);
                }
                else {
                    mAdapter.notifyDataSetChanged();;
                }
            }
        };
        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        mViewModel.mBucketlist.observe(this,bucketObserver);

    }

    private void initRecyclerView() {
        mBacklogRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mBacklogRecyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_sample_data) {
            addSampleData();
            return true;
        }
        else if (id == R.id.action_delete_all){
            deleteBucketList();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteBucketList() {
        mViewModel.deleteBucketList();
    }

    private void addSampleData() {
        mViewModel.addSampleData();
    }
}

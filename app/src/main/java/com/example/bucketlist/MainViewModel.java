package com.example.bucketlist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.bucketlist.Database.AppRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<BucketModel>> mBucketlist;
    private AppRepository mRepo;
    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepo = AppRepository.getInstance(application.getApplicationContext());
        mBucketlist = mRepo.mBucketList;
    }

    public void addSampleData() {
        mRepo.addSampleData();
    }

    public void deleteBucketList() {
        mRepo.deleteBucketList();
    }
}

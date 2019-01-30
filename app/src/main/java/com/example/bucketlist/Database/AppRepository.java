package com.example.bucketlist.Database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.bucketlist.BucketModel;
import com.example.bucketlist.sampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;

    public LiveData<List<BucketModel>> mBucketList;
    private BucketDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        mDb = BucketDatabase.getInsstance(context);
        mBucketList = getAllBucketItems();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.bucketDao().insertAll(sampleData.getList());
            }
        });
    }

    private LiveData<List<BucketModel>> getAllBucketItems() {
        return mDb.bucketDao().getAll();
    }

    public void deleteBucketList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
               mDb.bucketDao().deleteAll();
            }
        });
    }

    public void insertBucketList(BucketModel bucket) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.bucketDao().insertBucketItem(bucket);
            }
        });
    }
}

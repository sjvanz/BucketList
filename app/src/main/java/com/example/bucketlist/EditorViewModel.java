package com.example.bucketlist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.bucketlist.Database.AppRepository;

import java.util.Date;

public class EditorViewModel extends AndroidViewModel {

    public MutableLiveData<BucketModel> mLiveBucketlist =
            new MutableLiveData<>();

    private AppRepository mRepo;

    public EditorViewModel(@NonNull Application application) {
        super(application);
        mRepo = AppRepository.getInstance(getApplication());
    }


    public void saveBucketlistItem(String toString, String toString1) {
        BucketModel bucket = mLiveBucketlist.getValue();

        if( bucket == null){
            if(TextUtils.isEmpty(toString.trim())&& TextUtils.isEmpty(toString1.trim())){
                return;
            }
            bucket = new BucketModel(false,toString.trim(),toString1.trim(), new Date());
        }
        else {

        }
        mRepo.insertBucketList(bucket);
    }
}

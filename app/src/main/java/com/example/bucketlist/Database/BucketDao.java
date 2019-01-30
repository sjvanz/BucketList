package com.example.bucketlist.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.bucketlist.BucketModel;

import java.util.List;

@Dao
public interface BucketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBucketItem(BucketModel bucketModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll (List<BucketModel> bucketModels);

    @Delete
    void deleteBucketItem(BucketModel bucketModel);

    @Query("SELECT * FROM BucketList WHERE id = :id")
    BucketModel getBucketItemByID(int id);

    @Query("SELECT * FROM BucketList ORDER BY  date DESC")
    LiveData<List<BucketModel>> getAll();

    @Query("DELETE FROM BucketList")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM BucketList")
    int getCount();
}

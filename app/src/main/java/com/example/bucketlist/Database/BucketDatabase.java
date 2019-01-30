package com.example.bucketlist.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.bucketlist.BucketModel;

@Database(entities = {BucketModel.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class BucketDatabase extends RoomDatabase{
    public static final String DATABASE_NAME = "BucketDatabase.db";
    private static volatile BucketDatabase insstance;
    private static final Object LOCK = new Object();

    public abstract BucketDao bucketDao();

    public static BucketDatabase getInsstance(Context context) {
        if(insstance == null){
            synchronized (LOCK) {
                if (insstance == null) {
                    insstance = Room.databaseBuilder(context.getApplicationContext(),
                            BucketDatabase.class, DATABASE_NAME ).build();
                }
            }
        }
        return insstance;
    }
}

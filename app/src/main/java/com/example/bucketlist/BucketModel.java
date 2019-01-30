package com.example.bucketlist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "BucketList")
public class BucketModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private boolean checked;
    private String title;
    private String text;
    private Date date;

    @Ignore
    public BucketModel() {
    }

    public BucketModel(int id, boolean checked, String title, String text, Date date) {
        this.id = id;
        this.checked = checked;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    @Ignore
    public BucketModel(boolean checked, String title, String text, Date date) {
        this.checked = checked;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BucketModel{" +
                "id=" + id +
                ", checked=" + checked +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}

package com.example.bucketlist.Database;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.bucketlist.BucketModel;
import com.example.bucketlist.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BucketAdapter extends RecyclerView.Adapter<BucketAdapter.ViewHolder> {

    private final List<BucketModel> mList;
    private final Context mContext;

    public BucketAdapter(List<BucketModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =  LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.bucketlist_item,viewGroup , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final BucketModel list = mList.get(i);
        viewHolder.mTextView.setText(list.getText());
        viewHolder.mTitleview.setText(list.getTitle());
        viewHolder.mCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if(viewHolder.mCheck.isChecked()) {
                    viewHolder.mTitleview.setPaintFlags(viewHolder.mTitleview.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.mTextView.setPaintFlags(viewHolder.mTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.mTitleview.setTextColor(Color.RED);
                    viewHolder.mTextView.setTextColor(Color.RED);
                }
                else{
                    viewHolder.mTitleview.setPaintFlags( viewHolder.mTitleview.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                    viewHolder.mTextView.setPaintFlags( viewHolder.mTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                    viewHolder.mTitleview.setTextColor(Color.BLACK);
                    viewHolder.mTextView.setTextColor(Color.BLACK);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bucket_text)
        TextView mTextView;

        @BindView(R.id.bucket_title)
        TextView mTitleview;

        @BindView(R.id.bucket_checkbox)
        CheckBox mCheck;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


    }



}

package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.aldreduser.developwithfreedom.R;
import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private static final String TAG = "Adapter2"; //for debugging

    private Context mContext;
    private ArrayList<String> mTexts = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private OnImageListener mOnImageListener;
    private int tempNumber = 0; //used to number the texts

//    public Adapter2(Context context, ArrayList<String> imageTexts, ArrayList<Integer> images, OnImageListener onImageListener) {
//        mTexts = imageTexts;
//        mImages = images;
//
//        mContext = context;
//        this.mOnImageListener = onImageListener;
//    }
    public Adapter2(ArrayList<String> imageTexts, ArrayList<Integer> images, OnImageListener onImageListener) {
        mTexts = imageTexts;
        mImages = images;

        this.mOnImageListener = onImageListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level3_recyclerview_item1, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnImageListener);  //bug: mOnImageListener might be the problem
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // what happens to each widget

        Log.d(TAG, "onBindViewHolder: called.");    //for debugging

        tempNumber++;
        holder.imageName.setText("Image number " + tempNumber);

        // inefficient way of setting an onclick listener
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));
//
//                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        // how many list items are in the recyclerView
        return mTexts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //ViewHolder holds the widgets in memory of each entry

        //each widget in the item layout
        ImageView image;
        TextView imageName;
        CardView parentLayout;
        OnImageListener onImageListener;
        public ViewHolder(@NonNull View itemView, OnImageListener onImageListener) {
            super(itemView);
            image = itemView.findViewById(R.id.images);
            imageName = itemView.findViewById(R.id.texts);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onImageListener = onImageListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //todo: bug: problem might be here (i think its comming up as null)
            onImageListener.onImageClick(getAdapterPosition());
        }
    }
     public interface OnImageListener {
        void onImageClick(int position);
     }
}

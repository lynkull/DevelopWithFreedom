package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2;

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

    private ArrayList<Integer> mImages = new ArrayList<>();
    private OnImageListener mOnImageListener;       //todo: would the code still work it i take out mOnImageListener?
    private int tempNumber = 0; //used to number the texts

    public Adapter2(ArrayList<Integer> images, OnImageListener onImageListener) {
        mImages = images;
        this.mOnImageListener = onImageListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level3_recyclerview_item1, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnImageListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // what happens to each widget

        Log.d(TAG, "onBindViewHolder: called.");    //for debugging

        //todo: bug: if i scroll all the way down and up, the numbers in the text box keep increasing (the position integer remains the same)
//        tempNumber++;
//        holder.imageName.setText("Image number " + tempNumber);
//todo: try:        holder.imageName.setText("Image number " + tempNumber);
    }

    @Override
    public int getItemCount() {
        // how many list items are in the recyclerView
        return mImages.size();
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
            onImageListener.onImageClick(getAdapterPosition());
        }
    }
     public interface OnImageListener {
        void onImageClick(int position);
     }
}

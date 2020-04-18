package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler3;

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

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {

    private static final String TAG = "Adapter2"; //for debugging

    private ArrayList<String> mTexts = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    //    private OnImageListener mOnImageListener;
    private int tempNumber = 0; //used to number the texts

    public Adapter3(ArrayList<String> imageTexts, ArrayList<Integer> images) {
        mTexts = imageTexts;
        mImages = images;

//        this.mOnImageListener = onImageListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level3_recyclerview_item1, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // what happens to each widget

        Log.d(TAG, "onBindViewHolder: called.");    //for debugging

        //todo: bug: if i scroll all the way down and up, the numbers in the text box keep increasing (the position integer remains the same)
//        tempNumber++;
//        holder.imageName.setText("Image number " + tempNumber);
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

        //        OnImageListener onImageListener;
//        OnTextListener onTextListener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.images);
            imageName = itemView.findViewById(R.id.texts);
            parentLayout = itemView.findViewById(R.id.parent_layout);
//            this.onImageListener = onImageListener;
//            this.onTextListener = onTextListener;

            //todo: do something when the image is clicked, and something else when the text is clicked
            image.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imageName.setText("Image clicked.");
                }
            });
            imageName.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imageName.setText("Text clicked.");
                }
            });
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            onImageListener.onImageClick(getAdapterPosition());
//            onTextListener.onTextClick(getAdapterPosition());
        }
    }
//    public interface OnImageListener {
//        void onImageClick(int position);
//    }
//    public interface OnTextListener {
//        void onTextClick(int position);
//    }
}

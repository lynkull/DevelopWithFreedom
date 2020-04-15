package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.aldreduser.developwithfreedom.R;
import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private static final String TAG = "Adapter2"; //for debugging

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private OnNoteListener mOnNoteListener;

    public Adapter2(Context context, ArrayList<String> imageNames, ArrayList<String> images, OnNoteListener onNoteListener) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        this.mOnNoteListener = onNoteListener
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level3_recyclerview_item2, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnNoteListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // what happens to each widget

        Log.d(TAG, "onBindViewHolder: called.");    //for debugging

        holder.image.setText("this image name");
        holder.imageName.setText("this image name");

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
        // how many list items are in the list
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //ViewHolder holds the widgets in memory of each entry

        //each widget in the item layout
        TextView image;
        TextView imageName;
        RelativeLayout parentLayout;
        OnNoteListener onNoteClicked;
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteClicked.onNoteClick(getAdapterPosition());
        }
    }
     public interface OnNoteListener{
        void onNoteClick(int position);
     }

}

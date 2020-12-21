package com.example.faceapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.faceapp.R;
import com.example.faceapp.pojo.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    ArrayList<PostModel> ModelList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userId.setText(ModelList.get(position).getUserId() + "");
        holder.titleTV.setText(ModelList.get(position).getTitle());
        holder.bodyTV.setText(ModelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return ModelList.size();
    }

    public void getListFromDataBase(ArrayList<PostModel> movieList) {
        ModelList = movieList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userId , titleTV , bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            titleTV = itemView.findViewById(R.id.userTitle);
            bodyTV = itemView.findViewById(R.id.body);
        }
    }
}

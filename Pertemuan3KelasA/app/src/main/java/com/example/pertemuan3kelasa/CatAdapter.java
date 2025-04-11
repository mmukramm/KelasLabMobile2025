package com.example.pertemuan3kelasa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    private ArrayList<Cat> cats;

    public CatAdapter(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder holder, int position) {
        Cat cat = cats.get(position);
        holder.setData(cat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAge;
        private ImageView ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }

        public void setData(Cat cat) {
            tvName.setText(cat.getName());
            tvAge.setText(String.valueOf(cat.getAge()));
            Glide
                    .with(itemView)
                    .load(cat.getProfileImg())
                    .centerCrop()
                    .into(ivProfile);
        }
    }
}

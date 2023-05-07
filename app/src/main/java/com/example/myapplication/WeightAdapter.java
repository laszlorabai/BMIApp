package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeightAdapter extends RecyclerView.Adapter<WeightAdapter.ViewHolder> {

    private List<Weight> weightList;

    public WeightAdapter(List<Weight> weightList) {
        this.weightList = weightList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weight, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weight weight = weightList.get(position);
        holder.weightTextView.setText(String.valueOf(weight.weight));
        holder.dateTextView.setText(weight.date);
    }

    @Override
    public int getItemCount() {
        return weightList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView weightTextView;
        private TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            weightTextView = itemView.findViewById(R.id.weightTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}

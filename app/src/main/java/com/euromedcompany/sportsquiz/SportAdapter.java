package com.euromedcompany.sportsquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {

    private Context context;
    private List<Sport> sports;
    private OnItemClickListener listener;

    public SportAdapter(Context context, List<Sport> sports) {
        this.context = context;
        this.sports = sports;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_sport, parent, false);
        return new SportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport sport = sports.get(position);

        holder.sportImage.setImageResource(sport.getImageResourceId());
        holder.sportName.setText(sport.getName());

        // Set click listener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(sport);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder class
    public static class SportViewHolder extends RecyclerView.ViewHolder {
        ImageView sportImage;
        TextView sportName;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImage = itemView.findViewById(R.id.sportImage);
            sportName = itemView.findViewById(R.id.sportName);
        }
    }

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(Sport sport);
    }
}


package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SoccerAdapter extends RecyclerView.Adapter<SoccerAdapter.SoccerHolder>  {

    private Context context;
    private List<Soccer> soccerList;

    public SoccerAdapter(Context context, List<Soccer> soccerList){
        this.context = context;
        this.soccerList = soccerList;

    }

    @NonNull
    @Override
    public SoccerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new SoccerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoccerHolder holder, int position) {

        Soccer soccer = soccerList.get(position);
        holder.competition.setText(soccer.getCompetition());
        holder.title.setText(soccer.getTitle());
        holder.url.setText(soccer.getUrl());
        Glide.with(context).load(soccer.getThumbnail()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return  soccerList.size();
    }

    public class SoccerHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, url, competition;

        public SoccerHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.thumb);
            title = itemView.findViewById((R.id.title));
            url = itemView.findViewById(R.id.url);
            competition = itemView.findViewById(R.id.competition);
        }
    }

}

package com.dozydroid.githubjavapk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dozydroid.githubjavapk.controller.DeveloperActivity;
import com.dozydroid.githubjavapk.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MIRSAAB on 3/29/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i){
        viewHolder.title.setText(items.get(i).getLogin());
        viewHolder.gitHubLink = items.get(i).getHtml_url();

        Picasso.with(context).load(items.get(i).getAvatar_url()).placeholder(R.drawable.cat).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private String gitHubLink = "";
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvUserName);
            imageView = (ImageView) itemView.findViewById(R.id.imgUserAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Item clickedItem = items.get(pos);
                        Intent i = new Intent(context, DeveloperActivity.class);
                        i.putExtra("login", clickedItem.getLogin());
                        i.putExtra("html_url", clickedItem.getHtml_url());
                        i.putExtra("avatar_url", clickedItem.getAvatar_url());
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                    }
                }
            });
        }
    }
}

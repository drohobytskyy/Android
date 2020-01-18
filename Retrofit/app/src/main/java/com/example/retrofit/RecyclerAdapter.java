package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PostHolder> {

    private List<Post> posts;

    public RecyclerAdapter(List<Post> posts) {
         this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        return new PostHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder  holder, int position) {

        holder.user_id.setText(posts.get(position).getUserId());
        holder.id.setText(posts.get(position).getId());
        holder.title.setText(posts.get(position).getTitle());
        holder.text.setText(posts.get(position).getText());

    }

    @Override
    public int getItemCount() {

        return posts.size();

    }

    public class PostHolder extends RecyclerView.ViewHolder {

        TextView user_id, id, title, text;

         public PostHolder(@NonNull View itemView) {

            super(itemView);

            user_id = (TextView)itemView.findViewById(R.id.user_id);
            id = (TextView)itemView.findViewById(R.id.id);
            title = (TextView)itemView.findViewById(R.id.title);
            text = (TextView)itemView.findViewById(R.id.text);

         }
    }
}

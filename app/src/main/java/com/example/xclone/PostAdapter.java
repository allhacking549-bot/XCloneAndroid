package com.example.xclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.authorName.setText(post.author);
        holder.authorHandle.setText(post.handle);
        holder.postTime.setText(post.time);
        holder.postContent.setText(post.content);
        holder.repliesCount.setText(String.valueOf(post.replies));
        holder.retweetsCount.setText(String.valueOf(post.retweets));
        holder.likesCount.setText(String.valueOf(post.likes));

        // Like button
        holder.likeBtn.setSelected(post.liked);
        holder.likeBtn.setOnClickListener(v -> {
            post.liked = !post.liked;
            post.likes += post.liked ? 1 : -1;
            holder.likeBtn.setSelected(post.liked);
            holder.likesCount.setText(String.valueOf(post.likes));
            holder.likesCount.setTextColor(post.liked ? 0xFFFF1493 : 0xFF808080);
        });

        // Delete button
        holder.deleteBtn.setOnClickListener(v -> {
            posts.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView authorName, authorHandle, postTime, postContent;
        TextView repliesCount, retweetsCount, likesCount;
        ImageButton likeBtn, deleteBtn;
        ImageView avatar;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.post_avatar);
            authorName = itemView.findViewById(R.id.author_name);
            authorHandle = itemView.findViewById(R.id.author_handle);
            postTime = itemView.findViewById(R.id.post_time);
            postContent = itemView.findViewById(R.id.post_content);
            repliesCount = itemView.findViewById(R.id.replies_count);
            retweetsCount = itemView.findViewById(R.id.retweets_count);
            likesCount = itemView.findViewById(R.id.likes_count);
            likeBtn = itemView.findViewById(R.id.like_btn);
            deleteBtn = itemView.findViewById(R.id.delete_btn);
        }
    }
}
package com.example.xclone;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;
    private List<Post> postsList;
    private EditText tweetInput;
    private Button postBtn;
    private TextView charCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        postsRecyclerView = findViewById(R.id.posts_recycler_view);
        tweetInput = findViewById(R.id.tweet_input);
        postBtn = findViewById(R.id.post_btn);
        charCount = findViewById(R.id.char_count);

        // Setup RecyclerView
        postsList = new ArrayList<>();
        postAdapter = new PostAdapter(postsList, this);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsRecyclerView.setAdapter(postAdapter);

        // Load initial posts
        loadInitialPosts();

        // Character counter listener
        tweetInput.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int remaining = 280 - s.length();
                charCount.setText(String.valueOf(remaining));
                charCount.setTextColor(remaining < 0 ? 0xFFFF0000 : 0xFF808080);
                postBtn.setEnabled(s.length() > 0 && remaining >= 0);
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });

        // Post button listener
        postBtn.setOnClickListener(v -> createNewPost());
        postBtn.setEnabled(false);
    }

    private void loadInitialPosts() {
        postsList.add(new Post(
            1,
            "DevArchitect",
            "@dev_builder",
            "Building responsive single-page full clones using modern web primitives. Clean structure, fast load times, zero bloat.",
            "2h",
            12, 4, 89, false
        ));

        postsList.add(new Post(
            2,
            "TechInsights",
            "@techinsights",
            "What stack are you using for production backends in 2026? FastAPI, Go, or Node?",
            "5h",
            45, 18, 210, false
        ));

        postAdapter.notifyDataSetChanged();
    }

    private void createNewPost() {
        String content = tweetInput.getText().toString().trim();
        if (!content.isEmpty() && content.length() <= 280) {
            Post newPost = new Post(
                System.currentTimeMillis(),
                "CurrentUser",
                "@currentuser",
                content,
                "Just now",
                0, 0, 0, false
            );
            postsList.add(0, newPost);
            postAdapter.notifyItemInserted(0);
            tweetInput.setText("");
            charCount.setText("280");
            postBtn.setEnabled(false);
        }
    }
}
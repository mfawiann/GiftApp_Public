package com.example.giftapp_public;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * PhotosFragment
 *
 * Displays a simple gallery of sample images with descriptions.
 * Replace placeholder images and texts with your own content if needed.
 */
public class PhotosFragment extends Fragment {

    RecyclerView recyclerView;
    List<PhotoItem> photoList = new ArrayList<>();
    PhotoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        // Example photo items (replace with your own resources)
        photoList.add(new PhotoItem(R.mipmap.ic_launcher, "Sample photo 1"));
        photoList.add(new PhotoItem(R.mipmap.ic_launcher, "Sample photo 2"));
        photoList.add(new PhotoItem(R.mipmap.ic_launcher, "Sample photo 3"));

        adapter = new PhotoAdapter(photoList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    // Holds photo and description
    static class PhotoItem {
        int imageResId;
        String description;

        PhotoItem(int imageResId, String description) {
            this.imageResId = imageResId;
            this.description = description;
        }
    }

    // RecyclerView adapter
    class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

        List<PhotoItem> list;

        PhotoAdapter(List<PhotoItem> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_ani, parent, false);
            return new PhotoViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
            PhotoItem item = list.get(position);
            holder.imageView.setImageResource(item.imageResId);
            holder.textView.setText(item.description);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class PhotoViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            PhotoViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.aniImage);
                textView = itemView.findViewById(R.id.aniText);
            }
        }
    }
}

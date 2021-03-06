package com.quewelcy.omnios.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quewelcy.omnios.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.ViewHolder;

public class ControlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String HOME = "HOME";
    public static final String SHOW_SAVED = "SHOW SAVED";
    public static final String SHOW_QUEUE = "SHOW QUEUE";
    public static final String SEEK_LEFT_60 = "-60 SEC";
    public static final String SEEK_LEFT_20 = "-20 SEC";
    public static final String SEEK_RIGHT_20 = "+20 SEC";
    public static final String SEEK_RIGHT_60 = "+60 SEC";

    private final LayoutInflater mInflater;
    private final List<String> mDataSet;

    public ControlAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mDataSet = new ArrayList<>();
        mDataSet.add(HOME);
        mDataSet.add(SHOW_SAVED);
        mDataSet.add(SHOW_QUEUE);
        mDataSet.add(SEEK_LEFT_60);
        mDataSet.add(SEEK_LEFT_20);
        mDataSet.add(SEEK_RIGHT_20);
        mDataSet.add(SEEK_RIGHT_60);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SettingsViewHolder(mInflater.inflate(R.layout.item_control, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView title = holder.itemView.findViewById(R.id.item_control_title);
        title.setText(mDataSet.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public String getAction(int position) {
        return mDataSet.get(position);
    }

    private static class SettingsViewHolder extends RecyclerView.ViewHolder {
        public final View view;

        SettingsViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }
}

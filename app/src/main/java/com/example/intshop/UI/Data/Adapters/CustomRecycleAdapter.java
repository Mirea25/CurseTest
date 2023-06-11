package com.example.intshop.UI.Data.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.example.intshop.UI.Data.Item;
import com.example.intshop.R;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.intshop.UI.Ui.Tovar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecycleAdapter extends RecyclerView.Adapter<CustomRecycleAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Item> states;

    private Context mContext;



    public CustomRecycleAdapter(Context context, List<Item> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleAdapter.ViewHolder holder, int position) {
        Item state = states.get(position);
        holder.nameView.setText(state.getText());

        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Tovar.class);
                intent.putExtra("text_sample", holder.nameView.getText());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.CustomTextView);
        }
    }
}
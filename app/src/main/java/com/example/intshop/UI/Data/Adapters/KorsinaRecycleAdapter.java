package com.example.intshop.UI.Data.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.example.intshop.UI.Data.Item;
import com.example.intshop.R;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.intshop.UI.Ui.Korsina;
import com.example.intshop.UI.Ui.Tovar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KorsinaRecycleAdapter extends RecyclerView.Adapter<KorsinaRecycleAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Item> states;




    public KorsinaRecycleAdapter(Context context, List<Item> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public KorsinaRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.korsina_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(KorsinaRecycleAdapter.ViewHolder holder, int position) {
        Item state = states.get(position);
        holder.nameView.setText(state.getText());
        holder.checkBox.setChecked(false);

        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.checkBox.setChecked(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final CheckBox checkBox;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.textView3);
            checkBox = view.findViewById(R.id.checkBox);
        }
    }
}
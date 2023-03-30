package com.example.spotrkom.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotrkom.R;
import com.example.spotrkom.pojo.RanksModel;
import com.example.spotrkom.pojo.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<UserModel> users = new ArrayList<>();
    private OnNoteClickListener onNoteClickListener;
    private List<RanksModel> ranks = new ArrayList<>();

    public UserAdapter(List<UserModel> users) {
        this.users = users;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public interface OnNoteClickListener{
        void onNoteClick(int position);
        void onNoteLongClick(int position);
    }

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvExp;
        TextView tvRank;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.userName);
            tvExp = itemView.findViewById(R.id.exp);
            tvRank = itemView.findViewById(R.id.rank);
            ivAvatar = itemView.findViewById(R.id.image);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onNoteClickListener!= null){
                        onNoteClickListener.onNoteLongClick(getAdapterPosition());
                    }
                    return true;
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(users.get(position).getName());
        holder.tvExp.setText(Integer.toString(users.get(position).getExp()));
        if (users.get(position).getExp() < 500){
            holder.tvExp.setTextColor(Color.parseColor("#A3A3A3"));
            holder.tvRank.setText(R.string.three_hundred_bucks);
        } else if (users.get(position).getExp() < 2000){
            holder.tvExp.setTextColor(Color.parseColor("#28CF2E"));
            holder.tvRank.setText(R.string.open_the_door);
        } else if (users.get(position).getExp() < 3500){
            holder.tvExp.setTextColor(Color.parseColor("#EAD836"));
            holder.tvRank.setText(R.string.prodvinutiy);
        } else if (users.get(position).getExp() < 6000){
            holder.tvExp.setTextColor(Color.parseColor("#E44522"));
            holder.tvRank.setText(R.string.sportkom_legend);
        } else if (users.get(position).getExp() < 10000){
            holder.tvExp.setTextColor(Color.parseColor("#D31616"));
            holder.tvRank.setText(R.string.grand_master);
        } else{
            holder.tvExp.setTextColor(Color.parseColor("#7E1681"));
            holder.tvRank.setText(R.string.danger_masters);
        }
        holder.ivAvatar.setImageResource(users.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

}

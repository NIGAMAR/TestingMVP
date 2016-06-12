package com.example.appy.testingmvp.views.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appy.testingmvp.R;
import com.example.appy.testingmvp.databinding.SingleUserBinding;
import com.example.appy.testingmvp.datalayer.User;

import java.util.List;

/**
 * Created by Appy on 13/06/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View userView= LayoutInflater.from(context).inflate(R.layout.row_single_item,parent,false);
        return new UserViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user=userList.get(position);
        Glide.with(context).load(user.getAvatar_url()).into(holder.getUserProfilePhoto());
        holder.getUserName().setText(user.getLogin());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

class UserViewHolder extends RecyclerView.ViewHolder{
    private ImageView userProfilePhoto;
    private TextView userName;
    public UserViewHolder(View itemView) {
        super(itemView);
        userProfilePhoto= (ImageView) itemView.findViewById(R.id.userProfilePhoto);
        userName= (TextView) itemView.findViewById(R.id.userName);
    }
    public ImageView getUserProfilePhoto() {
        return userProfilePhoto;
    }
    public TextView getUserName() {
        return userName;
    }

}
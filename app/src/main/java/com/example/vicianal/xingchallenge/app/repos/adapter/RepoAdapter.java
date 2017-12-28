package com.example.vicianal.xingchallenge.app.repos.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vicianal.xingchallenge.R;
import com.example.vicianal.xingchallenge.entity.RepoEntity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<RepoEntity> items;

    @Inject
    public RepoAdapter() {
    }

    @Override
    public RepoAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoAdapter.RepoViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        RepoEntity repoEntity = items.get(position);

        if (repoEntity.isFork()) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGreen));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }

        holder.repoName.setText(String.format(
                context.getString(R.string.item_repo_name), repoEntity.getFullName()));

        holder.description.setText(String.format(
                context.getString(R.string.item_description), repoEntity.getDescription()));

        holder.ownerLogin.setText(String.format(
                context.getString(R.string.item_owner_login), repoEntity.getOwner().getLogin()));

        holder.itemView.setOnLongClickListener(view -> {
            showDialog(context);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<RepoEntity> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    private void showDialog(Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder
                .setTitle(context.getString(R.string.alert_dialog_title))
                .setMessage(R.string.alert_dialog_message)
                .setPositiveButton(R.string.alert_dialog_repository_html_url, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton(R.string.alert_dialog_owner_html_url, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_name) TextView repoName;
        @BindView(R.id.description) TextView description;
        @BindView(R.id.owner_login) TextView ownerLogin;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

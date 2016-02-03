package com.example.espenaj.ifi_rating.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.espenaj.ifi_rating.R;
import com.example.espenaj.ifi_rating.model.Player;

import java.util.List;

/**
 * Created by espenaj on 2/3/16.
 */
public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayersViewHolder> {
    String LOGTAG = "PlaylistListAdapter";
    List<Player> players;

    @Override
    public PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_view, parent, false);
        PlayersViewHolder playersViewHolder = new PlayersViewHolder(v);
        return  playersViewHolder;
    }

    @Override
    public void onBindViewHolder(PlayersViewHolder holder, int position) {
        Player player = players.get(position);
        holder.playerName.setText(player.getName());
        holder.rating.setText(player.getElo() + "");
    }

    @Override
    public int getItemCount() {
        if(players == null) {
            Log.d(LOGTAG, "players is null!");
            return -1;
        }
        return players.size();
    }

    public static class PlayersViewHolder extends RecyclerView.ViewHolder {
        TextView playerName;
        TextView rating;
        TextView standing;

        public PlayersViewHolder(View itemView) {
            super(itemView);
            playerName = (TextView) itemView.findViewById(R.id.playerName);
            rating = (TextView) itemView.findViewById(R.id.rating);
            standing = (TextView) itemView.findViewById(R.id.standing);
        }
    }

   public PlayerListAdapter(List<Player> players) {
        this.players = players;
    }
}

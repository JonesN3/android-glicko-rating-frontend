package com.example.espenaj.ifi_rating.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espenaj.ifi_rating.R;
import com.example.espenaj.ifi_rating.model.GeneralMatch;

import java.util.List;

/**
 * Created by espenaj on 1/26/16.
 */

/**
 * Created by espenaj on 1/26/16.
 */
public class GeneralMatchAdapter extends RecyclerView.Adapter<GeneralMatchAdapter.MatchViewHolder> {
    String LogTag = "MatchCardAdapter";
    String LOGTAG = "MatchCardAdapter";
    List<GeneralMatch> matches;

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MatchViewHolder matchViewHolder = new MatchViewHolder(v);
        return  matchViewHolder;
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        GeneralMatch match = matches.get(position);
        holder.player1.setText(match.getPlayerOneString());
        holder.player2.setText(match.getPlayerTwoString());
        holder.playerOneScore.setText(match.getPlayerOneScore());
        holder.playerTwoScore.setText(match.getPlayerTwoString());
        Log.d(LOGTAG, holder.cardView.getCardElevation() + "");
    }

    @Override
    public int getItemCount() {
        if(matches == null) {
            Log.d(LogTag, "matches is null!");
            return -1;
        }
        return matches.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView player1;
        TextView player2;
        TextView playerOneScore;
        TextView playerTwoScore;
        ImageView playerOnePhoto;
        ImageView playerTwoPhoto;

        public MatchViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            player1 = (TextView) itemView.findViewById(R.id.playerOneName);
            player2 = (TextView) itemView.findViewById(R.id.playerTwoName);
            playerOneScore = (TextView) itemView.findViewById(R.id.playerOneScore);
            playerTwoScore = (TextView) itemView.findViewById(R.id.playerTwoScore);
        }
    }

    public GeneralMatchAdapter(List<GeneralMatch> matches) {
        this.matches = matches;
    }
}

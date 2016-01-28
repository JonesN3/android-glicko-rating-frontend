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
import com.example.espenaj.ifi_rating.model.ChessMatch;

import java.util.List;

/**
 * Created by espenaj on 1/26/16.
 */
public class ChessMatchAdapter extends RecyclerView.Adapter<ChessMatchAdapter.MatchViewHolder> {
    String LogTag = "MatchCardAdapter";
    List<ChessMatch> matches;

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chess_match_view, parent, false);
        MatchViewHolder matchViewHolder = new MatchViewHolder(v);
        return  matchViewHolder;
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        ChessMatch match = matches.get(position);
        holder.player1.setText(match.getPlayerOneString());
        holder.player2.setText(match.getPlayerTwoString());
        holder.result.setText(match.getResult());
    }

    @Override
    public int getItemCount() {
        if(matches == null) {
            Log.d(LogTag, "matches is null!");
            return 0;
        }
        return matches.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView player1;
        TextView player2;
        TextView result;
        ImageView playerOnePhoto;
        ImageView playerTwoPhoto;

        public MatchViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            player1 = (TextView) itemView.findViewById(R.id.playerOneName);
            player2 = (TextView) itemView.findViewById(R.id.playerTwoName);
            result = (TextView) itemView.findViewById(R.id.result);
        }
    }

    public ChessMatchAdapter(List<ChessMatch> matches) {
        this.matches = matches;
    }
}

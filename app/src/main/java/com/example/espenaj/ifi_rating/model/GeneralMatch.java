package com.example.espenaj.ifi_rating.model;

import android.annotation.SuppressLint;

/**
 * Created by espenaj on 1/26/16.
 */
@SuppressLint("ParcelCreator")
public class GeneralMatch extends Match {
    int playerOneScore;
    int playerTwoScore;

    public GeneralMatch(String id, String playerOne, String playerTwo, int playerOneScore, int playerTwoScore) {
        super(id, playerOne, playerTwo);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}

package com.example.espenaj.ifi_rating.model;

import android.annotation.SuppressLint;

/**
 * Created by espenaj on 1/26/16.
 */
@SuppressLint("ParcelCreator")
public class ChessMatch extends Match {
    String result;

    public ChessMatch(String id, String playerOne, String playerTwo, String result) {
        super(id, playerOne, playerTwo);
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

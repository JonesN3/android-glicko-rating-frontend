package com.example.espenaj.ifi_rating.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espenaj on 1/14/16.
 */
public class Match implements Parcelable {
    int id_;
    String id;
    int playerOneScore;
    int playerTwoScore;
    String playerOne;
    String playerTwo;
    String result;

    public Match(String result, String playerOne, String playerTwo, String id) {
        this.result = result;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.id = id;
    }

    public Match(int playerOneScore, String playerOne, int playerTwoScore, String playerTwo, String result) {
        this.playerOneScore = playerOneScore;
        this.playerOne = playerOne;
        this.playerTwoScore = playerTwoScore;
        this.playerTwo = playerTwo;
        this.result = result;
    }

    protected Match(Parcel in) {
        id_ = in.readInt();
        id = in.readString();
        playerOneScore = in.readInt();
        playerTwoScore = in.readInt();
        playerOne = in.readString();
        playerTwo = in.readString();
        result = in.readString();
    }

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel in) {
            return new Match(in);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_);
        dest.writeString(id);
        dest.writeInt(playerOneScore);
        dest.writeInt(playerTwoScore);
        dest.writeString(playerOne);
        dest.writeString(playerTwo);
        dest.writeString(result);
    }
}

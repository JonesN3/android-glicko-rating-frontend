package com.example.espenaj.ifi_rating.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espenaj on 1/26/16.
 */
public class Match implements Parcelable {
    String id;
    String playerOneString;
    String playerTwoString;

    Player playerOne;
    Player playerTwo;

    public Match(String id, String playerOne, String playerTwo) {
        this.id = id;
        playerOneString = playerOne;
        playerTwoString = playerTwo;
    }

    protected Match(Parcel in) {
        id = in.readString();
        playerOneString = in.readString();
        playerTwoString = in.readString();
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

    public String getPlayerOneString() {
        return playerOneString;
    }

    public String getPlayerTwoString() {
        return playerTwoString;
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
        dest.writeString(id);
        dest.writeString(playerOneString);
        dest.writeString(playerTwoString);
    }
}

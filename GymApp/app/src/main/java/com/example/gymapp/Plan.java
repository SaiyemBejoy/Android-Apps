package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {
    private static final String TAG = "Plan";

    private GymTrainign trainign;
    private int minutes;
    private String day;
    private boolean isAccomplished;

    public Plan(GymTrainign trainign, int minutes, String day, boolean isAccomplished) {
        this.trainign = trainign;
        this.minutes = minutes;
        this.day = day;
        this.isAccomplished = isAccomplished;
    }

    public Plan() {
    }

    protected Plan(Parcel in) {
        trainign = in.readParcelable(GymTrainign.class.getClassLoader());
        minutes = in.readInt();
        day = in.readString();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public GymTrainign getTrainign() {
        return trainign;
    }

    public void setTrainign(GymTrainign trainign) {
        this.trainign = trainign;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "trainign=" + trainign +
                ", minutes=" + minutes +
                ", day='" + day + '\'' +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(trainign, flags);
        dest.writeInt(minutes);
        dest.writeString(day);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}

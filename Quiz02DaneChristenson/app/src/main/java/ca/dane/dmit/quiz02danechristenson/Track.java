package ca.dane.dmit.quiz02danechristenson;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dchristenson5 on 7/19/2017.
 */

public class Track {
    private UUID mId;
    private String mDescription;
    private Date mDate;
    private double mAmount;

    public Track() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
    }
}
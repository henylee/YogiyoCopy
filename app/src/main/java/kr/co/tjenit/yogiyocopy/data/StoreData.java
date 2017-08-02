package kr.co.tjenit.yogiyocopy.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-08-02.
 */

public class StoreData {

    private String storeName;
    private float averageRating;
    private int openTime;
    private int closeTime;
    private int minCost;
    private boolean isCesco;
    private List<String> reviews = new ArrayList<>();

    public StoreData() {

    }

    public StoreData(String storeName, float averageRating, int openTime, int closeTime, int minCost, boolean isCesco) {
        this.storeName = storeName;
        this.averageRating = averageRating;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.minCost = minCost;
        this.isCesco = isCesco;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    public boolean isCesco() {
        return isCesco;
    }

    public void setCesco(boolean cesco) {
        isCesco = cesco;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }


}

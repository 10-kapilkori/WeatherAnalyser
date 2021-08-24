package com.task.weatheranalyser.model;

import com.google.gson.annotations.SerializedName;

public class Condition {
    @SerializedName("text")
    String text;

    public String getText() {
        return text;
    }
}

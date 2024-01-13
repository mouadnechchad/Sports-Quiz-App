package com.euromedcompany.sportsquiz;

import java.util.List;

public class Question {
    private String text;
    private int imageResourceId; // Use 0 if no image
    private List<String> options;
    private int correctOptionIndex;

    public Question(String text, int imageResourceId, List<String> options, int correctOptionIndex) {
        this.text = text;
        this.imageResourceId = imageResourceId;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getText() {
        return text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

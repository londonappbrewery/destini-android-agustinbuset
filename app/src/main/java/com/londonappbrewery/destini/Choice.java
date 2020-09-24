package com.londonappbrewery.destini;

public class Choice {

    private int answer;
    private Chapter nextChapter;

    public Choice(int answer, Chapter nextChapter) {
        this.answer = answer;
        this.nextChapter = nextChapter;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Chapter getNextChapter() {
        return nextChapter;
    }

    public void setNextChapter(Chapter nextChapter) {
        this.nextChapter = nextChapter;
    }
}

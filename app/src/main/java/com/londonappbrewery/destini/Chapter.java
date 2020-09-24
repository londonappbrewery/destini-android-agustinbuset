package com.londonappbrewery.destini;

public class Chapter {

    private int order;
    private int story;
    private Choice topAnswer;
    private Choice bottomAnswer;

    public Chapter(int order, int story, Choice topAnswer, Choice bottomAnswer) {
        this.order = order;
        this.story = story;
        this.topAnswer = topAnswer;
        this.bottomAnswer = bottomAnswer;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public Choice getTopAnswer() {
        return topAnswer;
    }

    public void setTopAnswer(Choice topAnswer) {
        this.topAnswer = topAnswer;
    }

    public Choice getBottomAnswer() {
        return bottomAnswer;
    }

    public void setBottomAnswer(Choice bottomAnswer) {
        this.bottomAnswer = bottomAnswer;
    }
}

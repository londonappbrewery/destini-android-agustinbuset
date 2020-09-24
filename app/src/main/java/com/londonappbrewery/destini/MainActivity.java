package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button mTopAnswerButton;
    Button mBottomAnswerButton;
    TextView mStoryTextView;
    int mChapterIndex;
    Map<Integer, Chapter> mChapterDictionary = new HashMap<>();
    Chapter currentChapter;

    // TODO: Steps 4 & 8 - Declare member variables here:
    //building story structure
    Chapter end1 = new Chapter(4, R.string.T4_End,null,null);
    Chapter end2 = new Chapter(5, R.string.T5_End,null,null);
    Chapter end3 = new Chapter(6, R.string.T6_End,null,null);

    Choice choice3_1 = new Choice(R.string.T3_Ans1, end3);
    Choice choice3_2 = new Choice(R.string.T3_Ans2, end2);
    Chapter chapter3 = new Chapter(3, R.string.T3_Story,choice3_1,choice3_2);

    Choice choice2_1 = new Choice(R.string.T2_Ans1, chapter3);
    Choice choice2_2 = new Choice(R.string.T2_Ans2, end1);
    Chapter chapter2 = new Chapter(2, R.string.T2_Story,choice2_1,choice2_2);

    Choice choice1_1= new Choice(R.string.T1_Ans1,chapter3);
    Choice choice1_2= new Choice(R.string.T1_Ans2,chapter2);
    Chapter chapter1 = new Chapter(1, R.string.T1_Story,choice1_1,choice1_2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChapterDictionary.put(1,chapter1);
        mChapterDictionary.put(2,chapter2);
        mChapterDictionary.put(3,chapter3);
        mChapterDictionary.put(4,end1);
        mChapterDictionary.put(5,end2);
        mChapterDictionary.put(6,end3);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopAnswerButton = findViewById(R.id.buttonTop);
        mBottomAnswerButton = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        if(savedInstanceState != null){
            currentChapter= mChapterDictionary.get(savedInstanceState.getInt("chapterOrderKey"));

            mStoryTextView.setText(currentChapter.getStory());
            mTopAnswerButton.setText(currentChapter.getTopAnswer().getAnswer());
            mBottomAnswerButton.setText(currentChapter.getBottomAnswer().getAnswer());

        }else{
            mChapterIndex=1;
            currentChapter=chapter1;
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(currentChapter.getTopAnswer());
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(currentChapter.getBottomAnswer());
            }
        });

    }

    private void updateStory(Choice answer) {
        currentChapter= answer.getNextChapter();

        mStoryTextView.setText(currentChapter.getStory());

        mChapterIndex = currentChapter.getOrder();

        if(currentChapter.getTopAnswer() != null || currentChapter.getBottomAnswer() != null){
            mTopAnswerButton.setText(currentChapter.getTopAnswer().getAnswer());
            mBottomAnswerButton.setText(currentChapter.getBottomAnswer().getAnswer());
        }else{
            mTopAnswerButton.setVisibility(View.GONE);
            mBottomAnswerButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("chapterOrderKey", currentChapter.getOrder());
    }
}

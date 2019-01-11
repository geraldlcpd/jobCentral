package com.example.jobcentral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private Button cBillboard, cCVBox, cChat, cQuit;
    private Button cPostJob;
    Intent mToJobPost;
    static String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(type.equals("j"))
            setContentView(R.layout.activity_home_page_jobseeker);
        else
            setContentView(R.layout.activity_home_page_recruiter);

        cBillboard =(Button) findViewById(R.id.btnBod);
        cCVBox = (Button) findViewById(R.id.btnCV);
        cChat =(Button) findViewById(R.id.btnChat);
        cQuit = (Button) findViewById(R.id.btnQuit);
        cPostJob = findViewById(R.id.btnJobPost);

        cBillboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBillBoard();
            }
        });
        cCVBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCVBOX();
            }
        });
        cChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChat();
            }
        });
        cQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        cPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToJobPost();
            }
        });


    }

    private void moveToJobPost()
    {
        mToJobPost = new Intent(HomePage.this, JobPosting.class);
        startActivity(mToJobPost);
    }
    private void signOut() {
        Intent intent = new Intent(HomePage.this, NewLoginActivity.class);
        WelcomePage.reqSignOut();
        startActivity(intent);
        FirebaseAuth.getInstance().signOut();
    }

    private void openChat() {
        Intent intent = new Intent(HomePage.this, ChatActivity.class);
        startActivity(intent);
    }

    private void openCVBOX() {
        Intent intent = new Intent(this, CVSubmission.class);
        startActivity(intent);
    }

    private void openBillBoard() {
        Intent intent = new Intent(this, JobListing.class);
        startActivity(intent);
    }
}

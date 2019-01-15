package com.example.user.firstbuttonapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ThirdActivity extends AppCompatActivity
{
    private TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);




        // Directs the user to swipe up till the bottom of screen

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Swipe up";
                tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });





        // Return back to GT when swipe down operation detected

        View view = findViewById(android.R.id.content);


        view.setOnTouchListener(new OnSwipeTouchListener(ThirdActivity.this)
        {
            @Override
            public void onSwipeUp()
            {
                super.onSwipeUp();


                Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");

                if (gtIntent != null)
                {
                    startActivity(gtIntent);

                    String textToSpeak = "Swipe up again";
                    tts.speak(textToSpeak + "", TextToSpeech.QUEUE_FLUSH, null, null);



                    // Moves to next activity after 5 seconds

                    Handler handler = new Handler();

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent fourthActivityIntent = new Intent(getApplicationContext(), FourthActivity.class);
                            startActivity(fourthActivityIntent);
                        }
                    }, 5000);

                }
            }
        });
    }
}
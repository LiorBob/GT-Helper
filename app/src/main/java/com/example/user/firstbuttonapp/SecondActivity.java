package com.example.user.firstbuttonapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;




public class SecondActivity extends AppCompatActivity
{
    private TextToSpeech tts;
    private boolean upperButtonShown = true;
    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        button = new Button(this);           // Create new button
        button.setLayoutParams(new LinearLayout.LayoutParams(1200, 200));    // Set button size
        button.setBackgroundColor(Color.rgb(0, 255, 0));                  // Green button




        // Set button position

        button.setX(100);
        button.setY(150);

        setContentView(button);                     // Adds the button to view so we can see it





        // Initialize Text To Speech in order to notify the user about special instructions

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                String textToSpeak = "Press the green strip. Finger up!";
                tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });







        // Return back to GT - pressing this button click will bring us back to the camera in GT

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (upperButtonShown)
                {
                    button.setLayoutParams(new LinearLayout.LayoutParams(200, 200));    // Set button size
                    button.setBackgroundColor(Color.rgb(0, 0, 0));      // Black button



                    // Gets actual display width and height

                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    int width = displayMetrics.widthPixels;
                    int height = displayMetrics.heightPixels;




                    // Set lower button position

                    float buttonCameraX = width / 2 - 100;
                    float buttonCameraY = height - button.getHeight() * 2.5f;

                    button.setX(buttonCameraX);
                    button.setY(buttonCameraY);

                    setContentView(button);                     // Adds the button to view so we can see it */




                    // Directs the user to press the lower button

                    String textToSpeak = "Press the lower. Finger up, get the camera!";
                    tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);


                    upperButtonShown = false;

                    return;
                }




                Intent gtIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.translate");

                if (gtIntent != null)
                {
                    startActivity(gtIntent);



                    // Wait 3 seconds until next notification is being heard

                    Handler handler = new Handler();

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Press again. Finger up!";
                            tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
                        }
                    }, 3000);




                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Press last time";
                            tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
                        }
                    }, 13000);




                    // Wait 10 seconds until additional notification is being heard (Press at the position of the upper black button from 2nd screen)

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String textToSpeak = "Press the white strip";
                            tts.speak(textToSpeak + "" , TextToSpeech.QUEUE_FLUSH, null,null);
                        }
                    }, 23000);





                    // Wait 10 seconds until 3rd activity is shown up  with last button

                    handler.postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Intent thirdActivityIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                            startActivity(thirdActivityIntent);
                        }
                    }, 33000);
                }
            }
        });
    }
}

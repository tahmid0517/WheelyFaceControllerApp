package com.tahmid.wheelyfacecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Controller extends AppCompatActivity {
    private static final String SET_FACE = "F:";
    private static final String SPEAK = "S:";
    private static final int HAPPY = 0;
    private static final int MAD = 1;
    private static final int SURPRISED = 2;
    private static final int HOLLYWOOD = 3;
    private static final int SAD = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        Intent intent = getIntent();
    }

    public void setFace(int i)
    {
        String command = SET_FACE + String.valueOf(i);
        SocketConnector.write(command);
    }
    public void setHappy(View view) {setFace(HAPPY);}
    public void setMad(View view) {setFace(MAD);}
    public void setSurprised(View view) {setFace(SURPRISED);}
    public void setHollywood(View view) {setFace(HOLLYWOOD);}
    public void setSad(View view) {setFace(SAD);}

    public void speak(String line)
    {
        String command = SPEAK + line;
        SocketConnector.write(command);
    }
    public void greeting(View view) {speak("Hello humans. I am Wheely 3 point O.");}
    public void welcome(View view) {speak("Welcome to the Taves Show.");}
    public void chickenCrossTheRoadPart1(View view) {speak("Why did the chicken cross the road?");}
    public void chickenCrossTheRoadPart2(View view) {speak("I do not know the answer. That is a human joke with many variations.");}
    public void wee(View vew) {speak("weeeeeeeeeeeeeeeeeeeee");}
    public void ohYeah(View view) {speak("oh yaaaaaaaaaa");}
    public void customLine(View view)
    {
        EditText editTextBox = (EditText)findViewById(R.id.editText);
        String text = editTextBox.getText().toString();
        speak(text);
    }
    public void clearCustomLine(View view)
    {
        EditText editTextBox = (EditText)findViewById(R.id.editText);
        editTextBox.setText("");
    }
}

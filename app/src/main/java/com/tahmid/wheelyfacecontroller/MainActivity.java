package com.tahmid.wheelyfacecontroller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSavedAddress();
    }
    public void connect(View view)
    {
        SocketConnector.connect(getAddress());
        goToController();
    }
    public void goToController()
    {
        Intent intent = new Intent(this, Controller.class);
        startActivity(intent);
    }
    private static final String ADDRESS_MEMORY_KEY = "Wheely Controller Address";
    private static final String DEFAULT_ADDRESS = "94:A1:A2:76:FD:2B";
    public void setSavedAddress()
    {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        EditText addressBar = (EditText)findViewById(R.id.bluetoothAddress);
        String address = pref.getString(ADDRESS_MEMORY_KEY, DEFAULT_ADDRESS);
        addressBar.setText(address);
    }
    public String getAddress()
    {
        EditText addressBar = (EditText)findViewById(R.id.bluetoothAddress);
        String address = addressBar.getText().toString();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(ADDRESS_MEMORY_KEY,address);
        editor.apply();
        return address;
    }
}

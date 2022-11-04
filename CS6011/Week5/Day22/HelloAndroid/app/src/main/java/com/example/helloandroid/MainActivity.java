package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private boolean firstclick = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleClick( View view){
        Log.i("JJ:MainActivity","button was pressed");
        if(firstclick) {
            TextView roomNameTV = findViewById(R.id.RoomNameTxt);
            roomNameTV.setText("Enter a Room Name");
            firstclick = false;
        }
        else{
            Intent intent = new Intent(this,AnotherActivity.class);
startActivity(intent);
        }

    }
}
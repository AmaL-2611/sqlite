package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    TextView t1,t3;
    Button b1,b2;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.t1);
        t3=(TextView)findViewById(R.id.t3);
        et1=(EditText) findViewById(R.id.et1);
        dbHelper = new DatabaseHelper(this);
    }

    public void addme(View view) {
         String names= et1.getText().toString();
         if (dbHelper.addName(names)){
             Toast.makeText(this, "Name Added", Toast.LENGTH_SHORT).show();
             t1.setText("");
         }
         else {
             Toast.makeText(this, "Failed to Add Name", Toast.LENGTH_SHORT).show();
         }
    }

    public void show(View view) {
        String names =dbHelper.getAllNames();
        t1.setText(names);
    }
}
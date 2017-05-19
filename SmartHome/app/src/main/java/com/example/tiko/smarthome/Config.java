package com.example.tiko.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Config extends AppCompatActivity implements View.OnClickListener {

    EditText editTextIp,editTextPort;
    Button btnEnter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        editTextIp = (EditText)findViewById(R.id.editTextIp);
        editTextPort = (EditText)findViewById(R.id.editTextPort);
        btnEnter = (Button)findViewById(R.id.buttonEnter);
        btnEnter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEnter:
                if(editTextIp.getText().toString().isEmpty() && editTextPort.getText().toString().isEmpty()){
                    Toast.makeText(this,"Please enter PORT and IP",Toast.LENGTH_SHORT).show();
                }
                else if(editTextPort.getText().toString().isEmpty()){
                    Toast.makeText(this,"Please enter PORT",Toast.LENGTH_SHORT).show();
                }
                else if(editTextIp.getText().toString().isEmpty()){
                    Toast.makeText(this,"Please enter IP",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent send = new Intent();
                    send.setAction(Intent.ACTION_SEND);
                    send.putExtra("ip", editTextIp.getText().toString());
                    send.putExtra("port", editTextPort.getText().toString());
                    send.setType("text/plain");
                    if(send.resolveActivity(getPackageManager())!=null){
                        startActivity(send);
                    }
                    Toast.makeText(this, "Succesfull", Toast.LENGTH_SHORT).show();
                }
        }
    }
}

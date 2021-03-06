package com.example.tiko.smarthome;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Light extends AppCompatActivity implements View.OnClickListener {
    Button btnKitchen,btnDining,btnBed,btnBath,btnKor;
    boolean kitchen=true,dining=true,bed=true,bath=true,kor=true,x=true;
    MyTask mt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        btnKitchen=(Button)findViewById(R.id.btnKitchen);
        btnDining=(Button)findViewById(R.id.btnDining);
        btnBed=(Button)findViewById(R.id.btnBed);
        btnBath=(Button)findViewById(R.id.btnBath);
        btnKor=(Button)findViewById(R.id.btnKor);

        btnKitchen.setOnClickListener(this);
        btnDining.setOnClickListener(this);
        btnBed.setOnClickListener(this);
        btnBath.setOnClickListener(this);
        btnKor.setOnClickListener(this);
        if(savedInstanceState!=null){
            kitchen=savedInstanceState.getBoolean("kitchen",kitchen);
            dining=savedInstanceState.getBoolean("dining",dining);
            bed=savedInstanceState.getBoolean("bed",bed);
            bath=savedInstanceState.getBoolean("bath",bath);
            kor=savedInstanceState.getBoolean("kor",kor);
            if(kor==false){
                btnKor.setBackgroundColor(Color.parseColor("#FBFF5E"));
                btnKor.setText("KORRIDOR                        TURN OFF");
            }
            if(bath==false){
                btnBath.setBackgroundColor(Color.parseColor("#FBFF5E"));
                btnBath.setText("BATHROOM                        TURN OFF");
            }
            if(bed==false){
                btnBed.setBackgroundColor(Color.parseColor("#FBFF5E"));
                btnBed.setText("BED ROOM                          TURN OFF");
            }
            if(kitchen==false){
                  btnKitchen.setBackgroundColor(Color.parseColor("#FBFF5E"));
                  btnKitchen.setText("KITCHEN                        TURN OFF");
            }
            if(dining==false){
                btnDining.setBackgroundColor(Color.parseColor("#FBFF5E"));
                btnDining.setText("DINING ROOM                     TURN OFF");
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("kitchen",kitchen);
        outState.putBoolean("dining",dining);
        outState.putBoolean("bed",bed);
        outState.putBoolean("bath",bath);
        outState.putBoolean("kor",kor);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnKitchen:
                if (kitchen) {
                    try {
                        Intent intent = getIntent();
                        String ip = intent.getStringExtra("ip");
                        String port = intent.getStringExtra("port");
                        mt= new MyTask(ip,port,kitchen);
                        mt.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    btnKitchen.setBackgroundColor(Color.parseColor("#FBFF5E"));
                    btnKitchen.setText("KITCHEN                          TURN OFF");
                    kitchen=false;
                }
                else {
                    Intent intent = getIntent();
                    String ip = intent.getStringExtra("ip");
                    String port = intent.getStringExtra("port");
                    mt= new MyTask(ip,port,kitchen);
                    mt.execute();
                    btnKitchen.setBackgroundColor(Color.TRANSPARENT);
                    btnKitchen.setText("KITCHEN                          TURN ON");
                    kitchen=true;
                }
                break;
            case R.id.btnDining:
                if (dining) {
                    btnDining.setBackgroundColor(Color.parseColor("#FBFF5E"));
                    btnDining.setText("DINING ROOM                     TURN OFF");
                    dining=false;
                }
                else {
                    btnDining.setBackgroundColor(Color.TRANSPARENT);
                    btnDining.setText("DINING ROOM                     TURN ON");
                    dining=true;
                }
                break;
            case R.id.btnBed:
                if (bed) {
                    btnBed.setBackgroundColor(Color.parseColor("#FBFF5E"));
                    btnBed.setText("BED ROOM                            TURN OFF");
                    bed=false;
                }
                else {
                    btnBed.setBackgroundColor(Color.TRANSPARENT);
                    btnBed.setText("BED ROOM                            TURN ON");
                    bed=true;
                }
                break;
            case R.id.btnBath:
                if (bath) {
                    btnBath.setBackgroundColor(Color.parseColor("#FBFF5E"));
                    btnBath.setText("BATHROOM                        TURN OFF");
                    bath=false;
                }
                else {
                    btnBath.setBackgroundColor(Color.TRANSPARENT);
                    btnBath.setText("BATHROOM                        TURN ON");
                    bath=true;
                }
                break;
            case R.id.btnKor:
                if (kor) {
                    btnKor.setBackgroundColor(Color.parseColor("#FBFF5E"));
                    btnKor.setText("KORRIDOR                          TURN OFF");
                    kor=false;
                }
                else {
                    btnKor.setBackgroundColor(Color.TRANSPARENT);
                    btnKor.setText("KORRIDOR                          TURN ON");
                    kor=true;
                }
                break;
        }
    }
}

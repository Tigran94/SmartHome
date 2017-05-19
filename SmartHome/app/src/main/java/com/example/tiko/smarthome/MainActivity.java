package com.example.tiko.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLight,btnWindow,btnCurtain,btnSofa,btnConfig,btnExit;
    final int TRANSLATE_ID=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLight=(Button)findViewById(R.id.btnLight);
        btnWindow=(Button)findViewById(R.id.btnWindow);
        btnCurtain=(Button)findViewById(R.id.btnCurtain);
        btnSofa=(Button)findViewById(R.id.btnSofa);
        btnConfig=(Button)findViewById(R.id.btnConfig);
        btnExit=(Button)findViewById(R.id.btnExit);


        btnLight.setOnClickListener(this);
        btnWindow.setOnClickListener(this);
        btnCurtain.setOnClickListener(this);
        btnSofa.setOnClickListener(this);
        btnConfig.setOnClickListener(this);
        btnExit.setOnClickListener(this);


        Animation anim=null;
        anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        btnLight.startAnimation(anim);
        btnWindow.startAnimation(anim);
        btnConfig.startAnimation(anim);
        btnCurtain.startAnimation(anim);
        btnExit.startAnimation(anim);
        btnSofa.startAnimation(anim);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLight:
                intent=new Intent(this,Light.class);
                startActivity(intent);
                break;
            case R.id.btnWindow:
                intent=new Intent(this,Window.class);
                startActivity(intent);
                break;
            case R.id.btnCurtain:
                intent=new Intent(this,Curtain.class);
                startActivity(intent);
                break;
            case R.id.btnSofa:
                intent=new Intent(this,Sofa.class);
                startActivity(intent);
                break;
            case R.id.btnConfig:
                intent=new Intent(this,Config.class);
                startActivity(intent);
                break;
            case R.id.btnExit:
                System.exit(1);
        }
    }
}

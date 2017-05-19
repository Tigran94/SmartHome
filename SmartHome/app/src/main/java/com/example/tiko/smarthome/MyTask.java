package com.example.tiko.smarthome;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Tiko on 16.05.2017.
 */

public class MyTask extends AsyncTask<Void,Void,Void> {
    String ip,port;
    boolean kitchen;
    public MyTask(String ip,String port, boolean kitchen){
        this.ip = ip;
        this.port=port;
        this.kitchen = kitchen;
    }
    private void sendPost(String ip,String port, boolean kitchen) throws IOException {
        String kitch =  String.valueOf(kitchen);
        URL url = new URL("http://"+ip+":"+port+"/api/todos");//192.168.0.104:8080

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


        urlConnection.setRequestMethod("POST");

        String urlParameters = "text=";
        if (kitchen){
            urlParameters+="1";
        }else {
            urlParameters+="0";
        }

        urlConnection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = urlConnection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }

    private void sendGet(String ip,String port, boolean kitchen) throws IOException {
        String kitch =  String.valueOf(kitchen);
        URL url = new URL("http://"+ip+":"+port+"/");//192.168.0.104:8080
        String str = "";
        StringBuffer buf = new StringBuffer();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");

        try {
            InputStream is = new BufferedInputStream(urlConnection.getInputStream());
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                if (is != null) {
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    }
                }
            } finally {
                try {
                    is.close();
                } catch (Throwable ignore) {
                }
            }
        } finally {
            urlConnection.disconnect();
        }
        Log.d("asdasd", buf.toString());
        System.out.println(buf.toString());
    }

    protected Void doInBackground(Void... params) {
        try {
            sendPost(ip,port,kitchen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

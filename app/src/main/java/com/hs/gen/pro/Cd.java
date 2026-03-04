package com.hs.gen.pro;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.app.AlertDialog;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.view.LayoutInflater;
import android.view.View;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.widget.Toast;
import android.graphics.drawable.Drawable;


/**
 * Created by: KervzCodes
 * Date Crated: 08/10/2020
 * Project: SocksHttp-master (ENGLISH)
 **/
public class Cd extends AsyncTask<String, String, String> {

    private Context context;
    private OnUpdateListener listener;
    private boolean isOnCreate;

	private ProgressDialog progressDialog;

	private String s;

    public Cd(Context context, String s, OnUpdateListener listener) {
        this.context = context;
        this.listener = listener;
		this.s = s;
    }

    public void start(boolean isOnCreate) {
     this.isOnCreate = isOnCreate;
        execute();
    }

    public interface OnUpdateListener {
        void onUpdateListener(String result);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            StringBuilder sb = new StringBuilder();
         //   URL url = new URL(new String(new byte[]{104,116,116,112,115,58,47,47,114,97,119,46,103,105,116,104,117,98,117,115,101,114,99,111,110,116,101,110,116,46,99,111,109,47,100,97,114,107,110,101,116,104,48,55,47,78,80,72,78,101,116,119,111,114,107,47,106,108,121,110,101,116,104,47,117,112,46,106,115,111,110,}));
		URL url = new URL(s);
		 // GAMIT KAYO GITHUB PARA WALANG MAINTENANCE.. :)  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response;

            while ((response = br.readLine()) != null) {
                sb.append(response);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error on getting data: " + e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (!isOnCreate) {
			progressDialog = new ProgressDialog(context);
			progressDialog.setMessage("Finding Config...");
			progressDialog.setTitle("Please wait...");
			progressDialog.setCancelable(true);
			progressDialog.show();
        }
    }



    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog != null && !isOnCreate) {
            progressDialog.dismiss();

        }
        if (listener != null) {
            listener.onUpdateListener(s);
        }
    }
}

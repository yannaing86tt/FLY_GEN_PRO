package com.hs.gen.pro.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import flyvpnpro.official.gen.R;

public class Version {
    private SharedPreferences sp;

    private Context c;

    public Version(final Context c, String test) {

        sp = PreferenceManager.getDefaultSharedPreferences(c);
        AlertDialog.Builder a=new AlertDialog.Builder(c);
        View v=LayoutInflater.from(c).inflate(R.layout.abc_version, null);
        final EditText e1= (EditText)v.findViewById(R.id.version);

        if (sp.getString("FLYVersion", "").isEmpty()){
            sp.edit().putString("FLYVersion", test).apply();
        }

        e1.setText(sp.getString("FLYVersion", ""));

        a.setView(v);
        a.setNegativeButton("Close", null);
        a.setPositiveButton("Save", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface p1, int p2) {

                    sp.edit().putString("FLYVersion", e1.getText().toString()).apply(); 
                    sp.edit().putString("isChanged", "yes").apply();                                           
                }
            });
        Dialog dialog = a.create();
		dialog.show();
		dialog.getWindow().setBackgroundDrawableResource(R.drawable.hsdialogskill);  
	
    }

    public Version(Context c) {
        sp = PreferenceManager.getDefaultSharedPreferences(c);
        this.c = c;
    }
    
}

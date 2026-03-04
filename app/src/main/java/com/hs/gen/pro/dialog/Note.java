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

public class Note {
    private SharedPreferences sp;

    private Context c;

    public Note(final Context c, String test) {

        sp = PreferenceManager.getDefaultSharedPreferences(c);
        AlertDialog.Builder a=new AlertDialog.Builder(c);
        View v=LayoutInflater.from(c).inflate(R.layout.notes, null);
        final EditText e1= (EditText)v.findViewById(R.id.notes);

        if (sp.getString("FLYReleaseNotes", "").isEmpty()){
            sp.edit().putString("FLYReleaseNotes", test).apply();
        }
        e1.setText("1.0.0");
        e1.setText(sp.getString("FLYReleaseNotes", ""));

        a.setView(v);
        a.setNegativeButton("Close", null);
        a.setPositiveButton("Save", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface p1, int p2) {

                    sp.edit().putString("FLYReleaseNotes", e1.getText().toString()).apply(); 
                    sp.edit().putString("isChanged", "yes").apply();                                           
                }
            });
        Dialog dialog = a.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.hsdialogskill);  

    }

    public Note(Context c,ReleaseNotes notesDialog, EditText editText) {
        sp = PreferenceManager.getDefaultSharedPreferences(c);
        this.c = c;
    }

}








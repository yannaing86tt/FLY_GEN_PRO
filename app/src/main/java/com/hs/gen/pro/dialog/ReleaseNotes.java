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

public class ReleaseNotes {
    
    private SharedPreferences sp;

    private Context c;
	public static EditText e2;
    public ReleaseNotes(final Context c, String test) {

        sp = PreferenceManager.getDefaultSharedPreferences(c);
        AlertDialog.Builder a=new AlertDialog.Builder(c);
        View v=LayoutInflater.from(c).inflate(R.layout.abc_notes, null);
        final EditText e1= (EditText)v.findViewById(R.id.notes);
		 e2= v.findViewById(R.id.version);
		final EditText e4=v.findViewById(R.id.fName);
        if (sp.getString("FLYReleaseNotes", "").isEmpty()){
          //  sp.edit().putString("ReleaseNotes", test).apply();
        }
        if (sp.getString("FLYVersion", "").isEmpty()){
            sp.edit().putString("FLYVersion", test).apply();
        }
		//e2.setText("1.0");
        e2.setText(sp.getString("FLYVersion", ""));
        e1.setText(sp.getString("FLYReleaseNotes", ""));
		e4.setText(sp.getString("name", ""));
        a.setView(v);
        a.setNegativeButton("Close", null);
        a.setPositiveButton("Save", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface p1, int p2) {
					sp.edit().putString("FLYVersion", e2.getText().toString()).apply(); 
                    sp.edit().putString("isChanged", "yes").apply();      
                    sp.edit().putString("FLYReleaseNotes", e1.getText().toString()).apply(); 
					sp.edit().putString("isChanged", "yes").apply();      
					sp.edit().putString("name", e4.getText().toString()).apply();
                }
            });
        Dialog dialog = a.create();
		//	builer.create().show();
		dialog.show();
		dialog.getWindow().setBackgroundDrawableResource(R.drawable.hsdialogskill);  

    }

    public ReleaseNotes(Context c,ReleaseNotes notesDialog, EditText editText) {
        sp = PreferenceManager.getDefaultSharedPreferences(c);
        this.c = c;
    }
}

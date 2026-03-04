package com.hs.gen.pro.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import flyvpnpro.official.gen.R;

public class OutputDialog {
	private static TextView output;
	private AlertDialog.Builder a;
	public static Context c;
	
	public OutputDialog(Context c) {
        a = new AlertDialog.Builder(c);
        this.c = c;
	}

	public void show(String json) {
        View v=LayoutInflater.from(c).inflate(R.layout.output_dialog, null);
        output = v.findViewById(R.id.output);
        output.setText(json);

        a.setView(v);
    }

    public void init() {
        a.create().show();
    }
}

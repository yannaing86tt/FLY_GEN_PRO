package com.hs.gen.pro.dialog;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.hs.gen.pro.AESCrypt;
import com.hs.gen.pro.MainActivity;
import com.hs.gen.pro.util.FileUtil;
import flyvpnpro.official.gen.R;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import com.hs.gen.pro.HSConfigUpdater;
import android.widget.Toast;

public class SaveDialog 
{
    private SharedPreferences sp;

    private String outputString;

    public SaveDialog(final Context c,final JSONObject ja)
    {
        sp=PreferenceManager.getDefaultSharedPreferences(c);
        AlertDialog.Builder a=new AlertDialog.Builder(c);
        View v=LayoutInflater.from(c).inflate(R.layout.dialog_save,null);
        final EditText e2=v.findViewById(R.id.version);
        //final EditText e2=v.findViewById(R.id.password);
        final EditText e4=v.findViewById(R.id.fName);

        String defaultName = sp.getString("name", "");
        if (defaultName == null || defaultName.trim().isEmpty()) {
            defaultName = "plusvpnpro";
        }
        e4.setText(defaultName);

        final EditText[] e={};
        for(int i=0;i<e.length;i++)
        {
            //e2.setText("");
            //   e1.setText("1.0.0");
            e[i].setText(sp.getString("SAVE_"+i,""));
        }
        a.setView(v);
        a.setNeutralButton("Close",null);
        a.setPositiveButton("Save",new DialogInterface.OnClickListener()

            {
                @Override
                public void onClick(DialogInterface p1, int p2)
                {
                //    Toast.makeText(c, "Saved Succesfully to FLY GEN PRO", Toast.LENGTH_LONG).show(); //Toast.makeText(this, "Please set a file name!", 1).show(); 
                    String b=e4.getText().toString();
                    String string = sp.getString("pass", ""); 

                    String[] s={b};
                    for(int i=0;i<e.length;i++)
                    {
                        sp.edit().putString("SAVE_"+i,s[i]).apply();
                    }
                    if (e4.getText().toString().isEmpty()) { 
                        Toast.makeText(c, "Please set a file name!", Toast.LENGTH_LONG).show(); //Toast.makeText(this, "Please set a file name!", 1).show(); 
                        return; 
                    } 
                        String editable = e4.getText().toString(); 
                        sp.edit().putString("name", editable).apply(); 
                        String string1 = sp.getString("pass", ""); 
					try
					{
                    if (b.isEmpty())
                    {
                        Toast.makeText(c,"Please Complete the fields!",1).show();
                    }else
                    {
                        FileUtil.save(c,b,ja.toString());
                    }
                        try {
                            outputString = AESCrypt.encrypt(string1, ja.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        FileUtil.save(c,b, outputString);
//                        OutputDialog a=new OutputDialog(c);
//                        a.show(outputString);
//                        a.init();
                        Toast.makeText(c,"Saved Done!, Click to copy!",1).show();
			

                    }
                    catch (Exception e)
                    {}
                }
            });

        Dialog dialog = a.create();
        //  builer.create().show();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.hsdialogskill); 
    }


}

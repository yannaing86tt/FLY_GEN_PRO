package com.hs.gen.pro.util;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtil 
{
    public static void save(Context c,String title,String content)
    {
        File fileDir=new File(Environment.getExternalStorageDirectory(),"/FLY GEN PRO");
		fileDir.mkdir();
        File file=new File(fileDir,title+".json");
        try
        {
            OutputStream os=new FileOutputStream(file);
            os.write(content.getBytes());
            os.flush();
            os.close();
//            Toast.makeText(c,"Not supported your api version, click copy button!",1).show();
			
        }
        catch (IOException e)
        {
//            Toast.makeText(c,e.getMessage(),1).show();
        }
    }
}

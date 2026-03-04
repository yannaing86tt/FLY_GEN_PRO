package com.hs.gen.pro;

import android.Manifest;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.*;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.GravityCompat;
import java.util.*;
import android.view.*;
import android.graphics.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.*;
import android.graphics.*;
import android.widget.Button;

import com.hs.gen.pro.AESCrypt;
import com.hs.gen.pro.MainActivity;
import com.hs.gen.pro.adapter.ServerSpinnerAdapter;
import com.hs.gen.pro.dialog.PassDialog;
import com.hs.gen.pro.dialog.ReleaseNotes;
import com.hs.gen.pro.dialog.SaveDialog;
import com.hs.gen.pro.dialog.ServerDialog;
import com.hs.gen.pro.dialog.Version;
import com.hs.gen.pro.listener.SpinnerListener;
import com.hs.gen.pro.util.FileUtil;
import com.hs.gen.pro.util.HSCryptA;
import com.hs.gen.pro.util.HSCryptB;
import com.hs.gen.pro.util.HSCryptC;
import com.hs.gen.pro.util.HSCryptD;
import com.hs.gen.pro.util.HSCryptE;
import flyvpnpro.official.gen.R;
import com.hs.gen.pro.listener.*;
import com.hs.gen.pro.util.ProtectedHS;
import com.hs.gen.pro.dialog.Note;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;

import com.google.android.material.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.widget.*;
import androidx.viewpager.widget.*;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult;
import androidx.activity.result.ActivityResultCaller;
//import androidx.activity.result.registerForActivityResult;

import com.github.angads25.filepicker.controller.DialogSelectionListener;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;

public class MainActivity extends AppCompatActivity {
    final static int REQUEST_CODE = 333;
	private SharedPreferences sp;
	private Spinner a;
    private AlertDialog about;
    private FilePickerDialog dialog;
	public static final String PREFS_GERAL = "SocksHttpGERAL";
	private ClipData clip;
    private String v;
    //public static TextView edson;
    private String n;
    private TextView output;
	//private Button buttonedson;
	private String vch;
	private String coin;
	private String vch_info;
    private CharSequence em;
    private Button real;
    private Toolbar toolbar_main;
    private MainActivity.DrawerPanelMain mDrawerPanel;
    
    public static final String HSTitle = new String(new byte[]{70,76,89,32,71,69,78,32,80,82,79});
    public static final String HSMessage = new String(new byte[]{68,101,118,101,108,111,112,101,100,32,98,121,32,68,101,118,75,97,108,105});
    
    public class DrawerPanelMain
    
    implements NavigationView.OnNavigationItemSelectedListener
    {
    private AppCompatActivity mActivity;
    private NavigationView drawerNavigationView;
    private DrawerLayout drawerLayout;
    
    public DrawerPanelMain(AppCompatActivity activity) {
        mActivity = activity;
    } 
    
    private ActionBarDrawerToggle toggle;
    public void setDrawer(Toolbar toolbar) {
        drawerNavigationView = (NavigationView) mActivity.findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawerlayout);

        // set drawer
        toggle = new ActionBarDrawerToggle(mActivity,
                                           drawerLayout, toolbar, R.string.open, R.string.cancel);

        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();
        // set navigation view
        drawerNavigationView.setNavigationItemSelectedListener(this);
    }

    public ActionBarDrawerToggle getToogle() {
        return toggle;
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id)
        {
            case R.id.hsabout /*2131231020*/:
                AlertDialog.Builder aboutDiags = new AlertDialog.Builder(MainActivity.this);
                aboutDiags.setTitle((CharSequence) "About");
                aboutDiags.setMessage((CharSequence) "Developed by : DevKali");
                aboutDiags.setPositiveButton((CharSequence) "Ok", (DialogInterface.OnClickListener) null);
                aboutDiags.show();
                break;
                
            case R.id.hsexit /*2131231021*/:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage((CharSequence) "Are you sure you want to exit?");
                alertDialogBuilder.setNegativeButton((CharSequence) "Minimize", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface p1, int p2) {
                            finish();
                        }
                    });
                alertDialogBuilder.setPositiveButton((CharSequence) "Exit", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface p1, int p2) {                       
                            System.exit(0);
                            finishAndRemoveTask();
                        }
                    });
                alertDialogBuilder.show();
                break;
                
            case R.id.hsfacebook /*2131231022*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://web.facebook.com/groups/729862707975294/?ref=share")));
                break;
                
            case R.id.hstelegram /*2131231026*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/HSTunnelProOfficical")));
                break;

        }
        drawerLayout.closeDrawer((int) GravityCompat.START);


        return true;
    }

}

    private void output(){
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:"+getPackageName()));
        startActivity(intent);
    }

    private void AntiRemodHS(){
        // Keep package validation only, allow rebranded app label (PLUS GEN PRO)
        if (!(getPackageName().equals(HSProtect.pkgname))) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(getLayoutInflater().inflate(R.layout.hsprotect,null));
            builder.setCancelable(false);
            builder.setNegativeButton("Uninstall", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface p1, int p2) {
                        output();
                        //uninstall
                    }                      
                });
            builder.setPositiveButton("Exit", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface p1, int p2)
                    {
                        // TODO: Implement this method
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            finishAndRemoveTask();
                        } else {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                        System.exit(0);

                    }
                });
            builder.show();

        }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AntiRemodHS();
        welcomeNotif();
        ProtectedHS.init(this);
        ProtectedHS.CharlieProtect();
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        
        SharedPreferences prefs = getSharedPreferences(MainActivity.PREFS_GERAL, Context.MODE_PRIVATE);
        boolean showFirstTime = prefs.getBoolean("connect_first_time", true);
        // se primeira vez
        if (showFirstTime) {
            SharedPreferences.Editor pEdit = prefs.edit();
            pEdit.putBoolean("connect_first_time", false);
            pEdit.apply();
//            showBoasVindas();
            }
        
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		a = (Spinner) findViewById(R.id.serverList);
        
		toolbar_main = (Toolbar)findViewById(R.id.tool_bar);
        mDrawerPanel = new DrawerPanelMain(this);
        mDrawerPanel.setDrawer(toolbar_main);
		setSupportActionBar(toolbar_main);
        
       if (adapter() != null) {
            a.setAdapter(adapter());
        }
	    setupJson();
        
        try {
        JSONObject jsonObj = new JSONObject(ja().toString());
        String finalJson = jsonObj.toString(1);

        ((TextView)findViewById(R.id.json)).setText(finalJson);
		} catch (JSONException e) {}
        
        //Runtime External storage permission for saving download files
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)  == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 1);
            }
        }
    }
    
    private void welcomeNotif(){
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE); 
        Notification.Builder notification = new Notification.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.setChannelId(this.getPackageName() + ".hs.gen");
            createNotification(notificationManager, this.getPackageName() + ".hs.gen");
        }
        notification.setContentTitle(HSTitle)
            .setContentText(HSMessage)
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icons))
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(Notification.PRIORITY_HIGH)
            .setShowWhen(true)
            .setSmallIcon(R.drawable.icons);
        notificationManager.notify(4130,notification.getNotification());
    }

    private void createNotification(NotificationManager notificationManager, String id)
    {
        NotificationChannel mNotif = new NotificationChannel(id, "Developer", NotificationManager.IMPORTANCE_HIGH);
        mNotif.setShowBadge(true);
        notificationManager.createNotificationChannel(mNotif);
        // TODO: Implement this method
	}
	
	public void saveJson1(View v) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 1);
            }
        }
        new SaveDialog((Context)this, this.ja());

	}
  
    public void saveJson(View v) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 1);
            }
        }
        new SaveDialog((Context)this, this.ja());

	}
    
    public void addnotes1(View v) {
        new Note(this,"1.0.0");
    }

    public void addnotes(View v) {
        new ReleaseNotes(this,"1.0.0"); 
    }
    
	public void editServer(final int position) {

		ServerDialog.Server a=new ServerDialog.Server(MainActivity.this);
		try {
			final JSONArray ja=new JSONArray(sp.getString("ServerList", "[]"));
			a.edit(ja.getJSONObject(position));
            a.onServerAdd(new SpinnerListener() {
            @Override
            public void onAdd(JSONObject json) {
              try {
                String[] ob = {
                  "FLYName",
                  "FLYFLAG",
                  "FLYsHost",
                  "FLYsPort",
                  "FLYsslPort",
                  "FLYreHost",
                  "FLYrePort",
                  "FLYUser",
                  "FLYPass",
                  "FLYInfo",
                  "FLYBugPayload",
                  "FLYBugSNI",
                  "FLYchavKey",
                  "FLYnvKey",
                  "FLYdnsKey",
                  "V2rayConfig",
                  "udp_recv_window",
                  "udp_down_mbps",
                  "udp_up_mbps",                                             
                  "SSLMethod",
                  "ProxyMethod",
                  "SSLPayMethod",
                  "SSLRpMethod",
                  "DirectMethod",
                  "SlowDNSMethod",
                  "isv2ray",
                  "isUDP"                            
                };
                for (int i = 0; i < ob.length; i++) {
                  ja.getJSONObject(position).remove(ob[i]);
                }
                for (int i = 0; i < json.length(); i++) {
                  ja.getJSONObject(position).put(ob[i], json.getString(ob[i]));
                }
                sp.edit().putString("ServerList", ja.toString()).apply();
                setupJson();

              } catch (JSONException e) {
                Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
              }
            }
          });
			a.init();
		} catch (JSONException e) {
			Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
		}
	}

	public void deleteServer(final int position) {

		try {
			JSONArray ja=new JSONArray(sp.getString("ServerList", "[]"));
			ja.remove(position);
			sp.edit().putString("ServerList", ja.toString()).apply();
            setupJson();

		} catch (JSONException e) {
			Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
		}

	}

	public void add(View v) {

		ServerDialog.Server a=new ServerDialog.Server(this);
		a.add();
		a.onServerAdd(new SpinnerListener()
			{
				@Override
				public void onAdd(JSONObject json) {
					try {
						JSONArray ja=new JSONArray(sp.getString("ServerList", "[]"));
						ja.put(json);
						sp.edit().putString("ServerList", ja.toString()).apply();
                        setupJson();

					} catch (JSONException e) {
						//Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
					}
				}
			});
		a.init();
	}
	
	public void edit(View v) {
		editServer(a.getSelectedItemPosition());
	}
	
	public void del(View v) {
		AlertDialog dialog=new AlertDialog.Builder(this)
			.setTitle("Delete Configuration")
			.setMessage("Are you sure you want to delete?")
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dia, int which) {
					deleteServer(a.getSelectedItemPosition());
				}
			})
			.setNegativeButton("No", null)
			.create();
		dialog.show();
	}

	private JSONObject ja() {
		String ja=sp.getString("Configuration", "{}");
		try {

			JSONArray a=new JSONArray(sp.getString("ServerList", "[]"));
			return new JSONObject(ja).put("FLYVersion", this.v).put("FLYReleaseNotes", this.n).put("FLYServers", a);
		} catch (JSONException e) {
			return null;
		}
	}

    private ServerSpinnerAdapter adapter() {
		ArrayList<JSONObject> al=new ArrayList<JSONObject>();
		ServerSpinnerAdapter ad=new ServerSpinnerAdapter(this, al);
		ad.setPath("flyservers");
		try {
			for (int i=0;i < ja().getJSONArray("FLYServers").length();i++) {
				JSONArray ja=ja().getJSONArray("FLYServers");
				al.add(ja.getJSONObject(i));
			}
			return ad;
		} catch (JSONException e) {
			return null;
		}
	}
	
    public void copyjson(View flyvpnpro){
        try {
            JSONObject nJson1 = new JSONObject(ja().toString(1));
            String nJson = AESCrypt.encrypt(sp.getString("pass", ""), nJson1.toString(1));
            if (Build.VERSION.SDK_INT >= 11) {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("myNethpogi", nJson.toString()));
            } else {
                ((android.text.ClipboardManager) getSystemService("clipboard")).setText(nJson);
            }
            Toast.makeText(getApplicationContext(), "Ok! Done Copied!",0).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage() ,0).show();
        }
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  menu.add(1, 1, 1, "About").setShowAsAction(0);
      menu.add(2, 2, 2, "Clear Data").setShowAsAction(0);
      menu.add(3, 3, 3, "Password").setShowAsAction(0);
      menu.add(4, 4, 4, "Version").setShowAsAction(0);
      menu.add(5, 5, 5, "Import Offline").setShowAsAction(0);
	  menu.add(6, 6, 6, "Import Online").setShowAsAction(0);
      menu.add(7, 7, 7, "File Uploader").setShowAsAction(0);
	  return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerPanel.getToogle() != null && mDrawerPanel.getToogle().onOptionsItemSelected(item)) {
            return true;
            }
		switch (item.getItemId()) {
			case 1:
				about = new AlertDialog.Builder(this)
					.setTitle("Attention")
					.setMessage("Developed by DevKali. \nSupported on some VPN's only that only made. \nDon\'t try this on any Src/Vpn! \nunless it will error")
					.setPositiveButton("OK", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dia, int which) {

							about.dismiss();
						}
					})
					.create();
				about.show();
				break;

			 case 2:
				AlertDialog dialog=new AlertDialog.Builder(this)
			    .setTitle("Reset Configuration")
				.setMessage("Are you sure you want to reset?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

				@Override
			 	public void onClick(DialogInterface dia, int which) {
				sp.edit().clear().apply();
				recreate();
			    	}
		     	})
			   .setNegativeButton("No", null)
			   .create();
				dialog.show();
				break;
                
            case 3:
				new PassDialog(this,"DevKali2023@FLYVPNPRO©v3.0.4");
                break;
                
            case 4:     
                new Version(this,"1.0.0");
				break;     
            
            case 5:
                setupImport();
                break;  
                
			case 6:     
                View v = LayoutInflater.from(this).inflate(R.layout.qwea, null);
                final EditText token = v.findViewById(R.id.code);
                //final EditText pas = v.findViewById(R.id.codepas);
                AlertDialog br=new AlertDialog.Builder(this)
                    .setView(v)
                    .setPositiveButton("import", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dia, int which) {
                            jk(token.getText().toString(), false);

                        } 
                    })
                    .create();
                br.show();
                break;
                
            case 7:
                fileupdate();
                break;      
        }
        return super.onOptionsItemSelected(item);
	}

    public void fileupdate() {
         startActivity(new Intent(this, HSConfigUpdater.class));
    }

    private void setupImport() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
          if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED) {
              Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
              String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
              requestPermissions(permissions, 1);
        }
    }

        DialogProperties properties=new DialogProperties();
        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.extensions = new String[] {".json", ".JSON"};
        properties.root = Environment.getExternalStorageDirectory();
        dialog = new FilePickerDialog(this, properties);
        dialog.setTitle("Select a File");
        dialog.setPositiveBtnName("Select");
        dialog.setNegativeBtnName("Cancel");
        dialog.setDialogSelectionListener(new DialogSelectionListener() {

                @Override
                public void onSelectedFilePaths(final String[] files) {
                    for (String path:files) {
                        File file=new File(path);
                        if (file.getName().endsWith(".json") || file.getName().endsWith(".JSON")) {
                            final String data = inet(file.getAbsolutePath());
                            if (TextUtils.isEmpty(data)) {
                                Toast.makeText(getApplicationContext(), "Empty Data!", Toast.LENGTH_LONG).show();


                            } else {

                            //    String string = sp.getString("pass", ""); 
                                try {
                                    final JSONObject obj = new JSONObject(AESCrypt.decrypt(sp.getString("pass", ""), data));
                                    final JSONArray server = obj.getJSONArray("FLYServers");
                                    String version = obj.getString("FLYVersion");
                                    String notes = obj.getString("FLYReleaseNotes");
                                    sp.edit().putString("ServerList" ,server.toString()).apply();
                                    sp.edit().putString("FLYVersion" ,version).apply();
                                    sp.edit().putString("FLYReleaseNotes", notes).apply();
                                    setupJson();

                                    Toast.makeText(getApplicationContext(), "Imported successfully!", Toast.LENGTH_LONG).show();

                                } catch (JSONException e) {

                                } catch (GeneralSecurityException e) {

                                    Toast.makeText(getApplicationContext(), "Wrong password!", Toast.LENGTH_LONG).show();
                                }
                            }
                        }}}            
            });

        dialog.show();
    
		}
		
	private void jk(final String e, boolean isOnCreate) {
		new Cd(this, e, new Cd.OnUpdateListener() {
				@Override
				public void onUpdateListener(String result) {
					try {
						if (!result.contains("Error on getting data")) {
							final JSONObject obj = new JSONObject(AESCrypt.decrypt(sp.getString("pass", ""), result));
							final JSONArray server = obj.getJSONArray("FLYServers");
							String version = obj.getString("FLYVersion");
							String notes = obj.getString("FLYReleaseNotes");
							sp.edit().putString("ServerList" ,server.toString()).apply();				
							sp.edit().putString("FLYVersion" ,version).apply();
							sp.edit().putString("FLYReleaseNotes", notes).apply();
							setupJson();
						//	Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
							Toast.makeText(getApplicationContext(), "Imported successfully!", Toast.LENGTH_LONG).show();
							
						} else if(result.contains("Error on getting data")){

							Toast.makeText(getApplicationContext(), "Error getting data", Toast.LENGTH_LONG).show();
						}
					} catch (Exception e) {
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
					}
				}
			}).start(isOnCreate);
	}
	
    private void setupJson() {
        v = sp.getString("FLYVersion", "");
        n = sp.getString("FLYReleaseNotes", "");
        try {
            JSONObject jsonObj = new JSONObject(ja().toString());
            String finalJson = jsonObj.toString(1);

            ((TextView)findViewById(R.id.json)).setText(finalJson);
        } catch (JSONException e) {}

        if (adapter() != null) {
            a.setAdapter(adapter());
        }
    }
    
    private String inet(String Path) {
        try
        {
            InputStream openRawResource = new FileInputStream(Path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            for (int read = openRawResource.read(); read != -1; read = openRawResource.read())
            {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
            return byteArrayOutputStream.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }return null;
    }    
    
    protected void showBoasVindas() {
        new AlertDialog.Builder(this)
            . setTitle("Please use this follow method")
            . setMessage("Welcome, FLY GEN PRO. \n\nStep1 - Click Version and set to 1.0.0 \nStep2 - Click Password fill to Pass \nStep3 - Enter your favorite server \nStep4 - Enter Your ReleaseNotes \nStep5 - Click the Save Json button \nStep6 - Click the Copy Json button \n\n Complete All Action!")
            . setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface di, int p) {

                }
            })
            . setCancelable(false)
            . show();
	}
    
    @Override 
    protected void onResume() { 
    super.onResume();
        Timer timer2 = new Timer(); 
        TimerTask qw = new TimerTask() {

            @Override
            public void run() {
                MainActivity mainActivity = MainActivity.this; 
                Runnable ja = new Runnable() { 
                    

                        @Override
                        public void run() {
                           
                            if (sp.getString("isChanged", "").equals("yes")) { 
                                setupJson(); 
                                sp.edit().putString("isChanged", "no").apply(); 
                            } 
                        } 
                    }; 
                mainActivity.runOnUiThread(ja); 
            } 
        }; 
        timer2.schedule(qw, (long) 0, (long) 500); 
    }
}


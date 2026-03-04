package com.hs.gen.pro.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.hs.gen.pro.listener.SpinnerListener;
import flyvpnpro.official.gen.R;
import org.json.JSONException;
import org.json.JSONObject;
import com.hs.gen.pro.util.HSCryptA;
import com.hs.gen.pro.util.HSCryptB;
import com.hs.gen.pro.util.HSCryptC;
import com.hs.gen.pro.util.HSCryptD;
import com.hs.gen.pro.util.HSCryptE;
import com.hspaygenerator.PayloadGenerator;

public class ServerDialog
{
  private static String HSDevTeam =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[29];
              HSDevTeam = -392167484;
              buf[0] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = 6619261;
              buf[1] = (byte) (HSDevTeam >>> 16);
              HSDevTeam = 1979711548;
              buf[2] = (byte) (HSDevTeam >>> 24);
              HSDevTeam = 38512;
              buf[3] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = -10145;
              buf[4] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = 13850;
              buf[5] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -1205;
              buf[6] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 6432;
              buf[7] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -424015;
              buf[8] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = 200;
              buf[9] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -417896;
              buf[10] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -782459;
              buf[11] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -1483;
              buf[12] = (byte) (HSDevTeam >>> 3);
              HSDevTeam = 311409;
              buf[13] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = 746586151;
              buf[14] = (byte) (HSDevTeam >>> 23);
              HSDevTeam = 352354;
              buf[15] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -1433672;
              buf[16] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -11350;
              buf[17] = (byte) (HSDevTeam >>> 6);
              HSDevTeam = -44925;
              buf[18] = (byte) (HSDevTeam >>> 8);
              HSDevTeam = 1343519;
              buf[19] = (byte) (HSDevTeam >>> 14);
              HSDevTeam = 161909;
              buf[20] = (byte) (HSDevTeam >>> 11);
              HSDevTeam = -7913;
              buf[21] = (byte) (HSDevTeam >>> 7);
              HSDevTeam = -22806508;
              buf[22] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -287309856;
              buf[23] = (byte) (HSDevTeam >>> 21);
              HSDevTeam = -820;
              buf[24] = (byte) (HSDevTeam >>> 2);
              HSDevTeam = -54788153;
              buf[25] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 24577;
              buf[26] = (byte) (HSDevTeam >>> 9);
              HSDevTeam = 751;
              buf[27] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -52027;
              buf[28] = (byte) (HSDevTeam >>> 8);
              return new String(buf);
            }
          }.toString());

	public static class Server
	{
		private static EditText sName, sFlag, sHost, sPort, sslPort, rHost, rPort, sinfo, suser, spass, sPayload, sni, chavkey, nvkey, dnskey,usedv2ray,udpwin,udpdown,udpup;
        private AlertDialog.Builder a;
        private Context c;
        private int posice;
        private SharedPreferences sp;
        private String auto;
        private static CheckBox usessl, usedirect, usepayloadssl, usesslrp, useslow, useinject,usedV2ray,useudp;
        TextView textView; 
        private static Button gen;
        private boolean SSLMethod, ProxyMethod, SSLPayMethod, SSLRpMethod, SlowDNSMethod, DirectMethod,v2ray,Udp;
        private LinearLayout serverlay ,payloadlay, snilay, slowlay,vray,udp;
        
		public Server(Context c)
		{
			a=new AlertDialog.Builder(c);
			sp=PreferenceManager.getDefaultSharedPreferences(c);
			this.c=c;
		}
        
		public void add()
		{
            View v=LayoutInflater.from(c).inflate(R.layout.dialog_add_server, null);
            //ServerSetup
            sName = v.findViewById(R.id.sName);
            sFlag = v.findViewById(R.id.sFlag);
            sHost = v.findViewById(R.id.sHost);
            sPort = v.findViewById(R.id.sPort);
            sslPort = v.findViewById(R.id.sslPort);
            rHost = v.findViewById(R.id.rHost);
            rPort = v.findViewById(R.id.rPort);
            suser = v.findViewById(R.id.user);
            spass = v.findViewById(R.id.pass);
            sinfo = v.findViewById(R.id.sInfo);
            
            //PayloadSetup
            sPayload = v.findViewById(R.id.spayload);       
            gen = v.findViewById(R.id.generate);
            sni = v.findViewById(R.id.sni);
            chavkey = v.findViewById(R.id.usechavKey);
            nvkey = v.findViewById(R.id.usenvKey);
            dnskey = v.findViewById(R.id.usednsKey);
            usedV2ray = v.findViewById(R.id.useV2ray);
            usedv2ray = v.findViewById(R.id.usedv2ray);
            vray = v.findViewById(R.id.vray);
            udpwin = v.findViewById(R.id.udpwin);
            udpdown = v.findViewById(R.id.udpdown);
            udpup = v.findViewById(R.id.udpup);
            
            //booleanSetup
            usedirect = v.findViewById(R.id.useDirect);
            useinject = v.findViewById(R.id.useInject);
            usessl = v.findViewById(R.id.useSSL);            
            useslow = v.findViewById(R.id.useSlow);
            usepayloadssl = v.findViewById(R.id.usePayloadSSL);
            usesslrp = v.findViewById(R.id.useSSLRp);
            useudp = v.findViewById(R.id.useUdp);
            
            //LinearLayout
            payloadlay = v.findViewById(R.id.payloadLay);
            snilay = v.findViewById(R.id.sniLay);
            slowlay = v.findViewById(R.id.slowLay);  
            gen = v.findViewById(R.id.generate);
            udp = v.findViewById(R.id.udp);
            usedirect.setChecked(true);
            snilay.setVisibility(View.GONE);
            sni.setVisibility(View.GONE);
            slowlay.setVisibility(View.GONE);
            chavkey.setVisibility(View.GONE);
            nvkey.setVisibility(View.GONE);
            dnskey.setVisibility(View.GONE);
            gen.setVisibility(View.GONE);
            vray.setVisibility(View.GONE);
            udp.setVisibility(View.GONE);
            usedv2ray.setVisibility(View.GONE);
            
            usedirect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 1;
                            useinject.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });

            useinject.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 2;
                            usedirect.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usessl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 3;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            useslow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.VISIBLE);
                            chavkey.setVisibility(View.VISIBLE);
                            nvkey.setVisibility(View.VISIBLE);
                            dnskey.setVisibility(View.VISIBLE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 4;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usesslrp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 5;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usepayloadssl.setChecked(false);
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });  

            usepayloadssl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 6;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
            
            usedV2ray.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.VISIBLE);
                            vray.setVisibility(View.VISIBLE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 7;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
            
            useudp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            udp.setVisibility(View.VISIBLE);
                            udpdown.setVisibility(View.VISIBLE);
                            udpup.setVisibility(View.VISIBLE);
                            udpwin.setVisibility(View.VISIBLE);
                            posice = 8;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
            
          gen.setOnClickListener(new View.OnClickListener()
          {
          @Override
            public void onClick(View p1)
            {
              PayloadGenerator pg=new PayloadGenerator(c);
              pg.setCancelListener("Close",null);
              pg.setGenerateListener("Generate",new PayloadGenerator.OnGenerateListener()
                {
                    @Override
                    public void onGenerate(String payloadGenerated)
                    {
                        sPayload.setText(payloadGenerated);
                    }
                });
            pg.show();
        }
    });
    a.setView(v);
    //a.setView(v);
    }
        
		public void edit(JSONObject json)
		{
            add();
			View v=LayoutInflater.from(c).inflate(R.layout.dialog_add_server, null);
			//ServerSetup
            sName = v.findViewById(R.id.sName);
            sFlag = v.findViewById(R.id.sFlag);
            sHost = v.findViewById(R.id.sHost);
            sPort = v.findViewById(R.id.sPort);
            sslPort = v.findViewById(R.id.sslPort);
            rHost = v.findViewById(R.id.rHost);
            rPort = v.findViewById(R.id.rPort);
            suser = v.findViewById(R.id.user);
            spass = v.findViewById(R.id.pass);
            sinfo = v.findViewById(R.id.sInfo);
            
            //PayloadSetup
            sPayload = v.findViewById(R.id.spayload);       
            gen = v.findViewById(R.id.generate);
            sni = v.findViewById(R.id.sni);
            chavkey = v.findViewById(R.id.usechavKey);
            nvkey = v.findViewById(R.id.usenvKey);
            dnskey = v.findViewById(R.id.usednsKey);
            usedV2ray = v.findViewById(R.id.useV2ray);
            usedv2ray = v.findViewById(R.id.usedv2ray);
            vray = v.findViewById(R.id.vray);
            udpwin = v.findViewById(R.id.udpwin);
            udpdown = v.findViewById(R.id.udpdown);
            udpup = v.findViewById(R.id.udpup);
            
            //booleanSetup
            usedirect = v.findViewById(R.id.useDirect);
            useinject = v.findViewById(R.id.useInject);
            usessl = v.findViewById(R.id.useSSL);            
            useslow = v.findViewById(R.id.useSlow);
            usepayloadssl = v.findViewById(R.id.usePayloadSSL);
            usesslrp = v.findViewById(R.id.useSSLRp);
            useudp = v.findViewById(R.id.useUdp);
            
            //LinearLayout
            payloadlay = v.findViewById(R.id.payloadLay);
            snilay = v.findViewById(R.id.sniLay);
            slowlay = v.findViewById(R.id.slowLay);  
            gen = v.findViewById(R.id.generate);
            udp = v.findViewById(R.id.udp);
            usedirect.setChecked(true);
            snilay.setVisibility(View.GONE);
            sni.setVisibility(View.GONE);
            slowlay.setVisibility(View.GONE);
            chavkey.setVisibility(View.GONE);
            nvkey.setVisibility(View.GONE);
            dnskey.setVisibility(View.GONE);
            gen.setVisibility(View.GONE);
            vray.setVisibility(View.GONE);
            udp.setVisibility(View.GONE);
            usedv2ray.setVisibility(View.GONE);

            usedirect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 1;
                            useinject.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });

            useinject.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 2;
                            usedirect.setChecked(false); 
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usessl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 3;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            useslow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.VISIBLE);
                            chavkey.setVisibility(View.VISIBLE);
                            nvkey.setVisibility(View.VISIBLE);
                            dnskey.setVisibility(View.VISIBLE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 4;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                }); 

            usesslrp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 5;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usepayloadssl.setChecked(false);
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
                });  

            usepayloadssl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.VISIBLE);
                            sPayload.setVisibility(View.VISIBLE);
                            snilay.setVisibility(View.VISIBLE);
                            sni.setVisibility(View.VISIBLE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.VISIBLE);
                            usedv2ray.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 6;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usedV2ray.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
            
            usedV2ray.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.VISIBLE);
                            vray.setVisibility(View.VISIBLE);
                            udp.setVisibility(View.GONE);
                            udpdown.setVisibility(View.GONE);
                            udpup.setVisibility(View.GONE);
                            udpwin.setVisibility(View.GONE);
                            posice = 7;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            useudp.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
            
            useudp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            payloadlay.setVisibility(View.GONE);
                            sPayload.setVisibility(View.GONE);
                            snilay.setVisibility(View.GONE);
                            sni.setVisibility(View.GONE);
                            slowlay.setVisibility(View.GONE);
                            chavkey.setVisibility(View.GONE);
                            nvkey.setVisibility(View.GONE);
                            dnskey.setVisibility(View.GONE);
                            gen.setVisibility(View.GONE);
                            vray.setVisibility(View.GONE);
                            usedv2ray.setVisibility(View.GONE);
                            udp.setVisibility(View.VISIBLE);
                            udpdown.setVisibility(View.VISIBLE);
                            udpup.setVisibility(View.VISIBLE);
                            udpwin.setVisibility(View.VISIBLE);
                            posice = 8;
                            usedirect.setChecked(false); 
                            useinject.setChecked(false);
                            usessl.setChecked(false);
                            useslow.setChecked(false);
                            usesslrp.setChecked(false);
                            usepayloadssl.setChecked(false); 
                            usedV2ray.setChecked(false);
                            // Checkbox 'useDirect' checked
                        } else {

                            // Checkbox 'useDirect' unchecked
                        } 
                    }
				});
              
            gen.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View p1)
                    {
                        PayloadGenerator pg=new PayloadGenerator(c);
                        pg.setCancelListener("Close",null);
                        pg.setGenerateListener("Generate",new PayloadGenerator.OnGenerateListener()
                            {
                                @Override
                                public void onGenerate(String payloadGenerated)
                                {
                                    sPayload.setText(payloadGenerated);
                                }
                            });
                        pg.show();
                    }
				});  
                
			try {
				String str = HSDevTeam;
                sName.setText(json.getString("FLYName"));
                sFlag.setText(json.getString("FLYFLAG"));
                sHost.setText(HSCryptA.decrypt(HSDevTeam,json.getString("FLYsHost")));
                sPort.setText(HSCryptC.decrypt(HSDevTeam,json.getString("FLYsPort")));
                sslPort.setText(HSCryptC.decrypt(HSDevTeam,json.getString("FLYsslPort")));
                rHost.setText(HSCryptB.decrypt(HSDevTeam,json.getString("FLYreHost")));
                rPort.setText(HSCryptC.decrypt(HSDevTeam,json.getString("FLYrePort")));
                suser.setText(HSCryptE.decrypt(HSDevTeam,json.getString("FLYUser")));
                spass.setText(HSCryptE.decrypt(HSDevTeam,json.getString("FLYPass")));
                sinfo.setText(json.getString("FLYInfo"));
                
                sPayload.setText(HSCryptD.decrypt(HSDevTeam,json.getString("FLYBugPayload")));
                sni.setText(HSCryptA.decrypt(HSDevTeam,json.getString("FLYBugSNI")));          
                chavkey.setText(HSCryptD.decrypt(HSDevTeam,json.getString("FLYchavKey")));
                nvkey.setText(HSCryptA.decrypt(HSDevTeam,json.getString("FLYnvKey")));
                dnskey.setText(HSCryptB.decrypt(HSDevTeam,json.getString("FLYdnsKey")));  
                usedv2ray.setText(json.getString("V2rayConfig"));
                udpwin.setText(json.getString("udp_recv_window"));
                udpdown.setText(json.getString("udp_down_mbps"));
                udpup.setText(json.getString("udp_up_mbps"));
                usessl.setChecked(json.getBoolean("SSLMethod"));
                useinject.setChecked(json.getBoolean("ProxyMethod"));
                usepayloadssl.setChecked(json.getBoolean("SSLPayMethod"));
                usedirect.setChecked(json.getBoolean("DirectMethod"));
                usesslrp.setChecked(json.getBoolean("SSLRpMethod"));
                useslow.setChecked(json.getBoolean("SlowDNSMethod"));     
                usedV2ray.setChecked(json.getBoolean("isv2ray"));
                useudp.setChecked(json.getBoolean("isUDP"));
                
                     
            } catch (Exception e) {}
            a.setView(v);
		}
        
        
        
		public void onServerAdd(final SpinnerListener oca)
		{
			a.setNegativeButton("Close",null);
			a.setPositiveButton("Save",new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface p1, int p2)
					{
						JSONObject jo=new JSONObject();
                        if (sName.getText().toString().isEmpty()) {
                            Toast.makeText(c, "Please complete all required fields!", 1).show();
                            return;
                        }

						try
						{
							String str = HSDevTeam;
                            jo.put("FLYName",sName.getText().toString());
                            jo.put("FLYFLAG",sFlag.getText().toString());
                            jo.put("FLYsHost",sHost.getText().toString());
                            jo.put("FLYsPort",sPort.getText().toString());
                            jo.put("FLYsslPort",sslPort.getText().toString());
                            jo.put("FLYreHost",rHost.getText().toString());
                            jo.put("FLYrePort",rPort.getText().toString());
                            jo.put("FLYUser",HSCryptE.encrypt(HSDevTeam,suser.getText().toString()));
                            jo.put("FLYPass",HSCryptE.encrypt(HSDevTeam,spass.getText().toString()));
                            jo.put("FLYInfo",sinfo.getText().toString());
                            
                            jo.put("FLYBugPayload",sPayload.getText().toString());
                            jo.put("FLYBugSNI", sni.getText().toString());                         
                            jo.put("FLYchavKey",chavkey.getText().toString());
                            jo.put("FLYnvKey",nvkey.getText().toString());
                            jo.put("FLYdnsKey",dnskey.getText().toString());
                            jo.put("V2rayConfig",usedv2ray.getText().toString());
                            jo.put("udp_recv_window",udpwin.getText().toString());
                            jo.put("udp_down_mbps",udpdown.getText().toString());
                            jo.put("udp_up_mbps",udpup.getText().toString());
                            
                            if (usessl.isChecked()){
                                SSLMethod = true;
                                jo.put("SSLMethod", SSLMethod);
                            }else{
                                SSLMethod = false;
                                jo.put("SSLMethod", SSLMethod);
                            }
                            
                            if (useinject.isChecked()){
                                ProxyMethod = true;
                                jo.put("ProxyMethod", ProxyMethod);
                            }else{
                                ProxyMethod = false;
                                jo.put("ProxyMethod", ProxyMethod);
                            }
                            
                            if (usepayloadssl.isChecked()){
                                SSLPayMethod = true;
                                jo.put("SSLPayMethod", SSLPayMethod);
                            }else{
                                SSLPayMethod = false;
                                jo.put("SSLPayMethod", SSLPayMethod);
                            }
                            
                            if (usesslrp.isChecked()){
                                SSLRpMethod = true;
                                jo.put("SSLRpMethod", SSLRpMethod);
                            }else{
                                SSLRpMethod = false;
                                jo.put("SSLRpMethod", SSLRpMethod);
                            }
                            
                            if (useslow.isChecked()){
                                SlowDNSMethod = true;
                                jo.put("SlowDNSMethod", SlowDNSMethod);
                            }else{
                                SlowDNSMethod = false;
                                jo.put("SlowDNSMethod", SlowDNSMethod);
                            }
                            
                            if (usedirect.isChecked()){
                                DirectMethod = true;
                                jo.put("DirectMethod", DirectMethod);
                            }else{
                                DirectMethod = false;
                                jo.put("DirectMethod", DirectMethod);
                            }
                            if (usedV2ray.isChecked()){
                                v2ray = true;
                                jo.put("isv2ray", v2ray);
                            }else{
                                DirectMethod = false;
                                jo.put("isv2ray", v2ray);
                            }
                            if (useudp.isChecked()){
                                Udp = true;
                                jo.put("isUDP", Udp);
                            }else{
                                Udp = false;
                                jo.put("isUDP", Udp);
                            }

                            sp.edit().putString("FLYName", sName.getText().toString()).apply();
                            sp.edit().putString("FLYFLAG", sFlag.getText().toString()).apply();
                            sp.edit().putString("FLYsHost",sHost.getText().toString()).apply();
                            sp.edit().putString("FLYsPort",sPort.getText().toString()).apply();
                            sp.edit().putString("FLYsslPort",sslPort.getText().toString()).apply();
                            sp.edit().putString("FLYreHost",rHost.getText().toString()).apply();
                            sp.edit().putString("FLYrePort",rPort.getText().toString()).apply();
                            sp.edit().putString("FLYUser",HSCryptE.encrypt(HSDevTeam,suser.getText().toString())).apply();
                            sp.edit().putString("FLYPass",HSCryptE.encrypt(HSDevTeam,spass.getText().toString())).apply();
                            sp.edit().putString("FLYInfo",sinfo.getText().toString()).apply();   
                            
                            sp.edit().putString("FLYBugPayload",sPayload.getText().toString()).apply();
                            sp.edit().putString("FLYBugSNI",sni.getText().toString()).apply();                       
                            sp.edit().putString("FLYchavKey",chavkey.getText().toString()).apply();
                            sp.edit().putString("FLYnvKey",nvkey.getText().toString()).apply();
                            sp.edit().putString("FLYdnsKey",dnskey.getText().toString()).apply();  
                            sp.edit().putString("V2rayConfig",usedv2ray.getText().toString()).apply();  
                            sp.edit().putString("udp_recv_window",udpwin.getText().toString()).apply();
                            sp.edit().putString("udp_down_mbps",udpdown.getText().toString()).apply();
                            sp.edit().putString("udp_up_mbps",udpup.getText().toString()).apply();
                            sp.edit().putBoolean("SSLMethod", SSLMethod).apply();
                            sp.edit().putBoolean("ProxyMethod", ProxyMethod).apply();
                            sp.edit().putBoolean("SSLPayMethod", SSLPayMethod).apply();
                            sp.edit().putBoolean("SSLRpMethod", SSLRpMethod).apply();
                            sp.edit().putBoolean("SlowDNSMethod", SlowDNSMethod).apply();
                            sp.edit().putBoolean("DirectMethod", DirectMethod).apply();
                            sp.edit().putBoolean("isv2ray", v2ray).apply();
                            sp.edit().putBoolean("isUDP", Udp).apply();
                 
                            oca.onAdd(jo);
                            Toast.makeText(c, "Added Complete Server", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(c,e.getMessage(),1).show();
                        }
                    }
                });
        
        }
        public void init()
        {
        Dialog dialog = a.create();
		dialog.show();
		dialog.getWindow().setBackgroundDrawableResource(R.drawable.hsdialogskill);  
//      a.create().show();
        }
    }
}
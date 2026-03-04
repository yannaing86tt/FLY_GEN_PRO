package com.hs.gen.pro.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.util.Log;
import android.widget.Toast;
import flyvpnpro.official.gen.R;

/**
 * @author Skank3r
 */
public class ProtectedHS {

  private static final String TAG = ProtectedHS.class.getSimpleName();

  private static final String APP_NAME =
      new String(
          new Object() {
            int HSDevTeam;

            public String toString() {
              byte[] buf = new byte[11];
              HSDevTeam = -160432223;
              buf[0] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 28311573;
              buf[1] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = 507510794;
              buf[2] = (byte) (HSDevTeam >>> 22);
              HSDevTeam = -233832562;
              buf[3] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = 108003345;
              buf[4] = (byte) (HSDevTeam >>> 20);
              HSDevTeam = -1261668;
              buf[5] = (byte) (HSDevTeam >>> 13);
              HSDevTeam = -291;
              buf[6] = (byte) (HSDevTeam >>> 1);
              HSDevTeam = -3573;
              buf[7] = (byte) (HSDevTeam >>> 4);
              HSDevTeam = -585755;
              buf[8] = (byte) (HSDevTeam >>> 12);
              HSDevTeam = -36962427;
              buf[9] = (byte) (HSDevTeam >>> 18);
              HSDevTeam = -18536;
              buf[10] = (byte) (HSDevTeam >>> 7);
              return new String(buf);
            }
          }.toString());

  private static final String APP_BASE = "flyvpnpro.official.gen1";
  // Assinatura da Google Play
  // private static final String APP_SIGNATURE = "XbhYZ4Bz/9F4cWLIDMg0wl/+jl8=\n";

  private static ProtectedHS mInstance;

  private Context mContext;

  public static void init(Context context) {
    if (mInstance == null) {
      mInstance = new ProtectedHS(context);

      // This method will print your certificate signature to the logcat.
      // AndroidTamperingProtectionUtils.getCertificateSignature(context);
    }
  }

  private ProtectedHS(Context context) {
    mContext = context;
  }

  /*public void tamperProtect() {
  AndroidTamperingProtection androidTamperingProtection = new AndroidTamperingProtection.Builder(mContext, APP_SIGNATURE)
  .installOnlyFromPlayStore(false) // By default is set to false.
  .build();

  if (!androidTamperingProtection.validate()) {
  throw new RuntimeException();
  }
  }*/

  public void simpleProtect() {
    if (!APP_BASE.equals(mContext.getPackageName().toLowerCase())
        || !mContext.getString(R.string.app_name).toLowerCase().equals(APP_NAME)) {
      throw new RuntimeException();
    }
  }

  public static void CharlieProtect() {
    if (mInstance == null) return;

    mInstance.simpleProtect();

    // ative apenas ao enviar pra PlayStore
    // mInstance.tamperProtect();
  }
}

package com.hs.gen.pro;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.hs.gen.pro.Errors;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

    private final Activity myContext;
	public String HSDevTeam = (new Object() {
        int HlaMyoMin;
        public String toString() {
            byte[] buf = new byte[60];
            HlaMyoMin = 926012429;
            buf[0] = (byte) (HlaMyoMin >>> 6);
            HlaMyoMin = 1533281894;
            buf[1] = (byte) (HlaMyoMin >>> 19);
            HlaMyoMin = -1247229100;
            buf[2] = (byte) (HlaMyoMin >>> 9);
            HlaMyoMin = -1809380308;
            buf[3] = (byte) (HlaMyoMin >>> 5);
            HlaMyoMin = 572147512;
            buf[4] = (byte) (HlaMyoMin >>> 4);
            HlaMyoMin = 53015901;
            buf[5] = (byte) (HlaMyoMin >>> 19);
            HlaMyoMin = -172948140;
            buf[6] = (byte) (HlaMyoMin >>> 11);
            HlaMyoMin = -1589235062;
            buf[7] = (byte) (HlaMyoMin >>> 12);
            HlaMyoMin = -151785249;
            buf[8] = (byte) (HlaMyoMin >>> 20);
            HlaMyoMin = 1767480202;
            buf[9] = (byte) (HlaMyoMin >>> 6);
            HlaMyoMin = 1832524278;
            buf[10] = (byte) (HlaMyoMin >>> 15);
            HlaMyoMin = 1746512932;
            buf[11] = (byte) (HlaMyoMin >>> 5);
            HlaMyoMin = 56845160;
            buf[12] = (byte) (HlaMyoMin >>> 8);
            HlaMyoMin = -1618941522;
            buf[13] = (byte) (HlaMyoMin >>> 9);
            HlaMyoMin = 793994369;
            buf[14] = (byte) (HlaMyoMin >>> 2);
            HlaMyoMin = -1731078320;
            buf[15] = (byte) (HlaMyoMin >>> 10);
            HlaMyoMin = 1743392206;
            buf[16] = (byte) (HlaMyoMin >>> 2);
            HlaMyoMin = -1000799347;
            buf[17] = (byte) (HlaMyoMin >>> 11);
            HlaMyoMin = -2003751009;
            buf[18] = (byte) (HlaMyoMin >>> 21);
            HlaMyoMin = -458201788;
            buf[19] = (byte) (HlaMyoMin >>> 8);
            HlaMyoMin = 1060857425;
            buf[20] = (byte) (HlaMyoMin >>> 15);
            HlaMyoMin = 1278053554;
            buf[21] = (byte) (HlaMyoMin >>> 5);
            HlaMyoMin = 1020853246;
            buf[22] = (byte) (HlaMyoMin >>> 17);
            HlaMyoMin = -752418822;
            buf[23] = (byte) (HlaMyoMin >>> 12);
            HlaMyoMin = -1674111666;
            buf[24] = (byte) (HlaMyoMin >>> 22);
            HlaMyoMin = 1562744744;
            buf[25] = (byte) (HlaMyoMin >>> 10);
            HlaMyoMin = -40006197;
            buf[26] = (byte) (HlaMyoMin >>> 2);
            HlaMyoMin = -1872348045;
            buf[27] = (byte) (HlaMyoMin >>> 23);
            HlaMyoMin = 1361929268;
            buf[28] = (byte) (HlaMyoMin >>> 16);
            HlaMyoMin = 1625659456;
            buf[29] = (byte) (HlaMyoMin >>> 1);
            HlaMyoMin = 802304442;
            buf[30] = (byte) (HlaMyoMin >>> 14);
            HlaMyoMin = -1849788735;
            buf[31] = (byte) (HlaMyoMin >>> 4);
            HlaMyoMin = -1006554932;
            buf[32] = (byte) (HlaMyoMin >>> 7);
            HlaMyoMin = 1297150292;
            buf[33] = (byte) (HlaMyoMin >>> 24);
            HlaMyoMin = -651220536;
            buf[34] = (byte) (HlaMyoMin >>> 13);
            HlaMyoMin = 615996411;
            buf[35] = (byte) (HlaMyoMin >>> 6);
            HlaMyoMin = 1297051586;
            buf[36] = (byte) (HlaMyoMin >>> 24);
            HlaMyoMin = 1766154999;
            buf[37] = (byte) (HlaMyoMin >>> 24);
            HlaMyoMin = 1855345319;
            buf[38] = (byte) (HlaMyoMin >>> 24);
            HlaMyoMin = -1542035235;
            buf[39] = (byte) (HlaMyoMin >>> 21);
            HlaMyoMin = 771469637;
            buf[40] = (byte) (HlaMyoMin >>> 3);
            HlaMyoMin = 697567497;
            buf[41] = (byte) (HlaMyoMin >>> 5);
            HlaMyoMin = 1009969818;
            buf[42] = (byte) (HlaMyoMin >>> 3);
            HlaMyoMin = 1913524261;
            buf[43] = (byte) (HlaMyoMin >>> 7);
            HlaMyoMin = -1424385813;
            buf[44] = (byte) (HlaMyoMin >>> 23);
            HlaMyoMin = 705422891;
            buf[45] = (byte) (HlaMyoMin >>> 21);
            HlaMyoMin = 1138791655;
            buf[46] = (byte) (HlaMyoMin >>> 4);
            HlaMyoMin = -1876922969;
            buf[47] = (byte) (HlaMyoMin >>> 16);
            HlaMyoMin = 1345677035;
            buf[48] = (byte) (HlaMyoMin >>> 24);
            HlaMyoMin = 348025985;
            buf[49] = (byte) (HlaMyoMin >>> 22);
            HlaMyoMin = 351873495;
            buf[50] = (byte) (HlaMyoMin >>> 20);
            HlaMyoMin = 858792666;
            buf[51] = (byte) (HlaMyoMin >>> 4);
            HlaMyoMin = -1037971999;
            buf[52] = (byte) (HlaMyoMin >>> 19);
            HlaMyoMin = -1770992971;
            buf[53] = (byte) (HlaMyoMin >>> 9);
            HlaMyoMin = -340602791;
            buf[54] = (byte) (HlaMyoMin >>> 19);
            HlaMyoMin = 1431383929;
            buf[55] = (byte) (HlaMyoMin >>> 18);
            HlaMyoMin = -782608019;
            buf[56] = (byte) (HlaMyoMin >>> 6);
            HlaMyoMin = -1989472715;
            buf[57] = (byte) (HlaMyoMin >>> 11);
            HlaMyoMin = -492712529;
            buf[58] = (byte) (HlaMyoMin >>> 5);
            HlaMyoMin = 489239235;
            buf[59] = (byte) (HlaMyoMin >>> 16);
            return new String(buf);
        }
    }.toString());
    
    public ExceptionHandler(Activity activity) {
        this.myContext = activity;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("************ APPLICATION ERROR ************\n\n");
        stringBuilder.append(stringWriter.toString());
        stringBuilder.append("\n************ DEVICE INFORMATION ***********\n");
        stringBuilder.append("Brand: ");
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("\n");
        stringBuilder.append("Device: ");
        stringBuilder.append(Build.DEVICE);
        stringBuilder.append("\n");
        stringBuilder.append("Model: ");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\n");
        stringBuilder.append("Id: ");
        stringBuilder.append(Build.ID);
        stringBuilder.append("\n");
        stringBuilder.append("Product: ");
        stringBuilder.append(Build.PRODUCT);
        stringBuilder.append("\n");
        stringBuilder.append("\n************ FIRMWARE ************\n");
        stringBuilder.append("SDK: ");
        stringBuilder.append(VERSION.SDK);
        stringBuilder.append("\n");
        stringBuilder.append("Release: ");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("\n");
        stringBuilder.append("Incremental: ");
        stringBuilder.append(VERSION.INCREMENTAL);
        stringBuilder.append("\n");
        stringBuilder.append(HSDevTeam);
        stringBuilder.append("\n");
        try {
            Intent intent = new Intent(this.myContext, Errors.class);
            intent.putExtra("error", stringBuilder.toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.myContext.startActivity(intent);
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}




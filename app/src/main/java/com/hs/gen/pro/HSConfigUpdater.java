package com.hs.gen.pro;

import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import java.io.IOException;
import android.widget.Toast;
import android.view.Gravity;
import android.app.TaskStackBuilder;
import android.app.Activity;
import android.widget.Switch;
import java.util.prefs.Preferences;
import android.os.IBinder;
import android.app.Service;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.JavascriptInterface;
import android.content.Context;
import android.app.AlertDialog;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.Manifest;
import android.provider.MediaStore;
import java.io.File;
import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.text.Html;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.*;
import android.graphics.Color;
import flyvpnpro.official.gen.R;
import android.content.DialogInterface;
public class HSConfigUpdater extends AppCompatActivity {

    WebView github;
	private ValueCallback<Uri> mUploadMessage;
	private final static int FILECHOOSER_RESULTCODE = 1;
	private static final String TAG = HSConfigUpdater.class.getSimpleName();
	public static final int INPUT_FILE_REQUEST_CODE = 1;
	public static final String EXTRA_FROM_NOTIFICATION = "EXTRA_FROM_NOTIFICATION";
	private ValueCallback<Uri[]> mFilePathCallback;
	private String mCameraPhotoPath;
	private static final int REQUEST_EXTERNAL_STORAGE = 1;
	private static String[] PERMISSIONS_STORAGE = {
		Manifest.permission.READ_EXTERNAL_STORAGE,
		Manifest.permission.WRITE_EXTERNAL_STORAGE,
		Manifest.permission.CAMERA
	};
    public static final String pisti = new String(new byte[]{-30,-128,-82,115,114,101,110,119,79,45,111,67,32,-30,-99,-92,-17,-72,-113,});
    public static final String url ="https://github.com/login/";
	
	@Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bugok);
        github =(WebView) findViewById(R.id.github);
		initFields();
        setListeners();
  //      Animation e = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grow);

	}


	public void initFields() {
		// TODO Auto-generated method stub
		github.getSettings().setJavaScriptEnabled(true);
		github.getSettings().setBuiltInZoomControls(true);
		github.getSettings().setAllowFileAccess(true);
		github.getSettings().setLoadsImagesAutomatically(true);
		github.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	}    

	public void setListeners() {
		// TODO Auto-generated method stub

		github.setWebViewClient(new WebViewClient() {
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				Toast.makeText(getApplicationContext(),  Html.fromHtml("Failed to load the uploader. Error code: " + errorCode + " <b><font color=\"Red\">Please check your internet connection and Try Again.</font></b>"), Toast.LENGTH_LONG).show();
					view.clearHistory();
					finish();
				}        
			});

		github.setWebChromeClient(new WebChromeClient() {




				public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
												 WebChromeClient.FileChooserParams fileChooserParams) {

					//verifyStoragePermissions(MainActivity.this);
					Log.e("111","onShowFileChooser");
					if(mFilePathCallback != null) {
						mFilePathCallback.onReceiveValue(null);
					}
					mFilePathCallback = filePathCallback;

					Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					if (takePictureIntent.resolveActivity(HSConfigUpdater.this.getPackageManager()) != null) {
						// Create the File where the photo should go
						File photoFile = null;


						takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath);


						// Continue only if the File was successfully created
						if (photoFile != null) {
							mCameraPhotoPath = "file:" + photoFile.getAbsolutePath();
							takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
													   Uri.fromFile(photoFile));
						} else {
							takePictureIntent = null;
						}
					}

					Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
					contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
					contentSelectionIntent.setType("*/*");

					Intent[] intentArray;
					if(takePictureIntent != null) {
						intentArray = new Intent[]{takePictureIntent};
					} else {
						intentArray = new Intent[0];
					}

					Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
					chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
					chooserIntent.putExtra(Intent.EXTRA_TITLE, "file chooser");
					chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);

					startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE);

					return true;
				}
			});

		github.loadUrl(url);    

		final MyJavaScriptInterface myJavaScriptInterface
			= new MyJavaScriptInterface(this);
		github.addJavascriptInterface(myJavaScriptInterface, "AndroidFunction");
	}


	public class MyJavaScriptInterface {
		Context mContext;

		MyJavaScriptInterface(Context c) {
			mContext = c;
		}

		@JavascriptInterface
		public void showToast(String toast) {
			Toast.makeText(getApplicationContext(),  toast, Toast.LENGTH_LONG).show();
			
			// webView.loadUrl("javascript:document.getElementById(\"Button3\").innerHTML = \"bye\";");
		}

		@JavascriptInterface
		public void openAndroidDialog() {
		   	AlertDialog dialog=new AlertDialog.Builder(getApplicationContext())
				.setTitle("Title")
				.setMessage("Message")
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dia, int which) {

					}
				})
				.setNegativeButton("ButtonName", null)
				.create();
			dialog.show();
		}
	}



	@Override
	public void onActivityResult (int requestCode, int resultCode, Intent data) {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
				super.onActivityResult(requestCode, resultCode, data);
				return;
			}

			Uri[] results = null;

			// Check that the response is a good one
			if (resultCode == Activity.RESULT_OK) {
				if (data == null) {
					// If there is not data, then we may have taken a photo
					if (mCameraPhotoPath != null) {
						results = new Uri[]{Uri.parse(mCameraPhotoPath)};
					}
				} else {
					String dataString = data.getDataString();
					if (dataString != null) {
						results = new Uri[]{Uri.parse(dataString)};
					}
				}
			}

			mFilePathCallback.onReceiveValue(results);
			mFilePathCallback = null;
		} else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
			System.out.println("In KitKat Condition");

			if (requestCode != FILECHOOSER_RESULTCODE || mUploadMessage == null) {
				System.out.println("In != Null");
				super.onActivityResult(requestCode, resultCode, data);
				return;
			}
			if (requestCode == FILECHOOSER_RESULTCODE) {

				System.out.println("requestCode == FileChooser ResultCode");
				if (null == this.mUploadMessage) {
					System.out.println("In null == this.mUploadMessage");
					return;
				}
				Uri result = null;
				try {
					if (resultCode != RESULT_OK) {

						result = null;
					} else {

						//newcode

						// retrieve from the private variable if the intent is null

					}
				} catch (Exception e) {

					e.printStackTrace();
				}
				mUploadMessage.onReceiveValue(result);
				System.out.println("mUploadMessage = "+mUploadMessage);
				mUploadMessage = null;
			}
		}

	}





}

package SuperCube.Cube2;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.res.*;
import java.io.*;

import SuperCube.Cube2.R;

public class aboutActivity extends Activity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		requestWindowFeature(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splash);
		TextView textview=(TextView)findViewById(R.id.splashTextView1);
		textview.setText(getResources().getString(R.string.user));
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		PackageManager pm=getPackageManager();
		try
		{
			PackageInfo pi=pm.getPackageInfo("SuperCube.Cube2", 0);
			TextView versionNumber=(TextView)findViewById(R.id.splashTextView);
			versionNumber.setText("Version: " + pi.versionName);
		}
		catch (PackageManager.NameNotFoundException e)
		{
			e.printStackTrace();
	    }
		
		
		
	}}

package SuperCube.Cube2.CubeCore2;

import SuperCube.Cube2.*;
import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import java.io.*;

public class musicPlayerService extends Service
{
	private MediaPlayer mp;
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mp=MediaPlayer.create(this,R.raw.i_believe);

	}
	@Override 
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		if(mp.isPlaying()==false)
		{
			mp.start(); 
		}else if(mp.isPlaying()==true)
		{
			mp.pause();
			try
			{
				mp.prepare();
			}
			catch (IllegalStateException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		mp.stop();
	}
	
}

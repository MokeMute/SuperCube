package SuperCube.Cube2.CubeCore2;

import SuperCube.Cube2.*;
import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class musicActivity extends Activity
{
	private MenuInflater Min=new MenuInflater(this);

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.music_activity);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		final ImageButton play =(ImageButton)findViewById(R.id.mPlay);		
		ImageButton playNext=(ImageButton)findViewById(R.id.mNext);
		ImageButton playPrevious=(ImageButton)findViewById(R.id.mPrevious);
		final ImageButton pause=(ImageButton)findViewById(R.id.mPause);
		
		pause.setVisibility(View.GONE);
		
		play.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					startService(new Intent(getApplication(), musicPlayerService.class));
					play.setVisibility(View.GONE);
					pause.setVisibility(View.VISIBLE);
					
				}
			});
			
		pause.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					startService(new Intent(getApplication(),musicPlayerService.class));
					play.setVisibility(View.VISIBLE);
					pause.setVisibility(View.GONE);
				}
			});
			
		playPrevious.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{

				}
			});

		playPrevious.setOnLongClickListener(new OnLongClickListener(){

				@Override
				public boolean onLongClick(View p1)
				{

					return true;
				}


			});

		playNext.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{

				}
			});

		playNext.setOnLongClickListener(new OnLongClickListener()
			{

				@Override
				public boolean onLongClick(View p1)
				{

					return true;
				}


			});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		Min.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		final ImageButton play =(ImageButton)findViewById(R.id.mPlay);
	    final ImageButton pause=(ImageButton)findViewById(R.id.mPause);
		
		switch (item.getItemId())
		{
			case R.id.MbackToHome:
				Intent intent=new Intent(getApplication(), masterActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
				return true;
		    case R.id.MSetting:

				return true;
			case R.id.Mabout:

				return true;
			case R.id.Mexit:
				stopService(new Intent(getApplication(), musicPlayerService.class));
				play.setVisibility(View.VISIBLE);
				pause.setVisibility(View.GONE);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				this.finish();
			    return true;
		}
		return super.onOptionsItemSelected(item);
	}



}

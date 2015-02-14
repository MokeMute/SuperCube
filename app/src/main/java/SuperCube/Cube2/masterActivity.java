package SuperCube.Cube2;

import SuperCube.Cube2.CubeCore2.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class masterActivity extends core
{
	private MenuInflater Min=new MenuInflater(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		Min.inflate(R.menu.main_menu,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.Mmp:
				Intent intent=new Intent(getApplication(),musicActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				startActivity(intent);
				return true;
		    case R.id.MSetting:

				return true;
			case R.id.Mabout:
				Intent iabout=new  Intent(getApplication(),aboutActivity.class);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				startActivity(iabout);
				return true;
			case R.id.Mexit:
				stopService(new Intent(getApplication(),musicPlayerService.class));
				this.finish();
			    return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
}

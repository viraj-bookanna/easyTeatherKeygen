package lk.live.easytather.keygen;

import android.app.*;
import android.os.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			@Override
			public void run(){
				Intent gen = new Intent(getApplicationContext(), genActivity.class);
				startActivity(gen);
				finish();
			}
		}, 3000);
    }
}

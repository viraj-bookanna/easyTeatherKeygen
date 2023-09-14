package lk.live.easytather.keygen;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.util.*;
import android.content.*;

public class genActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button gen = findViewById(R.id.gen);
		gen.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v1){
				EditText imeiIn = findViewById(R.id.imei);
				EditText out = findViewById(R.id.out);
				String imei = imeiIn.getText().toString();
				try{
					String keys =
						Integer.toString(keygen.genkey(imei))+
						"\n"+
						Integer.toString(keygen.genkey(Integer.toString(keygen.genkey(imei))))+
						"\n"+
						Integer.toString(keygen.genkey(imei+Integer.toString(keygen.refine(imei))))+
						"\n"+
						Integer.toString(keygen.genkey(imei.toUpperCase(Locale.US)));
					out.setText(keys);
				}
				catch(Exception e){
					out.setText("oops..\nsomething went wrong!");
					Toast.makeText(getApplicationContext(), "oops..\nsomething went wrong!", Toast.LENGTH_LONG).show();
				}
			}
		});
		Button paste = findViewById(R.id.pasteBtn);
		paste.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v2){
				EditText pasteArea = findViewById(R.id.imei);
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				try {
					CharSequence textToPaste = clipboard.getPrimaryClip().getItemAt(0).getText();
					pasteArea.setText(textToPaste);
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "can't find text in clipboard", Toast.LENGTH_LONG).show();
				}
			}
		});
    }
}

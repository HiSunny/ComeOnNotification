package sunny.example.comeonnotification;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
//import android.graphics.Canvas;
//import android.graphics.PixelFormat;
//import android.graphics.drawable.Drawable;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {


	
	//Bitmap mBitmap = BitmapFactory.decodeStream(getResources()

		//	.openRawResource(R.drawable.qq));
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getResources()在onCreate()里,否则报空指针context为空
		//Resources android.content.Context.getResources()
		Intent intent = new Intent(this,NotificationActivity.class);
		PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		//将qq.jpg转化为Bitmap，使用它设置大图标
		Bitmap mBitmap=BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.qq);
		NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification mNotification = new Notification.Builder(getApplicationContext())
		.setContentTitle("notification")
		.setContentText("content")
		.setSmallIcon(R.drawable.ic_launcher)
		.setLargeIcon(mBitmap)
		.setContentIntent(mPendingIntent)
		.setDefaults(Notification.DEFAULT_ALL)
		.build();
		/*int DEFAULT_ALL Use all default values (where applicable). 
		int DEFAULT_LIGHTS Use the default notification lights. 
		int DEFAULT_SOUND Use the default notification sound. 
		int DEFAULT_VIBRATE Use the default notification vibrate. 
		 */
		/*setLights(int argb, int onMs, int offMs) 
Set the desired color for the indicator LED on the device, as well as the blink duty cycle (specified in milliseconds).
		setSound(Uri sound) 
Set the sound to play.
setVibrate(long[] pattern) 
Set the vibration pattern to use.
long[] vibrates={0,1000,1000,1000} notification到来时震动1s停止1s再震动1s
vibrates[0]:静止时长
vibrates[1]:振动时长
vibrates[2]：静止时长
.... */
		//void android.app.NotificationManager.notify(int id, Notification notification)
		//id： An identifier for this notification unique within your application.
		mNotificationManager.notify(2,mNotification);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*public static Bitmap drawableToBitmap(Drawable drawable) {

		Bitmap bitmap = Bitmap

		.createBitmap(

		drawable.getIntrinsicWidth(),

		drawable.getIntrinsicHeight(),

		drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888

		: Bitmap.Config.RGB_565);

		Canvas canvas = new Canvas(bitmap);

		// canvas.setBitmap(bitmap);

		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),

		drawable.getIntrinsicHeight());

		drawable.draw(canvas);

		return bitmap;

		}*/
}

package com.ese5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	private int x = 100;
	private int y = 100;
	private Bitmap img = null;
	private boolean dragOn = false;
	private String TAG = "ESE";

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		img = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.ic_launcher);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(img, x, y, null);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int eventaction = event.getAction();
		int tx = (int) event.getX();
		int ty = (int) event.getY();

		switch (eventaction) {
		case MotionEvent.ACTION_DOWN:
			Log.d(TAG, "DOWN");
			if (tx > x & tx < x + img.getWidth() & ty > y
					& ty < y + img.getHeight()) {
				Log.d(TAG, "DOWN ---------------------------------------------");
				dragOn = true;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (dragOn == true)
			{
			Log.d(TAG, "MOVE");
			x = tx;
			y = ty;
			invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			Log.d(TAG, "UP");
			dragOn = false;
			break;
		}
		return true;
	}

}

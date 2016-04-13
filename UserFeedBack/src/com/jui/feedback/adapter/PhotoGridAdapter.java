package com.jui.feedback.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.jui.feedback.PhotoActivity;
import com.jui.feedback.R;
import com.jui.feedback.photo.Bimp;
import com.jui.feedback.photo.BitmapCache;
import com.jui.feedback.photo.FileUtil;
import com.jui.feedback.photo.ImageHelper;
import com.jui.feedback.photo.BitmapCache.ImageCallback;
import com.jui.feedback.photo.ImageItem;

public class PhotoGridAdapter extends BaseAdapter
{

    final String TAG = getClass( ).getSimpleName( );
    List< ImageItem > dataList;
    Map< String , String > map = new HashMap< String , String >( );
    BitmapCache cache;
    PhotoActivity mActivity;
    LayoutInflater mInflater;
    ImageCallback callback = new ImageCallback( )
    {
	@Override
	public void imageLoad( ImageView imageView , Bitmap bitmap , Object ...params )
	{
	    if( imageView != null && bitmap != null )
	    {
		String url = (String)params[0];
		if( url != null && url.equals( (String)imageView.getTag( ) ) )
		{
		    ( (ImageView)imageView ).setImageBitmap( bitmap );
		}
		else
		{
		    Log.i( TAG , "callback, bmp not match" );
		}
	    }
	    else
	    {
		Log.i( TAG , "callback, bmp null" );
	    }
	}
    };

    public PhotoGridAdapter( PhotoActivity activity , List< ImageItem > list )
    {
	this.mActivity = activity;
	dataList = list;
	cache = new BitmapCache( );
	mInflater = LayoutInflater.from( mActivity );

    }

    @Override
    public int getCount()
    {
	int count = 0;
	if( dataList != null )
	{
	    count = dataList.size( );
	}
	return count;
    }

    @Override
    public Object getItem( int position )
    {
	return null;
    }

    @Override
    public long getItemId( int position )
    {
	return position;
    }

    class Holder
    {
	private ImageView image;
	private ImageView select;
    }

    @Override
    public View getView( final int position , View convertView , ViewGroup parent )
    {
	final Holder holder;

	if( convertView == null )
	{
	    holder = new Holder( );
	    convertView = mInflater.inflate( R.layout.layout_photo_gridview_item , null );
	    GridView.LayoutParams params = new GridView.LayoutParams( (PhotoActivity.width-PhotoActivity.numColumns) / PhotoActivity.numColumns , (PhotoActivity.width-PhotoActivity.numColumns) / PhotoActivity.numColumns );
	    convertView.setLayoutParams( params );
	    holder.image = (ImageView)convertView.findViewById( R.id.image );
	    holder.select = (ImageView) convertView.findViewById(R.id.isselected);

	    convertView.setTag( holder );
	}
	else
	{
	    holder = (Holder)convertView.getTag( );
	}

	
	if (position<dataList.size()) {
		final ImageItem item = dataList.get( position );

		holder.image.setTag( item.imagePath );
		cache.displayBmp( holder.image , item.imagePath , callback );
	}	

	holder.image.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			boolean flag = false;
			switch (event.getAction()) {
			case MotionEvent.ACTION_UP:
				changeLight((ImageView) v, 0);
				// onclick
				holder.select.setImageResource(R.drawable.icon_select_pressed);		
				doWithImage(position);
				flag = false;
				break;
			case MotionEvent.ACTION_DOWN:
				changeLight((ImageView) v, -80);
				flag = true;
				break;
			case MotionEvent.ACTION_CANCEL:
				changeLight((ImageView) v, 0);
				flag = false;
				break;
			default:
				flag = false;
				break;
			}
			return flag;
		}
	});
	
	return convertView;
    }
	
    private void doWithImage(int position){
    	// Bimp.max<4时可点击，否则不可点击，monkey测试时出现max大于4
		if (Bimp.tmpPaths.size() >= 3 || Bimp.max >= 3) {
			mActivity.finish();
			return;
		}
		final String path = ImageHelper.list.get(position).imagePath;
		if (path!=null) {
			Bimp.tmpPaths.add(path);
			Bimp.max++;
		}
		mActivity.finish();
		new Handler().post(new Runnable() {
			
			@Override
			public void run() {
				Bitmap bm = null;
				try {
					bm = Bimp.revitionImageSize(path);
				} catch (IOException e) {
					Log.i("berrytao", "图片压缩失败");
					bm = null;
					e.printStackTrace();
				}

				if (bm != null) {
					String newStr = path.substring(path.lastIndexOf("/") + 1,
							path.lastIndexOf("."));
					FileUtil.saveBitmap(bm, "" + newStr);

				}
			}
		});
		
		
    }
	private void changeLight(ImageView imageview, int brightness) {
		ColorMatrix matrix = new ColorMatrix();
		matrix.set(new float[] { 1, 0, 0, 0, brightness, 0, 1, 0, 0,
				brightness, 0, 0, 1, 0, brightness, 0, 0, 0, 1, 0 });
		imageview.setColorFilter(new ColorMatrixColorFilter(matrix));

	}
}

package com.jui.feedback.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jui.feedback.PhotoActivity;
import com.jui.feedback.R;
import com.jui.feedback.photo.Bimp;
import com.jui.feedback.photo.FileUtil;
import com.jui.feedback.photo.ItemImageLoad;

public class ItemGridAdapter extends BaseAdapter
{
    private LayoutInflater mInflater;
    private Context mContext;
    ItemImageLoad imageLoad;

    public ItemGridAdapter( Context context )
    {
	mContext = context;
	mInflater = LayoutInflater.from( mContext );
	imageLoad = new ItemImageLoad();
    }

    @Override
    public int getCount()
    {

	//	return Bimp.tmpBitmaps.size( ) + 1;
	return 3;
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

    @Override
    public View getView( final int position , View convertView , ViewGroup parent )
    {
	ViewHolder holder = null;
	if( convertView == null )
	{
	    holder = new ViewHolder( );
	    convertView = mInflater.inflate( R.layout.layout_item_gridview_item , null );
	    holder.img_item = (ImageView)convertView.findViewById( R.id.item_selected_image );
	    holder.img_del = (ImageView)convertView.findViewById( R.id.item_delete_image );
	    convertView.setTag( holder );

	}
	else
	{
	    holder = (ViewHolder)convertView.getTag( );
	}
	
	holder.img_item.setImageBitmap(null);
	holder.img_item.setBackgroundDrawable(null);
	
	if( position >= 3 || Bimp.tmpPaths.size( ) > 3 )
	{
	    holder.img_item.setVisibility( View.GONE );
	    holder.img_del.setVisibility( View.GONE );
	    holder.img_item.setTag("0");
	}
	else if( position > Bimp.tmpPaths.size( ) )
	{
	    holder.img_del.setVisibility( View.INVISIBLE );
	    holder.img_item.setVisibility( View.INVISIBLE );
	    holder.img_item.setTag("0");
	}
	else if( position == Bimp.tmpPaths.size( ) )
	{
	    holder.img_del.setVisibility( View.INVISIBLE );
	    holder.img_item.setBackgroundResource(R.drawable.img_add_style);
	    holder.img_item.setVisibility( View.VISIBLE );
	    holder.img_item.setTag("add");
	    
	}
	else
	{
		holder.img_item.setTag("0");
	    setImageResource( holder.img_item , holder.img_del , position );
	}

	holder.img_item.setOnClickListener( new OnClickListener( )
	{

	    @Override
	    public void onClick( View v )
	    {
	    	System.out.println("item onclick,postion:"+position+",max:"+Bimp.max+",size:"+Bimp.tmpPaths.size());
//		if( position == Bimp.tmpBitmaps.size( ) )
//		{
//		    Intent intent = new Intent( mContext , PhotoActivity.class );
//		    intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
//		    mContext.startActivity( intent );
//		}
		
		String tag = v.getTag().toString();
		if ("add".equals(tag)) {
			Intent intent = new Intent( mContext , PhotoActivity.class );
		    intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
		    mContext.startActivity( intent );
		}

	    }
	} );
	holder.img_del.setOnClickListener( new OnClickListener( )
	{

	    @Override
	    public void onClick( View v )
	    {
		if( position < Bimp.tmpPaths.size( ) )
		{
		    Bimp.max--;
		    String path = Bimp.tmpPaths.get( position );
		    Bimp.tmpPaths.remove( position );
		    String name = path.substring( path.lastIndexOf( "/" ) + 1 , path.lastIndexOf( "." ) );
		    FileUtil.delFile( name );

		    //这里需要提示更新adapter
		    ItemGridAdapter.this.notifyDataSetChanged( );
		}

	    }
	} );
	return convertView;
    }

    static class ViewHolder
    {
	ImageView img_item;
	ImageView img_del;

    }

    public void setImageResource( final ImageView image , final ImageView del , final int position )
    {
    	
    	if( position<Bimp.tmpPaths.size() && Bimp.tmpPaths != null && Bimp.tmpPaths.size( ) > 0 )
	    {
		String path = Bimp.tmpPaths.get( position );
		Bitmap bitmap = imageLoad.getImage(path);
		if( bitmap != null )
		{
		    image.setImageBitmap( bitmap );
		    image.setVisibility( View.VISIBLE );
		    del.setVisibility( View.VISIBLE );
		}
		else
		{
		    image.setVisibility( View.INVISIBLE );
		    del.setVisibility( View.INVISIBLE );
		}
	    }	

    }

}

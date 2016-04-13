package com.jui.feedback.adapter;

import com.jui.feedback.R;
import com.jui.feedback.bean.ItemUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGridAdapter extends BaseAdapter
{
    private Context mContext;
    private LayoutInflater inflater;

    public MainGridAdapter( Context context )
    {
	this.mContext = context;
	this.inflater = LayoutInflater.from( mContext );
    }

    public int getCount()
    {
	return ItemUtil.namesID.length;
    }

    public Object getItem( int index )
    {
	return null;
    }

    public long getItemId( int index )
    {
	return index;
    }

    public View getView( int index , View converView , ViewGroup parent )
    {
	Holder holder = new Holder( );
	if( converView == null )
	{
	    converView = inflater.inflate( R.layout.layout_main_gridview_item , null );
	    holder.imageView = (ImageView)converView.findViewById( R.id.myImage );
	    holder.textView = (TextView)converView.findViewById( R.id.myText );
	    converView.setTag( holder );
	}
	else
	{
	    holder = (Holder)converView.getTag( );
	}

	holder.imageView.setImageResource( ItemUtil.imagesID[index] );
	holder.textView.setText( ItemUtil.namesID[index] );

	return converView;
    }

    static class Holder
    {
	ImageView imageView;
	TextView textView;

    }

}

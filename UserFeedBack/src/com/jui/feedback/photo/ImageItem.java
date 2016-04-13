package com.jui.feedback.photo;

import java.io.Serializable;

/**
 * 一个图片对象
 * 
 * @author berrytao
 * 
 */
public class ImageItem implements Serializable
{
    private static final long serialVersionUID = -3613750090880810573L;
    public String imageId;
    public String imagePath;

    public ImageItem()
    {

    }

    public ImageItem( String imageId , String imagePath )
    {
	super( );
	this.imageId = imageId;
	this.imagePath = imagePath;
    }

}

package com.jui.feedback.net;

public final class ServerUrl
{

    //数据提交服务器地址 内网测试地址http://192.168.1.12/feedback_api/api
    //http://feedback.api.pada.cc/api
    private static final String PUBLIC_URL = "http://feedback.api.pada.cc/api";

    //图片提交服务器地址 内网测试地址http://192.168.1.11/upload/UploadFile.asmx
    //http://upload.cms.pada.cc/UploadFile.asmx
    private static final String IMAGE_URL = "http://upload.cms.pada.cc/UploadFile.asmx";

    public static String getServerUrlCommit()
    {
	return PUBLIC_URL;
    }

    public static String getImageServerUrlCommit()
    {
	return IMAGE_URL;
    }

}

package com.jui.feedback;

import android.app.Fragment;
import android.os.Bundle;

/**
 * 
 * 保存对象的Fragment
 * 负责在转屏时保存“提交信息”这一过程
 * @author berrytao
 *
 */
public class RetainedFragment extends Fragment {
	// data object we want to retain  
    // 保存一个异步的任务  
    private MyAsyncTask data;  
  
    // this method is only called once for this fragment  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        // retain this fragment  
        setRetainInstance(true);  
    }  
  
    public void setData(MyAsyncTask data)  
    {  
        this.data = data;  
    }  
  
    public MyAsyncTask getData()  
    {  
        return data;  
    }  
}

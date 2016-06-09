package com.stdzone.logoreg.Http;

import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

/**
 * Created by vishwesh on 16/3/16.
 */
public class EndPoints {
    public static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    public static AsyncHttpClient syncHttpClient = new SyncHttpClient();

    private static AsyncHttpClient getClient(){
        if (Looper.myLooper()==null)
        {
            return syncHttpClient;
        }
        else
        {
            return asyncHttpClient;
        }
    }


    public static void  getRegisterData (RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        getClient().post(Config.URLREGISTER, requestParams, asyncHttpResponseHandler);
    }
    public static void  getLoginData (RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        getClient().post(Config.URLLOGIN, requestParams, asyncHttpResponseHandler);
    }

}
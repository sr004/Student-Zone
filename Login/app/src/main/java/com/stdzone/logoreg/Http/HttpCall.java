package com.stdzone.logoreg.Http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.stdzone.logoreg.Activities.LoginActivity;
import com.stdzone.logoreg.Activities.SignupActivity;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by vishwesh on 16/3/16.
 */
public class HttpCall {
    int result;

    public int getLoginData(final Context context, String email, String password, final ProgressDialog progressDialog) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", email);
        requestParams.put("password", password);

        EndPoints.getLoginData(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {


                        result = new DataParser().parsegetLoginResponse(context, response, progressDialog);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Toast.makeText(context, "Login failed Please try again ", Toast.LENGTH_LONG).show();

                    }
                }
        );

        return result;
    }


    public void getRegisterData(final Context signupActivity, String name, String email, String password, final ProgressDialog progressDialog) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", name);
        requestParams.put("email", email);
        requestParams.put("password", password);

        EndPoints.getRegisterData(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {


                        result = new DataParser().parsegetRegisterResponse(signupActivity, response, progressDialog);

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Toast.makeText(signupActivity, "Registion failed Please try again ", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

}


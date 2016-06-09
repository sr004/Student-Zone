package com.stdzone.logoreg.Http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.stdzone.logoreg.Activities.LoginActivity;
import com.stdzone.logoreg.Activities.MainActivity;
import com.stdzone.logoreg.Activities.SignupActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by vishwesh on 16/3/16.
 */
public class DataParser {
    ArrayList<String> subList = new ArrayList<>();
    public int parsegetRegisterResponse(Context context, JSONObject jsonObject, ProgressDialog progressDialog) {
        try {
          {
                    JSONArray message = jsonObject.getJSONArray("result");

              progressDialog.dismiss();

              JSONObject temp = message.getJSONObject(0);
              if (temp.getString("success").equals("1"))
              {
                  Toast.makeText(context, "Successfully registred ", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(context, MainActivity.class);
                  ((SignupActivity) context).startActivity(intent);
                  ((SignupActivity) context).finish();

              }else
              {
                  Toast.makeText(context, "Registred failed please try again", Toast.LENGTH_LONG).show();

              }



              return 1;
                }
            } catch (JSONException e1) {
            e1.printStackTrace();
        }



      return -1;
    }


    public int parsegetLoginResponse(Context context, JSONObject jsonObject, ProgressDialog progressDialog) {
        try {
            {
                JSONArray message = jsonObject.getJSONArray("result");

                progressDialog.dismiss();

                JSONObject temp = message.getJSONObject(0);
                if (temp.getString("success").equals("1"))
                {
                    Toast.makeText(context, "Successfully ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, MainActivity.class);
                    ((LoginActivity) context).startActivity(intent);
                    ((LoginActivity) context).finish();
                    return 1;

                }else
                {
                    Toast.makeText(context, "Login failed please try again", Toast.LENGTH_LONG).show();

                }



                return 0;
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }



        return -1;
    }



}

package com.example.dell.mypostmandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    String url="http://nfly.in/api/course";
    String[] courseUrl={"mobile-app-development-using-android",
            "programming-101-in-python",
            "web-development-using-php-and-mysql",
            "object-oriented-programming-in-java"};
    String[] urls={"https://www.thecrazyprogrammer.com/example_data/fruits_array.json","https://simplifiedcoding.net/demos/marvel/","https://simplifiedcoding.net/demos/view-flipper/heroes.php"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn);
        tv=(TextView)findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST,url,new Response.Listener<String>( ){

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
                        tv.setText(response);
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("X-Api-Key", "59671596837f42d974c7e9dcf38d17e8");
                        return headers;
                    }


                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("course", "mobile-app-development-using-android");
                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}

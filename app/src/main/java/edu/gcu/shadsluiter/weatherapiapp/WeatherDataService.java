package edu.gcu.shadsluiter.weatherapiapp;

import android.widget.Toast;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataService {
    //public static final String KEY = "6283b081693dd3abc3e46bd9a3413ee9";

    Context context;
    String cityID;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public String getCityID(String cityName){
        String apiKey = "6283b081693dd3abc3e46bd9a3413ee9";
        String url = "http://api.openweathermap.org/data/2.5/weather?q= " + cityName + "&APPID= " +apiKey;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                cityID = "";

                try {
                    JSONObject jsonObj = response.getJSONObject("weather");
                    cityID = jsonObj.getString("id");
                    Toast.makeText(context, "CityID= " + cityID, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something wrong!", Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

        return cityID;
    }
    /*
    public List<WeatherReportModel>getCityForecastByID(String cityID){

    }

    public List<WeatherReportModel>getCityForecastByName(String cityName){

    }
    */
}

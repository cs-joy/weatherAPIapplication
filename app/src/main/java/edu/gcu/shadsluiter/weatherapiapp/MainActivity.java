package edu.gcu.shadsluiter.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Button btn_CityID, btn_getWeatherID, btn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign values to each control on the layout
        btn_CityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByName = findViewById(R.id.btn_getWeatherByCityName);

        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReports = findViewById(R.id.lv_weatherReports);

        // click listeners for each buttons
        btn_CityID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);

                String cityID = weatherDataService.getCityID(et_dataInput.getText().toString());

                Toast.makeText(MainActivity.this, "Returned an ID of " + cityID, Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "You clicked me! btn_getWeatherID", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "You clicked " + et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
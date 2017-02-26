package iut.paci.noelcommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class DistrictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        GridView grid = (GridView) findViewById(R.id.grid);
        DistrictAdapter adapter = new DistrictAdapter(this,R.layout.item_district, District.getDistricts());

        grid.setAdapter(adapter);
    }


}

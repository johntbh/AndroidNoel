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
        List<District> addresses = new ArrayList<>();
        addresses.add(new District(1,"Louvres","Quartier du Louvres",48.8640832,2.3309799,R.drawable.img_district1));
        addresses.add(new District(2,"Bourse","Quartier du Bourse",48.8640832,2.3309799,R.drawable.img_district2));
        addresses.add(new District(3,"Temple","Quartier du Temple",48.8640832,2.3309799,R.drawable.img_district3));
        DistrictAdapter adapter = new DistrictAdapter(this,R.layout.item_district, addresses);

        grid.setAdapter(adapter);
    }
}

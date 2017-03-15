package iut.paci.noelcommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DistrictActivity extends AppCompatActivity {
    private ArrayList<District> all = District.getDistricts();
    private ArrayList<District> select;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        grid = (GridView) findViewById(R.id.grid);
        DistrictAdapter adapter = new DistrictAdapter(this,R.layout.item_district, District.getDistricts());
        grid.setAdapter(adapter);

        final EditText e = (EditText) findViewById(R.id.adress);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.setText("");
            }
        });

        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                select = new ArrayList<>();

                for(District d:all){
                    if(Pattern.compile(Pattern.quote(s.toString()), Pattern.CASE_INSENSITIVE).matcher(d.name).find()){
                        select.add(d);
                    }
                }

                DistrictAdapter adapter = new DistrictAdapter(DistrictActivity.this,R.layout.item_district, select);
                grid.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}

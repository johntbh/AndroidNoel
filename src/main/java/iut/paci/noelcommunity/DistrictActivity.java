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
        addresses.add(new District(4,"Hôtel-de-Ville","Quartier de l'Hôtel de Ville",48.8640832,2.3309799,R.drawable.img_district4));
        addresses.add(new District(5,"Panthéon","Quartier du Panthéon",48.8640832,2.3309799,R.drawable.img_district5));
        addresses.add(new District(6,"Luxembourg","Quartier du Luxembourg",48.8640832,2.3309799,R.drawable.img_district6));
        addresses.add(new District(7,"Palais-Bourbon","Quartier du Palais-Bourbon",48.8640832,2.3309799,R.drawable.img_district7));
        addresses.add(new District(8,"Élysée","Quartier de l'Élysée",48.8640832,2.3309799,R.drawable.img_district8));
        addresses.add(new District(9,"Opéra","Quartier de l'Opéra",48.8640832,2.3309799,R.drawable.img_district9));
        addresses.add(new District(10,"Entrepôt","Quartier de l'Entrepôt",48.8640832,2.3309799,R.drawable.img_district10));
        addresses.add(new District(11,"Popincourt","Quartier de Popincourt",48.8640832,2.3309799,R.drawable.img_district11));
        addresses.add(new District(12,"Reuilly","Quartier de Reuilly",48.8640832,2.3309799,R.drawable.img_district12));
        addresses.add(new District(13,"Gobelins","Quartier des Gobelins",48.8640832,2.3309799,R.drawable.img_district13));
        addresses.add(new District(14,"Observatoire","Quartier de l'Observatoire",48.8640832,2.3309799,R.drawable.img_district14));
        addresses.add(new District(15,"Vaugirard","Quartier de Vaugirard",48.8640832,2.3309799,R.drawable.img_district15));
        addresses.add(new District(16,"Passy","Quartier de Passy",48.8640832,2.3309799,R.drawable.img_district16));
        addresses.add(new District(17,"Batignolles","Quartier de Batignolles",48.8640832,2.3309799,R.drawable.img_district17));
        addresses.add(new District(18,"Montmartre","Quartier de Montmartre",48.8640832,2.3309799,R.drawable.img_district18));
        addresses.add(new District(19,"Chaumont","Quartier de Chaumont",48.8640832,2.3309799,R.drawable.img_district19));
        addresses.add(new District(20,"Ménilmontant","Quartier de Ménilmontant",48.8640832,2.3309799,R.drawable.img_district20));
        DistrictAdapter adapter = new DistrictAdapter(this,R.layout.item_district, addresses);

        grid.setAdapter(adapter);
    }
}

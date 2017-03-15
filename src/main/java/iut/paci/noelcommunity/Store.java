package iut.paci.noelcommunity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.mapsforge.core.model.LatLong;
import org.w3c.dom.Text;

import java.util.Date;

class Store extends Place {
    int treeCount;

    Store(int id, String name, double latitude, double longitude, Date openingTime, Date closingTime, int treeCount) {
        super(id, name, latitude, longitude, openingTime, closingTime, R.layout.dialog_store, R.drawable.ic_sapin);
        this.treeCount = treeCount;
    }

    void draw(final Context context, final LatLong center){
        final DialogStore ds = new DialogStore(context);
        ds.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ds.show();
        TextView name = (TextView) ds.findViewById(R.id.tvNom);
        name.setText(this.name);
        TextView sapins = (TextView) ds.findViewById(R.id.tvSapins);
        sapins.setText(Integer.toString(treeCount));
        TextView horaires = (TextView) ds.findViewById(R.id.tvHoraires);
        String o_hour;
        String c_hour;
        String o_minute;
        String c_minute;
        if(openingTime.getHours()<10){
            o_hour = "0"+openingTime.getHours();
        }else{
            o_hour = Integer.toString(openingTime.getHours());
        }

        if(closingTime.getHours()<10){
            c_hour = "0"+closingTime.getHours();
        }else{
            c_hour = Integer.toString(closingTime.getHours());
        }

        if(openingTime.getMinutes()<10){
            o_minute = "0"+openingTime.getMinutes();
        }else{
            o_minute = Integer.toString(openingTime.getMinutes());
        }

        if(closingTime.getMinutes()<10){
            c_minute = "0"+closingTime.getMinutes();
        }else{
            c_minute = Integer.toString(closingTime.getMinutes());
        }

        String s_horaires = o_hour+"h"+o_minute+" - "+c_hour+"h"+c_minute;
        horaires.setText(s_horaires);
        Button b = (Button) ds.findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds.dismiss();
                String json = "{locations:[{latLng:{lat:"+center.getLatitude()+",lng:"+center.getLongitude()+"}},{latLng:{lat:"+latitude+",lng:"+longitude+"}}]}";

                String url = "https://www.mapquestapi.com/directions/v2/route?key=deamSBfbxULjOkFvP9dW1QiAKewVYxVg&json="+json+"&outFormat=json";
                Log.d("url",url);
                new DirectionTask((MapActivity) context).execute(url);
            }
        });
    }
}

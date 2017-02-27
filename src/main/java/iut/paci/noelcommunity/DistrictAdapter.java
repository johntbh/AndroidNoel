package iut.paci.noelcommunity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import iut.paci.noelcommunity.District;
import iut.paci.noelcommunity.DistrictActivity;
import iut.paci.noelcommunity.R;

public class DistrictAdapter extends ArrayAdapter<District>
{
    List<District> items;
    int customViewResourceId;

    public DistrictAdapter(Context context, int resource, List<District> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.customViewResourceId = resource;
    }

    @Override
    public View getView(final int position,
                        View convertView,
                        ViewGroup parent)
    {
        View layout = convertView;
        if (convertView == null){
            LayoutInflater inflater =((DistrictActivity)getContext()).getLayoutInflater();
            layout = inflater.inflate(customViewResourceId, parent, false);
        }
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogDistrict d = new DialogDistrict(v.getContext());
                d.show();
                TextView title = (TextView) d.findViewById(R.id.title);
                TextView description = (TextView) d.findViewById(R.id.description);
                Button out = (Button) d.findViewById(R.id.quit);
                out.setOnClickListener(new View.OnClickListener() {
                    @Override 
                    public void onClick(View v) {
                        d.dismiss();
                        Intent intent = new Intent(v.getContext(),MapActivity.class);
                        Bundle extra = new Bundle();
                        extra.putDouble("lat",items.get(position).latitude);
                        extra.putDouble("long",items.get(position).longitude);
                        extra.putInt("district_id",position+1);
                        intent.putExtras(extra);
                        getContext().startActivity(intent);
                    }
                });
                title.setText(items.get(position).name);
                description.setText(items.get(position).description);

            }
        });
        TextView positionTV = (TextView) layout.findViewById(R.id.position);
        positionTV.setText(Integer.toString(items.get(position).id));
        TextView nameTV = (TextView) layout.findViewById(R.id.name);
        nameTV.setText(items.get(position).name);
        ImageView flagIV = (ImageView) layout.findViewById(R.id.picture);
        flagIV.setImageResource(items.get(position).imageRessourceId);
        return layout;

    }


}

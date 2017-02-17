package iut.paci.noelcommunity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
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
    public View getView(int position,
                        View convertView,
                        ViewGroup parent)
    {
        View layout = convertView;
        if (convertView == null){
            LayoutInflater inflater =((DistrictActivity)getContext()).getLayoutInflater();
            layout = inflater.inflate(customViewResourceId, parent, false);
        }
        TextView positionTV = (TextView) layout.findViewById(R.id.position);
        positionTV.setText(Integer.toString(items.get(position).id));
        TextView nameTV = (TextView) layout.findViewById(R.id.name);
        nameTV.setText(items.get(position).name);
        ImageView flagIV = (ImageView) layout.findViewById(R.id.picture);
        flagIV.setImageResource(items.get(position).imageRessourceId);
        return layout;

    }


}

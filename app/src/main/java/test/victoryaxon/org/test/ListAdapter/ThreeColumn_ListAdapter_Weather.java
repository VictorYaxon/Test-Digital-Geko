package test.victoryaxon.org.test.ListAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import test.victoryaxon.org.test.R;
import test.victoryaxon.org.test.Models.Weather;

/**
 * Created by Mitch on 2016-05-06.
 */
public class ThreeColumn_ListAdapter_Weather extends ArrayAdapter<Weather> {
    private LayoutInflater mInflater;
    private ArrayList<Weather> users;
    private int mViewResourceId;
    public ThreeColumn_ListAdapter_Weather(Context context, int textViewResourceId, ArrayList<Weather> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);
        Weather user = users.get(position);
        if (user != null) {
            TextView txtNo = (TextView) convertView.findViewById(R.id.txtNo);
            TextView txtMaxima = (TextView) convertView.findViewById(R.id.txtMaximo);
            TextView txtMinima = (TextView) convertView.findViewById(R.id.txtMinimo);
            TextView txtTotal = (TextView) convertView.findViewById(R.id.textTotal);
            if (txtNo != null) {
                txtNo.setText(String.valueOf(user.getNo()));
            }
            if (txtMaxima != null) {
                txtMaxima.setText((String.valueOf(user.getTemperatura_maxima())));
            }
            if (txtMinima != null) {
                txtMinima.setText((String.valueOf(user.getTemperatura_minima())));
            }
            if (txtTotal != null) {
                txtTotal.setText(String.valueOf(user.getTotal()));
            }
        }
        return convertView;
    }
}
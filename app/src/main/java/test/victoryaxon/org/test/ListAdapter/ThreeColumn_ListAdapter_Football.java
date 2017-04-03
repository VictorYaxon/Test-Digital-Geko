package test.victoryaxon.org.test.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import test.victoryaxon.org.test.Models.Football;
import test.victoryaxon.org.test.R;
/**
 * Created by Mitch on 2016-05-06.
 */
public class ThreeColumn_ListAdapter_Football extends ArrayAdapter<Football> {
    private LayoutInflater mInflater;
    private ArrayList<Football> fbs;
    private int mViewResourceId;
    public ThreeColumn_ListAdapter_Football(Context context, int textViewResourceId, ArrayList<Football> fbs) {
        super(context, textViewResourceId, fbs);
        this.fbs = fbs;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);
        Football fb = fbs.get(position);
        if (fb != null) {
            TextView txtNombre_equipo = (TextView) convertView.findViewById(R.id.txtNombre_equipo);
            TextView txtGoles_contra = (TextView) convertView.findViewById(R.id.txtGoles_contra);
            TextView txtGoles_favor = (TextView) convertView.findViewById(R.id.txtGoles_favor);
            TextView txtTotal = (TextView) convertView.findViewById(R.id.txtTotal);
            if (txtNombre_equipo != null) {
                txtNombre_equipo.setText(String.valueOf(fb.getNombre_equipo()));
            }
            if (txtGoles_contra != null) {
                txtGoles_contra.setText((String.valueOf(fb.getGoles_contra())));
            }
            if (txtGoles_favor != null) {
                txtGoles_favor.setText((String.valueOf(fb.getGoles_favor())));
            }
            if (txtTotal != null) {
                txtTotal.setText(String.valueOf(fb.getDiferencia()));
            }
        }
        return convertView;
    }
}
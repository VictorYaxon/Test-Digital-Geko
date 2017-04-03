package test.victoryaxon.org.test.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import test.victoryaxon.org.test.ListAdapter.ThreeColumn_ListAdapter_Football;
import test.victoryaxon.org.test.Models.Football;
import test.victoryaxon.org.test.R;

import static test.victoryaxon.org.test.R.id.listView;

/**
 * Created by User on 02/04/2017.
 */

public class FootBallContoller extends Activity{
    Hashtable<String,Double> goles_diferencia = new Hashtable<String,Double>();
    private void footBallLeer() {
        String equipo;
        InputStream is = this.getResources().openRawResource(R.raw.football);
        String separador = ",";
        String valor = "";
        Double resultado = 0.0;
        String goles_favor = null;
        String goles_contra = null;
        String equipo_nombre = null;
        List<String> G_favor = new ArrayList<String>();
        ArrayList<Football> football = new ArrayList<Football>();
        List<String> G_contra = new ArrayList<String>();
        List<String> equiponombre = new ArrayList<String>();
        ListView listView;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while((equipo = br.readLine())!=null){
                equipo = equipo.replaceAll("[^A-z^0-9.]"," ").trim();
                Scanner sl = new Scanner(equipo);
                if(equipo.length()>100 ||equipo.length()<11){
                    equipo = equipo.replaceAll(equipo, "").trim();
                }
                if (!equipo.trim().equals("")) {
                    sl.useDelimiter("\\s*"+separador+"\\s*");
                    while (sl.hasNext()) {
                        valor = sl.next();
                        goles_favor = valor.substring(39,43).replaceAll("\\ ","").trim();
                        if(goles_favor.length()>0){
                            G_favor.add(goles_favor);
                        }
                        goles_contra = valor.substring(46,49).replaceAll("\\ ","").trim();
                        if(goles_contra.length()>0){
                            G_contra.add(goles_contra);
                        }
                        equipo_nombre = valor.substring(3,18).replaceAll("\\ ","").trim();
                        if(equipo_nombre.length()>4){
                            equiponombre.add(equipo_nombre);
                        }
                    }
                }
            }
            int contador = 0;
                while (contador < G_favor.size()) {
                    resultado = Double.parseDouble(G_favor.get(contador))-Double.parseDouble(G_contra.get(contador));
                    goles_diferencia.put(equiponombre.get(contador), resultado);
                    football.add(new Football(equiponombre.get(contador),Double.parseDouble(G_favor.get(contador)),Double.parseDouble(G_contra.get(contador)),resultado));
                    contador++;
                }
            }catch(Exception e){
            e.printStackTrace();
        }
        ThreeColumn_ListAdapter_Football adapter = new ThreeColumn_ListAdapter_Football(this,R.layout.list_adapter_view_football,football);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout_football);
        footBallLeer();
    }

    public void btnMaxValue(View v) {
        Object maxKey=null;
        Double maxValue = Double.MIN_VALUE;
        for(Map.Entry<String,Double> entry : goles_diferencia.entrySet()) {
            if(entry.getValue() < maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        Toast.makeText(this, "El equipo con la peor diferencia de goles es: " +maxKey +" con "+maxValue, Toast.LENGTH_SHORT).show();
    }
}

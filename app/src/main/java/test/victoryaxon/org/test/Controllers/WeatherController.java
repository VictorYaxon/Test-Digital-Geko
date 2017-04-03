package test.victoryaxon.org.test.Controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import test.victoryaxon.org.test.Models.Weather;
import test.victoryaxon.org.test.R;
import test.victoryaxon.org.test.ListAdapter.ThreeColumn_ListAdapter_Weather;

/**
 * Created by User on 01/04/2017.
 */

public class WeatherController extends Activity {
    Hashtable<Integer,Double> temperaturasMinimas = new Hashtable<Integer,Double>();
public void weatherLeer(){
    ListView Lista;
    InputStream is = this.getResources().openRawResource(R.raw.weather);
    BufferedReader br = new BufferedReader (new InputStreamReader(is));
    String clima;
    List<String> max = new ArrayList<String>();
    ArrayList<Weather> weather = new ArrayList<Weather>();
    List<String> min = new ArrayList<String>();
    String temperatura_maxima = null;
    String temperatura_minima = null;
    List<Double> listado = new ArrayList<Double>();
    String separador = ",";
    ListView listView;
    String valor = "";
    try
    {
        while((clima = br.readLine())!=null){
            clima = clima.replaceAll("[^0-9/.-]+"," ").trim();
            clima = clima.replaceAll("/"," ").trim();
            Scanner sl = new Scanner(clima);
            if(clima.length()<50){
                clima = clima.replaceAll(clima, "").trim();
            }
            if (!clima.trim().equals("")) {

                sl.useDelimiter("\\s*"+separador+"\\s*");
                while (sl.hasNext()) {
                    valor = sl.next();
                    temperatura_maxima = valor.substring(2,5).replaceAll("\\ ","").trim();
                    max.add(temperatura_maxima);
                    temperatura_minima = valor.substring(5,8).replaceAll("\\ ","").trim();
                    min.add(temperatura_minima);
                }
            }
        }
        Double resultado = 0.0;
        int contador = 0;
        while (contador < max.size()) {
            resultado = Double.parseDouble(max.get(contador))-Double.parseDouble(min.get(contador));
            weather.add(new Weather(contador,Double.parseDouble(min.get(contador)),Double.parseDouble(max.get(contador)),resultado));
            temperaturasMinimas.put(contador, resultado);
            contador++;
        }
        for (Map.Entry<Integer,Double> entry : temperaturasMinimas.entrySet()) {
            listado.add(entry.getValue());
        }

    }catch(Exception e) {
        System.out.println("Error de lectura del fichero");
        e.printStackTrace();
    }
        ThreeColumn_ListAdapter_Weather adapter = new ThreeColumn_ListAdapter_Weather(this,R.layout.list_adapter_view_weathers,weather);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout_weathers);
        weatherLeer();
    }
    public void btnMaxValue(View v) {
        Object maxKey=null;
        Double maxValue = Double.MIN_VALUE;
        for(Map.Entry<Integer,Double> entry : temperaturasMinimas.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        Toast.makeText(this,"Temperatura Minima es " + maxKey +")" + " " + maxValue, Toast.LENGTH_SHORT).show();
    }
}

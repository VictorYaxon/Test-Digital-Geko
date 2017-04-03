package test.victoryaxon.org.test.Models;

/**
 * Created by User on 02/04/2017.
 */

public class Weather {
    int no;
    Double temperatura_minima;
    Double temperatura_maxima;
    Double total;

    public Weather(int no, Double temperatura_minima, Double temperatura_maxima, Double total) {
        this.no = no;
        this.temperatura_minima = temperatura_minima;
        this.temperatura_maxima = temperatura_maxima;
        this.total = total;
    }
    public Weather() {
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Double getTemperatura_minima() {
        return temperatura_minima;
    }

    public void setTemperatura_minima(Double temperatura_minima) {
        this.temperatura_minima = temperatura_minima;
    }

    public Double getTemperatura_maxima() {
        return temperatura_maxima;
    }

    public void setTemperatura_maxima(Double temperatura_maxima) {
        this.temperatura_maxima = temperatura_maxima;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

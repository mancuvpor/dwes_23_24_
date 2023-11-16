package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReservaBean implements Serializable {
    private String fecha_inicio;
    private String fecha_fin;
    private int n_personas;
    private List<String> servicios;

    public ReservaBean() {
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getN_personas() {
        return n_personas;
    }

    public void setN_personas(int n_personas) {
        this.n_personas = n_personas;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "ReservaBean{" +
                "fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", n_personas=" + n_personas +
                ", servicios=" + servicios +
                '}';
    }
}


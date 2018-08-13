package mx.reddam.rdasistente.Models;

/**
 * Created by Rogelio Andrade on 10/08/2018.
 */

public class MovimientosContentModel {
    int id;
    int tipo;
    String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

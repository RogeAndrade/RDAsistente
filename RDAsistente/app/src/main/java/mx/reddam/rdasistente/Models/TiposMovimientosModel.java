package mx.reddam.rdasistente.Models;

import mx.reddam.rdasistente.Enums.EnumTipoMovimiento;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class TiposMovimientosModel {
    int idMovimiento;
    String titulo;
    String fecha;
    String Descripcion;
    String Imagen;
    EnumTipoMovimiento tipoMovimiento;

    public EnumTipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(EnumTipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}

package mx.reddam.rdasistente.Models;

import java.util.List;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class ListaMovimientosModel  extends  ResponseModel{
    List<TiposMovimientosModel> Movimientos;

    public List<TiposMovimientosModel> getMovimientos() {
        return Movimientos;
    }

    public void setMovimientos(List<TiposMovimientosModel> movimientos) {
        Movimientos = movimientos;
    }
}

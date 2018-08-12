package mx.reddam.rdasistente.Negocio.Controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.reddam.rdasistente.Models.MovimientosContent;

/**
 * Created by Rogelio Andrade on 10/08/2018.
 */

public class FinanzasController {
    public static FinanzasController instance = null;

    public static FinanzasController getInstance(){
        Object lock = new Object();
        if(instance==null){
            synchronized (lock){
                if(instance == null){
                    return new FinanzasController();
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public List<MovimientosContent> getContentFinanzas(){
        try{
            List<MovimientosContent> movimientos = new ArrayList<>();
            for(int i = 0; i< 10; i++){
                MovimientosContent movimiento = new MovimientosContent();
                movimiento.setDescripcion("");
                movimiento.setId(i);
                movimiento.setTipo(1);
                movimientos.add(movimiento);
            }
            return movimientos;
        }catch (Exception ex){
            Log.e("FinanazasController", "Error en getContentFinanzas: "+ex.getMessage());
        }
        return null;
    }
}

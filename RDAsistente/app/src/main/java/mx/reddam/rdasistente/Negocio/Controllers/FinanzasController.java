package mx.reddam.rdasistente.Negocio.Controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.reddam.rdasistente.Models.MovimientosContentModel;

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
                    instance = new FinanzasController();
                    return instance;
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public List<MovimientosContentModel> getContentFinanzas(){
        try{
            List<MovimientosContentModel> movimientos = new ArrayList<>();
            for(int i = 0; i< 10; i++){
                MovimientosContentModel movimiento = new MovimientosContentModel();
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

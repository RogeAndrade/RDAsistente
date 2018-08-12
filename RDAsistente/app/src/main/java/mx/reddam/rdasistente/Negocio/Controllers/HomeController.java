package mx.reddam.rdasistente.Negocio.Controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.reddam.rdasistente.Enums.EnumTipoMovimiento;
import mx.reddam.rdasistente.Enums.EnumTipoRespuesta;
import mx.reddam.rdasistente.Models.ListaMovimientosModel;
import mx.reddam.rdasistente.Models.TiposMovimientosModel;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class HomeController {
    public static HomeController instance = null;

    public static HomeController getInstance(){
        Object lock = new Object();
        if(instance==null){
            synchronized (lock){
                if(instance == null){
                    return new HomeController();
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public ListaMovimientosModel fillData(){
        ListaMovimientosModel listaModel = new ListaMovimientosModel();
        try{
            listaModel.setCodigoRespuesta(EnumTipoRespuesta.Correcto);
            listaModel.setMensaje("Datos home");
            List<TiposMovimientosModel> movimientosLista = new ArrayList<>();
            for (int i = 0; i < 10; i++)
            {
                TiposMovimientosModel movimiento = new TiposMovimientosModel();
                movimiento.setIdMovimiento(i);
                movimiento.setTitulo("Titulo ".concat(Integer.toString(i)));
                movimiento.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porttitor, quam ut rutrum fermentum, lorem quam volutpat justo, quis gravida nibh risus at tortor. Sed efficitur justo a tortor dapibus, sed facilisis erat convallis. Aliquam sit amet ultricies urna. Donec pharetra urna sed eros commodo, vitae dapibus metus malesuada.");
                movimiento.setImagen("http://i.imgur.com/DvpvklR.png");
                movimientosLista.add(movimiento);
                if (i < 3)
                    movimiento.setTipoMovimiento(EnumTipoMovimiento.Agenda);
                else if (i < 7)
                    movimiento.setTipoMovimiento(EnumTipoMovimiento.Finanzas);
                else if (i < 10)
                    movimiento.setTipoMovimiento(EnumTipoMovimiento.Tareas);
            }
            listaModel.setMovimientos(movimientosLista);
        }catch (Exception ex){
            Log.e("Error en HomeController", "fillData: "+ex.getMessage());
        }
        return listaModel;
    }
    private HomeController(){}

}

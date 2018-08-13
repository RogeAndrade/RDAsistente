package mx.reddam.rdasistente.Negocio.Controllers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.reddam.rdasistente.Models.MoreActionsModel;
import mx.reddam.rdasistente.R;

/**
 * Created by Rogelio Andrade on 12/08/2018.
 */

public class MainController {
    public static MainController instance = null;

    public static MainController getInstance(){
        Object lock = new Object();
        if(instance==null){
            synchronized (lock){
                if(instance == null){
                    return new MainController();
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public MoreActionsModel getMoreActions(){
        try{
            List<MoreActionsModel> moreActios = new ArrayList<>();
            for(int i=0; i<3; i++){
                MoreActionsModel model = new MoreActionsModel();
                model.setId(i);
                if(i==0) {
                    model.setImage(R.string.menu_free_time);
                }else if(i==1){
                    model.setImage(R.string.menu_free_time);
                }else if(i==2){
                    model.setImage(R.string.menu_free_time);
                }
            }
        }catch (Exception ex){
            Log.e("MainController", "Error en getMoreModel: "+ex.getMessage());
        }
        return null;
    }
}

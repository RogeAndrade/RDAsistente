package mx.reddam.rdasistente.Negocio.Controllers;

import android.support.v7.app.AppCompatActivity;
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
    AppCompatActivity activity;

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    public static MainController getInstance(){
        Object lock = new Object();
        if(instance==null){
            synchronized (lock){
                if(instance == null){
                    instance = new MainController();
                    return instance;
                }else{
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public List<MoreActionsModel> getMoreActions(){
        try{
            List<MoreActionsModel> moreActios = new ArrayList<>();
            for(int i=0; i<3; i++){
                MoreActionsModel model = new MoreActionsModel();
                model.setId(i);
                if(i==0) {
                    model.setImage(R.drawable.ic_icon_free_time);
                    model.setTitle(activity.getResources().getString(R.string.menu_free_time));
                }else if(i==1){
                    model.setImage(R.drawable.ic_icon_accounts);
                    model.setTitle(activity.getResources().getString(R.string.menu_free_accounts));
                }else if(i==2){
                    model.setImage(R.drawable.ic_icon_food);
                    model.setTitle(activity.getResources().getString(R.string.menu_free_food));
                }
                moreActios.add(model);
            }
            return moreActios;
        }catch (Exception ex){
            Log.e("MainController", "Error en getMoreModel: "+ex.getMessage());
        }
        return null;
    }
}

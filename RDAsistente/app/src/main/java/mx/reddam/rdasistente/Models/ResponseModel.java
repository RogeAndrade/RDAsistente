package mx.reddam.rdasistente.Models;

import mx.reddam.rdasistente.Enums.EnumTipoRespuesta;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public class ResponseModel {
    String mensaje;
    EnumTipoRespuesta codigoRespuesta;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public EnumTipoRespuesta getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(EnumTipoRespuesta codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
}

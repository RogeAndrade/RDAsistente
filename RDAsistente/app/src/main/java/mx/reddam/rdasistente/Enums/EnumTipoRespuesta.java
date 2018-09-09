package mx.reddam.rdasistente.Enums;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public enum EnumTipoRespuesta {
    @SerializedName("1")
    Correcto("Correcto", 1),
    @SerializedName("2")
    Error("Error", 2),
    @SerializedName("3")
    Excepcion("Excepcion", 3);

    private String nameTypeResponse;
    private int codeTypeRespose;

    private EnumTipoRespuesta(String nameTypeResponse, int codeTypeRespose){
        this.nameTypeResponse=nameTypeResponse;
        this.codeTypeRespose=codeTypeRespose;
    }

    public int getCodeTypeResponse() {
        return codeTypeRespose;
    }

    public String getNameTypeResponse() {
        return nameTypeResponse;
    }
}

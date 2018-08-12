package mx.reddam.rdasistente.Enums;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public enum EnumTipoRespuesta {
    Correcto("Correcto", 1), Error("Error", 2),
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

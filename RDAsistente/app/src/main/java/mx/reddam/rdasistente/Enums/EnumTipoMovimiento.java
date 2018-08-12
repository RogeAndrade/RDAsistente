package mx.reddam.rdasistente.Enums;

/**
 * Created by Rogelio Andrade on 08/08/2018.
 */

public enum EnumTipoMovimiento {
    Finanzas("Finanzas", 1), Tareas("Tareas", 2),
    Agenda("Agenda", 3);

    private String nameType;
    private int codeType;

    private EnumTipoMovimiento(String nameType, int codeType){
        this.nameType=nameType;
        this.codeType=codeType;
    }

    public int getCodeType() {
        return codeType;
    }

    public String getNameType() {
        return nameType;
    }
}

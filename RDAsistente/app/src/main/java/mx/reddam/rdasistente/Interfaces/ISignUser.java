package mx.reddam.rdasistente.Interfaces;

import mx.reddam.rdasistente.Models.DataUserModelRequest;

/**
 * Created by Rogelio Andrade on 07/09/2018.
 */

public interface ISignUser {
    public void successSign(DataUserModelRequest usuario);
    public void failSign();
}

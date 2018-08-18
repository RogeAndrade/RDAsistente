using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApi.Datas;
using WebApi.Models;

namespace WebApi.Controllers
{
    public class UserController : ApiController
    {
        ConexionUser conexion;
        public SignUserResponseModel Put(DatasUserModelRequest DatosUsuario) {
            SignUserResponseModel ModelRet = new SignUserResponseModel();
            conexion = ConexionUser.Instance;
            try
            {
                return conexion.RegistrarUsuario(DatosUsuario.Nombre, DatosUsuario.Apellidos, DatosUsuario.Telefono, DatosUsuario.Correo, DatosUsuario.Url, DatosUsuario.Usr, DatosUsuario.Pass, DatosUsuario.Facebook, DatosUsuario.Google, DatosUsuario.Mail);
            }
            catch(Exception ex)
            {
                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Excepcion;
                ModelRet.Mensaje = ex.Message;
                ModelRet.idUser = 0;
            }
            return ModelRet;
        }
    }
}

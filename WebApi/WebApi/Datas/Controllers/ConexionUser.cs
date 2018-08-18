using System;
using System.Collections.Generic;
using System.Data.Entity.Core.Objects;
using System.Linq;
using System.Web;
using WebApi.Models;

namespace WebApi.Datas
{
    public class ConexionUser
    {
        public static ConexionUser Instance { get; set; }

        public static ConexionUser GetInstance() {
            object Locked = new object();
            if (Instance == null)
            {
                lock (Locked)
                {
                    if (Instance == null)
                    {
                        Instance = new ConexionUser();
                        return Instance;
                    }
                    else
                    {
                        return Instance;
                    }
                }
            }
            else
            {
                return Instance;
            }
        }

        public SignUserResponseModel RegistrarUsuario(string Nombre, string Apellidos, string Telefono, string Correo, string Url, string Usr, string Pass, string Facebook, string Google, string Mail)
        {
            SignUserResponseModel ModelRet = new SignUserResponseModel();
            var ret = new ObjectParameter("ret", typeof(string));
            try
            {
                using (var Context = new Datas.Models.asistenteEntities()) {
                    var IdAsistente = Context.sp_register_user(Nombre, Apellidos, Telefono, Correo, Url, Usr, Pass, Facebook, Google, Mail, ret);
                    if (IdAsistente > 0)
                    {
                        ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Correcto;
                        ModelRet.Mensaje = "Usuario registrado";
                        ModelRet.idUser = IdAsistente;
                    }
                    else
                    {
                        switch (IdAsistente)
                        {
                            case -1:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta a la persona verifica los datos";
                                ModelRet.idUser = IdAsistente;
                                break;
                            case -2:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta al usuario verifica los datos";
                                ModelRet.idUser = IdAsistente;
                                break;
                            case -3:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta al usuario verifica los datos";
                                ModelRet.idUser = IdAsistente;
                                break;
                            case -4:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "El usuario ya existe intente con otro por favor";
                                ModelRet.idUser = IdAsistente;
                                break;
                            case -5:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "El correo ya está registrado, intente con otro";
                                ModelRet.idUser = IdAsistente;
                                break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Excepcion;
                ModelRet.Mensaje = ex.Message;
                ModelRet.idUser = 0;
            }
            return ModelRet;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Data.Entity.Core.Objects;
using System.Linq;
using System.Web;
using WebApi.Datas.Controllers;
using WebApi.Models;

namespace WebApi.Datas
{
    public class ConexionUser
    {
        public static ConexionUser Instance { get; set; }
        ConexionBitacora bitacora;

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

        private ConexionUser() { }

        public SignUserResponseModel RegistrarUsuario(string Nombre, string Apellidos, string Telefono, string Correo, string Url, string Usr, string Pass, string Facebook, string Google, string Mail)
        {
            SignUserResponseModel ModelRet = new SignUserResponseModel();
            bitacora = ConexionBitacora.GetInstance();
            var ret = new ObjectParameter("ret", typeof(int));
            try
            {
                using (var Context = new Datas.Models.asistenteEntities()) {
                    Context.Database.Connection.Open();
                    Context.sp_register_user(Nombre, Apellidos, Telefono, Correo, Url, Usr, Pass, Facebook, Google, Mail, ret);
                    if ((int)ret.Value > 0)
                    {
                        ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Correcto;
                        ModelRet.Mensaje = "Usuario registrado";
                        ModelRet.idUser = (int)ret.Value;
                        bitacora.GuardarBitacora(ModelRet.Mensaje, ModelRet.idUser);
                    }
                    else
                    {
                        switch ((int)ret.Value)
                        {
                            case -1:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta a la persona verifica los datos";
                                ModelRet.idUser = (int)ret.Value;
                                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
                                break;
                            case -2:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta al usuario verifica los datos";
                                ModelRet.idUser = (int)ret.Value;
                                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
                                break;
                            case -3:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido dar de alta al usuario verifica los datos";
                                ModelRet.idUser = (int)ret.Value;
                                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
                                break;
                            case -4:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "El usuario ya existe intente con otro por favor";
                                ModelRet.idUser = (int)ret.Value;
                                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
                                break;
                            case -5:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "El correo ya está registrado, intente con otro";
                                ModelRet.idUser = (int)ret.Value;
                                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
                                break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Excepcion;
                ModelRet.Mensaje = ex.InnerException.ToString();
                ModelRet.idUser = 0;
                bitacora.GuardarBitacora(ModelRet.Mensaje, 1);
            }
            return ModelRet;
        }
    }
}
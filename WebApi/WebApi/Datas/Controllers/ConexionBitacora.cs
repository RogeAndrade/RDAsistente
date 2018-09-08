using System;
using System.Collections.Generic;
using System.Data.Entity.Core.Objects;
using System.Linq;
using System.Web;
using WebApi.Models;

namespace WebApi.Datas.Controllers
{
    public class ConexionBitacora
    {
        private static ConexionBitacora Instance { get; set; }

        private ConexionBitacora() { }

        public static ConexionBitacora GetInstance()
        {
            object Locked = new object();
            if (Instance == null)
            {
                lock (Locked)
                {
                    if (Instance == null)
                    {
                        Instance = new ConexionBitacora();
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
        public ResponseModel GuardarBitacora(string Mensaje, int IdUsuario)
        {
            ResponseModel ModelRet = new ResponseModel();
            var ret = new ObjectParameter("ret", typeof(int));
            try
            {
                using (var Context = new Datas.Models.asistenteEntities())
                {
                    Context.Database.Connection.Open();
                    Context.sp_register_bitacora(Mensaje, IdUsuario, ret);
                    if ((int)ret.Value > 0)
                    {
                        ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Correcto;
                        ModelRet.Mensaje = "Usuario registrado";
                    }
                    else
                    {
                        switch ((int)ret.Value)
                        {
                            case -1:
                                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                                ModelRet.Mensaje = "No se ha podido guardar en la bitacora";
                                break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ModelRet.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Excepcion;
                ModelRet.Mensaje = ex.InnerException.ToString();
            }
            return ModelRet;
        }
    }
}
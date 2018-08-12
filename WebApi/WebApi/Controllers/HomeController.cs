using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;
using WebApi.Enums;
using WebApi.Models;

namespace WebApi.Controllers
{
    public class HomeController : ApiController
    {
        // GET: Home
        public ListaMovimientosResponseModel GetListaMovimientosResponseModel(int id)
        {
            ListaMovimientosResponseModel respuestaDto = new ListaMovimientosResponseModel();
            try
            {
                if (id == 1)
                {
                    respuestaDto.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Correcto;
                    respuestaDto.Mensaje = "Datos home";
                    respuestaDto.Movimientos = new List<TipoMovimientosResponseModel>();
                    for (int i = 0; i < 10; i++)
                    {
                        TipoMovimientosResponseModel movimiento = new TipoMovimientosResponseModel();
                        movimiento.IdMovimiento = i;
                        movimiento.Titulo = "Titulo " + i;
                        movimiento.Descripcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porttitor, quam ut rutrum fermentum, lorem quam volutpat justo, quis gravida nibh risus at tortor. Sed efficitur justo a tortor dapibus, sed facilisis erat convallis. Aliquam sit amet ultricies urna. Donec pharetra urna sed eros commodo, vitae dapibus metus malesuada.";
                        movimiento.Imagen = "http://icons.iconarchive.com/icons/igh0zt/ios7-style-metro-ui/128/MetroUI-Other-Task-icon.png";
                        respuestaDto.Movimientos.Add(movimiento);
                        if (i < 3)
                            movimiento.TipoMovimiento = Enumerados.TipoMovimientoEnum.Agenda;
                        else if (i < 7)
                            movimiento.TipoMovimiento = Enumerados.TipoMovimientoEnum.Finanzas;
                        else if (i < 10)
                            movimiento.TipoMovimiento = Enumerados.TipoMovimientoEnum.Tareas;
                    }
                }
                else
                {
                    respuestaDto.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Error;
                    respuestaDto.Mensaje = "Número inválido";
                }
            }
            catch (Exception ex)
            {
                respuestaDto.CodigoRespuesta = Enums.Enumerados.TipoRespuestaEnum.Excepcion;
                respuestaDto.Mensaje = ex.Message;
            }
            return respuestaDto;
        }
    }
}
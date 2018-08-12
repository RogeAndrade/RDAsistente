using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApi.Models
{
    public class ListaMovimientosResponseModel : ResponseModel
    {
        public List<TipoMovimientosResponseModel> Movimientos { get; set; }
    }
}
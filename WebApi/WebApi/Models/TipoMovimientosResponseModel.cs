using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebApi.Enums;

namespace WebApi.Models
{
    public class TipoMovimientosResponseModel
    {
        public int IdMovimiento { get; set; }

        public string Titulo { get; set; }

        public string Fecha { get; set; }

        public string Descripcion { get; set; }

        public string Imagen { get; set; } 

        public Enumerados.TipoMovimientoEnum TipoMovimiento { get; set; }
    }
}
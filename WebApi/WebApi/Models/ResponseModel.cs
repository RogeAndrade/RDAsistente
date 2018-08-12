using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using WebApi.Enums;

namespace WebApi.Models
{
    public class ResponseModel
    {
        public string Mensaje { get; set; }
        public Enumerados.TipoRespuestaEnum CodigoRespuesta { get; set; }
    }
}
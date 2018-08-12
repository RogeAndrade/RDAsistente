using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApi.Enums
{
    public class Enumerados
    {
        public enum TipoMovimientoEnum:sbyte
        {
            Finanzas = 1,
            Tareas = 2,
            Agenda = 3
        }

        public enum TipoRespuestaEnum:sbyte
        {
            Correcto = 1,
            Error = 2,
            Excepcion = 3
        }
    }
}
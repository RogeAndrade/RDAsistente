using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApi.Models
{
    public class DatasUserModelRequest
    {
        public string Nombre { set; get;  }
        public string Apellidos { set; get; }
        public string Telefono { set; get; }
        public string Correo { set; get; }
        public string Url { set; get; }
        public string Usr { set; get; }
        public string Pass { set; get; }
        public string Facebook { set; get; }
        public string Google { set; get; }
        public string Mail { set; get; }
    }
}
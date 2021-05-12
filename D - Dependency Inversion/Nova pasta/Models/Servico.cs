using System.ComponentModel.DataAnnotations;

namespace teste1.Models
{
    public class Servico
    {

        [Key]
        public int id {get; set;}

        public string nome {get; set;}

        public string demanda {get; set;}


        
        
    }
}
using System.ComponentModel.DataAnnotations;

namespace teste1.Models
{
    public class produto
    {
        
        [Key]
        public int id {get; set;}

        [Required(ErrorMessage = "")]
        public string nome {get;set;}

        public string preco {get; set;}


        






    }
}
using System.ComponentModel.DataAnnotations;

namespace teste1.Models
{
    public class usuario
    {
        
        [Key]
        public int id {get; set;}

        [Required(ErrorMessage = "")]
        public string nome {get;set;}

        public string email {get; set;}






    }
}
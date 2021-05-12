using System.Collections.Generic;
using System.Threading.Tasks;
using teste1.Models;

namespace teste1.Service.Interface
{
    public interface IServicoCurso
    {

         Task<List<Curso>> lista();

         Task<Curso> BuscaId();

         void Update();

         void Remove();
         

         //Void porque no service a função não vai retornar nada (apenas no controller)


        
    }
}
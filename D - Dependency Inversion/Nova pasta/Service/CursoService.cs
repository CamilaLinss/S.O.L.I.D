using System.Collections.Generic;
using System.Threading.Tasks;
using teste1.Data;
using teste1.Service.Interface;
using teste1.Models;
using Microsoft.EntityFrameworkCore;

namespace teste1.Service
{
    public class CursoService : IServicoCurso
    {

        private readonly DataContext _context;


        public CursoService (DataContext context){

            _context = context;

        }






        public async Task<Curso> BuscaId() 
        {
       
                return null;

        }


        //LISTA
        public async Task<List<Curso>> lista()
        {
                var cursos = await _context.Curso.ToListAsync();

                return cursos;

        }


        public void Remove()
        {
            throw new System.NotImplementedException();
        }

        public void Update()
        {
            throw new System.NotImplementedException();
        }


        


    } 













        
    
}
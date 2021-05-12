using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using teste1.Data;
using teste1.Models;

namespace teste1.Service
{



    public class ServicoService
    {

        //INJETANDO BANCO CONTEXTO
        private readonly DataContext _context;

        public ServicoService (DataContext context){

            _context = context;

        }



        //LISTA
        public async Task<List<Servico>> lista (){

            var servicos = await _context.Servico.ToListAsync();


                return servicos;

            
        }









        




    }
}
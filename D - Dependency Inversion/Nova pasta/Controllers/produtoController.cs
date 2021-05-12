using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using teste1.Data;


using teste1.Models;



namespace teste1.Controllers
{

    
    [ApiController]
    [Route("v1/produtos")]
    public class produtoController : ControllerBase
    {


        //INJEÇÃO // INJETO O DATACONTEXT ASSIM NÃO PRECISANDO COLOCAR FROMSERVICE EM TODOS OS METODOS
        private readonly DataContext _context;
    
    public produtoController (DataContext context){

        _context = context;

    }
    //--------------------



          //GET 
        [HttpGet]
        [Route("")]

                public async Task<ActionResult<List<produto>>> lista() {


            var produtos = await _context.produto.ToListAsync();


         return Ok(produtos);
            
        }






        //POST 
        [HttpPost]
        [Route("")]
        public async Task<ActionResult<produto>> cadastrar([FromBody] produto model){


            if (!ModelState.IsValid){

                return BadRequest(ModelState);

            }

           
            _context.produto.Add(model);

            await _context.SaveChangesAsync();

            return Ok(model);


        }








        
    }
}
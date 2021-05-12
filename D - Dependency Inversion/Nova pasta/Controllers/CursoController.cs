using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using teste1.Models;
using teste1.Service.Interface;

namespace teste1.Controllers
{

    [ApiController]
    [Route("v1/cursos")]
    public class CursoController : ControllerBase
    {

        private readonly IServicoCurso _servico;


    public CursoController (IServicoCurso servico){

        _servico = servico;

    }



    [HttpGet]
    public async Task<ActionResult<List<Curso>>> lista (){


        var cursos = await _servico.lista();

        return Ok(cursos);




    }




    public void delete(int num){



    }


     public void testedev(){


        
    }











        
    }
}
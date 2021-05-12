using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using teste1.Models;
using teste1.Service;

namespace teste1.Controllers
{

    //AQUI VOU TENTAR IMPLEMENTA OS SERVICES

    [ApiController]
    [Route("v1/servicos")]
    public class ServicoController : ControllerBase
    {


        private readonly ServicoService _servicoService;

        public ServicoController (ServicoService servicoService){

            _servicoService = servicoService;

        }



        [HttpGet]
        public async Task<ActionResult<List<Servico>>> lista (){


           var servicos =  await _servicoService.lista();

            return Ok(servicos);
            
        }
        




        
    }


}
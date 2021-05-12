using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using teste1.Data;
using teste1.Models;

namespace teste1.Controllers
{


    [ApiController]
    [Route("v1/usuarios")]
    public class usuariosController : ControllerBase
    {



        //GET 
        [HttpGet]
        [Route("")]

         // Aqui estamos fazendo uma chamada direta com o contexto de dados, sem incluir as camadas de IOC

        //Task de forma assincrona(chamadas) - Vai retornar uma lista - From(a partir de) services é para buscar um service do startup, no caso aquele banco em memoria - Referencia ao contexto de dados que vai trazer as informações
        public async Task<ActionResult<List<usuario>>> lista([FromServices] DataContext context) {


            //Quando o metodo é async então preciso do await para indicar que ele vai esperar algo(a resposta do banco por exemplo) para iniciar o proximo tratamento
            var usuarios = await context.usuario.ToListAsync();

         return Ok(usuarios);
            
        }




        //GET ID
        [HttpGet]
        //Aqui estou falando que vai ter uma variavel na rota e DEFINO que ele so aceite int, caso contrario vai dar 404
        [Route("{id:int}")]
        public async Task<ActionResult<usuario>> buscaId ([FromServices] DataContext context, int id){

           
            //
            var usuarioResult = await context.usuario
            .AsNoTracking()   // Pesquise melhor sobre
            .FirstOrDefaultAsync(x => x.id == id);      
                                //Nesses id o primeiro faz referenecia ao campo, o outro a variavel da rota

                return Ok(usuarioResult);




                //PARA CHAVE ESTRANGEIRA
                //O include é quando queremos retornar na resposta o atributo da classe estrangeira junto com a resposta
                //produto - Seria o nome da classe estrangeira
           // var usuario = await context.usuario.Include(x => x.produto).FirstOrDefaultAsync(x => x.Id == id);

        //First seria para buscar o id do produto
         //Temos também context.FindAsync

        }



        //POST 
        [HttpPost]
        [Route("")]
            //Observe que utilizo de novo o from, dessa vez um frombody 
            //pois indico que vou receber um corpo do tipo usuario
        public async Task<ActionResult<usuario>> cadastrar([FromServices] DataContext context, [FromBody] usuario model){



            //É PRECISO FAZER VALIDAÇÃO DO MODELSTATE, SIGA COMO NO OUTRO PROJETO
            if (!ModelState.IsValid){

                return BadRequest(ModelState);

            }

            //Aqui vamos adicionar a instancia, o corpo recebido e colocado na variavel model
            context.usuario.Add(model);

            //Com a linha anterior criamos instancia mas ainda não persistimos esses dados, fazemos isso coma linha a seguir
            await context.SaveChangesAsync();

            return Ok(model);


        }



        //GET WHERE
     //   [HttpGet]
      //  [Route("{id}")]
      //  public async Task<ActionResult<List<usuario>>> buscaPor([FromServices] DataContext context, int id){

           //     var usuarios = await context.usuario.ToListAsync();

         //   return null;

        //}











        
    }
}
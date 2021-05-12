using Microsoft.EntityFrameworkCore;
using teste1.Models;

namespace teste1.Data
{
    public class DataContext : DbContext
    {

        public DataContext(DbContextOptions<DataContext> options)
            :base (options)
            {
                    //COM MYSQL COLOCARIAMOS STRING DE CONEXÃO AQUI
            
            }
        

    //Preciso setar isso para dizer ao contexto as tabelas que ele tem que mapear
    public DbSet<usuario> usuario {get; set;}
    public DbSet<produto> produto {get; set;}
    public DbSet<Servico> Servico {get; set;}
    public DbSet<Curso> Curso {get; set;}


    //PARA FINALIZAR PRECISAMOS IR NO STARTUP PARA QUE ELE CONSIDERE ESSA CLASSE








    }
}
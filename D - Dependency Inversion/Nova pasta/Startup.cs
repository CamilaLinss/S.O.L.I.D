using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.OpenApi.Models;
using teste1.Data;
using teste1.Service;
using teste1.Service.Interface;

namespace teste1
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {

            //ADICIONAR CONTEXTO DE DATA
            services.AddDbContext<DataContext> (opt => opt.UseInMemoryDatabase("BANCOTESTE1"));

            //AddScoped - Gestão de dependencias do dotnet
            //Essa linha vai permitir que sempre que precisar o dotnet consiga criar uma copia em memoria desse banco assim a cada
            //consulta ele pega o da memoria e não rpecisa criar uma conexão nova, depois de concluida é destruida na memoria
            services.AddScoped<DataContext, DataContext> ();

            //Ao implementar uma IOC(Services) precisamos adicionar ao escopo, assim o dotnet consegue acessar e definir que ele faz parte do contexto criado
            services.AddScoped<ServicoService, ServicoService> ();
                //Se eu tenho um servico com interface, então devo citar ela também no scopo
             services.AddScoped<IServicoCurso, CursoService> ();


            //USE MVC não é mais utilizado, foi substituido por esse controller
            services.AddControllers();


            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo { Title = "teste1", Version = "v1" });
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "teste1 v1"));
            }

            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}

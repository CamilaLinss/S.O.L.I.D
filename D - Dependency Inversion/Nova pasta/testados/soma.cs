using Xunit;

namespace teste1.testados
{
    public class soma
    {

            [Theory]
            [InlineData(2,2)]
            public int somar(int num1, int num2){

            var resultado = num1 + num2;

            return resultado;


        }





        
    }
}
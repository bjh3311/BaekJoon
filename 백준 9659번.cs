using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_9659번
{
    class Program
    {
        static void Main(string[] args)
        {
            ulong N = ulong.Parse(Console.ReadLine());
            /* 1 이면 상근 
             * 2이면 찬영 
             * 3이면 상근
             * 4이면 찬영 
             * 5이면 상근
             * 6이면 찬영
            */
            //걍 홀수면 상근 짝수면 찬영이다.
            if(N%2==0)
            {
                Console.WriteLine("CY");
            }
            else
            {
                Console.WriteLine("SK");
            }
        }
    }
}

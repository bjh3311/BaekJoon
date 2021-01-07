using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2292번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int data = 7;
            int i;
           if(N==1)
            {
                Console.WriteLine(1);
            }
           else
            {
                for(i=2;data<N;i++)
                {
                    data = data + (6 * i);
                }
                Console.WriteLine(i);             
            }

        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1065번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int count = 0;
            if(100<=N && N<110)
            {
                Console.WriteLine(99);
            }
            else if(N<100)
            {
                Console.WriteLine(N);
            }
            else
            {
                for (int i = 111; i <= N; i++)
                {
                    int a = i / 100;
                    int b = (i / 10) % 10;
                    int c = i % 10;
                    int d = b - a;
                    if(c==(a+2*d))
                    {
                        count++;
                    }
                        }
                Console.WriteLine(count + 99);
            }
           
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_9461번
{
    class Program
    {
        static void Main(string[] args)
        {
            pado[1] = 1;
            pado[2] = 1;
            pado[3] = 1;
            pado[4] = 2;
            pado[5] = 2;
            pado[6] = 3;
            pado[7] = 4;
            pado[8] = 5;
            pado[9] = 7;
            pado[10] = 9;
            int T = int.Parse(Console.ReadLine());
            for(int i=0;i<T;i++)
            {
                int N = int.Parse(Console.ReadLine());
                if(N<6)
                {
                    Console.WriteLine(pado[N]);
                }
                else
                {
                    ulong a = Ban(N);
                    Console.WriteLine(a);
                }
            }
        }
        public static ulong[] pado = new ulong[101];
        public static ulong Ban(int N)
        {
              if(pado[N]==0)
              {
                pado[N] = Ban(N - 1) + Ban(N - 5);
              }
            return pado[N];
        }
    }
    
}

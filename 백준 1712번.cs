using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1712번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int A = int.Parse(s[0]);
            int B = int.Parse(s[1]);
            int C = int.Parse(s[2]);
            int i;
            if(B>=C)
            {
                Console.WriteLine(-1);
                goto Exit;

            }
            int x = A / (C - B);
            Console.WriteLine(x + 1);
            Exit:
            {

            }
        }
    }
}

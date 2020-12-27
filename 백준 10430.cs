using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_10430번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int A = int.Parse(s[0]);
            int B = int.Parse(s[1]);
            int C = int.Parse(s[2]);
            Console.WriteLine("{0}",(A+B)%C);
            Console.WriteLine("{0}", ((A % C) + (B % C)) % C);
            Console.WriteLine("{0}", (A*B) % C);
            Console.WriteLine("{0}", ((A % C)* (B % C)) % C);


        }
    }
}

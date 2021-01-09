using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_11718번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            ulong A = ulong.Parse(s[0]);
            ulong B = ulong.Parse(s[1]);
            StringBuilder res = new StringBuilder(); 
            if (A < B)
            {
                Console.WriteLine(B - A - 1);
                for (ulong i = A+1; i < B; i++)
                {

                    res.Append(i);
                    res.Append(" ");
                }
                Console.Write(res.ToString());
            }
            else if (A > B)
            {
                Console.WriteLine(A - B - 1);
                for (ulong i = B+1; i < A; i++)
                {

                    res.Append(i);
                    res.Append(" ");
                }
                Console.Write(res.ToString());
            }
            else
            {
                Console.WriteLine(0);
            }


        }
    }
}
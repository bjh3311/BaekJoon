using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2908번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int A = int.Parse(s[0]);
            int B = int.Parse(s[1]);
            int A_1 = A % 10;
            int A_2 = (A / 10) % 10;
            int A_3 = A / 100;
            int B_1 = B % 10;
            int B_2 = (B / 10) % 10;
            int B_3 = B / 100;
            int renewal_A = (A_1)*100+(A_2)*10+A_3;
            int renewal_B = (B_1) * 100 + (B_2) * 10 + B_3;
            if(renewal_A>renewal_B)
            {
                Console.Write("{0}", renewal_A);
            }
            else
            {
                Console.Write("{0}", renewal_B);
            }
        } 
    }
}

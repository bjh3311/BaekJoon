using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_11050번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int N = int.Parse(s[0]);
            int K = int.Parse(s[1]);
            int result = 1;
            for(int i=N;i>N-K;i--)
            {
                result *= i;
            }
            for(int i=K;i>0;i--)
            {
                result /= i;
            }
            Console.Write(result);
        }
    }
}

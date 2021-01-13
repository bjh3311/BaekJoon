using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_11051번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int N = int.Parse(s[0]);
            int K = int.Parse(s[1]);
            arr[1, 0] = 1;
            arr[1, 1] = 1;
            Console.WriteLine(Pas(N, K));  
        }
        public static int[,] arr = new int[1001, 1001];
        
        private static int Pas(int n,int k)
        {
            if (n == k || k == 0)
            {
                arr[n, k] = 1;
            }
            else
            {
                if (arr[n, k] == 0)
                {
                    arr[n, k]= (Pas(n - 1, k) + Pas(n - 1, k - 1))%10007;
                }
            }
            return arr[n, k];
        }
        

    }
}

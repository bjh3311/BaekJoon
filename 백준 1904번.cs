using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1904번
{
    class Program
    {
        static void Main(string[] args)
        {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            int N = int.Parse(Console.ReadLine());
            int a = Fib(N);
            Console.WriteLine(arr[N]);
            Console.WriteLine(832040 % 15746);
            
        }
        public static int[] arr = new int[1000001];
        private static int Fib(int n)
        {
            if(n==0||n==1)
            {
                return n;
            }
            else
            {
                if (arr[n] == 0)
                {
                    arr[n] = (Fib(n - 1) + Fib(n - 2))%15746;
                }
            }
            return arr[n];
        }
    }
}

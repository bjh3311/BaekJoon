using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1037번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = new int[N];
            string[] s = Console.ReadLine().Split();
            for(int i=0;i<N;i++)
            {
                arr[i] = int.Parse(s[i]);
            }
            int a = 1;
            Array.Sort(arr);
            Console.WriteLine(arr[0] * arr[N - 1]);
        }
    }
}

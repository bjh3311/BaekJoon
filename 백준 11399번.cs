using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_11399번
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
            Array.Sort(arr);
            int[] sum_arr = new int[N];
            sum_arr[0] = arr[0];
            for(int i=1;i<N;i++)
            {
                sum_arr[i] = sum_arr[i - 1] + arr[i];
            }
            int sum = 0;
            for(int i=0;i<N;i++)
            {
                sum += sum_arr[i];
            }
            Console.WriteLine(sum);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1546번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N;
            N = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            double[] arr = new double[N];
            for(int i=0;i<N;i++)
            {
                arr[i] =double.Parse(s[i]);
            }
            Array.Sort(arr);
            for(int i=0;i<N;i++)
            {
                arr[i] = (arr[i] *100) /70;
            }
            double sum = 0;
            for(int i=0;i<N;i++)
            {
                sum += arr[i];
            }
            Console.WriteLine(sum / N);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2751번
{
    public class Program
    {
        public static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = new int[N];
            StringBuilder sr = new StringBuilder();
            for (int i = 0; i < N; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            Array.Sort(arr);
            for (int i = 0; i < N; i++)
            {
                sr.Append(arr[i]);
                sr.Append("\n");
            }
            Console.Write(sr.ToString());
        }
    }
}

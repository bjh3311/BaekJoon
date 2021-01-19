using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_9095번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for(int i=4;i<12;i++)
            {
                arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            }
            for(int i=0;i<T;i++)
            {
                int a = int.Parse(Console.ReadLine());
                Console.WriteLine(arr[a]);
            }
        }
        public static int[] arr = new int[12];
        
    }
}

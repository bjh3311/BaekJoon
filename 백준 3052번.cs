using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_3052번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[10];
            int count = 0;
            for(int i=0;i<10;i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            for (int i = 0; i < 10; i++)
            {
                arr[i] = arr[i] % 42;
            }
            Array.Sort(arr);
            for (int i = 0; i < 9; i++)
            {
                if(arr[i]!=arr[i+1])
                {
                    count++;
                }
            }
            Console.WriteLine(count+1);

        }
    }
}

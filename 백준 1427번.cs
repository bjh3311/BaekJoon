using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1427번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = new int[10];
            int count = 0;
            while(true)
            {
                if (N > 0)
                {
                    arr[count] = N % 10;
                    N = N / 10;
                    count++;
                }
                else
                {
                    break;
                }
            }
            Array.Sort(arr);
            Array.Reverse(arr); ;
            for(int i=0;i<count;i++)
            {
                Console.Write("{0}", arr[i]);
            }

        }
    }
}

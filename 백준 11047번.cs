using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_11047번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int N = int.Parse(s[0]);
            int K = int.Parse(s[1]);
            int[] arr = new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            int count = 0;
            int index = N;
            while (true)
            {
                if(arr[index-1]<K)
                {
                    K = K - arr[index - 1];
                    count++;
                }
                else if(arr[index-1]==K)
                {
                    count++;
                    break;
                }
                else
                {
                    index = index - 1;
                }
            }
            Console.WriteLine(count);
        }
    }
}

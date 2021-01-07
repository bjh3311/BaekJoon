using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2775번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T_case = int.Parse(Console.ReadLine());
            int k;
            int n;
            int[] arr = new int[T_case];
            for(int i=0;i<T_case;i++)
            {
                k = int.Parse(Console.ReadLine());
                n = int.Parse(Console.ReadLine());
                int[,] house = new int[k+1, n];
                for(int j=0;j<n;j++)
                {
                    house[0, j] = j+1;//0호는 1호라고 친다.
                }
                for(int f=1;f<=k;f++)
                {
                    for(int j=0;j<n;j++)
                    {
                        for(int l=0;l<=j;l++)
                        {
                            house[f, j] += house[f - 1, l];
                        }
                    }
                }
                Console.WriteLine(house[k, n-1]);
            }
        }
    }
}

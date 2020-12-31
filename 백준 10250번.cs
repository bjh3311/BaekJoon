using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_10250번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            int[] arr = new int[T];
            for(int i=0;i<T;i++)
            {
                int count = 0;
                string[] s = Console.ReadLine().Split();
                int H, W, N;
                H = int.Parse(s[0]);
                W = int.Parse(s[1]);
                N = int.Parse(s[2]);
               int[,] hotel = new int[W, H];
               for(int j=0;j<W;j++)
                {
                    for(int k=0;k<H;k++)
                    {
                        count++;
                        if(count==N)
                        {
                            arr[i] = 100 * (k+1) + (j+1);
                        }
                    }
                }
                
                
            }
            for(int i=0;i<T;i++)
            {
                Console.WriteLine(arr[i]);
            }
        }
    }
}

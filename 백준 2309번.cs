using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2309번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[9];
            int[] result = new int[7];
            int sum=0;
            for(int i=0;i<9;i++)
            {
                arr[i] = int.Parse(Console.ReadLine());                
            }
            for(int i=0;i<9;i++)
            {
                sum += arr[i];
            }
            for(int i=0;i<9;i++)
            {
                for(int j=i+1;j<9;j++)
                {
                    if(sum-arr[i]-arr[j]==100)
                    {
                        for(int a=0;a<i;a++)
                        {
                            result[a] = arr[a];
                        }
                        for(int a=i+1;a<j;a++)
                        {
                            result[a-1] = arr[a];
                        }
                        for(int a=j+1;a<9;a++)
                        {
                            result[a - 2] = arr[a];
                        }
                    }
                }
            }
            Array.Sort(result);
            foreach(int item in result)
            {
                Console.WriteLine(item);
            }

        }
    }
}

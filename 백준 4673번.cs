using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_4673번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[10001];
            StringBuilder result = new StringBuilder();
            for(int i=0;i<10001;i++)
            {
                arr[i] = 0;
            }
            arr[0] = 1;
            for(int i=1;i<10001;i++)
            {
                if(arr[i]==0)
                {
                    int j = i;
                    result.Append(i);
                    result.Append("\n");
                    while(D(j)<=10000)
                    {
                        arr[D(j)] = 1;
                        j = D(j);

                    }
                }
            }   
            Console.Write(result.ToString());    
        }
        private static int D(int n)
        {
            int sum = n;
            while(n>0)
            {
                sum += n % 10;
                n = n / 10;
            }
            return sum;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2108번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = new int[N];
            int[] count = new int[8001];//정수의 범위는 -4000~4000 , -4000은 인덱스 0에 4000은 인덱스 8000에
            for(int i=0;i<N;i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            Array.Sort(arr);
            double sum = 0;
            for(int i=0;i<N;i++)
            {
                sum += arr[i];
                count[arr[i] + 4000]++;

            }
            int max = -1;
           for(int i=0;i<8001;i++)
            {
                if(max<count[i])
                {
                    max = count[i];
                }
            }
            int num = 0;
            int index = 0;
           for(int i=0;i<8001;i++)
            {
                if(max==count[i])
                {
                    num++;
                    if(num==2)
                    {
                        index = i;
                        break;
                    }
                }
            }
            if (num == 1)
            {
                for(int i=0;i<8001;i++)
                {
                    if(max==count[i])
                    {
                        index = i;
                        break;
                    }
                }
            }
                
                
            Console.WriteLine(Math.Round(sum/N));
            Console.WriteLine(arr[N / 2]);
            Console.WriteLine(index-4000);
            Console.WriteLine(arr[N - 1] - arr[0]);

        }
    }
}

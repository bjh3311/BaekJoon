using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_4948번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[1000001];
            for (int i = 0; i < 1000001; i++)
            {
                arr[i] = 0;
            }//배열 초기화
            for (int i = 2; i <= 1000000; i++)
            {
                if (arr[i] == 0)
                {
                    for (int j = 2; j * i <= 1000000; j++)
                    {
                        arr[j * i] = 1;
                    }
                }

            }//소수가 아니면 1을 넣는다
            arr[1] = 1;
            int count = 0;
            while (true)
            {
                int N = int.Parse(Console.ReadLine());
                if(N==0)
                {
                    break;
                }
                else
                {
                    for(int i=N+1;i<=2*N;i++)
                    {
                        if(arr[i]==0)
                        {
                            count++;
                        }
                    }
                }
                Console.WriteLine(count);
                count = 0;
            }
           
        }
    }
}

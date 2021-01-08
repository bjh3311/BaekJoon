using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_9020번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[10001];
            for (int i = 0; i < 10001; i++)
            {
                arr[i] = 0;
            }//배열 초기화
            for (int i = 2; i <= 10000; i++)
            {
                if (arr[i] == 0)
                {
                    for (int j = 2; j * i <= 10000; j++)
                    {
                        arr[j * i] = 1;
                    }
                }

            }//소수가 아니면 1을 넣는다
            arr[1] = 1;
            int T_num = int.Parse(Console.ReadLine());
            for(int i=0;i<T_num;i++)
            {
                int n = int.Parse(Console.ReadLine());
                int half = n / 2;
                for(int j=0; ; j++)
                {
                    if(arr[half-j]==0&&arr[half+j]==0)
                    {
                        Console.WriteLine("{0} {1}", half - j, half + j);
                        break;
                    }
                }

            }
        }
    }
}
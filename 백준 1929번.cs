using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1929번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int M = int.Parse(s[0]);
            int N = int.Parse(s[1]);
            int[] arr = new int[1000001];
            StringBuilder result = new StringBuilder();
            for(int i=0;i<1000001;i++)
            {
                arr[i] = 0;
            }//배열 초기화
            for(int i=2;i<=1000000;i++)
            {
                if(arr[i]==0)
                {
                    for(int j=2;j*i<=1000000;j++)
                    {
                        arr[j * i] = 1;
                    }
                }
                
            }//소수가 아니면 1을 넣는다
            arr[1] = 1;
            for(int i=M;i<=N;i++)
            {
                if(arr[i]==0)
                {
                    result.Append(i);
                    result.Append("\n");
                }
                
            }
            Console.Write(result.ToString());
        }
    }
}

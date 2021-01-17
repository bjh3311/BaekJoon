using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1463번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = new int[N + 1];
            arr[1] = 0;
            arr[0] = 0;
            for (int i = 2; i <= N;i++)
            {
                arr[i] = arr[i - 1] + 1; ;
                if(i%2==0)
                {
                    arr[i] = Min(arr[i], arr[i / 2] + 1);
                }
                if(i%3==0)
                {
                    arr[i] = Min(arr[i], arr[i / 3] + 1);
                }/*2와 3의 공배수를 넣었을때 i/2와 i/3 
                 둘 다 비교해야 하므로 else if가 아닌 
                   if문 2개로 작성하였다.*/
            }
            Console.WriteLine(arr[N]);
            
        }
       

       
        public static int Min(int a,int b)
        {
            if (a < b)
            {
                return a;
            }
            else
            {
                return b;
            }
        }
    }
}

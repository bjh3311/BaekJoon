using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1010번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            ulong A, B;
            int[] arr_B = new int[30];// 조합을 계산할때 분자
            int[] arr_A = new int[30];// 조합을 계산할때 분모
            for (int i=0;i<T;i++)
            {
                string[] s = Console.ReadLine().Split();
                A = ulong.Parse(s[0]);
                B = ulong.Parse(s[1]);
                for(ulong j=2;j<=A;j++)
                {
                    arr_A[j]++;
                }
                for(ulong j=B;j>B-A;j--)
                {
                    arr_B[j]++;
                }
                ulong temp = 1;
                for (ulong j = 2; j <= B; j = j + 2)
                {
                    if (arr_B[j] > 0)
                    {
                        temp *= j;
                    }
                }
                for (ulong j = 2; j <= A; j = j + 2)
                {
                    if(arr_A[j]>0)
                    {
                        temp = temp / j;
                    }
                    
                }
                for(ulong j=3;j<=B;j=j+2)
                {
                    if (arr_B[j] > 0)
                    {
                        temp *= j;
                    }
                }
                for (ulong j = 3; j <= A; j = j + 2)
                {
                    if (arr_A[j] > 0)
                    {
                        temp = temp / j;
                    }

                }
                Console.WriteLine(temp);
                for (ulong j = 2; j <30; j++)
                {
                    arr_A[j] = 0;
                }
                for (ulong j = 2; j <30 ; j++)
                {
                    arr_B[j] = 0;
                }//arr_A 와 arr_B배열 초기화
            }
        }
    }
}

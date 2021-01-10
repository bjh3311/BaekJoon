using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2609번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int A = int.Parse(s[0]);
            int B = int.Parse(s[1]);
            int[] A_arr = new int[10000];
            int[] A_arr2 = new int[10000];
            int[] B_arr = new int[10000];
            int[] B_arr2 = new int[10000];
            int Max = 1;
            int Min = 1;
            for (int i=2;A!=1 ;)
            {
                if(A%i==0)
                {
                    A_arr[i]++;
                    A_arr2[i]++;
                    A = A / i;
                }
                else
                {
                    i++;
                }

            }
            for (int i = 2; B!= 1;)
            {
                if (B% i == 0)
                {
                    B_arr[i]++;
                    B_arr2[i]++;
                    B = B / i;
                }
                else
                {
                    i++;
                }

            }
            for(int i=2;i<10000;)//최대공약수 구하기
            {
                if(A_arr[i]!=0&&B_arr[i]!=0)
                {
                    Max = Max * i;
                    A_arr[i]--;
                    B_arr[i]--;
                }
                else if(A_arr[i]==0||B_arr[i]==0)
                {
                    i++;
                }
            }
            for(int i=2;i<10000;)//최소공배수 구하기
            {
                if(A_arr2[i]>0||B_arr2[i]>0)
                {
                    Min = Min * i;
                    A_arr2[i]--;
                    B_arr2[i]--;
                }
                else
                {
                    i++;
                }
            }
            Console.WriteLine(Max);
            Console.WriteLine(Min);

        }
    }
}

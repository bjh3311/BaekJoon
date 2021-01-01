using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1157번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            int[] arr = new int[26];
            int max_index = 0;
            for(int i=0;i<26;i++)
            {
                arr[i] = 0;
            }
            for(int i=0;i<s.Length;i++)
            {
                for(int j=0;j<26;j++)
                {
                    if(Convert.ToInt32(s.ToString()[i])==65+j || Convert.ToInt32(s.ToString()[i]) == 97 + j) //아스키 코드를 활용
                    {
                        arr[j]++;
                    }
                }
            }
            for(int i=0;i<25;i++)
            {
               if(arr[max_index]<=arr[i+1])
                {
                    max_index = i + 1;
                }
            }
            for(int i=max_index;i>=0;i--)
            {
                if(max_index==0)
                {
                    Console.WriteLine("A");
                    break;
                }
                else if(arr[max_index]==arr[i-1])
                {
                    Console.WriteLine("?");
                    break;
                }
                else if(i==1)
                {
                    char c4 = Convert.ToChar(max_index + 65);
                    Console.WriteLine(c4);
                    break;
                }
            }

            

        }
    }
}

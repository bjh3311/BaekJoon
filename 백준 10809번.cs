using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_10809번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            int Length = s.Length;
            int[] arr = new int[26];
            for (int i = 0; i < 26; i++)
            {
                arr[i] = -1;
            }
            for (int i=0;i<Length;i++)
            {
                int a=Convert.ToInt32(s.ToString()[i]);
                if (arr[a - 97] == -1)
                {
                    arr[a - 97] = i;
                }
            }

            for(int i=0;i<26;i++)
            {
                Console.Write("{0} ", arr[i]);
            }


        }
    }
}

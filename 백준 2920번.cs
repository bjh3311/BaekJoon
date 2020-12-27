using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2920번
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[8];
            string[] s = Console.ReadLine().Split();
            arr[0] = int.Parse(s[0]);
            arr[1] = int.Parse(s[1]);
            arr[2] = int.Parse(s[2]);
            arr[3] = int.Parse(s[3]);
            arr[4] = int.Parse(s[4]);
            arr[5] = int.Parse(s[5]);
            arr[6] = int.Parse(s[6]);
            arr[7] = int.Parse(s[7]);
            int ascen = 0;
            int descen = 0;
            for (int i=0;i<8;i++)
            {
                if(arr[i]==i+1)
                {
                    ascen++;
                }
            }
            for(int i=0;i<8;i++)
            {
                if(arr[i]==8-i)
                {
                    descen++;
                }
            }
            if(ascen==8)
            {
                Console.Write("ascending");
            }
            else if(descen==8)
            {
                Console.Write("descending");
            }
            else
            {
                Console.Write("mixed");
            }
   

        }
    }
}

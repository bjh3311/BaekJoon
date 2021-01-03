using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1152번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            string s_trim = s.Trim();
            int before = s_trim.Length;
            string s_replace = s_trim.Replace(" ", "");
            int after = s_replace.Length;
            if(before-after==0)
            {
                if(before>0)
                {
                    Console.WriteLine(1);
                }
                else
                {
                    Console.WriteLine(0);
                }
            }
            else
            {
                Console.WriteLine(before - after + 1);
            }
            
        }
    }
}

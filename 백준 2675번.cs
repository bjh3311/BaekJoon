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
            int t_num = int.Parse(Console.ReadLine());
            for (int i = 0; i < t_num; i++)
            {
                string[] s = Console.ReadLine().Split();
                for (int k = 0; k < s[1].Length; k++)                
                {
                     for (int j = 0; j < int.Parse(s[0]); j++)
                     {
                        Console.Write(s[1].ToString()[k]);
                     }
                }
                Console.WriteLine();
            }
        }
    }
}

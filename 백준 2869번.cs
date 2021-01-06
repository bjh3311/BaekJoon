using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2869번
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] s = Console.ReadLine().Split();
            int A = int.Parse(s[0]);
            int B = int.Parse(s[1]);
            int V = int.Parse(s[2]);
            int count = 0;
            int gar = (V-A) % (A - B);
            if(gar==0)
            {
                Console.Write((V - A) / (A - B) + 1);
            }
            else
            {
                Console.Write((V - A) / (A - B) + 2);
            }
                
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_9184번
{
    class Program
    {
        static void Main(string[] args)
        {
            while(true)
            {
                string[] s = Console.ReadLine().Split();
                int a = int.Parse(s[0]);
                int b = int.Parse(s[1]);
                int c = int.Parse(s[2]);
                int final = result(a, b, c);
                if(a==-1&&b==-1&&c==-1)
                {
                    break;
                }
                else
                {
                    Console.WriteLine("w({0}, {1}, {2}) = {3}", a, b, c, final);
                }
                
            }
        }
        private static int[,,] w = new int[51, 51, 51];
        private static int result(int a, int b, int c)
        {
            if (a <= 0 || b <= 0 || c <= 0)
            {  
                return 1;
            }
            else if(a>20||b>20||c>20)
            {
                if(w[a,b,c]==0)
                {
                    w[a, b, c] = result(20, 20, 20);
                }
            }
            else if(a<b&&b<c)
            {
                if(w[a,b,c]==0)
                {
                    w[a, b, c] = result(a, b, c - 1) + result(a, b - 1, c - 1) - result(a, b - 1, c);
                }
            }
            else
            {
                if(w[a,b,c]==0)
                {
                    w[a, b, c] = result(a - 1, b, c) + result(a - 1, b - 1, c) + result(a - 1, b, c - 1) - result(a - 1, b - 1, c - 1);
                }
            }
            return w[a, b, c];
        }

    }
    
}

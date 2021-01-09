using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_5086번
{
    class Program
    {
        static void Main(string[] args)
        {
            while(true)
            {
                int A, B;
                string[] s = Console.ReadLine().Split();
                A = int.Parse(s[0]);
                B = int.Parse(s[1]);
                if(A ==0&&B==0)
                {
                    break;
                }
                else
                {
                    if(A%B==0)
                    {
                        Console.WriteLine("multiple");
                    }
                    else if(B%A==0)
                    {
                        Console.WriteLine("factor");
                    }
                    else
                    {
                        Console.WriteLine("neither");
                    }
                }

            }
        }
    }
}

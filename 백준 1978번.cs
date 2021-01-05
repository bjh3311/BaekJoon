using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1978번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            int count = 0;
            for (int i = 0; i < N; i++)
            {
                for (int j = 2; j <= int.Parse(s[i]); j++)
                {
                    if (int.Parse(s[i]) == 2)
                    {
                        count++;
                        break;
                    }
                    else if (int.Parse(s[i]) % j == 0)
                    {

                        break;
                    }
                    else if (j + 1 == int.Parse(s[i]))
                    {
                        count++;
                        break;
                    }

                }
            }
            Console.WriteLine(count);
        }
    }
}

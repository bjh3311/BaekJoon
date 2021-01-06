using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1011번
{
    class Program
    {
        static void Main(string[] args)
        {
            ulong T_num = ulong.Parse(Console.ReadLine());
            ulong[] result = new ulong[T_num];
            for (ulong i = 0; i < T_num; i++)
            {
                string[] s = Console.ReadLine().Split();
                ulong x = ulong.Parse(s[0]);
                ulong y = ulong.Parse(s[1]);
                ulong count = 2;
                ulong j;
                ulong k;
                if(y-x==1)
                {
                    result[i] = 1;
                }
                else if(y-x==2)
                {
                    result[i] = 2;
                }
                else if(y-x==3||y-x==4)
                {
                    result[i] = 3;
                }
                else if(y-x==5)
                {
                    result[i] = 4;
                }
                else
                {
                    for (j = 1; (j * j) < y - x; j++)
                    {
                        
                    }
                    for (k = 2; k < y - x;)
                    {
                        k = k + (2 * count);
                        count++;
                    }
                    ulong count_be = count - 1;
                    ulong k_be = k - (2 * count_be);
                    if (j * j == y - x)
                    {
                        result[i] = (2 * j) - 1;
                    }
                    else if (k == y - x)
                    {
                        result[i] = (2 * j) - 2;
                    }
                    else if(k<j*j)
                    {
                        result[i] = (2 * j) - 2;
                    }
                    else if(k>j*j)
                    {
                        result[i] = (2 * j) - 1;
                    }
                    
                }
                
            }
            for (ulong i = 0; i < T_num; i++)
            {
                Console.WriteLine(result[i]);
            }
        }
    }
}

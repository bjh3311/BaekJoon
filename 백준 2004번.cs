using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2004번
{
    class Program
    {
        static void Main(string[] args)
        {
            int two_count = 0;
            int five_count = 0;
            int zero_count = 0;
            string[] s = Console.ReadLine().Split();
            int n = int.Parse(s[0]);
            int m = int.Parse(s[1]);
            for (int i = n; i > n - m; i--)
            {
                int temp = i;
                for(int j=2;j<=i;)
                {
                    if(temp%j==0)
                    {
                        if(j==2)
                        {
                            two_count++;
                        }
                        else if(j==5)
                        {
                            five_count++; 
                        }
                        temp = temp / j;
                        if(temp==1)
                        {
                            break;
                        }
                    }
                    else
                    {
                        j++;
                    }
                }
            }
            for (int i = m; i > 0; i--)
            {
                int temp = i;
                for (int j = 2; j <= i;)
                {
                    if (temp % j == 0)
                    {
                        if (j == 2)
                        {
                            two_count--;
                        }
                        else if (j == 5)
                        {
                            five_count--;
                        }
                        temp = temp / j;
                        if (temp == 1)
                        {
                            break;
                        }
                    }
                    else
                    {
                        j++;
                    }
                }
            }
            while(true)
            {
                if(two_count!=0&&five_count!=0)
                {
                    two_count--;
                    five_count--;
                    zero_count++;
                }
                else
                {
                    break;
                }
            }
            Console.Write(zero_count);

        }
    }
}

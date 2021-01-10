using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1934번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            for(int i=0;i<T;i++)
            {
                string[] s = Console.ReadLine().Split();
                int A = int.Parse(s[0]);
                int B = int.Parse(s[1]);
                if(A%B==0)
                {
                    Console.WriteLine(A);
                }
                else if(B%A==0)
                {
                    Console.WriteLine(B);
                }
                else
                {
                    
                    if(A>B)
                    {
                        int A_temp = A;
                        int B_temp = B;
                        while(true)
                        {
                            int C = A_temp % B_temp;
                            if(C==0)
                            {
                                Console.WriteLine(A*(B/B_temp));
                                break;
                            }
                            else
                            {
                                A_temp = B_temp;
                                B_temp = C;
                            }
                        
                        }
                        
                        
                    }
                    else
                    {
                        int A_temp = A;
                        int B_temp = B;
                        while(true)
                        {
                            int C = B_temp % A_temp;
                            if(C==0)
                            {
                                Console.WriteLine(B * (A / A_temp));
                                break;
                            }
                            else
                            {
                                B_temp = A_temp;
                                A_temp = C;
                            }
                        }
                       
                    }
                }
            }
        }
    }
}

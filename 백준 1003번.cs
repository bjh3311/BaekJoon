using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1003번
{
    class Program
    {
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            FiboData[0] = 0;
            FiboData[1] = 1;
            Fib result = new Fib();
            int a = result.Fibo(40);
            for(int i=0;i<T;i++)
            {
                int N = int.Parse(Console.ReadLine());
                Console.WriteLine("{0} {1}",FiboData_zero[N],FiboData_one[N]);
            }
            
        }
        public static int[] FiboData = new int[41];
        public static int[] FiboData_zero = new int[41];
        public static int[] FiboData_one = new int[41];
        public class Fib
        {  
            public int Fibo(int n)
            {
                FiboData_zero[0] = 1;
                FiboData_one[1] = 1;
                if(n==0)
                {
                    return n;
                }
                else if(n==1)
                {
                    
                    return n;
                }
                else
                {
                    if (FiboData[n] == 0)
                    {
                        FiboData[n] = Fibo(n-1)+Fibo(n - 2);
                        FiboData_zero[n] = FiboData_zero[n - 1] + FiboData_zero[n - 2];
                        FiboData_one[n] = FiboData_one[n - 1] + FiboData_one[n - 2];
                        
                    }
                    
                }
                
                return FiboData[n];
            }
        }
            
           

    }
}

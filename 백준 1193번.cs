using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1193번
{
    class Program
    {
        static void Main(string[] args)
        {
            int X = int.Parse(Console.ReadLine());
            int result = 0;
            int i;
            int count;
            for( i=1;i<X;i++)
            {
                result = (i * (i + 1)) / 2;
                if(result>=X)
                {
                    break;
                }
            }
            if(i%2==0)//짝수이면 대각선아래로 내려감
            {
                for(count=0;count<X-(i*(i-1)/2)-1;count++)
                {

                }
                Console.Write("{0}/{1}", 1 + count, i - count);
            }
            else if(i%2==1)//홀수이면 대각선 위로 올라감
            {
                for(count=0;count< X - (i * (i - 1) / 2)-1;count++)
                {

                }
                Console.Write("{0}/{1}", i - count, 1 + count);
            }
            
        }
    }
}

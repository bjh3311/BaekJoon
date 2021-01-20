using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_13305번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            ulong[] length = new ulong[N - 1];//길이들의 배열
            ulong[] price = new ulong[N-1];//주유소 가격의 배열
            string[] s = Console.ReadLine().Split();
            for(int i=0;i<N-1;i++)
            {
                length[i] = ulong.Parse(s[i]);
            }
            s = Console.ReadLine().Split();
            for(int i=0;i<N-1;i++)//마지막 주유소는 못 사용하기 때문에 N-1까지 입력
            {
                price[i] = ulong.Parse(s[i]);
            }
            ulong min_price = price[0];
            ulong sum = (price[0] * length[0]);
            for (int i=1;i<N-1;i++)
            {
                if (price[i] >=min_price)
                {
                    sum += min_price * length[i];
                }
                else if(price[i]<min_price)
                {
                    sum += price[i] * length[i];
                    min_price = price[i];
                }

            }
            Console.WriteLine(sum);
            
            
        }
    }
}

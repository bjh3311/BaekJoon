using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_10828번
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack s = new Stack();
            int N = int.Parse(Console.ReadLine());
            int sum = 0;
            for (int i = 0; i < N; i++)
            {
                int a = int.Parse(Console.ReadLine());
                if(a==0)
                {
                    s.pop();
                }
                else
                {
                    s.push(a);
                }
            }
            for(int i=0;i<N;i++)
            {
                sum += s.arr[i];
            }
            Console.WriteLine(sum);
        }
    }
    class Stack
    {
        public int count = 0;
        public int[] arr = new int[100000];
        public void push(int val)
        {
            arr[count] = val;
            ++count;
        }
        public void pop()
        {
            if (count > 0)
            {
                arr[--count] = 0;
                
            }
           
        }
        public void size()
        {
            Console.WriteLine(count);
        }
        public void empty()
        {
            if (count > 0)
            {
                Console.WriteLine("0");
            }
            else
            {
                Console.WriteLine("1");
            }
        }
        public void top()
        {
            if (count > 0)
            {
                Console.WriteLine(arr[count - 1]);
            }
            else
            {
                Console.WriteLine("-1");
            }
        }

    }
}

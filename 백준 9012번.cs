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
            string[] t_case = new string[N];
            string[] result = new string[N];
            for (int i = 0; i < N; i++)
            {
                t_case[i] = Console.ReadLine();
            }
            for(int i=0;i<N;i++)
            {
                int a = t_case[i].Length;
                for(int j=0;j<a;j++)
                {
                    if(t_case[i].ToString()[j]=='(')
                    {
                        s.push(1);
                    }
                    else if(t_case[i].ToString()[j]==')')
                    {
                        s.pop();
                    }
                }
                if (s.count == 0)
                {
                    result[i] = "YES";
                }
                else
                {
                    result[i] = "NO";
                }
                s.count = 0;
            }
            for(int i=0;i<N;i++)
            {
                Console.WriteLine(result[i]);
            }
           
        }
    }
    class Stack
    {
        public int count = 0;
        public int[] arr = new int[100000];
        public void push(int val)
        {
            if (count >= 0)
            {
                arr[count] = val;
                ++count;
            }
        }
        public void pop()
        {
            if (count > 0)
            {
                arr[--count] = 0;

            }
            else
            {
                count = -200;
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

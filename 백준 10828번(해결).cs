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
            string[] com;
            for (int i = 0; i < N; i++)
            {
                com = Console.ReadLine().Split();
                if (com[0] == "push")
                {
                    s.push(int.Parse(com[1]));
                }
                else if (com[0] == "pop")
                {
                    s.pop();
                }
                else if (com[0] == "size")
                {
                    s.size();
                }
                else if (com[0] == "empty")
                {
                    s.empty();
                }
                else if (com[0] == "top")
                {
                    s.top();
                }
            }
            Console.Write(s.builder.ToString());
        }
    }
    class Stack
    {
        public int count = 0;
        public int[] arr = new int[10000];
        public StringBuilder builder=new StringBuilder();
        public void push(int val)
        {
            arr[count] = val;
            ++count;
        }
        public void pop()
        {
            if (count > 0)
            {
                count--;
                builder.Append(arr[count]);
                builder.Append("\n");
                

            }
            else
            {
                builder.Append("-1\n");
            }
        }
        public void size()
        {
            builder.Append(count);
            builder.Append("\n");
        }
        public void empty()
        {
            if (count > 0)
            {
                builder.Append("0\n");
            }
            else
            {
                builder.Append("1\n");
            }
        }
        public void top()
        {
            if (count > 0)
            {
                builder.Append(arr[count - 1]);
                builder.Append("\n");
            }
            else
            {
                builder.Append("-1\n");
            }
        }

    }
}
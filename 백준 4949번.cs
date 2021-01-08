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
            Stack stack = new Stack();
            while (true)
            {
                string t_case = Console.ReadLine();
                if(t_case==".")
                {
                    break;
                }
                for (int i = 0; i < t_case.Length; i++)
                {
                    if (t_case.ToString()[i] == '(')
                    {
                        stack.push(1);//소괄호면 1을 push
                    }
                    else if (t_case.ToString()[i] == '[')
                    {
                        stack.push(2);//대괄호면 2를 push
                    }
                    else if (t_case.ToString()[i] == ')')
                    {
                        if (stack.pop() != 1)
                        {
                            stack.count = -1000;
                        }
                    }
                    else if (t_case.ToString()[i] == ']')
                    {
                        if (stack.pop() != 2)
                        {
                            stack.count = -1000;
                        }
                    }
                    else if (t_case.ToString()[i] == '.')
                    {
                        if (stack.count == 0)
                        {
                            Console.WriteLine("yes");
                            break;
                        }
                        else if (stack.count != 0)
                        {
                            Console.WriteLine("no");
                            break;
                        }

                    }


                }
                for (int i = 0; i < t_case.Length; i++)
                {
                    stack.arr[i] = 0;//stack 초기화
                }
                stack.count = 0; //stack 초기화
            }
        }
    }
    class Stack
    {
        public int count = 0;
        public int[] arr = new int[101];
        public void push(int val)
        {
            if (count >= 0)
            {
                arr[count] = val;
                ++count;
            }
        }
        public int pop()
        {
            if (count > 0)
            {

                count--;
                int temp = arr[count];
                arr[count] = 0;
                return temp;


            }
            else
            {
                return -1000;
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
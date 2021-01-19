using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1541번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            string[] arr = s.Split('-');
            int result = Add(arr[0]);
            for(int i=1;i<arr.Length;i++)
            {
                result -= Add(arr[i]);
            }
            Console.WriteLine(result);
            
        }
        public static int Add(string i)
        {
            string[] arr = i.Split('+');
            int result = 0;
            for(int j=0;j<arr.Length;j++)
            {
                result+=int.Parse(arr[j]);
            }
            return result;
        }
    }
}

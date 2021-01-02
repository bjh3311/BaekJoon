using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_5622번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            int sum = 0;
            for(int i=0;i<s.Length;i++)
            {
                if(s.ToString()[i]=='A'||s.ToString()[i]=='B'||s.ToString()[i]=='C')
                {
                    sum = sum + 3;
                }
                else if (s.ToString()[i] == 'D' || s.ToString()[i] == 'E' || s.ToString()[i] == 'F')
                {
                    sum = sum + 4;
                }
                else if (s.ToString()[i] == 'G' || s.ToString()[i] == 'H' || s.ToString()[i] == 'I')
                {
                    sum = sum + 5;
                }
                else if (s.ToString()[i] == 'J' || s.ToString()[i] == 'K' || s.ToString()[i] == 'L')
                {
                    sum = sum + 6;
                }
                else if (s.ToString()[i] == 'M' || s.ToString()[i] == 'N' || s.ToString()[i] == 'O')
                {
                    sum = sum + 7;
                }
                else if (s.ToString()[i] == 'P' || s.ToString()[i] == 'Q' || s.ToString()[i] == 'R'||s.ToString()[i]=='S')
                {
                    sum = sum + 8;
                }
                else if (s.ToString()[i] == 'T' || s.ToString()[i] == 'U' || s.ToString()[i] == 'V')
                {
                    sum = sum + 9;
                }
                else if (s.ToString()[i] == 'W' || s.ToString()[i] == 'X' || s.ToString()[i] == 'Y'||s.ToString()[i]=='Z')
                {
                    sum = sum + 10;
                }
            }
            Console.WriteLine(sum);   
        }
    }
}

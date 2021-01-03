using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_1316번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            string[] s = new string[N];
            int[] arr = new int[26]; //각 알파벳의 갯수를 세기 위한 배열 선언
            int count = 0;
            for (int i = 0; i < N; i++)
            {
                s[i] = Console.ReadLine();
            }
            for (int j = 0; j < N; j++)
            {
                for (int i = 0; i < s[j].Length; i++)
                {
                    char code = s[j].ToString()[i];
                    int alpha = Convert.ToInt32(code) - 97;
                    arr[alpha]++;
                }//문장에서 각 알파벳의 갯수 세기
                for (int i = 0; i < 26; i++)
                {
                    if (arr[i] > 1)//알파벳 개수가 1개보다 많을 때
                    {                       
                        for (int k = 0; k < s[j].Length; k++)
                        {
                            char re = Convert.ToChar(i + 97);//아스키 코드로 변환
                            if (s[j].ToString()[k] == re)
                            {
                                for (int l = 1; l < arr[i]; l++)
                                {
                                    if (s[j].ToString()[k+l] != re)
                                    {                                       
                                        count++;
                                        goto Exit;
                                    }
                                }
                                k = k + arr[i] - 1;
                            }
                        }
                    }

                }
            Exit:
                {
                    ;
                }

                for (int i = 0; i < 26; i++)
                {
                    arr[i] = 0;
                }//배열 초기화
            }
            Console.WriteLine(N - count);

        }
    }
}
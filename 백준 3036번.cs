using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_3036번
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            string[] s = Console.ReadLine().Split();
            int[] arr = new int[N];
            for(int i=0;i<N;i++)
            {
                arr[i] = int.Parse(s[i]);
            }
            for(int i=1;i<N;i++)
            {
                if(arr[0]%arr[i]==0)
                {
                    Console.WriteLine("{0}/{1}", arr[0] / arr[i], 1);
                }
                else
                {

                    if (arr[0]> arr[i])
                    {
                        int A_temp = arr[0];
                        int B_temp = arr[i];
                        while (true)
                        {
                            int C = A_temp % B_temp;
                            if (C == 0)
                            {
                                Console.WriteLine("{0}/{1}",arr[0]/B_temp,arr[i]/B_temp);
                                break;
                            }
                            else
                            {
                                A_temp = B_temp;
                                B_temp = C;
                            }

                        }


                    }
                    else
                    {
                        int A_temp = arr[0];////arr[0]과 arr[i]의 최대공약수를 구한다
                        int B_temp = arr[i];
                        while (true)
                        {
                            int C = B_temp % A_temp;
                            if (C == 0)
                            {
                                Console.WriteLine("{0}/{1}",arr[0]/A_temp,arr[i]/A_temp);
                                break;
                            }
                            else
                            {
                                B_temp = A_temp;
                                A_temp = C;
                            }
                        }

                    }
                }
            }
        }
    }
}

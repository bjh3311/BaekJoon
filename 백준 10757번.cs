using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static void Main()
    {
        int[] A = new int[10001];
        int[] B = new int[10001];
        int[] C = new int[10001];
        for(int i=0;i<10001;i++)
        {
            A[i] = 0;
            B[i] = 0;
            C[i] = 0;
        }// 배열초기화
        string[] s = Console.ReadLine().Split();
        string A_st = s[0];
        string B_st = s[1];
        if (A_st.Length >= B_st.Length)
        {
            for (int i = 0; i < A_st.Length; i++)
            {
                A[i] = Convert.ToInt32(A_st.ToString()[i]) - 48;
            }
            for (int i = 0; i < B_st.Length; i++)
            {
                B[A_st.Length - 1 - i] = Convert.ToInt32(B_st.ToString()[B_st.Length - i - 1]) - 48;
            }
            for (int i = A_st.Length; i >=0; i--)
            {
                if (C[i]+A[i] + B[i] < 10)
                {
                    C[i] += A[i] + B[i];
                }
                else
                {
                    if (i != 0)
                    {
                        int j = i - 1;
                        C[j] += C[j] + 1;
                        C[i] += (A[i] + B[i] - 10);
                    }
                    else
                    {
                        C[i] += A[i] + B[i];
                    }
                }


            }
            for (int i = 0; i < A_st.Length; i++)
            {
                Console.Write(C[i]);
            }
        }
        else
        {
            for (int i = 0; i < B_st.Length; i++)
            {
                B[i] = Convert.ToInt32(B_st.ToString()[i]) - 48;
            }
            for (int i = 0; i < A_st.Length; i++)
            {
                A[B_st.Length - 1 - i] = Convert.ToInt32(A_st.ToString()[A_st.Length - i - 1]) - 48;
            }
            for (int i = B_st.Length; i >=0; i--)
            {
               
                if (C[i]+A[i] + B[i] < 10)
                {
                    C[i] += A[i] + B[i];
                }
                else
                {
                    if (i != 0)
                    {
                        int j = i - 1;
                        C[j] += C[j] + 1;
                        C[i] += A[i] + B[i] - 10;
                    }
                    else
                    {
                        C[i] += A[i] + B[i];
                    }
                }


            }


            for (int i = 0; i < B_st.Length; i++)
            {
                Console.Write(C[i]);
            }
        }
    }

}
        
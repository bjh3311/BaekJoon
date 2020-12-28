using System;
using System.Collections.Generic;

public class Program
{
    static void Main()
    {
        int N = int.Parse(Console.ReadLine());
        int count = 0;
        for (int i = 666; ; i++)
        {
            for (int j = 0; j < i.ToString().Length - 2; j++)
            {
                if (i.ToString()[j] == '6')
                {
                    if (i.ToString()[j + 1] == '6')
                    {
                        if (i.ToString()[j + 2] == '6')
                        {
                            count++;
                            break;
                        }
                    }
                }
            }
            if (count == N)
            {
                Console.WriteLine(i);
                break;
            }
        }
    }
}
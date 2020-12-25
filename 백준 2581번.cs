using System;

public class HelloWorld
{
    static void Main()
    {
        int count = 0;
        int sum = 0;
        int M = int.Parse(Console.ReadLine());
        int N = int.Parse(Console.ReadLine());
        int[] arr = new int[N - M + 1];
        int index;
        arr[0] = -1;
        for (int i = M; i <= N; i++)
        {
            for (index = 2; index < N; index++)
            {
                if (i == 1)
                {
                    break;
                }
                else if (i % index == 0)
                {
                    break;
                }
            }
            if (i == index)
            {
                arr[count] = i;
                count++;
            }
        }
        for (int i = 0; i < arr.Length; i++)
        {
            sum += arr[i];
        }
        if (sum > 0)
        {
            Console.WriteLine(sum);
        }
        Console.WriteLine(arr[0]);
    }
}
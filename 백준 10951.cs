using System;
public class Pro
{
    static void Main()
    {
        int A;
        int B;
            while (true)
            {
                string s = Console.ReadLine();
                if(s==null)
                {
                   break;
                }
                string[] sa = s.Split();
                A = int.Parse(sa[0]);
                B = int.Parse(sa[1]);
                Console.WriteLine(A + B);
            }
      
      

    }
}
using System;
namespace 백준_3053번
{
    class Program
    {
        static void Main(string[] args)
        {
            double R = double.Parse(Console.ReadLine());
            Console.WriteLine("{0:f6}",(Math.PI) * R*R);
            Console.WriteLine(R * R * 2);
        }
    }
}

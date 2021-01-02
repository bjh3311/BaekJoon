using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 백준_2941번
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = Console.ReadLine();
            int count = 0;
            for (int i = 0; i < s.Length; i++)
            {
                if (s.ToString()[i] == 'c')
                {
                    if (i != s.Length - 1)
                    {
                        if (s.ToString()[i + 1] == '-' || s.ToString()[i + 1] == '=')
                        {
                            count++;
                            i++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }

                }
                else if (s.ToString()[i] == 'd')
                {
                    if(i!=s.Length-1)
                    {
                        if (s.ToString()[i+1]=='z')
                        {
                            if(i!=s.Length-2)
                            {
                                if(s.ToString()[i+2]=='=')
                                {
                                    i = i + 2;
                                    count++;
                                }
                                else
                                {
                                    count = count + 2;
                                    i++;
                                }
                            }
                            else
                            {
                                count = count + 2;
                                i++;
                            }
                        }
                        else if (s.ToString()[i + 1] == '-')
                        {
                            count++;
                            i++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }

                }
                else if (s.ToString()[i] == 'l')
                {
                    if (i != s.Length - 1)
                    {
                        if (s.ToString()[i + 1] == 'j')
                        {
                            i++;
                            count++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }
                }
                else if (s.ToString()[i] == 'n')
                {
                    if (i != s.Length-1)
                    {
                        if (s.ToString()[i + 1] == 'j')
                        {
                            i++;
                            count++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }

                }
                else if (s.ToString()[i] == 's')
                {
                    if (i != s.Length - 1)
                    {
                        if (s.ToString()[i + 1] == '=')
                        {
                            i++;
                            count++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }
                }
                else if (s.ToString()[i] == 'z')
                {
                    if (i != s.Length - 1)
                    {
                        if (s.ToString()[i + 1] == '=')
                        {
                            i++;
                            count++;
                        }
                        else
                        {
                            count++;
                        }
                    }
                    else
                    {
                        count++;
                    }
                }
                else
                {
                    count++;
                }
            }
            Console.WriteLine(count);

        }
    }
}

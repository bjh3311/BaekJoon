package week4_진리표작성;
import java.util.*;
import java.io.*;
public class week4_진리표작성 {

	public static String s_from_b(boolean b)//boolean값을 string으로 바꿔준다
	{
		if(b==true)
		{
			return "T";
		}
		else
		{
			return "F";
		}
	}
	public static boolean P;
	public static boolean Q;
	public static boolean R;
	public static boolean b_from_s(String s)
	{
		if(s.equals("P"))
		{
			return P;
		}
		else if(s.equals("Q"))
		{
			return Q;
		}
		else
		{
			return R;
		}
		
	}
	public static boolean calc_result(boolean a,boolean b,String op)
	{
		if(op.equals("o"))//논리합
		{
			return a||b;
		}
		else if(op.equals("a"))//논리곱
		{
			return a&&b;
		}
		else if(op.equals("i"))//논리 함축
		{
			return (!a)||b;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//변수의 개수
		int M=Integer.parseInt(s[1]);//연산자의 개수
		int K=Integer.parseInt(s[2]);
		Stack<String> cal=new Stack<String>();//연산자 스택
		Stack<Boolean> pee_cal=new Stack<Boolean>();//피연산자 스택
		String s1=new String("n");//부정연산
		String s2=new String("a");//논리곱
		String s3=new String("o");//논리합
		String s4=new String("i");//논림함축
		s=br.readLine().split(" ");
		boolean[] table=new boolean[N];
		if(N==1)
		{
			System.out.println("P RESULT");
			boolean[][] truth= {{true},{false}};
			for(int j=0;j<2;j++)
			{
				P=truth[j][0];
				boolean RESULT=false;//결과값
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//연산자라면
					{
						if(!cal.isEmpty())//비어있지않다면
						{
							if(cal.peek().equals(s1))//맨꼭대기에 있는게 부정연산일 경우
							{
								boolean temp=pee_cal.pop();
								pee_cal.push(!temp);
								cal.pop();
								boolean b=pee_cal.pop();
								boolean a=pee_cal.pop();
								String temp_temp=cal.pop();
								pee_cal.push(calc_result(a,b,temp_temp));
								cal.push(s[i]);
									
							}
							else//맨꼭대기에 있는게 부정연산이 아닐경우
							{
								if(s[i].equals(s1))//근데 넣으려는게 부정연산일경우
								{
									cal.push(s[i]);
								}
								else//넣으려는게 부정연산이 아닐경우
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//비어있다면
						{
							cal.push(s[i]);
						}
						
					}//연산자라면 연산자스택에 push
					else
					{
						pee_cal.push(b_from_s(s[i]));//피연산자에는 T,F만 집어넣는다
					}//피연산자라면 피연산자스택에 push
					
				}
				while(!cal.isEmpty())//연산자 스택이 빌 때 까지
				{
					String temp=cal.pop();
					if(temp.equals("n"))//나온게 부정연산이라면
					{
						boolean temp_temp=pee_cal.pop();
						pee_cal.push(!temp_temp);
						
					}
					else
					{
						boolean b=pee_cal.pop();
						boolean a=pee_cal.pop();
						pee_cal.push(calc_result(a,b,temp));
					}
				}
				RESULT=pee_cal.pop();
				System.out.println();//결과는 두줄씩 띄어서 출력이다
				System.out.println(s_from_b(P)+" "+s_from_b(RESULT));
				
				
			}
			
		}
		else if(N==2)
		{
			System.out.println("P Q RESULT");
			boolean[][] truth= {{true,true},{true,false},{false,true},{false,false}};
			for(int j=0;j<4;j++)//변수가 2개면 결과값은 4개
			{
				P=truth[j][0];
				Q=truth[j][1];
				boolean RESULT=false;//결과값
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//연산자라면
					{
						if(!cal.isEmpty())//비어있지않다면
						{
							if(cal.peek().equals(s1))//맨꼭대기에 있는게 부정연산일 경우
							{
								boolean temp=pee_cal.pop();
								pee_cal.push(!temp);
								cal.pop();
								boolean b=pee_cal.pop();
								boolean a=pee_cal.pop();
								String temp_temp=cal.pop();
								pee_cal.push(calc_result(a,b,temp_temp));
								cal.push(s[i]);
									
							}
							else//맨꼭대기에 있는게 부정연산이 아닐경우
							{
								if(s[i].equals(s1))//근데 넣으려는게 부정연산일경우
								{
									cal.push(s[i]);
								}
								else//넣으려는게 부정연산이 아닐경우
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//비어있다면
						{
							cal.push(s[i]);
						}
						
					}//연산자라면 연산자스택에 push
					else
					{
						pee_cal.push(b_from_s(s[i]));//피연산자에는 T,F만 집어넣는다
					}//피연산자라면 피연산자스택에 push
					
				}
				while(!cal.isEmpty())//연산자 스택이 빌 때 까지
				{
					String temp=cal.pop();
					if(temp.equals("n"))//나온게 부정연산이라면
					{
						boolean temp_temp=pee_cal.pop();
						pee_cal.push(!temp_temp);
						
					}
					else
					{
						boolean b=pee_cal.pop();
						boolean a=pee_cal.pop();
						pee_cal.push(calc_result(a,b,temp));
					}
				}
				RESULT=pee_cal.pop();
				System.out.println();//결과는 두줄씩 띄어서 출력이다
				System.out.println(s_from_b(P)+" "+s_from_b(Q)+" "+s_from_b(RESULT));
			}
		}
		else//변수가 3개일때
		{
			System.out.println("P Q R RESULT");
			boolean[][] truth= {{true, true, true}, {true, true, false},
                    {true, false, true}, {true, false, false},
                    {false, true, true}, {false, true, false},
                    {false, false, true}, {false, false, false}};
			for(int j=0;j<8;j++)//변수가 3개면 결과값은 8개
			{
				P=truth[j][0];
				Q=truth[j][1];
				R=truth[j][2];
				boolean RESULT=false;//결과값
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//연산자라면
					{
						if(!cal.isEmpty())//비어있지않다면
						{
							if(cal.peek().equals(s1))//맨꼭대기에 있는게 부정연산일 경우
							{
								boolean temp=pee_cal.pop();
								pee_cal.push(!temp);
								cal.pop();
								boolean b=pee_cal.pop();
								boolean a=pee_cal.pop();
								String temp_temp=cal.pop();
								pee_cal.push(calc_result(a,b,temp_temp));
								cal.push(s[i]);
									
							}
							else//맨꼭대기에 있는게 부정연산이 아닐경우
							{
								if(s[i].equals(s1))//근데 넣으려는게 부정연산일경우
								{
									cal.push(s[i]);
								}
								else//넣으려는게 부정연산이 아닐경우
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//비어있다면
						{
							cal.push(s[i]);
						}
						
					}//연산자라면 연산자스택에 push
					else
					{
						pee_cal.push(b_from_s(s[i]));//피연산자에는 T,F만 집어넣는다
					}//피연산자라면 피연산자스택에 push
					
				}
				while(!cal.isEmpty())//연산자 스택이 빌 때 까지
				{
					String temp=cal.pop();
					if(temp.equals("n"))//나온게 부정연산이라면
					{
						boolean temp_temp=pee_cal.pop();
						pee_cal.push(!temp_temp);
						
					}
					else
					{
						boolean b=pee_cal.pop();
						boolean a=pee_cal.pop();
						pee_cal.push(calc_result(a,b,temp));
					}
				}
				RESULT=pee_cal.pop();
				System.out.println();//결과는 두줄씩 띄어서 출력이다
				System.out.println(s_from_b(P)+" "+s_from_b(Q)+" "+s_from_b(R)+" "+s_from_b(RESULT));
			}
		}
		

	}

}

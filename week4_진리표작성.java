package week4_����ǥ�ۼ�;
import java.util.*;
import java.io.*;
public class week4_����ǥ�ۼ� {

	public static String s_from_b(boolean b)//boolean���� string���� �ٲ��ش�
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
		if(op.equals("o"))//����
		{
			return a||b;
		}
		else if(op.equals("a"))//����
		{
			return a&&b;
		}
		else if(op.equals("i"))//�� ����
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
		int N=Integer.parseInt(s[0]);//������ ����
		int M=Integer.parseInt(s[1]);//�������� ����
		int K=Integer.parseInt(s[2]);
		Stack<String> cal=new Stack<String>();//������ ����
		Stack<Boolean> pee_cal=new Stack<Boolean>();//�ǿ����� ����
		String s1=new String("n");//��������
		String s2=new String("a");//����
		String s3=new String("o");//����
		String s4=new String("i");//������
		s=br.readLine().split(" ");
		boolean[] table=new boolean[N];
		if(N==1)
		{
			System.out.println("P RESULT");
			boolean[][] truth= {{true},{false}};
			for(int j=0;j<2;j++)
			{
				P=truth[j][0];
				boolean RESULT=false;//�����
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//�����ڶ��
					{
						if(!cal.isEmpty())//��������ʴٸ�
						{
							if(cal.peek().equals(s1))//�ǲ���⿡ �ִ°� ���������� ���
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
							else//�ǲ���⿡ �ִ°� ���������� �ƴҰ��
							{
								if(s[i].equals(s1))//�ٵ� �������°� ���������ϰ��
								{
									cal.push(s[i]);
								}
								else//�������°� ���������� �ƴҰ��
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//����ִٸ�
						{
							cal.push(s[i]);
						}
						
					}//�����ڶ�� �����ڽ��ÿ� push
					else
					{
						pee_cal.push(b_from_s(s[i]));//�ǿ����ڿ��� T,F�� ����ִ´�
					}//�ǿ����ڶ�� �ǿ����ڽ��ÿ� push
					
				}
				while(!cal.isEmpty())//������ ������ �� �� ����
				{
					String temp=cal.pop();
					if(temp.equals("n"))//���°� ���������̶��
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
				System.out.println();//����� ���پ� �� ����̴�
				System.out.println(s_from_b(P)+" "+s_from_b(RESULT));
				
				
			}
			
		}
		else if(N==2)
		{
			System.out.println("P Q RESULT");
			boolean[][] truth= {{true,true},{true,false},{false,true},{false,false}};
			for(int j=0;j<4;j++)//������ 2���� ������� 4��
			{
				P=truth[j][0];
				Q=truth[j][1];
				boolean RESULT=false;//�����
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//�����ڶ��
					{
						if(!cal.isEmpty())//��������ʴٸ�
						{
							if(cal.peek().equals(s1))//�ǲ���⿡ �ִ°� ���������� ���
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
							else//�ǲ���⿡ �ִ°� ���������� �ƴҰ��
							{
								if(s[i].equals(s1))//�ٵ� �������°� ���������ϰ��
								{
									cal.push(s[i]);
								}
								else//�������°� ���������� �ƴҰ��
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//����ִٸ�
						{
							cal.push(s[i]);
						}
						
					}//�����ڶ�� �����ڽ��ÿ� push
					else
					{
						pee_cal.push(b_from_s(s[i]));//�ǿ����ڿ��� T,F�� ����ִ´�
					}//�ǿ����ڶ�� �ǿ����ڽ��ÿ� push
					
				}
				while(!cal.isEmpty())//������ ������ �� �� ����
				{
					String temp=cal.pop();
					if(temp.equals("n"))//���°� ���������̶��
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
				System.out.println();//����� ���پ� �� ����̴�
				System.out.println(s_from_b(P)+" "+s_from_b(Q)+" "+s_from_b(RESULT));
			}
		}
		else//������ 3���϶�
		{
			System.out.println("P Q R RESULT");
			boolean[][] truth= {{true, true, true}, {true, true, false},
                    {true, false, true}, {true, false, false},
                    {false, true, true}, {false, true, false},
                    {false, false, true}, {false, false, false}};
			for(int j=0;j<8;j++)//������ 3���� ������� 8��
			{
				P=truth[j][0];
				Q=truth[j][1];
				R=truth[j][2];
				boolean RESULT=false;//�����
				for(int i=0;i<s.length;i++)
				{
					if(s[i].equals(s1)||s[i].equals(s2)||s[i].equals(s3)||s[i].equals(s4))//�����ڶ��
					{
						if(!cal.isEmpty())//��������ʴٸ�
						{
							if(cal.peek().equals(s1))//�ǲ���⿡ �ִ°� ���������� ���
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
							else//�ǲ���⿡ �ִ°� ���������� �ƴҰ��
							{
								if(s[i].equals(s1))//�ٵ� �������°� ���������ϰ��
								{
									cal.push(s[i]);
								}
								else//�������°� ���������� �ƴҰ��
								{
									String temp=cal.pop();
									boolean b=pee_cal.pop();
									boolean a=pee_cal.pop();
									pee_cal.push(calc_result(a,b,temp));
									cal.push(s[i]);
								}
							}
						}
						else//����ִٸ�
						{
							cal.push(s[i]);
						}
						
					}//�����ڶ�� �����ڽ��ÿ� push
					else
					{
						pee_cal.push(b_from_s(s[i]));//�ǿ����ڿ��� T,F�� ����ִ´�
					}//�ǿ����ڶ�� �ǿ����ڽ��ÿ� push
					
				}
				while(!cal.isEmpty())//������ ������ �� �� ����
				{
					String temp=cal.pop();
					if(temp.equals("n"))//���°� ���������̶��
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
				System.out.println();//����� ���پ� �� ����̴�
				System.out.println(s_from_b(P)+" "+s_from_b(Q)+" "+s_from_b(R)+" "+s_from_b(RESULT));
			}
		}
		

	}

}

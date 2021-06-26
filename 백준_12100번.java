import java.util.*;
import java.io.*;
public class ����_12100�� {
	public static int N;
	public static int[][] map;
	public static int max;
	public static void find_max()//�ϼ��� temp_map���� �ִ밪 ã��
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				max=Math.max(map[i][j],max);
			}
		}
	}
	public static void game(int count)
	{
		if(count==5)//5�� ����Ǿ�����
		{
			find_max();
			return;
		}
		int[][] temp_map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				temp_map[i][j]=map[i][j];//temp�ʿ� ��������
			}
		}
		left(count);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				map[i][j]=temp_map[i][j];
			}
		}
		right(count);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				map[i][j]=temp_map[i][j];
			}
		}
		up(count);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				map[i][j]=temp_map[i][j];
			}
		}
		down(count);
		
		
	}
	public static void left(int count)//�������� ����
	{
		for(int i=0;i<N;i++)
		{
			int index=0;
			int block=0;
			for(int j=0;j<N;j++)
			{
				if(map[i][j]!=0)
				{
					if(map[i][j]==block)
					{
							map[i][index-1]=block*2;
							map[i][j]=0;
							block=0;
					}
					else
					{
						block=map[i][j];
						map[i][j]=0;
						map[i][index]=block;
						index++;
					}
				}
			}
		}
		game(count+1);
	}
	public static void right(int count)//���������� ����
	{
		
		for(int i=0;i<N;i++)
		{
			int index=N-1;
			int block=0;
			for(int j=N-1;j>=0;j--)
			{
				if(map[i][j]!=0)
				{
					if(map[i][j]==block)
					{
							map[i][index+1]=block*2;
							map[i][j]=0;
							block=0;
					}
					else
					{
						block=map[i][j];
						map[i][j]=0;
						map[i][index]=block;
						index--;
					}
				}
			}
		}
		game(count+1);
	}
	public static void up(int count)//�������� ����
	{
		for(int i=0;i<N;i++)
		{
			int index=0;
			int block=0;
			for(int j=0;j<N;j++)
			{
				if(map[j][i]!=0)
				{
					if(map[j][i]==block)
					{
							map[index-1][i]=block*2;
							map[j][i]=0;
							block=0;
					}
					else
					{
						block=map[j][i];
						map[j][i]=0;
						map[index][i]=block;	
						index++;
					}
				}
			}
		}
		game(count+1);
	}
	public static void down(int count)//�Ʒ������� ����
	{
		for(int i=0;i<N;i++)
		{
			int index=N-1;
			int block=0;
			for(int j=N-1;j>=0;j--)
			{
				if(map[j][i]!=0)
				{
					if(map[j][i]==block)
					{
							map[index+1][i]=block*2;
							map[j][i]=0;
							block=0;
					}
					else
					{
						block=map[j][i];
						map[j][i]=0;
						map[index][i]=block;
						index--;
					}
				}
			}
		}
		game(count+1);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		game(0);
		System.out.println(max);
	}
}
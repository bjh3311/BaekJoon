import java.util.*;
import java.io.*;

public class 백준_17281번 {

	public static int[][] inf;//안타 정보
	public static int N;
	public static boolean[] visited =new boolean[8];
	public static int result =Integer.MIN_VALUE;
	public static int[] arr=new int[8];
	public static boolean[] base;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		inf = new int[N][9];
		String[] s;
		for(int i = 0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j = 0;j<9;j++)
			{
				inf[i][j]=Integer.parseInt(s[j]);
			}
		}
		mut(0);
		System.out.println(result);
	}
	public static void mut(int n)
	{
		if(n==8)
		{
			play();
			return;
		}
		for(int i=0;i<8;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				arr[n]=i+1;
				mut(n+1);
				visited[i]=false;
			}
		}
	}
	public static void play()
	{
		int temp = 0;
		int out =0;
		int index = 0;//몇 번 타자인지
		int n =0;//현재 타자가 무엇을 치는지
		for(int i=0;i<N;i++)//i는 몇이닝인지
		{
			base = new boolean[3];
			out = 0;
			while(out<3)//한 이닝을 다 진행시킨다
			{
				index = index%9;
				if(index<3)
				{
					n = inf[i][arr[index]];
				}
				else if(index == 3)//4번타자는
				{
					n= inf[i][0];//무조건 1번선수
				}
				else
				{
					n = inf[i][arr[index-1]];
				}
				if(n==0)
				{
					out++;
				}
				else
				{
					temp = temp+move(n);
				}
				index++;
			}
		}
		result = Math.max(result, temp);
		return;
	}
	public static int move(int act)
	{
		int score=0;
		if(act == 4)
		{
			for(int i=0;i<3;i++)
			{
				if(base[i])
				{
					base[i]=false;
					score++;
				}
			}
			score++;
		}
		else
		{
			for(int i=0;i<act;i++)
			{
				if(base[2])
				{
					base[2]=false;
					score++;
				}
				if(base[1])
				{
					base[1]=false;
					base[2]=true;
				}
				if(base[0])
				{
					base[0]=false;
					base[1]=true;
				}
			}
			base[act-1]=true;//타자를 옮긴다
		}
		return score;
	}
}

import java.util.*;
import java.io.*;
class Dice{
	int top,bottom,west,east,south,north;
	public Dice() {
		this.top=0;
		this.bottom=0;
		this.west=0;
		this.east=0;
		this.north=0;
		this.south=0;
	}
	public void moveWest()
	{
		int temp=top;
		top=east;
		east=bottom;
		bottom=west;
		west=temp;
	}
	public void moveEast()
	{
		int temp=top;
		top=west;
		west=bottom;
		bottom=east;
		east=temp;
		
	}
	public void moveNorth()
	{
		int temp=top;
		top=south;
		south=bottom;
		bottom=north;
		north=temp;
		
	}
	public void moveSouth()
	{
		int temp=top;
		top=north;
		north=bottom;
		bottom=south;
		south=temp;
	}
}
public class 백준_14499번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);//지도의 크기 N,M
		int y=Integer.parseInt(s[2]);
		int x=Integer.parseInt(s[3]);//시작점 x,y좌표
		int K=Integer.parseInt(s[4]);//명령의 개수
		int[][] map=new int[N][M];//지도
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}//맵 입력
		s=br.readLine().split(" ");
		int[] order=new int[K];
		Dice dice=new Dice();
		for(int i=0;i<K;i++)
		{
			order[i]=Integer.parseInt(s[i]);
		}//명령 입력받기
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++)
		{
			if(order[i]==1)//동쪽
			{
				if(x+1>=M)
				{
					continue;
				}
				x=x+1;
				if(x<M&&x>=0&&y<N&&y>=0)//범위 안에 있어야 한다.
				{
					if(map[y][x]==0)
					{
						dice.moveEast();
						map[y][x]=dice.bottom;
						sb.append(dice.top+"\n");
					}
					else
					{
						dice.moveEast();
						dice.bottom=map[y][x];
						map[y][x]=0;
						sb.append(dice.top+"\n");
					}
				}
				
			}
			else if(order[i]==2)//서쪽
			{
				if(x-1<0)
				{
					continue;
				}
				x=x-1;
				if(x<M&&x>=0&&y<N&&y>=0)//범위 안에 있어야 한다.
				{
					if(map[y][x]==0)
					{
						dice.moveWest();
						map[y][x]=dice.bottom;
						sb.append(dice.top+"\n");
					}
					else
					{
						dice.moveWest();
						dice.bottom=map[y][x];
						map[y][x]=0;
						sb.append(dice.top+"\n");
					}
				}
			}
			else if(order[i]==3)//북쪽
			{
				if(y-1<0)
				{
					continue;
				}
				y=y-1;
				if(x<M&&x>=0&&y<N&&y>=0)//범위 안에 있어야 한다.
				{
					if(map[y][x]==0)
					{
						dice.moveNorth();
						map[y][x]=dice.bottom;
						sb.append(dice.top+"\n");
					}
					else
					{
						dice.moveNorth();
						dice.bottom=map[y][x];
						map[y][x]=0;
						sb.append(dice.top+"\n");
					}
				}
			}
			else if(order[i]==4)//남쪽
			{
				if(y+1>=N)
				{
					continue;
				}
				y=y+1;
				if(x<M&&x>=0&&y<N&&y>=0)//범위 안에 있어야 한다.
				{
					if(map[y][x]==0)
					{
						dice.moveSouth();
						map[y][x]=dice.bottom;
						sb.append(dice.top+"\n");
					}
					else
					{
						dice.moveSouth();
						dice.bottom=map[y][x];
						map[y][x]=0;
						sb.append(dice.top+"\n");
					}
				}
			}
		}
		System.out.print(sb.toString());
	}
}

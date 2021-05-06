import java.util.*;
import java.io.*;
class loc//위치를 나타내는 객체
{
	int y;
	int x;
	public loc(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class 백준_15686번 {
	static int result;//결과값
	static boolean[] visited;
	static int M;
	static int N;
	static int[][] map;
	static ArrayList<loc> house;//집의 위치를 나타내는 ArrayList
	static ArrayList<loc> chi;
	public static void backtrack(int start,int count)
	{
		if(count==M)//최대 M개에 도달하면 치킨거리 계산시작
		{
			DFS();
			return;
		}
		//열어둘 M개의 치킨집을 찾는과정
		for(int i=start;i<chi.size();i++)
		{
			visited[i]=true;//true이면 이번 계산에서 확인할 M개의 치킨집 중 하나라는 뜻
			backtrack(i+1,count+1);//i+1로 다음backtrack을 시작함으로써 시간단축
			visited[i]=false;
		}
	}
	public static void DFS()
	{
		int temp_result=0;
		for(int i=0;i<house.size();i++)//집들의 위치를 확인한다
		{
			int min=Integer.MAX_VALUE;
			for(int j=0;j<chi.size();j++)
			{
				if(visited[j])//true이면 M개의 치킨집중 하나라는 뜻
				{
					int dis=Math.abs(house.get(i).x-chi.get(j).x)+Math.abs(house.get(i).y-chi.get(j).y);	
					min=Math.min(min,dis);
				}
			}
			temp_result=temp_result+min;
		}
		result=Math.min(result, temp_result);//temp_map에서의 치킨거리와 결과치킨거리중 작은값으로 결과치킨값을 갱신
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);//최대 개수
		map=new int[N][N];
		house=new ArrayList<loc>();
		chi=new ArrayList<loc>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1)//집의 위치를 넣어준다
				{
					house.add(new loc(i,j));
				}
				else if(map[i][j]==2)
				{
					chi.add(new loc(i,j));
				}
			}
		}
		visited=new boolean[chi.size()];
		result=Integer.MAX_VALUE;//일단 최대값으로 정해놓는다.
		backtrack(0,0);
		System.out.println(result);
		br.close();
	}
}

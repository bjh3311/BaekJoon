import java.util.*;
import java.io.*;

public class 백준_1525번 {

	public static HashMap<String,Integer> map=new HashMap<String,Integer>();
	//맵에 담겨져 있는지 아닌지로 방문처리
	public static String correct="123456780";
	public static int[] dy= {-1,0,1,0};
	public static int[] dx= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String init="";
		String[] s;
		for(int i=0;i<3;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<3;j++)
			{	
				init=init+s[j];
			}
		}
		map.put(init, 0);
		System.out.println(BFS(init));
	}
	public static int BFS(String init)
	{
		Queue<String> q=new LinkedList<String>();
		q.add(init);
		while(!q.isEmpty())
		{
			
			String now=q.poll();
			int now_move=map.get(now);//현재까지 움직임 카운트
			int index=now.indexOf('0');
			int y=index/3;//현재 빈칸의 y좌표
			int x=index%3;//현재 빈칸의 x좌표
			if(now.equals(correct))//만약 정렬이 되어 있다면
			{
				return now_move;
			}
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(ny<0||ny>2||nx<0||nx>2)//다음 움직일 위치가 맵에서 벗어나면 continue
				{
					continue;
				}
				int next_index=(ny*3)+nx;
				char temp=now.charAt(next_index);
				String next=now.replace(temp, 'c');
				next=next.replace('0', temp);
				next=next.replace('c', '0');
				if(!map.containsKey(next))
				{
					q.add(next);
					map.put(next, now_move+1);
				}
			}
		}
		return -1;
	}
}

import java.util.*;
import java.io.*;
class Node
{
	int y;
	int x;
	Node(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
class Head
{
	int y;
	int x;
	int dir;//0이면 오른쪽, 1이면 왼쪽, 2이면 아래,3이면 위
	Head(int y,int x,int dir)
	{
		this.y=y;
		this.x=x;
		this.dir=dir;
	}
}
public class 백준_3190번 {

	public static int[] dy = {0,1,0,-1};
	public static int[] dx = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		String[] s;
		int[][] map = new int[N+1][N+1];//맵에 사과 체크
		for(int i=0;i<K;i++)//맵에 사과 체크
		{
			s = br.readLine().split(" ");
			map[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1]=1;
		}
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer,String> hashmap = new HashMap<Integer,String>();
		for(int i =0 ;i<L;i++)
		{
			s = br.readLine().split(" ");
			hashmap.put(Integer.parseInt(s[0]), s[1]);
		}
		map[0][0]=2;//2는 뱀의 몸통
		Deque<Node> dq = new ArrayDeque<Node>();//뱀의 몸통위치 덱
		dq.addFirst(new Node(0,0));
		int result = 0 ;//한턴 진행될떄마다 +1
		Queue<Head> q = new LinkedList<Head>();
		q.add(new Head(0,0,0));
		while(!q.isEmpty())
		{
			result++;
			Head temp = q.poll();
			int dir = temp.dir;
			int ny = temp.y+dy[dir];
			int nx = temp.x+dx[dir];
			if(nx>=N||nx<0||ny>=N||ny<0||map[ny][nx]==2)
			{
				break;
			}//벽이 있거나 뱀의 몸이 있다면 break
			if(map[ny][nx]==0)//사과가 없다면 꼬리를 없애줘야한다
			{
				Node rmnode = dq.removeFirst();
				map[rmnode.y][rmnode.x]=0;
			}
			dq.addLast(new Node(ny,nx));
			map[ny][nx]=2;//머리가 진행된 곳은 2로 체크해준다
			if(hashmap.containsKey(result))//방향 전환을 해줘야 한다면
			{
				if("L".equals(hashmap.get(result)))//왼쪽방향 전환
				{		
					q.add(new Head(ny,nx,(dir+3)%4));
				}
				else//오른쪽 방향 전환
				{
					q.add(new Head(ny,nx,(dir+1)%4));
				}
			}
			else// 방향 전환 없을 때
			{
				q.add(new Head(ny,nx,dir));
			}
		}
		System.out.println(result);
	}
}
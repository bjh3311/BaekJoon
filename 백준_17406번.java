import java.util.*;
import java.io.*;
public class 백준_17406번 {

	public static int N;
	public static int M;
	public static int result = Integer.MAX_VALUE;
	public static int K;
	public static ArrayList<Integer>[] arr ;//회전연산 리스트
	public static boolean[] visited;
	public static int[][] map;
	public static int[][] copy_map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		K=Integer.parseInt(s[2]);
		map=new int[N][M];
		for(int i =0;i<N;i++)//맵 입력
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		arr=new ArrayList[K];
		visited=new boolean[K];
		for(int i=0;i<K;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<K;i++)
		{
			s=br.readLine().split(" ");
			int r=Integer.parseInt(s[0]);
			int c=Integer.parseInt(s[1]);
			int a=Integer.parseInt(s[2]);
			arr[i].add(r);
			arr[i].add(c);
			arr[i].add(a);
		}
		result = Integer.MAX_VALUE;
		int[] list =new int[K];
		mut(0,list);
		System.out.println(result);
	}
	
	public static void cal(int[][] temp_map)//배열 값 찾기
	{
		for(int i=0;i<N;i++)
		{
			int temp = 0;
			for(int j=0;j<M;j++)
			{
				temp=temp+temp_map[i][j];
			}
			result=Math.min(temp, result);
		}
	}
	public static void rotate(int[] list)//회전함수
	{
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] tmp = copy();
		for(int n=0;n<K;n++)
		{
			int r = arr[list[n]].get(0);
			int c = arr[list[n]].get(1);
			int s = arr[list[n]].get(2);
			for(int i=1;i<=s;i++)
			{
				for(int j=0;j<2*i;j++)//왼쪽 위부터 시계방향으로 큐에 추가
				{
					q.add(tmp[r-i-1][c-i-1+j]);
					q.add(tmp[r-i-1+j][c+i-1]);
					q.add(tmp[r+i-1][c+i-1-j]);
					q.add(tmp[r+i-1-j][c-i-1]);
				}
				for(int j=0;j<2*i;j++)//값 넣어주기
				{
					tmp[r-i-1][c-i-1+j+1]=q.poll();
					tmp[r-i-1+j+1][c+i-1]=q.poll();
					tmp[r+i-1][c+i-1-j-1]=q.poll();
					tmp[r+i-1-j-1][c-i-1]=q.poll();
				}			
			}
		}
		cal(tmp);
	}
	public static void mut(int n,int[] list)
	{
		if(n==K)//K개를 다 골랐다면
		{
			rotate(list);
			return;
		}
		for(int i=0;i<K;i++)
		{	
			if(!visited[i])
			{
				visited[i]=true;
				list[n]=i;
				mut(n+1,list);
				visited[i]=false;
			}
		}
	}
	public static int[][] copy()
	{
		int[][] tmp = new int[N][M];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				tmp[i][j]=map[i][j];
			}
		}
		return tmp;
	}
}
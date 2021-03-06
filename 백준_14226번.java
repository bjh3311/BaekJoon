import java.util.*;
public class 백준_14226번 {
	public static int S;
	public static int[][] visited; 
	public static void BFS()
	{
		Queue<Integer> q=new LinkedList<Integer>();
		visited[1][0]=0;//처음 위치는 0
		q.add(1);//처음 이모티콘 개수 1개
		q.add(0);//클립보드에는 0
		while(!q.isEmpty())//q가 빌 때까지
		{
			int s=q.poll();//이모티콘 개수
			int c=q.poll();//클리보드에 저장되어있는 이모티콘 개수
			if(visited[s][s]==-1)//클립보드에 복사연산
			{
				visited[s][s]=visited[s][c]+1;
				q.add(s);
				q.add(s);
			}
			if(s-1>=0&&visited[s-1][c]==-1)//삭제연산
			{
				q.add(s-1);
				q.add(c);//클립보드 개수는 그대로
				visited[s-1][c]=visited[s][c]+1;
			}
			if(s+c<=S&&visited[s+c][c]==-1)
			{
				q.add(s+c);
				q.add(c);//클리보드에 저장되어잇는 이모티콘 개수는 동일
				visited[s+c][c]=visited[s][c]+1;
			}
			
		}
		int ans=-1;
		for(int i=0;i<=S;i++)
		{
			if(visited[S][i]!=-1)
			{
				if(ans==-1||ans>visited[S][i])
				{
					ans=visited[S][i];
				}
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		S=scan.nextInt();
		visited=new int[S+2][S+2];
		for(int i=0;i<=S;i++)
		{
			Arrays.fill(visited[i], -1);//visited를 -1로 초기화
		}
		BFS();
	}

}

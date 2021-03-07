import java.util.*;
public class 백준_5014번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int F,S,G,U,D;
		F=scan.nextInt();//건물 높이
		S=scan.nextInt();//내가 있는곳
		G=scan.nextInt();//목표
		U=scan.nextInt();//엘베로 올라갈 수 있는 층수
		D=scan.nextInt();//엘베로 내려갈 수 있는 층수
		Queue<Integer> q=new LinkedList<Integer>();
		int[] result=new int[F+1];
		Arrays.fill(result, -2);//모든 층을 -1로 초기화
		boolean[] visited=new boolean[F+1];
		q.add(S);
		visited[S]=true;
		result[S]=0;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			if(temp+U<=F&&!visited[temp+U])
			{
				result[temp+U]=result[temp]+1;
				q.add(temp+U);
				visited[temp+U]=true;
			}
			if(temp-D>0&&!visited[temp-D])
			{
				result[temp-D]=result[temp]+1;
				q.add(temp-D);
				visited[temp-D]=true;
			}
		}
	    if(result[G]==-2)
	    {
	    	System.out.println("use the stairs");
	    }
	    else
	    {
	    	System.out.println(result[G]);
	    }
		

	}

}

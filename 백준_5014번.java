import java.util.*;
public class ����_5014�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int F,S,G,U,D;
		F=scan.nextInt();//�ǹ� ����
		S=scan.nextInt();//���� �ִ°�
		G=scan.nextInt();//��ǥ
		U=scan.nextInt();//������ �ö� �� �ִ� ����
		D=scan.nextInt();//������ ������ �� �ִ� ����
		Queue<Integer> q=new LinkedList<Integer>();
		int[] result=new int[F+1];
		Arrays.fill(result, -2);//��� ���� -1�� �ʱ�ȭ
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

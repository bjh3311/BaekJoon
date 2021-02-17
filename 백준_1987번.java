import java.util.Scanner;
public class ����_1987�� {
	public static int R;
	public static int C;
	public static char[][] arr;
	public static char[] visited=new char[400];
	public static int result=0;
	public static void dfs(int x,int y,int n)
	{
		if(x>=0&&y>=0&&x<R&&y<C)
		{
			
			for(int i=0;i<n;i++)
			{
				if(arr[x][y]==visited[i])
				{
					return;//arr[x][y]�� �ִ� ���ڰ� visited�迭�� �ִٸ� ���α׷� ����
				}
			}
			if(result<n+1)
			{
				result=n+1;
			}
			visited[n]=arr[x][y];//visited�迭�� �湮�� ���ĺ� �Է�
			dfs(x+1,y,n+1);
			dfs(x-1,y,n+1);
			dfs(x,y+1,n+1);
			dfs(x,y-1,n+1);//�����¿� �� Ȯ��
			visited[n]=0;
		}			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		R=scan.nextInt();
		C=scan.nextInt();
		scan.nextLine();//���๮�� ����
		arr=new char[R][C];
		visited=new char[R*C];
	    for(int i=0;i<R;i++)
	    {
	    	String s=scan.nextLine();
	    	for(int j=0;j<C;j++)
	    	{
	    		arr[i][j]=s.charAt(j);
	    	}
	    }
	    dfs(0,0,0);
	    System.out.println(result);
	}
	

}

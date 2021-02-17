import java.util.Scanner;
public class 백준_1987번 {
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
					return;//arr[x][y]에 있는 문자가 visited배열에 있다면 프로그램 종료
				}
			}
			if(result<n+1)
			{
				result=n+1;
			}
			visited[n]=arr[x][y];//visited배열에 방문한 알파벳 입력
			dfs(x+1,y,n+1);
			dfs(x-1,y,n+1);
			dfs(x,y+1,n+1);
			dfs(x,y-1,n+1);//상하좌우 다 확인
			visited[n]=0;
		}			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		R=scan.nextInt();
		C=scan.nextInt();
		scan.nextLine();//개행문자 제거
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

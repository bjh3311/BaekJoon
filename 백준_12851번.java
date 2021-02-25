import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 백준_12851번 {
	public static int N;
	public static int K;
	public static int[][] arr=new int[100001][2];//arr에는 몇 초를 저장
	public static boolean[] visited=new boolean[100001];
	public static Queue<Integer> q=new LinkedList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		K=scan.nextInt();
		q.add(N);
    	visited[N]=true;
    	arr[N][0]=0;
    	arr[N][1]=1;
    	while(!q.isEmpty())
    	{
    		int temp=q.poll();
    		if(temp==K)
    		{
    			System.out.println(arr[temp][0]);
    			System.out.println(arr[temp][1]);
    			System.exit(0);//프로그램 종료
    		}
    		if(temp-1>=0&&temp-1<=100000)
    		{
    			if(!visited[temp-1])//처음 방문했을때
    			{
    				visited[temp-1]=true;
        			arr[temp-1][0]=arr[temp][0]+1;
        			arr[temp-1][1]=arr[temp][1];
        			q.add(temp-1);
    			}
    			else//처음 방문한게 아닐때
    			{
    			     if(arr[temp-1][0]==arr[temp][0]+1)
    			     {
    			    	 arr[temp-1][1]+=arr[temp][1];
    			     }
    			}
    		}
    		if(temp+1>=0&&temp+1<=100000)
    		{
    			if(!visited[temp+1])//처음 방문했을때
    			{
    				visited[temp+1]=true;
        			arr[temp+1][0]=arr[temp][0]+1;
        			arr[temp+1][1]=arr[temp][1];
        			q.add(temp+1);
    			}	
    			else//처음 방문한게 아닐때
    			{
    				if(arr[temp+1][0]==arr[temp][0]+1)
    				{
    				     arr[temp+1][1]+=arr[temp][1];
    				}
    			}
    		}
    		if(2*temp>=0&&2*temp<=100000)
    		{
    			if(!visited[temp*2])//처음 방문했을때
    			{
    				visited[temp*2]=true;
        			arr[temp*2][0]=arr[temp][0]+1;
        			arr[temp*2][1]=arr[temp][1];
        			q.add(temp*2);
    			}
    			else//처음 방문한게 아닐때
    			{
    				if(arr[temp*2][0]==arr[temp][0]+1)
    				{
    					arr[temp*2][1]+=arr[temp][1];
    				}
    			}
    		}
    	}
	}

}
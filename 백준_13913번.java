import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.*;
public class ����_13913�� {
	public static int N;
	public static int K;
	public static int[][] arr=new int[100001][2];//arr���� �� �ʸ� ����
	public static boolean[] visited=new boolean[100001];
	public static Queue<Integer> q=new LinkedList<Integer>();
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		K=scan.nextInt();
		if(N==K)
		{
			System.out.println(0);
			System.out.print(K);
			System.exit(0);
		}//����ó��
		if(Math.abs(N-K)==1)
		{
			if(N<K)
			{
				System.out.println(1);
				System.out.print(N+" "+K);
			}
			else
			{
				System.out.print(1);
				System.out.print(K+" "+N);
			}
			System.exit(0);
		}//����ó��
		q.add(N);
    	visited[N]=true;
    	arr[N][0]=0;
    	while(!q.isEmpty())
    	{
    		int temp=q.poll();
    		if(temp==K)
    		{
    			System.out.println(arr[temp][0]);
    			while(arr[temp][1]!=N)
    			{
    				sb.append(arr[temp][1]+" ");
    				temp=arr[temp][1];//���� ����
    			}
    			String[] s=sb.toString().split(" ");
    			bw.write(N+" ");//���ۺκ�
    			for(int i=s.length-1;i>=0;i--)
    			{
    				bw.write(s[i]+" ");
    			}
    			bw.write(K+"");
    			bw.flush();
    			bw.close();
    			System.exit(0);//���α׷� ����
    		}
    		if(temp-1>=0&&temp-1<=100000)
    		{
    			if(!visited[temp-1])//ó�� �湮������
    			{
    				visited[temp-1]=true;
        			arr[temp-1][0]=arr[temp][0]+1;
        			arr[temp-1][1]=temp;
        			q.add(temp-1);
    			}			
    		}
    		if(temp+1>=0&&temp+1<=100000)
    		{
    			if(!visited[temp+1])//ó�� �湮������
    			{
    				visited[temp+1]=true;
        			arr[temp+1][0]=arr[temp][0]+1;
        			arr[temp+1][1]=temp;
        			q.add(temp+1);
    			}			
    		}
    		if(2*temp>=0&&2*temp<=100000)
    		{
    			if(!visited[temp*2])//ó�� �湮������
    			{
    				visited[temp*2]=true;
        			arr[temp*2][0]=arr[temp][0]+1;
        			arr[temp*2][1]=temp;
        			q.add(temp*2);
    			}
    		}
    	}
	}
}
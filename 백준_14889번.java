import java.io.*;
public class ����_14889�� {
	public static int[][] arr;//��ü �ɷ�ġ �迭 ����
	public static int min;
	public static int N;
	public static int[] visited;
	public static int[] result;
	public static int[][] com=new int[21][21];
	public static int[] index;//�������� ��������� �ִ� �迭
	public static int[] index_2;//�������� ��������� �ִ� �迭
	public static StringBuilder sb1=new StringBuilder();
	public static StringBuilder sb2=new StringBuilder();
	public static int Pas(int n,int k)
	{
		if(n==k||k==0)
		{
			com[n][k]=1;
		}
		else
		{
			if(com[n][k]==0)
			{
				com[n][k]=(Pas(n-1,k)+Pas(n-1,k-1));
			}
		}
		return com[n][k];
	}//������ȹ���� �̿��� ������ �� ���
	public static void dfs(int count)
	{
		if(count==N/2)
		{
			for(int i=0;i<N/2;i++)
			{
				sb1.append(result[i]+" ");
			}
			for(int i=0;i<N;i++)
			{
				if(visited[i]==0)
				{
					sb2.append(i+1);
					sb2.append(" ");
				}
			}			
			return;
		}
		else if(count==0)
		{
			for(int i=0;i<N;i++)
			{		
	        	if(visited[i]!=1)
	        	{   	
	        			visited[i]=1;
	           			result[count]=i+1;
	           			dfs(count+1);
	            		visited[i]=0;			
	        	}
	   	    }	
		}
		else
		{
			for(int i=0;i<N;i++)
			{		
	        	if(visited[i]!=1)
	        	{   
	        		if(i+1>result[count-1])
	        		{
	        			visited[i]=1;
	           			result[count]=i+1;
	           			dfs(count+1);
	            		visited[i]=0;
	        		}
	       			
	        	}
	   	    }	
		}
		
	}
	public static int calc(int[] index)
	{
		int sum=0;
		for(int i=0;i<N/2;i++)
		{
			for(int j=0;j<N/2;j++)
			{
				if(i!=j)
				{
					sum+=arr[index[i]-1][index[j]-1];
				}
			}
		}
		return sum;
	}//�������� ������ �������� �� �ɷ�ġ ���
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}//�ɷ�ġ�� �Է�
		index=new int[N/2];
		index_2=new int[N/2];
		for(int i=0;i<N/2;i++)
		{
			index[i]=i+1;
		}//index�� 123...�Է�
		for(int i=0;i<N/2;i++)
		{
			index_2[i]=N/2+i+1;
		}//index_2�� 456....�Է�
		min=Math.abs(calc(index)-calc(index_2));//�ʱ� �ּҰ� ���
		com[1][0]=1;
		com[1][0]=1;
		int a=Pas(N,N/2);//N���� N/2�� �̴� ������ ����
		visited=new int[N];
		result=new int[N];
		dfs(0);
		String[] s1=sb1.toString().split(" ");
		String[] s2=sb2.toString().split(" ");
		int count=0;
		int num=1;
		while(num<=a)
		{
			for(int j=0;j<N/2;j++)
			{
				index[j]=Integer.parseInt(s1[j+count]);
				index_2[j]=Integer.parseInt(s2[j+count]);
			}
			count=count+(N/2);
			num++;
			min=Math.min(min, Math.abs(calc(index)-calc(index_2)));		
	    }
		System.out.println(min);
		br.close();		
	}

}

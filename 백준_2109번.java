import java.util.*;
import java.io.*;
public class ����_2109�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][2];
		for(int i=0;i<n;i++)
		{
			String[] s=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(s[0]);
			arr[i][1]=Integer.parseInt(s[1]);
		}
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int[] o1,int[] o2)
			{
				if(o2[0]==o1[0])
				{
					return o2[1]-o2[1];
				}
				else
				{
					return o2[0]-o1[0];
				}
				
			}
		});//���Ƿ� �������� ����
		int ans=0;
		boolean[] visited=new boolean[10001];
		visited[0]=true;
		for(int i=0;i<n;i++)
		{
			int a=arr[i][1];
		    for(int j=a;j>=0;j--)//����ִ� �ڸ��� �ִ��� Ȯ��
		    {
		    	if(!visited[j])
				{
					ans+=arr[i][0];
					visited[j]=true;
					break;
				}
		    }
		}
		System.out.println(ans);
	}
}

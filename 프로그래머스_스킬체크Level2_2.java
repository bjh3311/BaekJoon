import java.util.*;
import java.io.*;

public class 프로그래머스_스킬체크Level2_2 {

	public static boolean one_sq(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 1인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==0)
				{
					return false;//0이 있으면 false 반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static boolean zero_sq(int[][] arr,int i,int j,int N)//주어진 사각형이 전부 0인지 확인
	{
		for(int a=i;a<i+N;a++)
		{
			for(int b=j;b<j+N;b++)
			{
				if(arr[a][b]==1)
				{
					return false;//1이 있으면 false반환
				}
			}
		}
		return true;//for문을 문제없이 다 실행하면 true반환
	}
	public static int zero=0;
	public static int one=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		int size=arr[0].length;
		divide(arr,0,0,size);
		System.out.println(zero+" "+one);
	}
	public static void divide(int[][] arr,int i,int j,int N)
    {
       if(N==1)
       {
    	   if(arr[i][j]==1)
    	   {
    		   one++;
    	   }
    	   else
    	   {
    		   zero++;
    	   }
       }
       else
       {
    	   if(one_sq(arr,i,j,N))
    	   {
    		   one++;
    	   }
    	   else if(zero_sq(arr,i,j,N))
    	   {
    		   zero++;
    	   }
    	   else
    	   {
    		   divide(arr,i,j,N/2);//왼쪽위
    		   divide(arr,i+(N/2),j,N/2);//오른쪽위
    		   divide(arr,i,j+(N/2),N/2);//왼쪽아래
    		   divide(arr,i+(N/2),j+(N/2),N/2);//오른쪽아래
    	   }
       }
    }
}

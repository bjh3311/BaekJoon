import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 백준_10830번 {
    public static int[][] init;
	public static int[][] arr;
	public static int[][] temp;
	public static int N;
	public static void divide(long B)
	{
		if(B==1)
		{
			//B는 1이면 아무것도 안함
		}
	    else if(B==2)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					temp[i][j]=arr[i][j];//temp에다가 arr복사
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					arr[i][j]=0;//arr값 초기화
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					for(int k=0;k<N;k++)
					{
						arr[i][j]+=(temp[i][k]*temp[k][j])%1000;//mod연산
					}
				}
			}//arr에다가 arr^2저장
		}
		else if(B%2==0)//짝수면
		{
			divide(B/2);
			divide(2);	
		}
		else//홀수면
		{
			divide(B/2);
			divide(2);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					temp[i][j]=arr[i][j];//temp에다가 arr복사
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					arr[i][j]=0;//arr값 초기화
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					for(int k=0;k<N;k++)
					{
						arr[i][j]+=(temp[i][k]*init[k][j])%1000;//mod연산
					}
				}
			}//arr에다가 arr^2저장
			
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		long B=Long.parseLong(s[1]);
        arr=new int[N][N];
        temp=new int[N][N];
        init=new int[N][N];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				init[i][j]=arr[i][j];
			}
		}//arr의 원래상태 저장
		divide(B);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(arr[i][j]%1000+" ");
			}
			System.out.println();
		}
       

	}

}
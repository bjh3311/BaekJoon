import java.util.*;
public class 백준_1744번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		Arrays.sort(arr);
		int ans=0;
		for(int i=N-1;i>=0;i--)
		{
			if(arr[i]<0)
			{
				break;
			}
			if(i==0)
			{
				ans+=arr[i];
				break;
			}	
			if(arr[i]*arr[i-1]>arr[i]+arr[i-1])
			{
				ans+=arr[i]*arr[i-1];
				i--;
			}
			else
			{
				ans+=arr[i];
			}		
		}//양수끼리
		for(int i=0;i<N;i++)
		{
			if(arr[i]>0)
			{
				break;
			}
			if(i==N-1)
			{
				ans+=arr[i];
				break;
			}
			if(arr[i]<0&&arr[i+1]<0)
			{
				ans+=arr[i]*arr[i+1];
				i++;
			}
			else if(arr[i]<0&&arr[i+1]>0)
			{
				ans+=arr[i];
			}
		}//음수끼리
		System.out.println(ans);	
	}
}

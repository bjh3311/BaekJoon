import java.util.*;
public class 백준_2437번 {

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
		int sum=0;
		for(int i=0;i<N;i++)
		{
			if(sum<arr[i]-1)
			{
				System.out.println(sum+1);
				System.exit(0);
			}
			sum+=arr[i];
		}
		System.out.println(sum+1);//만약 끝까지 갔다면
	}

}

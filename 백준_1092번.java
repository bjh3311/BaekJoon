import java.util.*;
public class 백준_1092번 {

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
		int M=scan.nextInt();
		int[] box=new int[M];
		for(int i=0;i<M;i++)
		{
			box[i]=scan.nextInt();
		}
		Arrays.sort(box);
		for(int i=0;i<M;i++)
		{
			if(box[i]>arr[N-1])//만약 박스중에 크레인이 들 수 있는 무게보다 무거운게있다면
			{
				System.out.println("-1");
				System.exit(0);//-1을 출력하고 프로그램 종료
			}				
		}
		int count=0;//걸리는 시간
		while(true)
		{
			int index=0;
			for(int i=0;i<M;i++)
			{
				if(box[i]!=5000000)
				{
					index++;
					break;
				}
			}
			if(index==0)
			{
				break;
			}//모든 박스를 옮겼는지 확인한다.
			for(int i=N-1;i>=0;i--)
			{
				for(int j=M-1;j>=0;j--)
				{
					if(arr[i]>=box[j])
					{
						box[j]=5000000;
						break;
					}
				}
			}
			count++;
		}
		
		System.out.println(count);

	}

}

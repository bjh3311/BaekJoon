import java.util.*;
public class ����_1092�� {

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
			if(box[i]>arr[N-1])//���� �ڽ��߿� ũ������ �� �� �ִ� ���Ժ��� ���ſ���ִٸ�
			{
				System.out.println("-1");
				System.exit(0);//-1�� ����ϰ� ���α׷� ����
			}				
		}
		int count=0;//�ɸ��� �ð�
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
			}//��� �ڽ��� �Ű���� Ȯ���Ѵ�.
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

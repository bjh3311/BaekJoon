import java.util.*;
public class ����_1068�� {

	public static int leaf=0;
	public static int Erase;
	public static ArrayList<Integer>[] arr;
	public static void DFS(int n)
	{
		if(arr[n].size()==0)//�ڽ� ��尡 ���ٸ� leaf�� ����
		{
			leaf++;
		}
		for(int i=0;i<arr[n].size();i++)
		{
			if(arr[n].get(i)!=Erase)//������ �Ǵ� ��尡 �ƴҽÿ� DFS�ǽ�
			{
				DFS(arr[n].get(i));
			}
			else
			{
				if(arr[n].size()==1&&arr[arr[n].get(i)].size()==0)
				{
					leaf++;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		int root=0;
		for(int i=0;i<N;i++)
		{
			int a=sc.nextInt();
			if(a==-1)
			{
				root=i;//�θ� ��尡 ������ root����̴�
			}
			else
			{
				arr[a].add(i);
			}
		}
		Erase=sc.nextInt();
		DFS(root);//root������ �����Ѵ�
		if(Erase==root)//root��带 ����ٸ� 0�� ����ϰ� �ý��� ����
		{
			System.out.println("0");
			System.exit(0);
		}
		if(leaf==0)
		{
			System.out.println("1");
			System.exit(0);
		}
		System.out.println(leaf);//���� ��� ���
		
	}

}

import java.util.*;
public class 백준_1068번 {

	public static int leaf=0;
	public static int Erase;
	public static ArrayList<Integer>[] arr;
	public static void DFS(int n)
	{
		if(arr[n].size()==0)//자식 노드가 없다면 leaf값 증가
		{
			leaf++;
		}
		for(int i=0;i<arr[n].size();i++)
		{
			if(arr[n].get(i)!=Erase)//지워야 되는 노드가 아닐시에 DFS실시
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
				root=i;//부모 노드가 없을시 root노드이다
			}
			else
			{
				arr[a].add(i);
			}
		}
		Erase=sc.nextInt();
		DFS(root);//root노드부터 시작한다
		if(Erase==root)//root노드를 지운다면 0을 출력하고 시스템 종료
		{
			System.out.println("0");
			System.exit(0);
		}
		if(leaf==0)
		{
			System.out.println("1");
			System.exit(0);
		}
		System.out.println(leaf);//리프 노드 출력
		
	}

}

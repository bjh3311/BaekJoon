import java.util.*;
import java.io.*;
public class DAY1_1 {

	public static int L;
	public static int C;
	public static String[] s;
	public static String[] mo= {"a","i","o","e","u"};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine().split(" ");
		L=Integer.parseInt(s[0]);
		C=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		Arrays.sort(s);//������������ ����
		DFS(0,0,"");
		
		//1. üũ�� -���� ����
		//2. �������ΰ�?? - ���� + ����,���� ����
		//3. ����� ���� ��ȸ - ������ ���� ���ĺ�
		//4. �� �� �ִ°�? - ���� ����
		//5. ���� -dfs(next) -> ����,����
		//6. üũ�ƿ�- ���� ����
		}
	public static void DFS(int n,int index,String temp)
	{
		if(n==L)//�������� �����޴°�??
		{
			int moem=0;
			for(int i=0;i<L;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(temp.substring(i,i+1).equals(mo[j]))
					{
						moem++;
					}
				}
			}
			if(moem>=1&&L-moem>=2)//������ 2������ ���� ������ 1������ ������ �����̴�
			{
				System.out.println(temp);
			}
			else
			{
				return;
			}
		}
		for(int i=index;i<C;i++)
		{
			DFS(n+1,i+1,temp+s[i]);
		}
	}
}

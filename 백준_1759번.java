import java.util.Arrays;
import java.util.Scanner;
public class ����_1759�� {

	public static int L;//��ȣ�� ����
	public static int C;//�־��� ������ ����
	public static char[] result;//�����
	public static StringBuilder sb=new StringBuilder();//���
	public static char[] CharArr;//�־��� ���ڵ�
	public static char[] MO_Arr= {'a','e','i','o','u'};//���� �迭
	public static int[] visited;//�湮���� �ʾ����� 0 �湮������ 1
	public static int isable(char[] abc)//�־��� ������ ����1�� ����2���� �����ϴ��� Ȯ��
	{
		int MO=0;//���� ����
		int JA=0;//���� ����
		for(int i=0;i<abc.length;i++)
		{
			int Mo_temp=MO;
			for(int j=0;j<5;j++)
			{
				if(abc[i]==(MO_Arr[j]))
				{
					MO++;	
				}
			}
			if(MO==Mo_temp)
			{
				JA++;
			}//���������� �����̾��ٸ� ����++;
		}
		
		if(MO==0||JA<2)
		{
			return 0;
		}
		else
		{
			return 1;
		}
		
	}
	public static void backtrack(int n)
	{
		if(n==L)//n�� ��ȣ�� ���̿� ���ٸ�
		{
			if(isable(result)==1)//����1������2���ִ��� Ȯ��
			{
				for(int i=0;i<L;i++)
				{
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		if(n==0)
		{
			for(int i=0;i<C;i++)
			{
				if(visited[i]==0)
				{
					visited[i]=1;
					result[n]=CharArr[i];
					backtrack(n+1);
					visited[i]=0;
				}
			}
		}
		else
		{
			for(int i=0;i<C;i++)
			{
				if(visited[i]==0)
				{
					if(Character.compare(CharArr[i], result[n-1])>0)//���������� ������ ���� ����
					{
						visited[i]=1;
						result[n]=CharArr[i];
						backtrack(n+1);
						visited[i]=0;
					}
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		L=scan.nextInt();
		C=scan.nextInt();
		CharArr=new char[C];
		result=new char[L];
		visited=new int[C];
		scan.nextLine();//���� ����
		String[] s=scan.nextLine().split(" ");
        for(int i=0;i<C;i++)
        {
        	CharArr[i]=s[i].charAt(0);
        }
		Arrays.sort(CharArr);
		backtrack(0);
		System.out.println(sb.toString());
	}

}

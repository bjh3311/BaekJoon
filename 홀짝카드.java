import java.util.*;
import java.io.*;
public class Ȧ¦ī�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int T_case=1;//���° �׽�Ʈ���̽����� ��Ÿ��
		StringBuilder sb=new StringBuilder();
		while(T>0)
		{
			T--;
			int N=Integer.parseInt(br.readLine());
			ArrayList<Integer> arr=new ArrayList<Integer>();
			String[] s=br.readLine().split(" ");
			int result=0;
			for(int i=0;i<N;i++)
			{
				arr.add(Integer.parseInt(s[i]));
			}
			Collections.sort(arr);
			Collections.reverse(arr);//�������� ����
			while(!arr.isEmpty())
			{
				int temp=arr.get(0);//����ؼ� ���� ū ���� ��� ���� ����Ѵ�
				boolean ispossible=true;
				for(int i=arr.size()-1;i>0;i--)
				{
					if((arr.get(0)+arr.get(i))%2==0)//¦����
					{
						arr.remove(i);//�ش� �ϴ� �� �����
						result=result+arr.get(0);
						ispossible=false;
						arr.remove(0);
						break;
					}
				}
				if(ispossible)//�ᱹ ¦���� ���� �����ߴٸ� �ƽ����� ����ū���� ���ְ� �� ����ū���� ������
				{
					arr.remove(0);//���� ū �� ���ش�
					result=result+arr.get(0);//�� ���� ū �� ������
					arr.remove(0);
				}
			}
			sb.append("#"+T_case+" "+result+"\n");
			T_case++;
		}
		System.out.print(sb.toString());
	}
}

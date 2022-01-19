import java.util.*;
import java.io.*;
class jewerly implements Comparable<jewerly>
{
	int M;//����
	int V;//��ġ
	public jewerly(int M,int V)
	{
		this.M=M;
		this.V=V;
	}
	public int compareTo(jewerly o)
	{	
		return M-o.M;
	}
}
public class DAY3_�������� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		jewerly[] jewelries=new jewerly[N];
		int[] bags=new int[K];
		for(int i=0;i<N;i++)//���� ����
		{
			s=br.readLine().split(" ");
			jewelries[i]=new jewerly(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		for(int i=0;i<K;i++)//���� ����
		{
			s=br.readLine().split(" ");
			bags[i]=Integer.parseInt(s[0]);
		}
		Arrays.sort(bags);//���� ���� ������������ ����
		Arrays.sort(jewelries);//���� ���� ������������ ����
		int jIndex=0;
		long result=0;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<bags.length;i++)
		{
			int bag=bags[i];//���� ����
			while(jIndex<N&&jewelries[jIndex].M<=bag)
			{
				q.add(jewelries[jIndex].V);
				jIndex++;
			}
			if(!q.isEmpty())
			{
				result+=q.poll();
			}
		}
		System.out.println(result);
	}
}

import java.util.*;
import java.io.*;
class oil_bank implements Comparable<oil_bank>
{
	int dis;
	int oil;
	public oil_bank(int dis,int oil)
	{
		this.dis=dis;
		this.oil=oil;
	}
	@Override
	public int compareTo(oil_bank o)
	{
		return dis-o.dis;//거리가 짧은게 큰 우선순위를 가진다
	}
}
public class 백준_1826번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<oil_bank> info=new PriorityQueue<oil_bank>();//주유소 정보가 담겨있다.
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			info.add(new oil_bank(a,b));
		}
		s=br.readLine().split(" ");
		int L=Integer.parseInt(s[0]);//마을까지의 거리
		int P=Integer.parseInt(s[1]);//현재 갖고있는 기름의 양
		int result=0;//결과값
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());//가장 큰 기름의 양이 큰 우선순위 가짐
		while(P<L)//현재 가지고있는연료가 거리보다 작을때만
		{
			while(!info.isEmpty()&&P>=info.peek().dis)//처음 가지고 있는 연료로 갈 수 있는 주유소 쭉 입력받는다
			{
				oil_bank temp=info.poll();
				q.add(temp.oil);
			}
			if(q.isEmpty())//현재 가지고 있는 연료로 갈 수 있는 주유소가 없다면...
			{
				result=-1;
				break;
			}
			P=P+q.poll();
			result++;
		}
		System.out.println(result);
	}
}

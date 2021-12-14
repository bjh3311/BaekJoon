import java.util.*;
import java.io.*;
public class 홀짝카드 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int T_case=1;//몇번째 테스트케이스인지 나타냄
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
			Collections.reverse(arr);//내림차순 정렬
			while(!arr.isEmpty())
			{
				int temp=arr.get(0);//계속해서 가장 큰 수를 얻기 위해 노력한다
				boolean ispossible=true;
				for(int i=arr.size()-1;i>0;i--)
				{
					if((arr.get(0)+arr.get(i))%2==0)//짝수면
					{
						arr.remove(i);//해당 하는 수 지운다
						result=result+arr.get(0);
						ispossible=false;
						arr.remove(0);
						break;
					}
				}
				if(ispossible)//결국 짝수의 합을 못구했다면 아쉬운대로 가장큰수는 내주고 그 다음큰수를 취하자
				{
					arr.remove(0);//가장 큰 수 없앤다
					result=result+arr.get(0);//그 다음 큰 수 취하자
					arr.remove(0);
				}
			}
			sb.append("#"+T_case+" "+result+"\n");
			T_case++;
		}
		System.out.print(sb.toString());
	}
}

import java.util.*;
import java.io.*;
public class 백준_1966번 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		int bigger=0;
		for(int i=0;i<T;i++)
		{
			int count=0;//몇번째로 출력하는지 확인
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int[] arr=new int[N];
            s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[j]=Integer.parseInt(s[j]);
			}//해당인덱스의 중요도
			for(int j=0;j<N;j++)
			{
				q.add(j);
			}//q에 인덱스를 순서대로 넣는다
			loops: while(true)
			{
				bigger=0;
				for(int j=0;j<N;j++)
				{
					if(arr[q.peek()]<arr[j])
					{
						bigger++;
					}
				}
				if(bigger>0)//큐의 맨 앞보다 큰게 하나라도 있다면
				{
					q.add(q.poll());//가장 뒤에 재배치
				}
				else//큐의  맨 앞보다 큰게 하나도 없다면
				{
					if(q.peek()==M)//큐의 맨 앞이 찾던 인덱스면
					{
						count++;
						sb.append(count+"\n");
						q.clear();//q초기화
						break loops;
					}
					else//큐의 맨 앞이 찾던 인덱스가 아니면
					{
						arr[q.poll()]=0;//큐에서 제거하고 해당하는 인덱스의 중요도값도 0으로 초기화
						count++;//출력횟수++
					}				
				}				
			}					
		}
		System.out.print(sb.toString());

	}

}

import java.util.*;
import java.io.*;
public class 프로그래머스_타겟넘버 {

	public static int answer;
	public static boolean[] visited;
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		System.out.println(solution(arr,3));
	}
	public static int solution(int[] numbers, int target) {
        answer = 0;
        visited=new boolean[numbers.length];
        DFS(numbers,target,0,0,0);
        return answer;
    }
	public static void DFS(int[] numbers,int target,int value,int count,int index)
	{
		if(count==numbers.length)
		{
			if(value==target)
			{
				answer++;
			}
			return;
		}
		if(!visited[index])
		{
			visited[index]=true;
			DFS(numbers,target,value-numbers[index],count+1,index+1);
			DFS(numbers,target,value+numbers[index],count+1,index+1);
			visited[index]=false;
		}
		
	}
}

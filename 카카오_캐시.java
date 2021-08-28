import java.util.*;
import java.io.*;
public class 카카오_캐시 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cacheSize=Integer.parseInt(br.readLine());
		String[] cities=br.readLine().split(" ");
		System.out.println(solution(cacheSize,cities));

	}
	public static ArrayList<String> cache=new ArrayList<String>();
	public static int solution(int cacheSize,String[] cities)
	{
		
		int length=cities.length;
		for(int i=0;i<length;i++)
		{
			cities[i]=cities[i].toUpperCase();
		}
		int answer=0;
		for(int i=0;i<length;i++)
		{
			String temp=cities[i];
			if(cacheSize==0)
			{
				answer=answer+5;
			}
			else if(cache.contains(temp))//cache hit
			{
				cache.remove(temp);
				cache.add(temp);
				answer=answer+1;
			}
			else if(cache.size()<cacheSize&&!cache.contains(temp))
			{
				cache.add(temp);
				answer=answer+5;
			}
			else if(cache.size()==cacheSize&&!cache.contains(temp))//cache miss경우
			{
				cache.remove(0);
				cache.add(temp);
				answer=answer+5;
			}
		}
		return answer;
	}

}

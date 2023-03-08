import java.util.*;
import java.io.*;
public class 프로그래머스_메뉴리뉴얼 {

	public static void main(String[] args) throws IOException{
		String[] orders= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course= {2,3,4};
		for(String temp : solution(orders,course))
		{
			System.out.println(temp);
		}
	}
	public static HashMap<String,Integer> map;
	public static ArrayList<String> solution(String[] orders, int[] course)
	{
		for(int i =0;i<orders.length;i++)
		{
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
		ArrayList<String> answer= new ArrayList();
		for(int i=0;i<course.length;i++)
		{
			map=new HashMap<String,Integer>();
			int max=Integer.MIN_VALUE;
			for(int j=0;j<orders.length;j++)
			{
				Backtrack(orders[j],"",0,course[i]);
			}	
			Set<String> set=map.keySet();
			for(String temp : set)
			{
				max=Math.max(max, map.get(temp));
			}
			if(max<2)
			{
				continue;
			}
			for(String temp : set)
			{
				if(map.get(temp)==max)
				{
					answer.add(temp);
				}
			}
		}
		Collections.sort(answer);//문자 오름차순 정렬
		return answer;
	}
	public static void Backtrack(String order,String now,int index, int n){
        if(now.length() == n) 
        {
           map.put(now,map.getOrDefault(now,0)+1);
           return;
        }
        for(int i = index ; i<order.length();i++){
            now=now+order.charAt(i);
            Backtrack(order,now,i+1,n);
            now=now.substring(0,now.length()-1);
        }
    }
}

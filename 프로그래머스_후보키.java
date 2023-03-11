import java.util.*;
public class 프로그래머스_후보키 {

	public static String[][] rel;
	public static HashSet<String> candidate=new HashSet<String>();
	public static void main(String[] args)
	{
		String[][] relation= {{"100","ryan","music","2"},
				{"200","apeach","math","2"},{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}
	public static int solution(String[][] relation) {
        int col=relation[0].length;//콜롬 길이
        ArrayList<Integer> arr=new ArrayList<Integer>();
        rel=relation.clone();
        for(int i=1;i<=col;i++)
        {
        	backtrack(0,i,arr,0);
        }
        return candidate.size();//후보키의 사이즈
    }
	public static void backtrack(int now,int N,ArrayList<Integer> arr,int start)
	{
		if(now==N)
		{
			String temp="";
			for(int i : arr)
			{
				temp=temp+i;
			}
			if(!isMinimal(temp))// 현재 선택된 컬럼들로 이루어진 후보키가 최소성을 만족하는지 확인
			{
				return;
			}
			if(!isUnique(temp))//현재 선택된 칼럼들로 이루어진 후보키가 유일성을 만족하는지 확인
			{
				return;
			}
			candidate.add(temp);//모두 만족한다면 정답에 추가한다
			return;
		}
		for(int i=start;i<rel[0].length;i++)
		{
			arr.add(i);
			backtrack(now+1,N,arr,i+1);
			arr.remove(arr.size()-1);
		}
	}
	public static boolean isMinimal(String s)//최소성 검사
	{
		for(String temp : candidate)
		{
			int count=0;
			for(int i=0;i<temp.length();i++)
			{
				if(s.contains(String.valueOf(temp.charAt(i))))
				{
					count++;
				}
			}
			if(count==temp.length())
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isUnique(String s)//유일성 검사
	{
		  String[] arr=s.split("");
		  HashSet<String> unique=new HashSet<String>();
		  for(int i=0;i<rel.length;i++)
		  {
			  String temp="";
			  for(String a : arr)
			  {
				  temp=temp+rel[i][Integer.parseInt(a)];
			  }
			  if(unique.contains(temp))
			  {
				  return false;
			  }
			  unique.add(temp);
		  }
		  return true;
	}
}

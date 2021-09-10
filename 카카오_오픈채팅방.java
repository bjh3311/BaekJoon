import java.util.*;
import java.io.*;
public class 카카오_오픈채팅방 {

	public String[] solution(String[] record)
	{
		Map<String,String> idMap=new HashMap<>();
		List<String[]> result=new LinkedList<>();
		for(String records: record)
		{
			String[] keyWord=records.split(" ");
			if(keyWord[0].equals("Enter"))
			{
				idMap.put(keyWord[1], keyWord[2]);
				result.add(keyWord);
			}
			else if(keyWord[0].equals("Change"))
			{
				idMap.put(keyWord[1], keyWord[2]);
			}
			else
			{
				result.add(keyWord);
			}
		}
		String[] answer= new String[result.size()];
		int index=0;
		for(String[] keyWords:result)
		{
			String nickName=idMap.get(keyWords[1]);
			if(keyWords[0].equals("Enter"))
			{
				answer[index++]=nickName+"님이 들어왔습니다.";
			}
			else if(keyWords[0].equals("Leave"))
			{
				answer[index++]=nickName+"님이 나갔습니다.";
			}
		}
		return answer;
	}

}

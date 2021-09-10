import java.util.*;
import java.io.*;
public class īī��_����ä�ù� {

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
				answer[index++]=nickName+"���� ���Խ��ϴ�.";
			}
			else if(keyWords[0].equals("Leave"))
			{
				answer[index++]=nickName+"���� �������ϴ�.";
			}
		}
		return answer;
	}

}

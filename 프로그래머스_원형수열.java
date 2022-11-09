import java.util.*;
import java.io.*;


class 프로그래머스_원형수열 {
    public int solution(int[] elements) {
        int answer = 0;
        int size=elements.length;
        int[] arr=new int[2*elements.length];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<elements.length;i++)
        {
            arr[i]=elements[i];
        }
        for(int i=elements.length;i<2*elements.length;i++)
        {
            arr[i]=elements[i-elements.length];
        }
        for(int i=1;i<=elements.length;i++)//순열 길이
        {
            for(int j=0;j<elements.length;j++)
            {
                int temp=0;
                for(int start=j;start<j+i;start++)
                {
                    temp=temp+arr[start];
                }
                map.put(temp,1);
            }
        }
        answer=map.size();
        return answer;
    }
}
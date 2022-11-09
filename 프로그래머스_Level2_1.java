import java.util.*;
import java.io.*;

class 프로그래머스_Level2_1 {
    public static boolean[] visited;
    public static int answer=0;
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    public static void dfs(int depth,int k,int[][] dungeons)
    {
        for(int i=0;i<dungeons.length;i++)
        {
            if(!visited[i]&&k>=dungeons[i][0])
            {
                visited[i]=true;
                dfs(depth+1,k-dungeons[i][1],dungeons);
                visited[i]=false;
            }
        }
        answer=Math.max(answer,depth);
    }
}

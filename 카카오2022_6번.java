import java.util.*;
import java.io.*;
public class 카카오2022_6번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] board=new int[N][M];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(s[j]);
			}
		}
		int count=Integer.parseInt(br.readLine());
		int[][] skill=new int[count][6];
		for(int i=0;i<count;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<6;j++)
			{
				skill[i][j]=Integer.parseInt(s[j]);
			}
		}
		System.out.println(solution(board,skill));

	}
	public static int solution(int[][] board, int[][] skill)
	{
        int answer = 0;
        int N=board.length;
        int M=board[0].length;
        for(int i=0;i<skill.length;i++)
        {
        	int type=skill[i][0];
        	int r1=skill[i][1];
        	int c1=skill[i][2];
        	int r2=skill[i][3];
        	int c2=skill[i][4];
        	int degree=skill[i][5];
        	if(type==1)
        	{
        		for(int y=r1;y<=r2;y++)
        		{
        			for(int x=c1;x<=c2;x++)
        			{
        				board[y][x]=board[y][x]-degree;
        			}
        		}
        	}
        	else
        	{
        		for(int y=r1;y<=r2;y++)
        		{
        			for(int x=c1;x<=c2;x++)
        			{
        				board[y][x]=board[y][x]+degree;
        			}
        		}
        	}
        }
        for(int i=0;i<N;i++)
        {
        	for(int j=0;j<M;j++)
        	{
        		if(board[i][j]>0)
        		{
        			answer++;
        		}
        	}
        }
        return answer;
    }

}

import java.util.*;
import java.io.*;

public class 프로그래머스_파괴되지않은건물 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		int[][] board=new int[N][M];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(s[j]);
			}
		}
		int temp=Integer.parseInt(br.readLine());
		int[][] skill=new int[temp][6];
		for(int i=0;i<temp;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<6;j++)
			{
				skill[i][j]=Integer.parseInt(s[j]);
			}
		}
		System.out.println(solution(board,skill));

	}
	public static int solution(int[][] board,int[][] skill)
	{
		int answer=0;
		int[][] temp=new int[board.length+1][board[0].length+1];
		for(int i=0;i<skill.length;i++)//O(1)
		{
			int r1=skill[i][1];
			int c1=skill[i][2];
			int r2=skill[i][3];
			int c2=skill[i][4];
			int degree=skill[i][5]*(skill[i][0]==1 ? -1 : 1);
			temp[r1][c1]+=degree;
			temp[r1][c2+1]+=(degree*-1);
			temp[r2+1][c1]+=(degree*-1);
			temp[r2+1][c2+1]+=degree;
		}//temp에 누적합
		
		for(int i=0;i<temp.length;i++)
		{
			for(int j=1;j<temp[i].length;j++)
			{
				temp[i][j]+=temp[i][j-1];
			}
		}//가로 누적합
		
		for(int j=0;j<temp[0].length;j++)
		{
			for(int i=1;i<temp.length;i++)
			{
				temp[i][j]+=temp[i-1][j];
			}
		}//세로누적합
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=board[i][j]+temp[i][j];
				if(board[i][j]>=1)
				{
					answer++;
				}
			}
		}
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		return answer;
	}

}
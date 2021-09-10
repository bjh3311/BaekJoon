import java.util.*;
import java.io.*;
public class 카카오_크레인인형 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] board=new int[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(s[j]);
			}
		}
		s=br.readLine().split(" ");
		int[] moves=new int[8];
		for(int i=0;i<8;i++)
		{
			moves[i]=Integer.parseInt(s[i]);
		}
		System.out.println(solution(board,moves));

	}
	public static int solution(int[][] board,int[] moves)
	{
		int answer=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<moves.length;i++)
		{
			int order=moves[i]-1;
			for(int j=0;j<board.length;j++)
			{
				if(board[j][order]!=0)
				{
					if(!stack.isEmpty()&&stack.peek()==board[j][order])
					{
						stack.pop();
						answer=answer+2;
					}
					else 
					{
						stack.push(board[j][order]);
					}
					board[j][order]=0;
					break;
				}
			}
		}
		return answer;
	}

}

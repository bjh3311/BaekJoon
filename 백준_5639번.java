import java.util.*;
import java.io.*;
class Node
{
	int num;
	Node left;
	Node right;
	public Node(int num)
	{
		this.num=num;
	}
	public void insert(int n)
	{
		if(n<this.num)//왼쪽 서브트리로 가야한다
		{
			if(this.left==null)
			{
				this.left=new Node(n);
			}
			else
			{
				this.left.insert(n);
			}
		}
		else//오른쪽 서브트리로 가야한다
		{
			if(this.right==null)
			{
				this.right=new Node(n);
			}
			else
			{
				this.right.insert(n);
			}
		}
	}
}
public class 백준_5639번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int temp=Integer.parseInt(br.readLine());
		Node root=new Node(temp);
		String s;
		while(true)
		{
			s=br.readLine();
			if(s==null||s.equals(""))//입력이 비어있으면 break
			{
				break;
			}
			int key=Integer.parseInt(s);
			root.insert(key);
		}
		postorder(root);
		
	}
	public static void postorder(Node now)
	{
		if(now==null)
		{
			return;
		}
		postorder(now.left);
		postorder(now.right);
		System.out.println(now.num);
		
	}
}

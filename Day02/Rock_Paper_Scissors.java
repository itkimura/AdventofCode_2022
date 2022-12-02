/* package name */
package Day02;

/* File class */
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/* List */
import	java.util.List;
import	java.util.ArrayList;
import	java.util.Collections;

public class Rock_Paper_Scissors{
	public static void main(String[] args){
		File file = new File("./Day02/input.txt");
		try{
			FileReader filereader = new FileReader(file);
			int ch = filereader.read();
			int player1 = 0, player2 = 0;
			int one = 0, two = 0, res = 0;
			for (int i = 0; ch != -1; i++)
			{
				if (i % 4 == 0)
					one = ch - 'A' + 1;
				else if (i % 2 == 0)
					two = ch - 'X' + 1;
				if (ch == '\n')
				{
					/* Part 1*/
					/*
					res = winner(one, two);
					if (res == 0)
					{
						player1 += 3;
						player2 += 3;
					}
					else if (res == 1)
						player1 += 6;
					else
						player2 += 6;
					*/
					/* Part 2 */
					res = winner(two);
					if (res == 0)
					{
						player1 += 3;
						player2 += 3;
						two = one;
					}
					else if (res == 1)
					{
						player1 += 6;
						two = 2;
						if (one == 1)
							two = 3;
						if (one == 2)
							two = 1;
					}
					else if (res == 2)
					{
						player2 += 6;
						two = 1;
						if (one == 1)
							two = 2;
						if (one == 2)
							two = 3;
					}
					player1 += one;
					player2 += two;
				}
				ch = filereader.read();
			}
			System.out.println("player1 = " + player1 + " player2 = " + player2);
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

	private static int winner(int two)
	{
		/* Part 1 */
		/*
		if (one == two)
			return (0);
		else if ((one == 1 && two == 3) || (one == 2 && two == 1) || (one == 3 && two == 2))
			return (1);
		return (2);
		*/
		/* Part 2 */
		if (two == 1)
			return (1);
		if (two == 2)
			return (0);
		return (2);
	}
}

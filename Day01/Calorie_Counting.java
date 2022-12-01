/* package name */
package Day01;

/* File class */
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/* List */
import	java.util.List;
import	java.util.ArrayList;
import	java.util.Collections;

public class Calorie_Counting{
	public static void main(String[] args){
		/* Set path */
		File file = new File("./Day01/input.txt");
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			FileReader filereader = new FileReader(file);
			int ch = filereader.read();
			int nb = 0;
			int total = 0;
			while (ch != -1)
			{
				if ((char)ch == '\n' && nb == 0)
				{
					list.add(total);
					total = 0;
				}
				if ((char)ch == '\n')
				{
					total = total + nb;
					nb = 0;
				}
				else
					nb = nb * 10 + (ch - '0');
				ch = filereader.read();
			}
			int max = 0;
			for(int i = 0; i < list.size(); i++)
			{
				if (max < list.get(i))
					max = list.get(i);
			}
			System.out.println("max = " + max);
			int max3 = 0;
			for (int i = 0; i < 3; i++)
			{
				max3 = max3 + Collections.max(list);
				int tmp = Collections.max(list);
				list.remove(Collections.max(list));
			}
			System.out.println("Total of Top3 = " + max3);
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}

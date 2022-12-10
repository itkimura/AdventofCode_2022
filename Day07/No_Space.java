import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class No_Space{
	static String file_path = "./input.txt";

	public static void main(String[] args) throws Exception{
		var input = Files.readString(Path.of(file_path));
		var content = input.split("\n");
		part1(content);
	}

	private static void part1(String[] content){
		Directory root = new Directory("/", 0);
		List<Directory> list = new ArrayList<>();
		list.add(root);
		Directory curr = root;
		for (String line: content){
			var command = line.split(" ");
			/* if it is the size, increase size into curr */
			if (isNumeric(command[0]) == true)
				curr.addSize(Long.parseLong(command[0]));
			/* if it is dir,
			 * make new dir class and add it in map */
			if (command[0].equals("dir"))
			{
				Directory tmp = new Directory(command[1], 0, curr);
				curr.addChild(tmp.getName(), tmp);
				list.add(tmp);
			}
			/* if it is cd, move it from map*/
			if (command[0].equals("$") && command[1].equals("cd")){
				if (command[2].equals("..") && curr.getParent() != null)
					curr = curr.getParent();
				else if (command[2].equals("/"))
					curr = root;
				else
					curr = curr.getChild(command[2]);
			}
		}
		totalPart1(list);
		part2(list, root);
	}
	
	public static void part2(List<Directory> list, Directory root)
	{
		long need = (30000000 - (70000000 - root.totalSize()));
		System.out.println("Total space:\t\t70000000");
		System.out.println("Used Space:\t\t" + root.totalSize());
		System.out.println("Free Space:\t\t" + (70000000 - root.totalSize()));
		System.out.println("Space to delete:\t" + need);

		Directory tmp = root;
		long min = 30000000;
		for (Directory dir : list)
		{
			Long size = dir.totalSize();
			Long gap = size - need;
			//System.out.println("size = " + size + "\tgap = " + gap);
			if (gap > 0 && min > gap)
			{
				tmp = dir;
				min = gap;
			}
		}
		System.out.println("\nPart2 = " + tmp.totalSize());
	}

	public static boolean isNumeric(String s)
	{
		for (int i = 0; i < s.length() ; i++)
		{
			if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				return (false);
		}
		return (true);
	}

	public static void totalPart1(List<Directory> list){
		Long	total;

		total = 0L;
		for (Directory dir : list)
		{
			Long size = dir.totalSize();
			if (size <= 100000)
				total += size;
		}
		System.out.println("Part1 = " + total + "\n");
	}
}

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

class Supply_Stack{
	static int total_cargo = 9;
	static String file_path = "./input.txt";

	public static void main(String[] args) throws Exception{
		var input = Files.readString(Path.of(file_path));
		var content = input.split("\n");
		part1(content);
		part2(content);
	}

	private static List<Deque<Character>> create_stack(String[] content){
		List<Deque<Character>> list = new ArrayList<>();
		for (int i = 0; i < total_cargo; i++)
		{
			Deque<Character> stack = new ArrayDeque<>();
			list.add(stack);
		}
		return (list);
	}
	private static void part2(String[] content){
		var list = create_stack(content);
		for (String line: content)
		{
				for (int i = 0; i < line.length(); i++)
				{
					char c = line.charAt(i);
					if (c != ' ' && c >= 'A' && c <= 'Z')
						list.get(i / 4).addLast(c);
					if (i == 0 && c == 'm')
					{
						var column = line.split(" ");
						Deque<Character> tmp = new ArrayDeque<>();
						for (int j = 0; j < Integer.parseInt(column[1]); j++)
							tmp.push(list.get(Integer.parseInt(column[3]) - 1).pop());
						var size = tmp.size();
						for(int j = 0; j < size ; j++)
							list.get(Integer.parseInt(column[5]) - 1).push(tmp.pop());
					}
				}
		}
		System.out.print("Part2 = ");
		for (int i = 0; i < total_cargo; i++)
			System.out.print(list.get(i).pop());
		System.out.println();
	}

	private static void part1(String[] content){
		var list = create_stack(content);
		for (String line: content)
		{
				for (int i = 0; i < line.length(); i++)
				{
					char c = line.charAt(i);
					if (c != ' ' && c >= 'A' && c <= 'Z')
						list.get(i / 4).addLast(c);
					if (i == 0 && c == 'm')
					{
						var column = line.split(" ");
						for (int j = 0; j < Integer.parseInt(column[1]); j++)
						{
							var tmp = list.get(Integer.parseInt(column[3]) - 1).pop();
							if (tmp != 0)
								list.get(Integer.parseInt(column[5]) - 1).push(tmp);
						}
					}
				}
		}
		System.out.print("Part1 = ");
		for (int i = 0; i < total_cargo; i++)
			System.out.print(list.get(i).pop());
		System.out.println();
	}
}

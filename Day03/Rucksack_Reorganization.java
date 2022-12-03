import java.nio.file.Files;
import java.nio.file.Path;

class Rucksack_Reorganization{
	public static void main(String[] args) throws Exception{
		var input = Files.readString(Path.of("./input.txt"));
		var content = input.split("\n");
		part1(content);
		part2(content);
	}

	private static void part2(String[] content){
		int i = 0, total = 0;
		String s1 = "", s2 = "", s3 = "";
		for (String line: content)
		{
			if (i == 0)
				s1 = line;
			if (i == 1)
				s2 = line;
			if (i == 2)
			{
				s3 = line;
				var c = match2(s1, s2, s3);
				total += culc(c);
				i = -1;
			}
			i++;
		}
		System.out.println("Part2: " + total);
	}

	private static void part1(String[] content){
		int total = 0;
		for (String line : content){
			var s1 = line.substring(0, line.length() / 2);
			var s2 = line.substring(line.length() / 2, line.length());
			var c = match(s1, s2);
			total += culc(c);
		}
		System.out.println("Part1: " + total);
	}

	private static char match2(String s1, String s2, String s3){
		for (int i = 0; i < s1.length(); i++)
		{
			var c = s1.charAt(i);
			String str = String.valueOf(c);
			if (s2.contains(str) == true)
			{
				if (s3.contains(str) == true)
					return (c);
			}
		}
		return (0);
	}

	private static int culc(char c)
	{
		if (c >= 'a' && c <= 'z')
			return (c - 'a' + 1);
		if (c >= 'A' && c <= 'Z')
			return (c - 'A' + 27);
		return (0);
	}

	private static char match(String s1, String s2){
		for (int i = 0; i < s1.length(); i++)
		{
			var c = s1.charAt(i);
			String str = String.valueOf(c);
			if (s2.contains(str) == true)
				return (s1.charAt(i));
		}
		return (0);
	}
}

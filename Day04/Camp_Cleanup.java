import java.nio.file.Files;
import java.nio.file.Path;

class Camp_Cleanup{
	public static void main(String[] args) throws Exception{
		var input = Files.readString(Path.of("./input.txt"));
		var content = input.split("\n");
		test_lines(content);
	}

	private static void test_lines(String[] content){
		int p1 = 0, p2 = 0;
		for (String line: content)
		{
			var str = line.split(",");
			var n1 = str[0].split("-");
			var n2 = str[1].split("-");
		
			int nb1, nb2, nb3, nb4;
			nb1 = Integer.parseInt(n1[0]);
			nb2 = Integer.parseInt(n1[1]);
			nb3 = Integer.parseInt(n2[0]);
			nb4 = Integer.parseInt(n2[1]);
			if (part1(nb1, nb2, nb3, nb4) == true)
				p1++;
			if (part2(nb1, nb2, nb3, nb4) == true)
				p2++;
		}
		System.out.println("Part1 = " + p1);
		System.out.println("Part2 = " + p2);
	}
	
	private static boolean part1(int nb1, int nb2, int nb3, int nb4){
		if ((nb1 >= nb3 && nb2 <= nb4) || (nb1 <= nb3 && nb2 >= nb4))
			return (true);
		return (false);
	}
	
	private static boolean part2(int nb1, int nb2, int nb3, int nb4){
		if (nb1 <= nb4 && nb2 >= nb3)
			return (true);
		return (false);
	}
}

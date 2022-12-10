import java.nio.file.Files;
import java.nio.file.Path;

class Tuning_Trouble{
	static String file_path = "./input.txt";

	public static void main(String[] args) throws Exception{
		var input = Files.readString(Path.of(file_path));
		var content = input.split("\n");
		System.out.println("Part1 = " + parse(content, 4));
		System.out.println("Part2 = " + parse(content, 14));
		//part2(content);
	}

	public static int parse(String[] content, int nb){
		for (String line: content){
			for (int i = 0; i < line.length() - nb; i++)
			{
				var tmp = line.substring(i, i + nb);
				if (is_duplicate(tmp) == false)
					return (i + nb);
			}
		}
		return (0);
	}

	public static boolean is_duplicate(String str){
		for (int i = 0; i < str.length(); i++)
		{
			for (int j = i + 1; j < str.length(); j++)
			{
				if (str.charAt(i) == str.charAt(j))
						return (true);
			}
		}
		return (false);
	}
}

import java.nio.file.Files;
import java.nio.file.Path;

class ver2{
	/* 0:Rock, 1:Paper, 2:Scissor */
	static int[] toWin = {1, 2, 0}; // 0:Rock -> 1:Paper, 1:Paper -> 2:Scissor, 2:Scissor -> 0:Rock
	static int[] toLose = {2, 0, 1}; // 0:Rock -> 2:Scissor, 1:Paper -> 2:Rock, 2:Scissor -> 1:Paper
	
	/* main */
	/* throws -> error handling */
	public static void main(String[] args) throws Exception {
		var input = Files.readString(Path.of("./input.txt"));

		/* .split -> devide strings into array by "\n" */
		//var score = input.split("\n");
		/* for each in string array */
		//for (String value : score)
		//	System.out.println(value);

		static int[] game1(String line){
			return new int[] {line.charAt(0), line.charAt(2) - 'X'};
		}
	}

}

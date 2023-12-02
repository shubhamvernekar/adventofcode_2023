import java.util.*;
import java.io.*;

public class Day2 {
	public static boolean task1(String str, int red, int green, int blue) {
		String parts[] = str.split(";");

		for(String s : parts) {
			String cubes[] = s.split(",");
			for(String c : cubes) {
				c = c.trim();
				String p[] = c.split(" ");
				if(p[1].equals("blue") && Integer.parseInt(p[0]) > blue) return false;
				else if(p[1].equals("red") && Integer.parseInt(p[0]) > red) return false;
				else if(p[1].equals("green") && Integer.parseInt(p[0]) > green) return false;
			}
		}

		return true;	
	}

	public static int minCubes(String str) {
		int blue = 1;
		int red = 1;
		int green = 1;

		String parts[] = str.split(";");

		for(String s : parts) {
			String cubes[] = s.split(",");
			for(String c : cubes) {
				c = c.trim();
				String p[] = c.split(" ");
				if(p[1].equals("blue")) {
					blue = Math.max(blue, Integer.parseInt(p[0]));
				} else if(p[1].equals("red")) {
					red = Math.max(red, Integer.parseInt(p[0]));
				} else if(p[1].equals("green")) {
					green = Math.max(green, Integer.parseInt(p[0]));
				}
			}
		}
		return blue * red * green;
	}

	public static void main(String args[]) {
		if(args.length == 0) {
			System.out.println("Please provide file path.");
			return;
		}

		String filePath = args[0];
		long task1result = 0;
		long task2result = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String parts[] = line.split(":");
				if(task1(parts[1], 12, 13, 14)) {
					task1result += Integer.parseInt(parts[0].split(" ")[1]);
				}

				task2result += minCubes(parts[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Result task 1 = " + task1result);
		System.out.println("Result task 2  = " + task2result);
	}
}


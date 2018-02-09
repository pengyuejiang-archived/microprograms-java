import java.util.Scanner;

public class Core {
	
	// 用来存储数字：
	public static int[][] matrix = new int[9][9];
	// 数独格子数组，包含了数据信息、位置信息和修改权限：
	public static SudokuGrid[][] sg = new SudokuGrid[9][9];
	
	// 收集数据方法：
	public static void collectData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请逐行输入数独矩阵，空的用0填充，格子之间用\",\"隔开：");
		for (int i = 0; i < 9; i++) {
			matrix[i] = toIntArray(scanner.next().split(","));
		}
	}
	
	// 内部算法：转换字符串类型数组为整数类型数组
	private static int[] toIntArray(String[] arr) {
		int[] rslt = new int[arr.length];
		for (int i = 0; i < 9; i++) {
			rslt[i] = Integer.parseInt(arr[i]);
		}
		return rslt;
	}
	
	// 赋值数独矩阵：
	public static void generate() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sg[i][j] = new SudokuGrid(matrix[i][j], i + 1, j + 1, 3 * (i / 3 + 1) - 2 + j / 3, matrix[i][j] == 0);
			}
		}
	}
	
	// 用来遍历数独矩阵：
	public static void display() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sg[i][j].value);
				if (j != 8) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
	
}
/*
 * 成功了！
 * 而且还挺快的，效率还不错。
 * 但是有一个小bug
 * 每一次都会有两个格子还是0。
 * 不清楚原因。
 * 下次更新的时候再算一遍来解决。
 * 最后，庆祝一下
 * 四小时内完成的项目
 */
import java.util.Scanner;

public class SudokuV1 {
	
	// 用来存储数字：
	public static int[][] matrix = new int[9][9];
	// 数独格子数组，包含了数据信息、位置信息和修改权限：
	public static SudokuGrid[][] sg = new SudokuGrid[9][9];
	// 用来判断什么时候终止计算的变量：
	public static boolean solved = false;
	
	// 用来遍历数独矩阵：
	public static void display() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j == 9) {
					System.out.println(sg[i][j].value);
				} else {
					System.out.print(sg[i][j].value + ",");
				}
			}
			System.out.println();
		}
	}
	
	// 主方法：
	public static void main(String[] args) {
		// 收集数据：
		collectData();
		// 给数独矩阵赋值：
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sg[i][j] = new SudokuGrid(matrix[i][j], i + 1, j + 1, 3 * (i / 3 + 1) - 2 + j / 3, isZero(matrix[i][j]));
			}
		}
		// 计算：
		// 只要全场有一个0就不停止计算：
		while (!solved) {
			// 九次循环对应九个数字：
			for (int i = 1; i <= 9; i++) {
				// 消除制定数字：
				eliminate(i);
				// 九次循环对应九个宫：
				for (int j = 1; j <= 9; j++) {
					choose(j, i);
				}
				// 每一次做完一个数字之后重置更改权限：
				restore();
			}
			// 用来判断什么时候停止：
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// 只要发现一个0就不改变解决状态：
					if (sg[i][j].value == 0) {
						break;
					}
					// 如果检查到最后一个并且其值不为0，改变解决状态：
					if (i == 8 && j == 8 && sg[8][8].value != 0) {
						solved = true;
					}
				}
			}
		}
		display();
	}
	
	// 重置格子状态：
	private static void restore() {
		// 一次排除工作和确认结束之后将之前为这个数字排除掉但是没有值的格子标为：可修改：
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sg[i][j].value == 0) {
					sg[i][j].editable = true;
				}
			}
		}
	}
	
	// 宫内排查：
	private static void choose(int block, int num) {
		// 用来标记可修改的格子的数量的变量：
		int temp = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// 如果发现一个可以修改的并且在制定宫内的格子：
				if (sg[i][j].block == block && sg[i][j].editable) {
					// 记入统计：
					temp++;
				}
			}
		}
		// 如果一个区内仅有一个格子可修改时，确认：
		if (temp == 1) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// 这段代码有点重复了，不知道怎么改：
					if (sg[i][j].block == block && sg[i][j].editable) {
						sg[i][j].value = num;
					}
				}
			}
		}
	}
	
	private static void eliminate(int num) {
		// 嵌套循环检查矩阵的每一个格子：
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// 如果格子里头有跟要找的数字一样的数字：
				if (sg[i][j].value == num) {
					// 分别用三个代码表示三种排除操作：
					for (int k = 1; k <= 3; k++) {
						// 传输要执行的操作代码和该格子的位置信息到mark()方法，然后标记不可能是答案的格子：
						mark(k, sg[i][j].row, sg[i][j].column, sg[i][j].block);
					}
					//下一步：
					//统计一个区里头有几个空白格子，如果只有一个的话，马上填充，然后set Editable false
				}
			}
		}
	}
	
	private static void mark(int code, int row, int column, int block) {
		switch (code) {
			// 操作1：查找整个矩阵，在同一行的所有格子被排除：
			case 1:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (sg[i][j].row == row) {
							sg[i][j].editable = false;
						}
					}
				}
				break;
			// 操作2：查找整个矩阵，在同一列的所有格子被排除：
			case 2:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (sg[i][j].column == column) {
							sg[i][j].editable = false;
						}
					}
				}
				break;
			// 操作3：查找整个矩阵，在同一宫的所有格子被排除：
			case 3:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (sg[i][j].block == block) {
							sg[i][j].editable = false;
						}
					}
				}
				break;
			default:
				break;
		}
	}
	
	// 判断0方法：
	private static boolean isZero(int num) {
		if (num == 0) {
			return true;
		}
		return false;
	}
	
	// 收集数据方法：
	public static void collectData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请逐行输入数独矩阵，用\",\"隔开：");
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
	
}
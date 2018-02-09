public class EliminationAlgorithm {
	
	public static void run() {
		for (int i = 1; i <= 9; i++) {
			// 消除制定数字：
			find(i);
			// 九次循环对应九个宫：
			for (int j = 1; j <= 9; j++) {
				choose(j, i);
			}
			// 每一次做完一个数字之后重置更改权限：
			reset();
		}
	}
	
	private static void find(int num) {
		// 嵌套循环检查矩阵的每一个格子：
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// 如果格子里头有跟要找的数字一样的数字：
				if (Core.sg[i][j].value == num) {
					// 分别用三个代码表示三种排除操作：
					for (int k = 0; k < 3; k++) {
						// 传输要执行的操作代码和该格子的位置信息到exclude()方法，然后标记不可能是答案的格子：
						exclude(k, Core.sg[i][j].row, Core.sg[i][j].column, Core.sg[i][j].block);
					}
					//下一步：
					//统计一个区里头有几个空白格子，如果只有一个的话，马上填充，然后set Editable false
				}
			}
		}
	}
	
	private static void exclude(int code, int row, int column, int block) {
		switch (code) {
			// 操作0：查找整个矩阵，在同一行的所有格子被排除：
			case 0:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (Core.sg[i][j].row == row) {
							Core.sg[i][j].editable = false;
						}
					}
				}
				break;
			// 操作1：查找整个矩阵，在同一列的所有格子被排除：
			case 1:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (Core.sg[i][j].column == column) {
							Core.sg[i][j].editable = false;
						}
					}
				}
				break;
			// 操作2：查找整个矩阵，在同一宫的所有格子被排除：
			case 2:
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (Core.sg[i][j].block == block) {
							Core.sg[i][j].editable = false;
						}
					}
				}
				break;
		}
	}
	
	// 宫内排查：
	private static void choose(int block, int num) {
		// 用来标记可修改的格子的数量的变量：
		int temp = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// 如果发现一个可以修改的并且在制定宫内的格子：
				if (Core.sg[i][j].block == block && Core.sg[i][j].editable) {
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
					if (Core.sg[i][j].block == block && Core.sg[i][j].editable) {
						Core.sg[i][j].value = num;
					}
				}
			}
		}
	}
	
	// 重置格子状态：
	private static void reset() {
		// 一次排除工作和确认结束之后将之前为这个数字排除掉但是没有值的格子标为：可修改：
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Core.sg[i][j].value == 0) {
					Core.sg[i][j].editable = true;
				}
			}
		}
	}
	
}
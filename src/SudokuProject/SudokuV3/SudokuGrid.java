public class SudokuGrid {
	
	public int value;
	public int row;
	public int column;
	public int block;
	public boolean editable;
	
	public SudokuGrid(int value, int row, int column, int block, boolean editable) {
		this.value = value;
		this.row = row;
		this.column = column;
		this.block = block;
		this.editable = editable;
	}
	
}
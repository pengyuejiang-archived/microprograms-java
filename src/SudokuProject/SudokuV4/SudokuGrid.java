public class SudokuGrid {

	private int value;
	private int row;
	private int column;
	private int block;
	private boolean editable;

	public SudokuGrid(int value, int row, int column, int block, boolean editable) {
		this.value = value;
		this.row = row;
		this.column = column;
		this.block = block;
		this.editable = editable;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getColumn() {
		return column;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getBlock() {
		return block;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean getEditable() {
		return editable;
	}

}

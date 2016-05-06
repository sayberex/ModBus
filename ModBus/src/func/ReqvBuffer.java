package func;

public class ReqvBuffer {
	private final 	int		BUF_SIZE 	= 256;
	private			long	buf[] 		= new long[BUF_SIZE];
	private			int		size  		= 0;

	/*public Short[] getBuf() {
		return buf;
	}*/

	public Integer getSize() {
		return size;
	}
	
	public void setBufItem(int index, short Value) {
		if 
	}
	
	public void setSize(Integer size) {
		if ((size >= 0) && (size < BUF_SIZE))	this.size = size;
	}
}

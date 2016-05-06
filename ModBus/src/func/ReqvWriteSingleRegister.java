package func;

public class ReqvWriteSingleRegister {
	private int addr;
	private	int	reg;
	
	public ReqvWriteSingleRegister() {
		reg = 0;
		addr = 0;
	}
	
	public ReqvWriteSingleRegister(int addr, int reg) {
		this.addr 	= addr;
		this.reg 	= reg;
	}

	public int getAddr() {
		return addr;
	}

	public int getReg() {
		return reg;
	}

	public void setAddr(int addr) {
		if ((addr >= 0) && (addr <= 0xFFFF))	this.addr = addr;
	}

	public void setReg(int reg) {
		if ((reg >= 0) && (reg <= 0xFFFF))		this.reg = reg;
	}

	public Byte[] Reqv() {
		return null;
	}
}

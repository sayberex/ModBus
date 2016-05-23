package func;

public class ReqvWriteSingleRegister extends Reqvest {
	private int 		addr;
	private	int			reg;

	
	public ReqvWriteSingleRegister(int devAddr) {
		reg 	= 0;
		addr 	= 0;
		super.setDevAddr(devAddr);
	}
	
	public ReqvWriteSingleRegister(int devAddr, int addr) {
		this.addr 		= addr;
		super.setDevAddr(devAddr);
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

	public int[] Build() {
		super.setBufItem(0, super.getDevAddr());
		super.setBufItem(1, 0x06);			//0x06 	- Set Single Register Function

		super.setBufItem(2, addr>>>8);		//		- Set Single Register Address High
		super.setBufItem(3, addr&0xFF);		//		- Set Single Register Address Low
		
		super.setBufItem(4, reg>>>8);		//		- Set Single Register Value High
		super.setBufItem(5, reg&0xFF);		//		- Set Single Register Value Low

		super.setSize(6);					//		- Set Packet Size
		super.setBufItem(super.getSize(), super.calcLRC());
		super.setSize(super.getSize()+1);
		super.asciiSerialize();
		return super.getBuf();
	}
	
	public int[] Build(int reg) {
		super.setBufItem(0, super.getDevAddr());
		super.setBufItem(1, 0x06);			//0x06 	- Set Single Register Function
		super.setBufItem(2, addr);			//		- Set Single Register Address
		super.setBufItem(3, reg);			//		- Set Single Register Value
		super.setSize(4);					//		- Set Packet Size
		return super.getBuf();
	}
	
	public int[] Build(int addr, int reg) {
		super.setBufItem(0, super.getDevAddr());
		super.setBufItem(1, 0x06);			//0x06 	- Set Single Register Function
		super.setBufItem(2, addr);			//		- Set Single Register Address
		super.setBufItem(3, reg);			//		- Set Single Register Value
		super.setSize(4);					//		- Set Packet Size
		return super.getBuf();
	}
}

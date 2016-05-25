package func;

abstract public class Reqvest {
	private static final 	int			BUF_SIZE 	= 1024;						//PACKET BUFFER SIZE CONST
	private	static			int			buf[] 		= new int[BUF_SIZE];		//PACKET BUFFER AS IS NEED FOR CRC CALC
	private	static			byte		outbuf[]	= new byte[BUF_SIZE];		//PACKET ASCII OR RTU THAT WILL BE SEND TO PORT
	private static			int			outsize		= 0;						//outbuf index
	private	static			int			size  		= 0;						//PACKET BUFFER
	private 				int			devAddr		= 0;						//DEVICE ADDR


	private	static			ProtoMode	protoMode	= ProtoMode.ASCII;			//DEVICE PROTOCOL MODE ASCII/RTU
	private static final	byte[]		convDigitToASCII = new byte[] { 0x30,	//'0'
																		0x31,	//'1'
																		0x32,	//'2'
																		0x33,	//'3'
																		0x34,	//'4'
																		0x35,	//'5'
																		0x36,	//'6'
																		0x37,	//'7'
																		0x38,	//'8'
																		0x39,	//'9'
																		0x41,	//'A'
																		0x42,	//'B'
																		0x43,	//'C'
																		0x44,	//'D'
																		0x45,	//'E'
																		0x46};	//'F'

	//**************************************************************************
	public static ProtoMode getProtoMode() 				{return protoMode;}
	public static void 		setProtoMode(ProtoMode protoMode) {Reqvest.protoMode = protoMode;}
	//**************************************************************************


	//**************************************************************************
	public int 				getDevAddr() 				{return devAddr;}
	public void				setDevAddr(int devAddr) 	{this.devAddr = devAddr;}
	//**************************************************************************

	
	//**************************************************************************
	public int[] 			getBuf() 					{return buf;}
	public byte[]			getOutBuf()					{return outbuf;}
	protected static void 	setBufItem(int index, int Value) {
		if ((index >= 0) && (index <= BUF_SIZE))	buf[index] = Value;
	}
	//**************************************************************************
	
	//**************************************************************************
	public  	int			getSize() 					{return size;}
	protected 	void 		setSize(int size) 			{Reqvest.size = size;}
	//**************************************************************************
	
	//**************************************************************************
	abstract public int[] 	Build();
	//**************************************************************************
	

	//**************************************************************************
	protected static void asciiSerialize() {
		int val 		= 0;
		int outindex 	= 0;
		for (int i = 0; i < size; i++) {
			val = buf[i]&0xFF;
			outbuf[outindex++] = convDigitToASCII[val>>>4];
			outbuf[outindex++] = convDigitToASCII[val&0x0F];
		}
	}
	//**************************************************************************
	
	protected static byte calcLRC() {
		long LRC = 0;
		for (int i = 0; i < size; i++)	LRC += buf[i]&0xFF;
		LRC = ((long)0xFF - LRC) + 1;
		return (byte)(LRC);
	}
}

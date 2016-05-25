import func.*;
//pushed

public class main {

	public static void main(String[] args) {
		ReqvWriteSingleRegister wsr = new ReqvWriteSingleRegister(1,0x25);
		
		//wsr.set
		
		int Buf[] = wsr.Build();
		byte bbuf[] = wsr.getOutBuf();
		
		for (int i = 0; i < wsr.getSize(); i++) {
			System.out.println();
			System.out.printf("%2x", (byte)Buf[i]);
		}
		
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.printf("%x ", bbuf[i]);
		}
	}

}

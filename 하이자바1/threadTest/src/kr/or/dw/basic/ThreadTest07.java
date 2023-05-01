package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {

	/*
	 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
	 * 
	 * 컴퓨터의 가위바위보는 난수를 이용해서 구하고 
	 * 사용자의 가위바위보는 showInputDialog()를 이용해서 입력받는다.
	 * 
	 * 입력시간은 5초로 제한하고, 카운트다운을 진행한다.
	 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
	 * 
	 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
	 * 결과예시)
	 * -- 결     과 --
	 * 컴퓨터 : 가위
	 * 사용자 : 바위
	 * 	<승!!>
	 */
	public static InputRSP RSP = new InputRSP();
	
	public static void main(String[] args) {
		
		CountInput ci = new CountInput();
		
		RSP.start();
		
		ci.start();
		
	}

}

class InputRSP extends Thread{
	
	public static boolean in;
	
	@Override
	public void run() {
		String str = null;
		int URSP = 0;
		do {
			str = JOptionPane.showInputDialog("가위바위보 게임! 하나를 입력하세요");
			
			if(str.equals("가위")) {
				URSP = 1;
				in = true;
			}else if(str.equals("바위")) {
				URSP = 2;
				in = true;
			}else if(str.equals("보")) {
				URSP = 3;
				in = true;
			}
		}while(str == null || !str.equals("가위") && !str.equals("바위") && !str.equals("보"));
		
		int CRSP = (int)(Math.random() * 3) + 1;
		
		String CRSPs = null;
		if(CRSP == 1) {
			CRSPs = "가위";
		}else if(CRSP == 2) {
			CRSPs = "바위";
		}else if(CRSP == 3) {
			CRSPs = "보";
		}
		
		System.out.println("-- 결    과 --");
		System.out.println("컴퓨터 : " + CRSPs);
		System.out.println("사용자 : " + str);
		if(URSP == CRSP) {
			System.out.println("<무승부>");
		}else if(URSP == CRSP + 1 || URSP + 2 == CRSP) {
			System.out.println("<승!!!>");
		}else {
			System.out.println("<패...>");
		}
	}

}

class CountInput extends Thread{

	@Override
	public void run() {
		for(int i = 5; i >= 0; i--) {
			System.out.println(i);
			
			if(InputRSP.in == true) {
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			ThreadTest07.RSP.sleep(10L);
			ThreadTest07.RSP.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("지정시간이 경과하였습니다. 당신의 패배입니다.");
		
	}
	
}
package Main;

import housie_ticket.Coupn;

public class Test {
	public static void main(String[] args) {
		
		Coupn ticket = new Coupn();
		int[][] tNumber = ticket.getTicket();
		ticket.showTicket(tNumber);
	}
}

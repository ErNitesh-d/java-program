package methodoverloading;

class bank {
	int reteofinterest() {
		return 0;
	}
}

class sbi extends bank{
	int reteofinterest()
	{
		return 6;
	}
}
class axis extends bank{
	int reteofinterest() {
		return 5;
	}
}

 class methodovr1 {
public static void main(String []args) {
	System.out.println("Method Overload Demo");
	
	sbi s = new sbi();
	System.out.println("From SBI bank"+s.reteofinterest());
	
	axis a = new axis();
	System.out.println("From AXIS bank"+a.reteofinterest());
}


}




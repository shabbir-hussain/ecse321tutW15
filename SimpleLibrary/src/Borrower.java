import java.util.ArrayList;


public class Borrower {

	protected ArrayList<Loan> mActiveLoans;
	public String mName;
	public Borrower(String Name){
		mName = Name;

		mActiveLoans = new ArrayList<Loan>();
	}
	
	public void AddLoan(Loan l){
		mActiveLoans.add(l);
	}

}

import java.util.ArrayList;


public class PublicLibrary {
	public ArrayList<Item> mCatalog;
	protected ArrayList<Borrower> mBorrowers;
	protected ArrayList<Loan> mActiveLoans;
	
	public PublicLibrary(ArrayList<Borrower> borrowers){
		mBorrowers = borrowers;
		mActiveLoans = new ArrayList<Loan>();
		mCatalog = new ArrayList<Item>();
		
		Book b1 = new Book("1","HitchHikersGuideToTheGalaxy");
		Book b2 = new Book("2","101DadJokes");
		mCatalog.add(b1);
		mCatalog.add(b2);
		
	}
	
	
	
	
	public void LoanItem(Item loanItem,Borrower b){
		Loan l = new Loan(loanItem,b);
		b.AddLoan(l);
				
	}
}

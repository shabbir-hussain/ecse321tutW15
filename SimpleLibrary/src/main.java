import java.util.ArrayList;


public class main {
	public static void main(String[] args){
		
		Borrower shabbir = new Borrower("Shabbir");
		ArrayList<Borrower> borrowerList = new ArrayList<Borrower>();
		borrowerList.add(shabbir);
		
		PublicLibrary lib = new PublicLibrary(borrowerList);
		
		lib.LoanItem(lib.mCatalog.get(0), shabbir);
	}
}



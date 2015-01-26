
public class Loan {
	public Loan(Item loanItem, Borrower b) {
		person = b;
		item = loanItem;
		loanDate = "now";
		returnDate = "Later";
	}
	public Borrower person;
	public Item item;
	public String loanDate;
	public String returnDate;
}

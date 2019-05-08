package logic;

public class SearchCardID {

	public static int searchBarItemID;
	
	public static int newID() {
		searchBarItemID++;
		return searchBarItemID;
	}
	
}

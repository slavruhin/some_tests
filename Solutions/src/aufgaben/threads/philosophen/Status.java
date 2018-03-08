package aufgaben.threads.philosophen;

public enum Status {

	THINK          ("denkt nach..."), 
	HUNGRY         ("hat Hunger"), 
	LEFT_FORK_UP   ("nimmt die linke Gabel"), 
	RIGTH_FORK_UP  ("nimmt die rechte Gabel"), 
	EAT            ("isst..."),
	RIGTH_FORK_DOWN("legt die rechte Gabel ab"), 
	LEFT_FORK_DOWN ("legt die linke Gabel ab"); 

	private Status(String message) {
		this.message = message;
	}
	public final String message;
}

package bb_management;

public interface User {
	public void add() throws Exception;
	public void delete(String n) throws Exception;
	public void edit(String n) throws Exception;
	public void search(String n) throws Exception;
}

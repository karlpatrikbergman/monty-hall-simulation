package se.patrikbergman.lab.misc.montyhall.host;

public interface HostViewOfBox {
	public int getId();
	public boolean containsMoney();
	public boolean isPicked();
	public void open();
	public void close();
}

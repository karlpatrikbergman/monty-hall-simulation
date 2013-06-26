package se.patrikbergman.lab.misc.montyhall.guest;

public interface GuestViewOfBox {
	public int getId();
	public void setAsPicked();
	public void setAsNotPicked();
	public boolean isPicked();
	public boolean isOpen();
}

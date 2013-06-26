package se.patrikbergman.lab.misc.montyhall.box;

import se.patrikbergman.lab.misc.montyhall.guest.GuestViewOfBox;
import se.patrikbergman.lab.misc.montyhall.host.HostViewOfBox;
import se.patrikbergman.lab.misc.montyhall.staff.StaffViewOfBox;

public class Box implements StaffViewOfBox, GuestViewOfBox, HostViewOfBox {
	private final int id;
	private boolean containsMoney = false;
	private boolean isOpen = false;
	private boolean isPickedByGuest = false;
	
	public Box(int id) {
		this.id = id;
	}
	
	public int getId()  {
		return this.id;
	}
	
	@Override
	public void setAsPicked() {
		this.isPickedByGuest = true;
		
	}

	@Override
	public void setAsNotPicked() {
		this.isPickedByGuest = false;
	}

	@Override
	public boolean isPicked() {
		return isPickedByGuest;
	}

	@Override
	public void open() {
		this.isOpen = true;
	}
	
	@Override
	public boolean isOpen() {
		return isOpen;
	}

	@Override
	public void close() {
		this.isOpen = false;
		
	}

	@Override
	public void empty() {
		this.containsMoney = false;
	}

	@Override
	public void putMoneyIn() {
		this.containsMoney = true;
	}
	
	@Override
	public boolean containsMoney() {
		return containsMoney;
	}
}

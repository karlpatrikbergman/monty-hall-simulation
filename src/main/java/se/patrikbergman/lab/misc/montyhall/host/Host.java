package se.patrikbergman.lab.misc.montyhall.host;

import java.util.List;

public class Host {
	private final List<? extends HostViewOfBox> boxes;
	
	public Host(List<? extends HostViewOfBox> boxes) {
		this.boxes = boxes;
	}
	
	public void openEmtpyNotPickedBox() {
		closeAllBoxes();
		for (HostViewOfBox box : boxes) {
			if (!box.isPicked() && !box.containsMoney()) {
				box.open();
				System.out.println("Host opened empty box: " + box.getId());
				break;
			}
		}
	}
	
	private void closeAllBoxes() {
		for (HostViewOfBox box : boxes) {
			box.close();
		}
	}
}

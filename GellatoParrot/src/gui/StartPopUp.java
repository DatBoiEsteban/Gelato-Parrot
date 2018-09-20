package gui;

import javax.swing.JOptionPane;

public class StartPopUp {
	private boolean start = false;
	public StartPopUp() {
		Object[] options = {"Si!", "Nel Meringuel"};
		int result = JOptionPane.showOptionDialog(null, "Desea iniciar la partida", "Gellato Parrot", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(result == JOptionPane.YES_OPTION) {
			setStart(true);
		}else {
			setStart(false);
		}
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
}

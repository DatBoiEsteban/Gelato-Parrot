package consts;

import java.awt.Font;

public interface IGUIconsts {
	public final int WINDOW_HEIGHT = 720;
	public final int WINDOW_WIDTH = 1280;
	public final int BUTTON_HEIGHT = 40;
	public final int BUTTON_WIDTH = 120;
	public final int BORDER = 30;
	public final int COUNTER_WIDTH = 80;
	public final int COUNTER_HEIGHT = 30;
	public final String WINDOW_TITLE = "Gelato Parrot";

	// buttons consts
	public final int BUTTONS_PANE_HEIGHT = WINDOW_HEIGHT / 4;
	public final int BUTTONS_PANE_WIDTH = WINDOW_WIDTH / 4;
	public final int BUTTONS_Y_LOCATION = WINDOW_HEIGHT - BUTTONS_PANE_HEIGHT;
	public final int BUTTONS_X_LOCATION = (WINDOW_WIDTH / 2) - (BUTTONS_PANE_WIDTH / 2);

	public final int ING_BUTTON_WIDTH = BUTTONS_PANE_WIDTH / 6;
	public final int ING_BUTTON_HEIGHT = 40;

	public final Font BUTTONS_FONT = new Font("Courier New", Font.PLAIN, 12);

	// Cone const
	public final int CONE_PANE_HEIGHT = (int) (WINDOW_HEIGHT * 0.7);
	public final int CONE_PANE_WIDTH = WINDOW_WIDTH / 8;
	public final int CONE_PANE_X_LOCATION = (int) (WINDOW_WIDTH * 0.80);
}

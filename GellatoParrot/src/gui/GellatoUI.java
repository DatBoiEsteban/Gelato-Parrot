package gui;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import consts.IGUIconsts;
import consts.I_INGconsts;
import lists.GenericList;
import lists.Ingredient;
import loader.JsonLoader;
import threads.PaintIngredientButtons;
import threads.Timer;

public class GellatoUI extends JFrame implements IGUIconsts, I_INGconsts {
	private GenericList<Ingredient> DrawableIngs = null;
	private JsonLoader IngsJson = null;
	private Timer time;
	private StartPopUp strt;
	private PaintIngredientButtons ingsPaintr;

	public GellatoUI(JsonLoader json) {
		IngsJson = json;
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBounds(200, 200, WINDOW_WIDTH, WINDOW_HEIGHT);

		this.setTitle(WINDOW_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		initComponents();
		this.setVisible(true);
		time = new Timer((JLabel) this.getContentPane().getComponent(1));
		strt = new StartPopUp();
		if (getStatus()) {
			this.setDrawableIngs(IngsJson.getIngL());
			paint(this.getGraphics());
			time.resumeTimer();
			time.start();
		} else {
			this.dispose();
			System.exit(0);
		}
	}

	public boolean getStatus() {
		return strt.isStart();
	}

	public int getCurrentTime() {
		return time.getTime();
	}

	public void initComponents() {
		JButton sndOrd = new JButton("Enviar Orden!");
		sndOrd.setBounds(this.getWidth() - BUTTON_WIDTH - BORDER, this.getHeight() - BUTTON_HEIGHT - BORDER,
				BUTTON_WIDTH, BUTTON_HEIGHT);

		JLabel time = new JLabel("Tiempo: ");
		time.setBounds(this.getWidth() - BORDER - COUNTER_WIDTH, BORDER, COUNTER_WIDTH, COUNTER_HEIGHT);

		this.getContentPane().add(sndOrd);
		this.getContentPane().add(time);
		//this.getContentPane().setBackground(Color.black);
	}

	public void setDrawableIngs(GenericList<Ingredient> ings) {
		this.DrawableIngs = ings;
	}

	public GenericList<Ingredient> getDrawableIngs() {
		return DrawableIngs;
	}
	
}

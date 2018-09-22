package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import consts.IGUIconsts;
import lists.GenericList;
import lists.Ingredient;
import lists.Queue;
import lists.Stack;

public class GellatoGui extends JFrame implements IGUIconsts {
	private Stack<Ingredient> cone = new Stack<Ingredient>();;
	private ConePanel PlayerOrderBuild;
	private ButtonsArray panel;
	private SendOrder SendOrderButton;
	private InfoPanel info;
	private OrderPanel OrderToBuild;
	private UndoButton undoButton;
	private GenericList<Ingredient> currentOrder;

	public GellatoGui() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setTitle("Gellato Parrot");
		this.setResizable(false);
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {
		PlayerOrderBuild = new ConePanel(cone);
		panel = new ButtonsArray(cone, PlayerOrderBuild);
		info = new InfoPanel();
		info.setBounds(0, 0, 115, 90);
		OrderToBuild = new OrderPanel();
		OrderToBuild.setLocation(PlayerOrderBuild.getX() - CONE_PANE_WIDTH, 0);

		JPanel panel2 = new JPanel();
		panel2.setBounds(500, 0, 200, 100);
		panel2.setBackground(Color.decode("#abb2bc"));

		SendOrderButton = new SendOrder();
		SendOrderButton.setBounds((int) (WINDOW_WIDTH - BORDER - (BUTTON_WIDTH * 0.85)),
				WINDOW_HEIGHT - BORDER - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
		undoButton = new UndoButton(PlayerOrderBuild);
		undoButton.setBounds(SendOrderButton.getX() - BUTTON_WIDTH - 10, SendOrderButton.getY(), BUTTON_WIDTH,
				BUTTON_HEIGHT);

		this.getContentPane().add(panel);
		this.getContentPane().add(PlayerOrderBuild);
		this.getContentPane().add(SendOrderButton);
		this.getContentPane().add(info);
		this.getContentPane().add(OrderToBuild);
		this.getContentPane().add(undoButton);

		this.getContentPane().add(panel2);
	}

	public void addButtons(GenericList<Ingredient> pIngL) {
		panel.paintButtons(pIngL);

	}

	public void changePoints(int newPoints) {
		info.changePoints(newPoints);
	}

	public void setCurrentOrder(GenericList<Ingredient> pOrder) {
		currentOrder = pOrder;
		OrderToBuild.setOrder(currentOrder);
	}

	public GenericList<Ingredient> getCurrentOrder() {
		return currentOrder;
	}

	public Stack<Ingredient> getCone() {
		return cone;
	}

	public void resetCone() {
		cone = new Stack<Ingredient>();
		PlayerOrderBuild.setNewCone(cone);
		panel.setNewStack(cone);
	}

	public void incrementOrdersDone() {
		info.incrementOrdersDone();
	}

	public int getOrdersLeft() {
		return info.getOrdersLeft();
	}

	public boolean doResort() {
		return SendOrderButton.doResort();
	}

	public void setOrdersLeft(int points) {
		info.addOrdersLeft(points);
	}

	public void setOrderStatus() {
		SendOrderButton.wasOrderCorrect(true);
	}

	public void resetOrderStatus() {
		SendOrderButton.resetStatus();
	}

	public boolean isSendOrderPressed() {
		return SendOrderButton.isPressed();
	}

	public void SendOrderUnpress() {
		SendOrderButton.setUnpressed();
	}
}

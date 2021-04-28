package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameView extends JFrame {
	private JPanel hero;
	private JPanel opponent;
	private JPanel heroButtons;
	private JPanel opponentButtons;
	// private JPanel Field;
	private JPanel heroField;
	private JPanel opponentField;
	private JPanel heroHand;
	private JPanel opponentHand;
	private JPanel hero1;
	private JPanel hero2;
//	private JPanel play;
	public GameView() {
		this.setBounds(150, 0, 1250, 975);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		hero1 = new JPanel();
		hero1.setPreferredSize(new Dimension(this.getWidth(), 300));

		hero2 = new JPanel();
		hero2.setPreferredSize(new Dimension(this.getWidth(), 300));

		/*
		 * play = new JPanel(); play.setPreferredSize(new Dimension(300, 200));
		 */
		this.add(hero1, BorderLayout.SOUTH);
		this.add(hero2, BorderLayout.NORTH);
		//this.add(play, BorderLayout.CENTER);
		hero1.setLayout(new GridLayout(2, 5));
		hero2.setLayout(new GridLayout(2, 5));
		gameVisual();
		this.revalidate();
		this.repaint();

	}

	public JPanel getHero1() {
		return hero1;
	}

	public void setHero1(JPanel hero1) {
		this.hero1 = hero1;
	}

	public JPanel getHero2() {
		return hero2;
	}

	public void setHero2(JPanel hero2) {
		this.hero2 = hero2;
	}

	/*
	 * public JPanel getPlay() { return play; }
	 * 
	 * public void setPlay(JPanel play) { this.play = play; }
	 */
	
	public void gameVisual() {
		this.setBounds(100, 0, 1300, 1000);
		this.setVisible(true);
		hero = new JPanel();
		opponent = new JPanel();
		heroButtons = new JPanel();
		opponentButtons = new JPanel();
		heroHand = new JPanel();
		opponentHand = new JPanel();
		// Field = new JPanel();
		heroField = new JPanel();
		opponentField = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		hero.setPreferredSize(new Dimension(650, 225));
		opponent.setPreferredSize(new Dimension(650, 225));
		heroButtons.setPreferredSize(new Dimension(300, 100));
		opponentButtons.setPreferredSize(new Dimension(100, 100));
		heroHand.setPreferredSize(new Dimension(300, 100));
		opponentHand.setPreferredSize(new Dimension(300, 100));
		// Field.setPreferredSize(new Dimension(this.getWidth(), 500));
		this.add(hero, BorderLayout.SOUTH);
		this.add(opponent, BorderLayout.NORTH);
		// this.add(Field, BorderLayout.CENTER);
		// Field.setLayout(new GridLayout(2, 0));
		heroButtons.setLayout(new GridLayout(2, 1));
		opponentButtons.setLayout(new GridLayout(2, 1));
		hero.setLayout(new GridLayout(1, 2));
		opponent.setLayout(new GridLayout(1, 3));
		hero.add(heroButtons, BorderLayout.EAST);
		opponent.add(opponentButtons, BorderLayout.WEST);
		hero.add(heroHand, BorderLayout.WEST);
		opponent.add(opponentHand, BorderLayout.EAST);
//		this.add(heroField, BorderLayout.SOUTH);
//		this.add(opponentField, BorderLayout.NORTH);
		this.revalidate();
		this.repaint();
	}

	/*
	 * public JPanel getField() { return Field; }
	 */

//	public void setField(JPanel field) {
//		Field = field;
//	}

	public JPanel getHero() {
		return hero;
	}

	public void setHero(JPanel hero) {
		this.hero = hero;
	}

	public JPanel getOpponent() {
		return opponent;
	}

	public void setOpponent(JPanel opponent) {
		this.opponent = opponent;
	}

	public JPanel getHeroButtons() {
		return heroButtons;
	}

	public void setHeroButtons(JPanel heroButtons) {
		this.heroButtons = heroButtons;
	}

	public JPanel getOpponentButtons() {
		return opponentButtons;
	}

	public void setOpponentButtons(JPanel opponentButtons) {
		this.opponentButtons = opponentButtons;
	}

	public JPanel getHeroField() {
		return heroField;
	}

	public void setHeroField(JPanel heroField) {
		this.heroField = heroField;
	}

	public JPanel getOpponentField() {
		return opponentField;
	}

	public void setOpponentField(JPanel opponentField) {
		this.opponentField = opponentField;
	}

	public JPanel getHeroHand() {
		return heroHand;
	}

	public void setHeroHand(JPanel heroHand) {
		this.heroHand = heroHand;
	}

	public JPanel getOpponentHand() {
		return opponentHand;
	}

	public void setOpponentHand(JPanel opponentHand) {
		this.opponentHand = opponentHand;
	}

	public JPanel getField1() {
		return heroField;
	}

	public void setField1(JPanel field1) {
		heroField = field1;
	}

	public JPanel getField2() {
		return opponentField;
	}

	public void setField2(JPanel field2) {
		opponentField = field2;
	}

	public JPanel getP1hand() {
		return heroHand;
	}

	public void setP1hand(JPanel p1hand) {
		this.heroHand = p1hand;
	}

	public JPanel getP2hand() {
		return opponentHand;
	}

	public void setP2hand(JPanel p2hand) {
		this.opponentHand = p2hand;
	}

	public JPanel getPlayer1() {
		return hero;
	}

	public void setPlayer1(JPanel player1) {
		hero = player1;
	}

	public JPanel getPlayer2() {
		return opponent;
	}

	public void setPlayer2(JPanel player2) {
		opponent = player2;
	}

	public static void main(String[] args) {
		new GameView();
	}

	public JPanel getButtons1() {
		return heroButtons;
	}

	public void setButtons1(JPanel buttons1) {
		this.heroButtons = buttons1;
	}

	public JPanel getButtons2() {
		return opponentButtons;
	}

	public void setButtons2(JPanel buttons2) {
		this.opponentButtons = buttons2;
	}

}

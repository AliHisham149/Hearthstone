package Controller;

import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import engine.Game;
import engine.GameListener;
import exceptions.FullHandException;
import view.GameView;

public class GameController implements ActionListener, GameListener {
	private GameView view;
	private Game model;
	private ArrayList<JButton> hand1;

	private JButton opponentButton = new JButton();
	private JButton heroButton = new JButton();
	private JButton endturn1;
	private JButton endturn2;
	private JButton addToField1;
	private JButton addToField2;
	private JButton heroInformation1;
	private JButton attack1;
	private JButton attack2;
	private JButton heroInformation2;
	private JButton savedHero;
	private String firstHero;
	private String secondHero;
	private Hero p1;
	private Hero p2;
	private ArrayList field1;
	private boolean condition1;
	private boolean condition2;

	public GameController() throws FullHandException, CloneNotSupportedException, IOException {
		view = new GameView();
		JButton h1 = new JButton("HUNTER");
		h1.addActionListener(this);
		h1.setActionCommand("hunter1");
		JButton h2 = new JButton("HUNTER");
		h2.addActionListener(this);
		h2.setActionCommand("hunter2");
		JButton m1 = new JButton("MAGE");
		m1.addActionListener(this);
		m1.setActionCommand("mage1");
		JButton m2 = new JButton("MAGE");
		m2.addActionListener(this);
		m2.setActionCommand("mage2");
		JButton p1 = new JButton("PRIEST");
		p1.addActionListener(this);
		p1.setActionCommand("priest1");
		JButton p2 = new JButton("PRIEST");
		p2.addActionListener(this);
		p2.setActionCommand("priest2");
		JButton w1 = new JButton("WARLOCK");
		w1.addActionListener(this);
		w1.setActionCommand("warlock1");
		JButton w2 = new JButton("WARLOCK");
		w2.addActionListener(this);
		w2.setActionCommand("warlock2");
		JButton pal1 = new JButton("PALADIN");
		pal1.addActionListener(this);
		pal1.setActionCommand("paladin1");
		JButton pal2 = new JButton("PALADIN");
		pal2.addActionListener(this);
		pal2.setActionCommand("paladin2");
		JButton assignhero1 = new JButton("ASSIGN HERO1");
		assignhero1.addActionListener(this);
		JButton assignhero2 = new JButton("ASSIGN HERO2");
		assignhero2.addActionListener(this);
		JButton start = new JButton("START");
		start.addActionListener(this);
		view.getHero1().add(h1);
		view.getHero1().add(m1);
		view.getHero1().add(p1);
		view.getHero1().add(w1);
		view.getHero1().add(pal1);
		view.getHero1().add(assignhero1);
		view.getHero2().add(h2);
		view.getHero2().add(m2);
		view.getHero2().add(p2);
		view.getHero2().add(w2);
		view.getHero2().add(pal2);
		view.getHero2().add(assignhero2);
		// view.getPlay().add(start, BorderLayout.CENTER);
		start.setPreferredSize(new Dimension(300, 100));
//		TheGame();
		/*
		 * Hunter p1=new Hunter(); Mage p2=new Mage(); view =new GameView(); model=new
		 * Game(p1, p2); hand1=new ArrayList<JButton>(); endturn1=new JButton();
		 * endturn2=new JButton(); usepower1=new JButton(); usepower2=new JButton();
		 * ArrayList<JButton> field1=new ArrayList<JButton>(); JTextArea Heroinfo=new
		 * JTextArea(p1.getName()+"\n"+p1.getCurrentHP()+"\n"+p1.getCurrentManaCrystals(
		 * )+"\n"+p1.getTotalManaCrystals()); JTextArea Heroinfo2=new
		 * JTextArea(p2.getName()+"\n"+p2.getCurrentHP()+"\n"+p2.getCurrentManaCrystals(
		 * )+"\n"+p2.getTotalManaCrystals()); Heroinfo.setEditable(false);
		 * Heroinfo2.setEditable(false); usepower1.addActionListener(this);
		 * usepower1.setText("use Hero power"); view.add(usepower1, BorderLayout.EAST);
		 * usepower2.addActionListener(this); usepower2.setText("use Hero power");
		 * view.add(usepower2, BorderLayout.WEST); endturn1.addActionListener(this);
		 * endturn1.setText("end turn"); endturn1.setActionCommand("p1Turn");
		 * endturn2.addActionListener(this); endturn2.setText("end turn");
		 * endturn2.setActionCommand("p2Turn"); // endturn.setPreferredSize(new
		 * Dimension(50,50)); view.add(endturn1, BorderLayout.EAST); int
		 * left1=p1.getDeck().size()-p1.getHand().size();
		 * view.getPlayer1().setToolTipText(p1.getName()+"/"+"Hp:"+p1.getCurrentHP()+"/"
		 * +"Cmc:"+ p1.getCurrentManaCrystals()+"/"
		 * +"Tmc:"+p1.getTotalManaCrystals()+"/"+left1+"CardsLeft"); int
		 * left2=p2.getDeck().size()-p2.getHand().size();
		 * view.getPlayer2().setToolTipText(p2.getName()+"/"+"Hp:"+p2.getCurrentHP()+"/"
		 * +"Cmc:"+ p2.getCurrentManaCrystals()+"/"+"Tmc:"
		 * +p2.getTotalManaCrystals()+"/"+left2+"CardsLeft"); model.setListener(this);
		 * 
		 * for(int i=0;i<model.getCurrentHero().getHand().size();i++) { JButton card=new
		 * JButton(); card.addActionListener(this); card.setSize(20, 70); String s=
		 * p1.getHand().get(i).getName() + "\n"+" " + p1.getHand().get(i).getManaCost()
		 * +"\n"+" "+p1.getHand().get(i).getRarity(); card.setText(s);
		 * view.getP1hand().add(card); } for(int
		 * i=0;i<model.getOpponent().getHand().size();i++) { JButton card=new JButton();
		 * card.addActionListener(this); card.setSize(20, 70); String s=
		 * p2.getHand().get(i).getName() + "\n  " + p2.getHand().get(i).getManaCost()
		 * +"  \n  "+p2.getHand().get(i).getRarity(); card.setText(s);
		 * 
		 * view.getP2hand().add(card); } view.getButtons1().add(usepower1);
		 * view.getButtons1().add(endturn1);
		 * view.getPlayer1().add(Heroinfo,BorderLayout.WEST);
		 * view.getButtons2().add(usepower2); view.getButtons2().add(endturn2);
		 * view.getPlayer2().add(Heroinfo2);
		 */
	}

	public void TheGame() {
//		p1=new Hunter();
//		p2=new  Mage();
		try {
			model = new Game(p1, p2);
		} catch (FullHandException | CloneNotSupportedException e) {
			// ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e);
			// ed.setVisible(true);
		}
		model.setListener(this);

		int x = p1.getCurrentManaCrystals() == 1 ? 1 : 2;
		String curHeroPower = p1.isHeroPowerUsed() ? "Already Used" : "Available";
		String oppHeroPower = p2.isHeroPowerUsed() ? "Already Used" : "Available";
		if (x == 1) {
			heroButton.setText("<html>" + p1.getName().toUpperCase() + "<br/>HP: " + p1.getCurrentHP() + "/30"
					+ "<br/>ManaCrystals: " + p1.getCurrentManaCrystals() + "/" + p1.getTotalManaCrystals()
					+ "<br/>Total Deck Cards: " + p1.getDeck().size() + "<br/>Hero Power: " + curHeroPower + "</html>");

			opponentButton.setText("<html>" + p2.getName().toUpperCase() + "<br/>HP: " + p2.getCurrentHP() + "/30"
					+ "<br/>ManaCrystals: " + p2.getCurrentManaCrystals() + "/" + p2.getTotalManaCrystals()
					/* + "<br/>Cards in Hand: " + p2.getHand().size() */ + "<br/>Total Deck Cards: "
					+ p2.getDeck().size() + "<br/>Hero Power: " + oppHeroPower + "</html>");

		} else {
			heroButton.setText("<html>" + p1.getName().toUpperCase() + "<br/>HP: " + p1.getCurrentHP() + "/30"
					+ "<br/>ManaCrystals: " + p1.getCurrentManaCrystals() + "/" + p1.getTotalManaCrystals()
					+ "<br/>Total Deck Cards: " + p1.getDeck().size() + "<br/>Hero Power: " + curHeroPower + "</html>");

			opponentButton.setText("<html>" + p2.getName().toUpperCase() + "<br/>HP: " + p2.getCurrentHP() + "/30"
					+ "<br/>ManaCrystals: " + p2.getCurrentManaCrystals() + "/" + p2.getTotalManaCrystals()
					/* + "<br/>Cards in Hand: " + p2.getHand().size() */ + "<br/>Total Deck Cards: "
					+ p2.getDeck().size() + "<br/>Hero Power: " + oppHeroPower + "</html>");

		}
		for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) {
			JButton card = new JButton();
			card.addActionListener(this);
			card.setSize(35, 85);

			if (p1.getHand().get(i) instanceof Minion) {
				Minion m = (Minion) p1.getHand().get(i);
				String s = m.getName() + "\n" + " " + m.getManaCost() + "\n" + " " + m.getRarity() + "\n" + " "
						+ m.getCurrentHP() + "\n" + " " + m.getMaxHP() + "\n" + " " + m.isDivine() + "\n" + " "
						+ !m.isSleeping() + "\n" + " " + m.isTaunt();

				card.setText(s);
			} else {
				String s = p1.getHand().get(i).getName() + "\n" + " " + p1.getHand().get(i).getManaCost() + "\n" + " "
						+ p1.getHand().get(i).getRarity();
				card.setText(s);
			}

			view.getHeroHand().add(card);
		}
		for (int i = 0; i < model.getOpponent().getHand().size(); i++) {
			JButton card = new JButton();
			card.addActionListener(this);
			card.setSize(35, 85);
			if (p2.getHand().get(i) instanceof Minion) {
				Minion m = (Minion) p2.getHand().get(i);
				String s = m.getName() + "\n" + " " + m.getManaCost() + "\n" + " " + m.getRarity() + "\n" + " "
						+ m.getCurrentHP() + "\n" + " " + m.getMaxHP() + "\n" + " " + m.isDivine() + "\n" + " "
						+ !m.isSleeping() + "\n" + " " + m.isTaunt();
				card.setText(s);
			} else {
				String s = p2.getHand().get(i).getName() + "\n  " + " " + p2.getHand().get(i).getManaCost() + "  \n  "
						+ " " + p2.getHand().get(i).getRarity();
				card.setText(s);
			}
			view.getOpponentHand().add(card);

		}
		attack1 = new JButton("ATTACK");
		attack1.addActionListener(this);
		attack2 = new JButton("ATTACK");
		attack2.addActionListener(this);
		attack2.setActionCommand("attack2");
		endturn1 = new JButton("END TURN");
		endturn1.addActionListener(this);
		endturn2 = new JButton("END TURN");
		endturn2.addActionListener(this);
		endturn2.setActionCommand("endturn2");
		addToField1 = new JButton("ADD TO FIELD");
		addToField1.addActionListener(this);
		addToField2 = new JButton("ADD TO FIELD");
		addToField2.addActionListener(this);
		addToField2.setActionCommand("addToField2");

		view.getHeroButtons().add(heroButton, BorderLayout.NORTH);
		view.getOpponentButtons().add(opponentButton, BorderLayout.NORTH);
		view.getHeroButtons().add(attack1, BorderLayout.SOUTH);
		view.getHeroButtons().add(endturn1, BorderLayout.EAST);
		view.getHeroButtons().add(addToField1, BorderLayout.WEST);
		view.getOpponentButtons().add(attack2, BorderLayout.SOUTH);
		view.getOpponentButtons().add(endturn2, BorderLayout.EAST);
		view.getOpponentButtons().add(addToField2, BorderLayout.WEST);

	}

	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		if (b.getActionCommand().equals("hunter1")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			firstHero = "Hunter";
		} else if (b.getActionCommand().equals("mage1")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			firstHero = "Mage";
		} else if (b.getActionCommand().equals("warlock1")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			firstHero = "Warlock";
		} else if (b.getActionCommand().equals("priest1")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			firstHero = "Priest";
		} else if (b.getActionCommand().equals("paladin1")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			firstHero = "Paladin";
		}

		else if (b.getActionCommand().equals("hunter2")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			secondHero = "Hunter";
		} else if (b.getActionCommand().equals("mage2")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			secondHero = "Mage";
		} else if (b.getActionCommand().equals("warlock2")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			secondHero = "Warlock";
		} else if (b.getActionCommand().equals("priest2")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			secondHero = "Priest";
		} else if (b.getActionCommand().equals("paladin2")) {
			if (savedHero != null)
				savedHero.setBackground(new JButton().getBackground());
			savedHero = b;
			savedHero.setBackground(Color.LIGHT_GRAY);
			secondHero = "Paladin";
		} else if (b.getActionCommand().equals("ASSIGN HERO1") && !firstHero.equals("")) {
			condition1 = true;
			// view.getTheBlock().remove(view.getBlocker1());
			if (firstHero.equals("Hunter"))
				try {
					p1 = new Hunter();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (firstHero.equals("Mage"))
				try {
					p1 = new Mage();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (firstHero.equals("Warlock"))
				try {
					p1 = new Warlock();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (firstHero.equals("Priest"))
				try {
					p1 = new Priest();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (firstHero.equals("Paladin"))
				try {
					p1 = new Paladin();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			if (condition1 && condition2) {

				view.remove(view.getHero2());
				view.remove(view.getHero1());
				// view.remove(view.getPlay());
				view.gameVisual();
				TheGame();
				view.revalidate();
				view.repaint();
			}
			view.revalidate();
			view.repaint();
		}

		else if (b.getActionCommand().equals("ASSIGN HERO2") && !secondHero.equals("")) {
			condition2 = true;
			view.revalidate();
			view.repaint();
			if (secondHero.equals("Hunter"))
				try {
					p2 = new Hunter();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (secondHero.equals("Mage"))
				try {
					p2 = new Mage();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (secondHero.equals("Warlock"))
				try {
					p2 = new Warlock();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (secondHero.equals("Priest"))
				try {
					p2 = new Priest();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			else if (secondHero.equals("Paladin"))
				try {
					p2 = new Paladin();
				} catch (IOException | CloneNotSupportedException e1) {
					/*
					 * ExceptionDialog ed = new ExceptionDialog("ERORR!!!", e1);
					 * ed.setVisible(true);
					 */
				}
			if (condition1 && condition2) {
				view.remove(view.getHero2());
				view.remove(view.getHero1());
				// view.remove(view.getPlay());
				view.gameVisual();
				TheGame();
				view.revalidate();
				view.repaint();
			}
			view.revalidate();
			view.repaint();
		}

		/*
		 * @Override public void actionPerformed(ActionEvent e) { JButton b = (JButton)
		 * e.getSource();
		 * 
		 * if (b.getActionCommand().equals("p1Turn")) {
		 * 
		 * try { model.endTurn(); view.getP1hand().removeAll();
		 * view.getP2hand().removeAll(); for (int i = 0; i <
		 * model.getOpponent().getHand().size(); i++) { JButton card = new JButton();
		 * card.addActionListener(this); card.setSize(20, 70); String s =
		 * p2.getHand().get(i).getName() + "\n  " + p2.getHand().get(i).getManaCost() +
		 * "  \n  " + p2.getHand().get(i).getRarity(); card.setText(s);
		 * 
		 * view.getP2hand().add(card); } heroInformation2.setText(p2.getName() + "\n" +
		 * p2.getCurrentHP() + "\n" + p2.getCurrentManaCrystals() + "\n" +
		 * p2.getTotalManaCrystals()); for (int i = 0; i <
		 * model.getCurrentHero().getHand().size(); i++) { JButton card = new JButton();
		 * card.addActionListener(this); card.setSize(20, 70); String s =
		 * p1.getHand().get(i).getName() + "\n" + " " +
		 * p1.getHand().get(i).getManaCost() + "\n" + " " +
		 * p1.getHand().get(i).getRarity(); card.setText(s);
		 * 
		 * view.getP1hand().add(card); } view.getPlayer1().revalidate();
		 * view.getPlayer1().repaint(); view.getPlayer2().revalidate();
		 * view.getPlayer2().repaint(); } catch (FullHandException e1) {
		 * e1.printStackTrace(); } catch (CloneNotSupportedException e1) {
		 * e1.printStackTrace(); }
		 * 
		 * } if (b.getActionCommand().equals("p2Turn")) {
		 * 
		 * try { model.endTurn(); for (int i = 0; i < p2.getHand().size(); i++) {
		 * p2.getHand().remove(i);
		 * 
		 * } for (int i = 0; i < p1.getHand().size(); i++) { p1.getHand().remove(i);
		 * 
		 * } for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) { JButton
		 * card = new JButton(); card.addActionListener(this); card.setSize(20, 70);
		 * String s = p1.getHand().get(i).getName() + "\n" + " " +
		 * p1.getHand().get(i).getManaCost() + "\n" + " " +
		 * p1.getHand().get(i).getRarity(); card.setText(s);
		 * 
		 * view.getP1hand().add(card); } heroInformation1.setText(p1.getName() + "\n" +
		 * p1.getCurrentHP() + "\n" + p1.getCurrentManaCrystals() + "\n" +
		 * p1.getTotalManaCrystals()); for (int i = 0; i <
		 * model.getOpponent().getHand().size(); i++) { JButton card = new JButton();
		 * card.addActionListener(this); card.setSize(20, 70); String s =
		 * p2.getHand().get(i).getName() + "\n  " + p2.getHand().get(i).getManaCost() +
		 * "  \n  " + p2.getHand().get(i).getRarity(); card.setText(s);
		 * 
		 * view.getP2hand().add(card); } view.getPlayer1().revalidate();
		 * view.getPlayer1().repaint(); view.getPlayer2().revalidate();
		 * view.getPlayer2().repaint(); } catch (FullHandException e1) {
		 * e1.printStackTrace(); } catch (CloneNotSupportedException e1) {
		 * e1.printStackTrace(); }
		 * 
		 * }
		 * 
		 * }
		 */
	}

	public static void main(String[] args) throws FullHandException, CloneNotSupportedException, IOException {
		new GameController();
	}
}

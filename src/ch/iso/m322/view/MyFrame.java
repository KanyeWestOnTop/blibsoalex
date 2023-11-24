package ch.iso.m322.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ch.iso.m322.controller.AddDataActionListener;
import ch.iso.m322.controller.EintragLoader;
import ch.iso.m322.model.Eintrag;
import ch.iso.m322.ressources.FrameConstants;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 2438104279704561527L;

	private MyMenu myMenuBar;
	private JTextField eintrag;
	private JButton focusElement;
	private JList<String> myJList;

	public MyFrame() {
		super(FrameConstants.FRAME_TITLE);

		this.myMenuBar = new MyMenu();
		this.setJMenuBar(this.myMenuBar);

		this.add(createContent());
	}

	// main panel
	private JPanel createContent() {
		final JPanel content = new JPanel(new BorderLayout(5, 5));
		content.setBackground(new Color(255, 255, 255));

		content.add(createContentLeft(), BorderLayout.CENTER);
		content.add(createContentRight(), BorderLayout.EAST);

		return content;
	}

	private JPanel createContentLeft() {
		final JPanel contentLeft = new JPanel(new BorderLayout(0, 0));
		contentLeft.setBackground(new Color(255, 255, 255));

		final DefaultListModel<String> listModel = new DefaultListModel<>();
		Iterator<Eintrag> data = new EintragLoader();
		while (data.hasNext()) {
		    Eintrag eintrag = data.next();
		    listModel.addElement(eintrag.getEintrag());
		}
		JList<String> list = new JList<>(listModel);

		setMyJList(list);

		final JScrollPane contentLeftScroller = new JScrollPane(list);
		contentLeftScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentLeftScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// add list
		contentLeft.add(contentLeftScroller, BorderLayout.CENTER);

		return contentLeft;
	}

	private JPanel createContentRight() {

		final JPanel contentRight = new JPanel(new BorderLayout(5, 5));
		contentRight.setBackground(new Color(255, 255, 255));

		final JPanel contentRightUp = new JPanel (new GridLayout(10, 1, 1, 1));
		
		
		final JLabel lEintrag = new JLabel();
		lEintrag.setText("Neuer Eintrag");

		final JTextField tEintrag = new JTextField();
		this.eintrag = tEintrag;

		final JButton bAdd = new JButton(FrameConstants.FRAME_BUTTON_ADD);

		bAdd.addActionListener(new AddDataActionListener());
		contentRightUp.add(lEintrag);
		contentRightUp.add(tEintrag);
		contentRightUp.add(bAdd);

		contentRight.add(contentRightUp);
		return contentRight;
	}

	public Eintrag getData() {

		String e = this.eintrag.getName();

		return new Eintrag(e);
	}

	public JButton getFocusElement() {
		return focusElement;
	}

	public void setFocusElement(JButton focusElement) {
		this.focusElement = focusElement;
	}

	public JList<String> getMyJList() {
		return myJList;
	}

	public void setMyJList(JList<String> list) {
		this.myJList = list;
	}

	public Eintrag getEintrag() {
		String e = this.eintrag.getName();
		return new Eintrag (e);
	}

}

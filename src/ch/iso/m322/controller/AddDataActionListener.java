package ch.iso.m322.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import ch.iso.m322.model.Eintrag;
import ch.iso.m322.util.ReferenceFinder;
import ch.iso.m322.view.MyFrame;

public class AddDataActionListener implements ActionListener {



	@Override
	public void actionPerformed(ActionEvent e) {

		final Component item = (Component) e.getSource();
		final JFrame frame = ReferenceFinder.findFrame(item);		

		Eintrag eintrag = ((MyFrame) frame).getEintrag();

		final JList<String> list = ((MyFrame) frame).getMyJList();
		final DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
		
		model.addElement(eintrag.getEintrag());
		

		
		
		
	
	}

}

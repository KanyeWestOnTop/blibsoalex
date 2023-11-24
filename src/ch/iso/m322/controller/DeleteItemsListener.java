package ch.iso.m322.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;


import ch.iso.m322.util.ReferenceFinder;
import ch.iso.m322.view.MyFrame;

public class DeleteItemsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		final Component item = (Component) e.getSource();
		final MyFrame frame = (MyFrame) ReferenceFinder.findFrame(item);


		final JList<String> list = frame.getMyJList();
		final DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
		
		model.removeAllElements();

		
	}

}

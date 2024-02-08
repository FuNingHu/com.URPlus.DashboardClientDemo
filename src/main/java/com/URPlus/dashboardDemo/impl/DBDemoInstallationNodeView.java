package com.URPlus.dashboardDemo.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.URPlus.impl.dashboard.DashboardClient;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;

public class DBDemoInstallationNodeView implements SwingInstallationNodeView<DBDemoInstallationNodeContribution>{

	private final Style style;
	private JTextField commandField = new JTextField();
	private JLabel returnLabel = new JLabel("aucune message actuallement!");
	private JButton sendButton = new JButton("Send");

	private JButton btnPowerOn = new JButton("Power On");
	private JButton btnBrakeRelease = new JButton("Brake Release");
	private JButton btnRobotMode = new JButton("Robot Mode");
	private JButton btnPowerOff = new JButton("Power Off");
	private JButton btnGetSN = new JButton("getSN");
	private DashboardClient dashboardClient = new DashboardClient("127.0.0.1");

	private JLabel labelResult = new JLabel();
	private JLabel labelVariable = new JLabel();

	
	public DBDemoInstallationNodeView(Style style) {
		// TODO Auto-generated constructor stub
		this.style = style;
		
	}
	@Override
	public void buildUI(JPanel panel, DBDemoInstallationNodeContribution contribution) {
		// TODO Auto-generated method stub
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(createSpaceing(0, 100));
		panel.add(createButtonBox(btnPowerOn, btnBrakeRelease, btnRobotMode, btnPowerOff, btnGetSN));
		panel.add(createVerticalSpacing());
		panel.add(createDescription(labelResult));
		panel.add(createVerticalSpacing());
		panel.add(createDescription(labelVariable));
		panel.add(createSpaceing(0, 50));
	}
	
	public void setReturnLabel(String str) {
		returnLabel.setText(str);
	}
	public void setCommandField(String str) {
		commandField.setText(str);
	}
	public void setLabelVariableText(String str) {
		labelVariable.setText("Var_11 = "+str);
	}
	private Box createDescription(JLabel label) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(label);
		return box;
	}
	private Box createReplyBox(JLabel jLable) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(new JLabel("Reply: "));
		box.add(jLable);
		return box;
	}
	
	
	private Box createButtonBox(JButton btnPower, JButton btnBrake, JButton btnMode, JButton btnOff, JButton btnSN) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnPower.setPreferredSize(new Dimension(180,40));btnPower.setMaximumSize(btnPower.getPreferredSize());
		btnBrake.setPreferredSize(new Dimension(180,40));btnBrake.setMaximumSize(btnBrake.getPreferredSize());
		btnMode.setPreferredSize(new Dimension(180,40));btnMode.setMaximumSize(btnMode.getPreferredSize());
		btnOff.setPreferredSize(new Dimension(180, 40));btnOff.setMaximumSize(btnOff.getPreferredSize());
		btnSN.setPreferredSize(new Dimension(160, 40));btnSN.setMaximumSize(btnSN.getPreferredSize());
		btnBrake.setBackground(new Color(87, 160, 209));btnOff.setBackground(new Color(87,160,209));
		btnPower.setFocusable(false);btnBrake.setFocusable(false);btnMode.setFocusable(false);btnOff.setFocusable(false); btnSN.setFocusable(false);
		btnPower.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dashboardClient.powerOn();
			}
		});
		btnBrake.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dashboardClient.brakeRelease();
			}
		});
		btnMode.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				labelResult.setText("Result: ");
				labelResult.setText("Result: "+ dashboardClient.robotmode());
			}
		});
		btnOff.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dashboardClient.powerOff();
			}
		});
		btnSN.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				labelResult.setText("Result: ");
				labelResult.setText("Result: "+ dashboardClient.getSerialNumber());
			}
		});
		box.add(btnPower); box.add(createHorizontalSpacing()); box.add(btnBrake);box.add(createHorizontalSpacing());box.add(btnMode);box.add(createHorizontalSpacing());
		box.add(btnOff); box.add(createHorizontalSpacing()); box.add(btnSN);
		return box;
	}
	
	private Component createHorizontalSpacing() {
		return Box.createRigidArea(new Dimension(style.getHorizontalSpacing(),0));
	}
	private Component createVerticalSpacing() {
		return Box.createRigidArea(new Dimension(0,style.getHorizontalSpacing()));
	}
	private Component createSpaceing(int horizontal, int vertical) {
		return Box.createRigidArea(new Dimension(horizontal, vertical));
	}

}

package com.aberigle.java.android.keybinder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

	private Shell s = Shell.instance;
	private JFrame frmDpadSimulator;
	private JButton btnCenter;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmDpadSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDpadSimulator = new JFrame();
		frmDpadSimulator.setTitle("DPAD Shell - by aberigle");
		frmDpadSimulator.setBounds(100, 100, 450, 300);
		frmDpadSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnUp = new JButton("UP");
		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s.input(AndroidKeyEvent.KEYCODE_DPAD_UP);
			}
		});
		btnUp.setBounds(180, 49, 80, 55);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmDpadSimulator.getContentPane().setLayout(null);
		frmDpadSimulator.getContentPane().add(btnUp);

		btnDown = new JButton("DOWN");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.input(AndroidKeyEvent.KEYCODE_DPAD_DOWN);
			}
		});
		btnDown.setBounds(180, 181, 80, 55);
		frmDpadSimulator.getContentPane().add(btnDown);

		btnLeft = new JButton("LEFT");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.input(AndroidKeyEvent.KEYCODE_DPAD_LEFT);
			}
		});
		btnLeft.setBounds(90, 115, 80, 55);
		frmDpadSimulator.getContentPane().add(btnLeft);

		btnRight = new JButton("RIGHT");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.input(AndroidKeyEvent.KEYCODE_DPAD_RIGHT);
			}
		});
		btnRight.setBounds(270, 115, 80, 55);
		frmDpadSimulator.getContentPane().add(btnRight);

		btnCenter = new JButton("CENTER");
		btnCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.input(AndroidKeyEvent.KEYCODE_DPAD_CENTER);
			}
		});
		btnCenter.setBounds(180, 115, 80, 55);
		frmDpadSimulator.getContentPane().add(btnCenter);

		JButton btnCheckAdb = new JButton("Check ADB");
		btnCheckAdb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (s.isAdbWorking()) {
					setButtonsEnabled(true);
				}
			}
		});
		btnCheckAdb.setBounds(10, 11, 111, 55);
		frmDpadSimulator.getContentPane().add(btnCheckAdb);

		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s.input(AndroidKeyEvent.KEYCODE_BACK);
			}
		});
		btnBack.setBounds(335, 196, 89, 55);
		frmDpadSimulator.getContentPane().add(btnBack);
		setButtonsEnabled(false);
	}

	private void setButtonsEnabled(boolean b) {
		btnCenter.setEnabled(b);
		btnUp.setEnabled(b);
		btnDown.setEnabled(b);
		btnLeft.setEnabled(b);
		btnRight.setEnabled(b);
		btnBack.setEnabled(b);
	}
}

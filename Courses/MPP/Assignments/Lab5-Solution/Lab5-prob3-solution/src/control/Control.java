package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;

import data.Data;
import data.Logins;
import ui.*;
public enum Control {
	INSTANCE;
	Start start;
	Grades grades;
	DestinationScreen destinationScreen;
	Login login;
	String username;
	Remarks remarks;
	private ScreenInfo screenInfo;
	private boolean isLoggedIn = false;
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean b) {
		isLoggedIn = b;
	}
	
	public void setStart(Start st) {
		this.start = st;
	}
	public void backToStart(JFrame frame) {
		screenInfo = null;
		destinationScreen = null;
		frame.setVisible(false);
		start.setMessage("");
		start.setVisible(true);
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			showLoginScreen();
		}
	}

	private void showLoginScreen() {
		login = new Login();
		start.setVisible(false);
		login.setVisible(true);
	}

//	private void showGradesScreen() {
//		login.setVisible(false);
//		grades = new Grades();
//		HashMap<String, String> gr
//				= Data.dataMap.get(username).getGrades();
//		StringBuilder sb = new StringBuilder();
//		for(String key : gr.keySet()) {
//			sb.append(key + " : " + gr.get(key) + "\n");
//		}
//		grades.setGrades(sb.toString());
//		grades.setTitle("Grades for " + username);
//		grades.setHeading("Grades for " + username);
//		Control.INSTANCE.start.setMessage("");
//		Control.INSTANCE.start.setVisible(false);
//		grades.setVisible(true);
//	}
//
//	private void showRemarksScreen() {
//		login.setVisible(false);
//		remarks = new Remarks();
//		HashMap<String, String> rem
//				= Data.dataMap.get(username).getTeacherRemarks();
//		StringBuilder sb = new StringBuilder();
//		for(String key : rem.keySet()) {
//			sb.append(key + " : " + rem.get(key) + "\n");
//		}
//		remarks.setRemarks(sb.toString());
//		remarks.setTitle("Teacher Remarks for " + username);
//		remarks.setHeading("Teacher Remarks for " + username);
//		Control.INSTANCE.start.setMessage("");
//		Control.INSTANCE.start.setVisible(false);
//		remarks.setVisible(true);
//	}

	private void showDestinationScreen() {
		login.setVisible(false);
		Control.INSTANCE.start.setMessage("");
		Control.INSTANCE.start.setVisible(false);
		destinationScreen.showDestinationScreen(username);
	}

	class RemarksListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			screenInfo = ScreenInfo.REMARKS;
			destinationScreen = new Grades();
			if (isLoggedIn) {
				showDestinationScreen();
			} else {
				showLoginScreen();
			}
		}
	}
	class GradesListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			screenInfo = ScreenInfo.GRADES;
			destinationScreen = new Grades();
			if (isLoggedIn) {
				showDestinationScreen();
			} else {
				showLoginScreen();
			}
		}

	}
	class SubmitLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String username = login.getUserName();
			String password = login.getPassword();
			if(!Logins.foundUserNamePwd(username, password)) {
				login.setMessage("Login failed.");
			} else {
				Control.this.username = username;
				Control.this.isLoggedIn = true;
				login.setMessage("Successful login");
				showDestinationScreen();
//				if(screenInfo == ScreenInfo.GRADES) {
//					showGradesScreen();
//				} else if(screenInfo == ScreenInfo.REMARKS){
//					showRemarksScreen();
//				}
			}
		}
	}
	public SubmitLoginListener getSubmitLoginListener() {
		return new SubmitLoginListener();
	}
	public LoginListener getLoginListener() {
		return new LoginListener();
	}
	public RemarksListener getRemarksListener() {
		return new RemarksListener();
	}
	public GradesListener getGradesListener() {
		return new GradesListener();
	}
}

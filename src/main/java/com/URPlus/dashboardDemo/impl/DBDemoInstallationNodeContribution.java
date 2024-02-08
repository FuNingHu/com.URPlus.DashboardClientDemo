package com.URPlus.dashboardDemo.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.URPlus.impl.dashboard.DashboardClient;
import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputFactory;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;

public class DBDemoInstallationNodeContribution implements InstallationNodeContribution{

	private final DataModel model;
	private final DBDemoInstallationNodeView view;
	private final InstallationAPIProvider apiProvider;

	private Timer uiTimer;
	private final String TCP_IP = "127.0.0.1";
	private final int TCP_PORT = 29999;
	
	private static final String COMMAND_KEY = "command";
	private static final String COMMAND_DEFAULT = "";

	private DashboardClient dashboardClient = new DashboardClient(TCP_IP);
	
	
	public DBDemoInstallationNodeContribution(InstallationAPIProvider apiProvider, DataModel model,
			DBDemoInstallationNodeView view){
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
		this.apiProvider = apiProvider;
	}

	@Override
	public void openView() {
		// TODO Auto-generated method stub
		view.setCommandField(model.get(COMMAND_KEY, COMMAND_DEFAULT));
		
		uiTimer = new Timer();
		uiTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				view.setLabelVariableText(dashboardClient.getVariable("Var_11"));
			}
		}, 0, 200);
	}

	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		if(uiTimer!= null) {
			uiTimer.cancel();
		}
	}

	@Override
	public void generateScript(ScriptWriter writer) {
		// TODO Auto-generated method stub
		
	}

}

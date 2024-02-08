package com.URPlus.dashboardDemo.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.ContributionConfiguration;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.data.DataModel;

public class DBDemoInstallationNodeService implements SwingInstallationNodeService<DBDemoInstallationNodeContribution, DBDemoInstallationNodeView>{

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return "Dashboard Demo";
	}

	@Override
	public DBDemoInstallationNodeView createView(ViewAPIProvider apiProvider) {
		// TODO Auto-generated method stub
		SystemAPI systemAPI = apiProvider.getSystemAPI();
		Style style = systemAPI.getSoftwareVersion().getMajorVersion() >= 5? new V5Style() : new V3Style();
		return new DBDemoInstallationNodeView(style);
	}

	@Override
	public DBDemoInstallationNodeContribution createInstallationNode(InstallationAPIProvider apiProvider,
			DBDemoInstallationNodeView view, DataModel model, CreationContext context) {
		// TODO Auto-generated method stub
		return new DBDemoInstallationNodeContribution(apiProvider, model, view);
	}

}

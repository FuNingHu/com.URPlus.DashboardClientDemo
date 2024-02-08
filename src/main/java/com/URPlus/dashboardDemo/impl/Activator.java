package com.URPlus.dashboardDemo.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */
public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		bundleContext.registerService(SwingInstallationNodeService.class, new DBDemoInstallationNodeService(), null);
		System.out.println("DashboardDemo says Hello World!");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("DashboardDemo says Goodbye World!");
	}
}


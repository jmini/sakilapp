/*******************************************************************************
 * Copyright (c) 2010 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package net.sakilapp.ui.swt.application;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * <h3>ApplicationActionBarAdvisor</h3> Used for menu contributions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

  private IWorkbenchAction exitAction;
  private IWorkbenchAction catalogAction;
  private IWorkbenchAction retailAction;
  private IWorkbenchAction customersAction;

  public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
    super(configurer);
  }

  @Override
  protected void makeActions(IWorkbenchWindow window) {
    exitAction = ActionFactory.QUIT.create(window);
    register(exitAction);

    //TODO JBR: change these Actions => should correspond IViewButton of the scout desktop
    catalogAction = new SwtOutlineViewAction("Catalog", net.sakilapp.client.ui.desktop.Desktop.CatalogOutlineViewButton.class);
    register(catalogAction);

    retailAction = new SwtOutlineViewAction("Retail", net.sakilapp.client.ui.desktop.Desktop.RetailOutlineViewButton.class);
    register(retailAction);

    customersAction = new SwtOutlineViewAction("Customers", net.sakilapp.client.ui.desktop.Desktop.CustomersOutlineViewButton.class);
    register(customersAction);
  }

  @Override
  protected void fillMenuBar(IMenuManager menuBar) {
    menuBar.add(new MenuManager("", IWorkbenchActionConstants.M_FILE));
  }

  @Override
  protected void fillCoolBar(ICoolBarManager coolBar) {
    IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
    coolBar.add(new ToolBarContributionItem(toolbar, "org.eclipse.ui.main.toolbar"));
    toolbar.add(catalogAction);
    toolbar.add(customersAction);
    toolbar.add(retailAction);
  }

}

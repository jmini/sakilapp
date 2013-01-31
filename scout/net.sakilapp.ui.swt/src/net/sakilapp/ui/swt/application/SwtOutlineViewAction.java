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

import net.sakilapp.ui.swt.Activator;

import org.eclipse.jface.action.Action;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.IAction;
import org.eclipse.scout.rt.client.ui.desktop.IDesktop;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

/**
 * 
 */
public class SwtOutlineViewAction extends Action implements IWorkbenchAction {

  private final Class<? extends AbstractOutlineViewButton> m_actionCls;

  /**
   * @param title
   * @param actionCls
   */
  public SwtOutlineViewAction(String title, Class<? extends AbstractOutlineViewButton> actionCls) {
    super(title, SWT.TOGGLE);
    setId(actionCls.getSimpleName());
    m_actionCls = actionCls;
  }

  @Override
  public void run() {
    ISwtEnvironment env = Activator.getDefault().getEnvironment();
    final IDesktop desktop = env.getScoutDesktop();
    Runnable t = new Runnable() {
      public void run() {
        IAction[] actions = desktop.getActions();
        for (IAction a : actions) {
          if (a instanceof AbstractOutlineViewButton) {
            if (a.getClass().isAssignableFrom(m_actionCls)) {
              try {
                a.setSelected(true);
                a.doAction();
              }
              catch (ProcessingException e) {
                // TODO Do something with the StackTrace.
                e.printStackTrace();
              }
            }
            //
          }
        }
      }
    };
    env.invokeScoutLater(t, 0);
  }

  public void dispose() {
  }

}

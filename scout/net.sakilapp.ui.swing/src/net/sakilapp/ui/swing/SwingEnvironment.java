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
package net.sakilapp.ui.swing;

import java.awt.Frame;

import org.eclipse.scout.rt.client.ui.desktop.IDesktop;
import org.eclipse.scout.rt.ui.swing.DefaultSwingEnvironment;
import org.eclipse.scout.rt.ui.swing.window.desktop.ISwingScoutRootFrame;
import org.eclipse.scout.rt.ui.swing.window.desktop.LegacySwingScoutRootFrame;

public class SwingEnvironment extends DefaultSwingEnvironment {

  @Override
  public ISwingScoutRootFrame createRootComposite(Frame rootFrame, IDesktop desktop) {
    ISwingScoutRootFrame ui = new LegacySwingScoutRootFrame(this, rootFrame, desktop);
    decorate(desktop, ui);
    return ui;
  }
}

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
package net.sakilapp.client.ui.desktop;

import java.util.ArrayList;

import net.sakilapp.client.ClientSession;
import net.sakilapp.client.ui.desktop.outlines.CatalogOutline;
import net.sakilapp.client.ui.desktop.outlines.CustomersOutline;
import net.sakilapp.client.ui.desktop.outlines.RetailOutline;
import net.sakilapp.shared.Texts;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.logger.IScoutLogger;
import org.eclipse.scout.commons.logger.ScoutLogManager;
import org.eclipse.scout.rt.client.ClientSyncJob;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktop;
import org.eclipse.scout.rt.client.ui.desktop.IDesktop;
import org.eclipse.scout.rt.client.ui.desktop.bookmark.menu.AbstractBookmarkMenu;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.client.ui.form.ScoutInfoForm;
import org.eclipse.scout.rt.client.ui.form.outline.DefaultOutlineTableForm;
import org.eclipse.scout.rt.client.ui.form.outline.DefaultOutlineTreeForm;

public class Desktop extends AbstractDesktop implements IDesktop {
  private static IScoutLogger logger = ScoutLogManager.getLogger(Desktop.class);

  public Desktop() {
  }

  @Override
  protected Class<? extends IOutline>[] getConfiguredOutlines() {
    ArrayList<Class<? extends IOutline>> list = new ArrayList<Class<? extends IOutline>>();
    list.add(CatalogOutline.class);
    list.add(RetailOutline.class);
    list.add(CustomersOutline.class);

    @SuppressWarnings("unchecked")
    Class<? extends IOutline>[] result = (Class<? extends IOutline>[]) list.toArray(new Class<?>[list.size()]);
    return result;
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Sakilapp");
  }

  @Override
  protected void execOpened() throws ProcessingException {
    // outline tree
    DefaultOutlineTreeForm treeForm = new DefaultOutlineTreeForm();
    treeForm.startView();

    //outline table
    DefaultOutlineTableForm tableForm = new DefaultOutlineTableForm();
    tableForm.startView();

    if (getAvailableOutlines().length > 0) {
      setOutline(getAvailableOutlines()[0]);
    }
  }

  @Order(10.0)
  public class CatalogOutlineViewButton extends AbstractOutlineViewButton {
    public CatalogOutlineViewButton() {
      super(Desktop.this, CatalogOutline.class);
    }
  }

  @Order(20.0)
  public class RetailOutlineViewButton extends AbstractOutlineViewButton {
    public RetailOutlineViewButton() {
      super(Desktop.this, RetailOutline.class);
    }
  }

  @Order(30.0)
  public class CustomersOutlineViewButton extends AbstractOutlineViewButton {
    public CustomersOutlineViewButton() {
      super(Desktop.this, CustomersOutline.class);
    }
  }

  @Order(10.0)
  public class FileMenu extends AbstractMenu {

    @Override
    public String getConfiguredText() {
      return Texts.get("FileMenu");
    }

    @Order(100.0)
    public class ExitMenu extends AbstractMenu {

      @Override
      public String getConfiguredText() {
        return Texts.get("ExitMenu");
      }

      @Override
      public void execAction() throws ProcessingException {
        ClientSyncJob.getCurrentSession(ClientSession.class).stopSession();
      }
    }
  }

  @Order(20.0)
  public class ToolsMenu extends AbstractMenu {

    @Override
    public String getConfiguredText() {
      return Texts.get("ToolsMenu");
    }
  }

  @Order(25)
  public class BookmarkMenu extends AbstractBookmarkMenu {
    public BookmarkMenu() {
      super(Desktop.this);
    }
  }

  @Order(30.0)
  public class HelpMenu extends AbstractMenu {

    @Override
    public String getConfiguredText() {
      return Texts.get("HelpMenu");
    }

    @Order(10.0)
    public class AboutMenu extends AbstractMenu {

      @Override
      public String getConfiguredText() {
        return Texts.get("AboutMenu");
      }

      @Override
      public void execAction() throws ProcessingException {
        ScoutInfoForm form = new ScoutInfoForm();
        form.startModify();
      }
    }
  }
}

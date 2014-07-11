/*******************************************************************************
 * Copyright 2011 Jérémie Bresson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sakilapp.client.ui.forms;

import net.sakilapp.client.ui.desktop.outlines.pages.ActorsTablePage;
import net.sakilapp.client.ui.desktop.outlines.pages.ActorsTablePage.Table;
import net.sakilapp.client.ui.forms.ActorsSelectForm.MainBox.CancelButton;
import net.sakilapp.client.ui.forms.ActorsSelectForm.MainBox.DisplayPageField;
import net.sakilapp.client.ui.forms.ActorsSelectForm.MainBox.OkButton;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.pagefield.AbstractPageField;
import org.eclipse.scout.rt.shared.TEXTS;

public class ActorsSelectForm extends AbstractForm {

  public ActorsSelectForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("SelectActors");
  }

  public void startDisplay() throws ProcessingException {
    startInternal(new ActorsSelectForm.DisplayHandler());
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public DisplayPageField getDisplayPageField() {
    return getFieldByClass(DisplayPageField.class);
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  /**
   * Convenience method
   *
   * @return the Table in the TablePage
   */
  public Table getTable() {
    return getDisplayPageField().getPage().getTable();
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class DisplayPageField extends AbstractPageField<ActorsTablePage> {
      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }
    }

    @Order(20.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(30.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class DisplayHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() throws ProcessingException {
      getDisplayPageField().setPage(new ActorsTablePage(true));
    }

    @Override
    protected void execPostLoad() throws ProcessingException {
      touch();
    }
  }
}

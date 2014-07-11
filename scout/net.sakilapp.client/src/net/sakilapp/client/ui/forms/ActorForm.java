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

import net.sakilapp.client.ui.forms.ActorForm.MainBox.CancelButton;
import net.sakilapp.client.ui.forms.ActorForm.MainBox.FirstNameField;
import net.sakilapp.client.ui.forms.ActorForm.MainBox.LastNameField;
import net.sakilapp.client.ui.forms.ActorForm.MainBox.MetadataBox;
import net.sakilapp.client.ui.forms.ActorForm.MainBox.OkButton;
import net.sakilapp.client.ui.template.formfield.AbstractMetadataBox;
import net.sakilapp.shared.formdata.ActorFormData;
import net.sakilapp.shared.security.UpdateActorPermission;
import net.sakilapp.shared.services.process.IActorProcessService;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;

@FormData(value = ActorFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class ActorForm extends AbstractForm {

  public ActorForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Actor");
  }

  public void startModify() throws ProcessingException {
    startInternal(new ActorForm.ModifyHandler());
  }

  public void startNew() throws ProcessingException {
    startInternal(new ActorForm.NewHandler());
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  public LastNameField getLastNameField() {
    return getFieldByClass(LastNameField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public MetadataBox getMetadataBox() {
    return getFieldByClass(MetadataBox.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  /**
   * Convenience Method to access the id of the category that is in the form
   *
   * @return actorId
   *         id of the actor represented by the form
   */
  public Long getFilmId() {
    return getMetadataBox().getIdField().getValue();
  }

  /**
   * Convenience Method to set the categoryNr in the id field.
   *
   * @param actorId
   *          id of the actor represented by the form
   */
  public void setActorId(Long actorId) {
    getMetadataBox().getIdField().setValue(actorId);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class MetadataBox extends AbstractMetadataBox {
    }

    @Order(20.0)
    public class FirstNameField extends AbstractStringField {

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("FirstName");
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }
    }

    @Order(30.0)
    public class LastNameField extends AbstractStringField {

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("LastName");
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }
    }

    @Order(40.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(50.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {

    @Override
    public void execLoad() throws ProcessingException {
      IActorProcessService service = SERVICES.getService(IActorProcessService.class);
      ActorFormData formData = new ActorFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateActorPermission());
    }

    @Override
    public void execStore() throws ProcessingException {
      IActorProcessService service = SERVICES.getService(IActorProcessService.class);
      ActorFormData formData = new ActorFormData();
      exportFormData(formData);
      formData = service.store(formData);
      importFormData(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    public void execLoad() throws ProcessingException {
      IActorProcessService service = SERVICES.getService(IActorProcessService.class);
      ActorFormData formData = new ActorFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);
    }

    @Override
    public void execStore() throws ProcessingException {
      IActorProcessService service = SERVICES.getService(IActorProcessService.class);
      ActorFormData formData = new ActorFormData();
      exportFormData(formData);
      formData = service.create(formData);
      importFormData(formData);
    }
  }
}

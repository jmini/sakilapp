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

import net.sakilapp.client.ui.forms.FilmForm.MainBox.CancelButton;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.MetadataBox;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.OkButton;
import net.sakilapp.client.ui.template.formfield.AbstractMetadataBox;
import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.FilmFormData;
import net.sakilapp.shared.security.UpdateFilmPermission;
import net.sakilapp.shared.services.process.IFilmProcessService;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.service.SERVICES;

@FormData(value = FilmFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class FilmForm extends AbstractForm {

  public FilmForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Film");
  }

  public void startModify() throws ProcessingException {
    startInternal(new FilmForm.ModifyHandler());
  }

  public void startNew() throws ProcessingException {
    startInternal(new FilmForm.NewHandler());
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
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
   * @return filmId
   *         id of the film represented by the form
   */
  public Long getFilmId() {
    return getMetadataBox().getIdField().getValue();
  }

  /**
   * Convenience Method to set the categoryNr in the id field.
   * 
   * @param filmId
   *          id of the film represented by the form
   */
  public void setFilmId(Long filmId) {
    getMetadataBox().getIdField().setValue(filmId);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class MetadataBox extends AbstractMetadataBox {

    }

    //TODO: add fields

    @Order(30.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(40.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {

    @Override
    public void execLoad() throws ProcessingException {
      IFilmProcessService service = SERVICES.getService(IFilmProcessService.class);
      FilmFormData formData = new FilmFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateFilmPermission());
    }

    @Override
    public void execStore() throws ProcessingException {
      IFilmProcessService service = SERVICES.getService(IFilmProcessService.class);
      FilmFormData formData = new FilmFormData();
      exportFormData(formData);
      formData = service.store(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    public void execLoad() throws ProcessingException {
      IFilmProcessService service = SERVICES.getService(IFilmProcessService.class);
      FilmFormData formData = new FilmFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);
    }

    @Override
    public void execStore() throws ProcessingException {
      IFilmProcessService service = SERVICES.getService(IFilmProcessService.class);
      FilmFormData formData = new FilmFormData();
      exportFormData(formData);
      formData = service.create(formData);
    }
  }
}

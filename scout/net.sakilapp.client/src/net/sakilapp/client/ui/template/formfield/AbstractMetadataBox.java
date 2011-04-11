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
package net.sakilapp.client.ui.template.formfield;

import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.AbstractMetadataBoxData;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;

@FormData(value = AbstractMetadataBoxData.class, sdkCommand = FormData.SdkCommand.CREATE, defaultSubtypeSdkCommand = FormData.DefaultSubtypeSdkCommand.CREATE)
public abstract class AbstractMetadataBox extends AbstractGroupBox {

  @Override
  protected boolean getConfiguredBorderVisible() {
    return false;
  }

  @Override
  protected boolean getConfiguredEnabled() {
    return false;
  }

  public IdField getIdField() {
    return getFieldByClass(IdField.class);
  }

  public LastUpdateField getLastUpdateField() {
    return getFieldByClass(LastUpdateField.class);
  }

  @Order(10.0)
  public class IdField extends AbstractLongField {

    @Override
    protected boolean getConfiguredEnabled() {
      return false;
    }

    @Override
    protected String getConfiguredLabel() {
      return Texts.get("Id");
    }
  }

  @Order(20.0)
  public class LastUpdateField extends AbstractDateField {

    @Override
    protected boolean getConfiguredEnabled() {
      return false;
    }

    @Override
    protected String getConfiguredLabel() {
      return Texts.get("LastUpdate");
    }
  }
}

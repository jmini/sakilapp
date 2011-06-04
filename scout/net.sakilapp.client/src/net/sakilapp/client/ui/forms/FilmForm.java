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

import net.sakilapp.client.ui.forms.FilmForm.MainBox.ActorsTableField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.CancelButton;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.CategoriesTableField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.DescriptionField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.LanguageField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.LengthField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.MetadataBox;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.OkButton;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.OriginalLanguageField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.RatingField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.ReleaseYearField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.RentalPriceBox;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.RentalPriceBox.RentalDurationField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.RentalPriceBox.RentalRateField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.ReplacementCostField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.SpecialFeaturesField;
import net.sakilapp.client.ui.forms.FilmForm.MainBox.TitleField;
import net.sakilapp.client.ui.template.formfield.AbstractMetadataBox;
import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.FilmFormData;
import net.sakilapp.shared.security.UpdateFilmPermission;
import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.code.SpecialFeatureCodeType;
import net.sakilapp.shared.services.lookup.LanguageLookupCall;
import net.sakilapp.shared.services.lookup.YearLookupCall;
import net.sakilapp.shared.services.process.IFilmProcessService;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.doublefield.AbstractDoubleField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.client.ui.messagebox.MessageBox;
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;
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

  public ActorsTableField getActorsTableField() {
    return getFieldByClass(ActorsTableField.class);
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public CategoriesTableField getCategoriesTableField() {
    return getFieldByClass(CategoriesTableField.class);
  }

  public DescriptionField getDescriptionField() {
    return getFieldByClass(DescriptionField.class);
  }

  public LanguageField getLanguageField() {
    return getFieldByClass(LanguageField.class);
  }

  public LengthField getLengthField() {
    return getFieldByClass(LengthField.class);
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

  public OriginalLanguageField getOriginalLanguageField() {
    return getFieldByClass(OriginalLanguageField.class);
  }

  public RatingField getRatingField() {
    return getFieldByClass(RatingField.class);
  }

  public ReleaseYearField getReleaseYearField() {
    return getFieldByClass(ReleaseYearField.class);
  }

  public RentalDurationField getRentalDurationField() {
    return getFieldByClass(RentalDurationField.class);
  }

  public RentalPriceBox getRentalPriceBox() {
    return getFieldByClass(RentalPriceBox.class);
  }

  public RentalRateField getRentalRateField() {
    return getFieldByClass(RentalRateField.class);
  }

  public ReplacementCostField getReplacementCostField() {
    return getFieldByClass(ReplacementCostField.class);
  }

  public SpecialFeaturesField getSpecialFeaturesField() {
    return getFieldByClass(SpecialFeaturesField.class);
  }

  public TitleField getTitleField() {
    return getFieldByClass(TitleField.class);
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

    @Order(20.0)
    public class TitleField extends AbstractStringField {

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return ScoutTexts.get("Title");
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }
    }

    @Order(30.0)
    public class DescriptionField extends AbstractStringField {

      @Override
      protected int getConfiguredGridH() {
        return 4;
      }

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("Description");
      }

      @Override
      protected boolean getConfiguredMultilineText() {
        return true;
      }

      @Override
      protected boolean getConfiguredWrapText() {
        return true;
      }
    }

    @Order(40.0)
    public class ReleaseYearField extends AbstractSmartField<Integer> {

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("ReleaseYear");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return YearLookupCall.class;
      }
    }

    @Order(50.0)
    public class LanguageField extends AbstractSmartField<Long> {

      @Override
      protected String getConfiguredLabel() {
        return ScoutTexts.get("Language");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return LanguageLookupCall.class;
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }
    }

    @Order(60.0)
    public class OriginalLanguageField extends AbstractSmartField<Long> {

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("OriginalLanguage");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return LanguageLookupCall.class;
      }
    }

    @Order(70.0)
    public class LengthField extends AbstractIntegerField {

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("Length");
      }
    }

    @Order(80.0)
    public class RentalPriceBox extends AbstractSequenceBox {

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("RentalPrice");
      }

      @Order(10.0)
      public class RentalRateField extends AbstractDoubleField {

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }

        @Override
        protected String execFormatValue(Double validValue) {
          String f = super.execFormatValue(validValue);
          if (validValue != null) {
            f = f + " $";
          }
          return f;
        }

        @Override
        protected Double execParseValue(String text) throws ProcessingException {
          String t = text.replaceAll("\\$", "");
          return super.execParseValue(t);
        }
      }

      @Order(20.0)
      public class RentalDurationField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return Texts.get("Slash");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }

        @Override
        protected String execFormatValue(Integer validValue) {
          String f = super.execFormatValue(validValue);
          if (validValue != null) {
            f = f + " " + Texts.get("Days");
          }
          return f;
        }

        @Override
        protected Integer execParseValue(String text) throws ProcessingException {
          String t = text.replaceAll(Texts.get("Days"), "");
          return super.execParseValue(t);
        }
      }
    }

    @Order(90.0)
    public class ReplacementCostField extends AbstractDoubleField {

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("ReplacementCost");
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }

      @Override
      protected String execFormatValue(Double validValue) {
        String f = super.execFormatValue(validValue);
        if (validValue != null) {
          f = f + " $";
        }
        return f;
      }

      @Override
      protected Double execParseValue(String text) throws ProcessingException {
        String t = text.replaceAll("\\$", "");
        return super.execParseValue(t);
      }
    }

    @Order(100.0)
    public class RatingField extends AbstractSmartField<String> {

      @Override
      protected Class<? extends ICodeType<?>> getConfiguredCodeType() {
        return RatingCodeType.class;
      }

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("Rating");
      }
    }

    @Order(110.0)
    public class SpecialFeaturesField extends AbstractListBox<String> {

      @Override
      protected Class<? extends ICodeType> getConfiguredCodeType() {
        return SpecialFeatureCodeType.class;
      }

      @Override
      protected int getConfiguredGridH() {
        return 7;
      }

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("SpecialFeatures");
      }
    }

    @Order(120.0)
    public class ActorsTableField extends AbstractTableField<ActorsTableField.Table> {

      @Override
      protected int getConfiguredGridH() {
        return 6;
      }

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("Actors");
      }

      @Order(10.0)
      public class Table extends AbstractTable {
        public ActorIdColumn getActorIdColumn() {
          return getColumnSet().getColumnByClass(ActorIdColumn.class);
        }

        public FirstNameColumn getFirstNameColumn() {
          return getColumnSet().getColumnByClass(FirstNameColumn.class);
        }

        public LastNameColumn getLastNameColumn() {
          return getColumnSet().getColumnByClass(LastNameColumn.class);
        }

        @Order(10.0)
        public class ActorIdColumn extends AbstractLongColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return Texts.get("Id");
          }

          @Override
          protected boolean getConfiguredPrimaryKey() {
            return true;
          }

          @Override
          protected boolean getConfiguredVisible() {
            return false;
          }

          @Override
          protected int getConfiguredWidth() {
            return 60;
          }
        }

        @Order(20.0)
        public class FirstNameColumn extends AbstractStringColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return Texts.get("FirstName");
          }

          @Override
          protected boolean getConfiguredSummary() {
            return true;
          }

          @Override
          protected int getConfiguredWidth() {
            return 220;
          }
        }

        @Order(30.0)
        public class LastNameColumn extends AbstractStringColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return Texts.get("LastName");
          }

          @Override
          protected boolean getConfiguredSummary() {
            return true;
          }

          @Override
          protected int getConfiguredWidth() {
            return 220;
          }
        }

        @Order(10.0)
        public class AddMenu extends AbstractMenu {

          @Override
          protected boolean getConfiguredEmptySpaceAction() {
            return true;
          }

          @Override
          protected boolean getConfiguredSingleSelectionAction() {
            return false;
          }

          @Override
          protected String getConfiguredText() {
            return ScoutTexts.get("SC_Label_AddToDictionary");
          }

          @Override
          protected void execAction() throws ProcessingException {
            //TODO: add a search dialog to add actors. Check for unique actor. Recreate deleted rows
            MessageBox.showOkMessage("TODO", "To be implemented", "add actor with id 1");
            addRowsByMatrix(new Object[]{new Object[]{1L, "First Name (id 1)", "Last Name (id 1)"}});
          }
        }

        @Order(20.0)
        public class DeleteMenu extends AbstractMenu {

          @Override
          protected String getConfiguredText() {
            return ScoutTexts.get("DeleteMenu");
          }

          @Override
          protected boolean getConfiguredMultiSelectionAction() {
            return true;
          }

          @Override
          protected void execAction() throws ProcessingException {
            deleteRows(getSelectedRows());
          }
        }
      }
    }

    @Order(130.0)
    public class CategoriesTableField extends AbstractTableField<CategoriesTableField.Table> {

      @Override
      protected int getConfiguredGridH() {
        return 4;
      }

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

      @Override
      protected String getConfiguredLabel() {
        return Texts.get("Categories");
      }

      @Order(10.0)
      public class Table extends AbstractTable {
        public CategoryIdColumn getCategoryIdColumn() {
          return getColumnSet().getColumnByClass(CategoryIdColumn.class);
        }

        public NameColumn getNameColumn() {
          return getColumnSet().getColumnByClass(NameColumn.class);
        }

        @Order(10.0)
        public class CategoryIdColumn extends AbstractLongColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return Texts.get("Id");
          }

          @Override
          protected boolean getConfiguredPrimaryKey() {
            return true;
          }

          @Override
          protected boolean getConfiguredVisible() {
            return false;
          }

          @Override
          protected int getConfiguredWidth() {
            return 60;
          }
        }

        @Order(20.0)
        public class NameColumn extends AbstractStringColumn {

          @Override
          protected String getConfiguredHeaderText() {
            return ScoutTexts.get("Name");
          }

          @Override
          protected boolean getConfiguredSummary() {
            return true;
          }

          @Override
          protected int getConfiguredWidth() {
            return 340;
          }
        }

        @Order(10.0)
        public class AddMenu extends AbstractMenu {

          @Override
          protected boolean getConfiguredEmptySpaceAction() {
            return true;
          }

          @Override
          protected boolean getConfiguredSingleSelectionAction() {
            return false;
          }

          @Override
          protected String getConfiguredText() {
            return ScoutTexts.get("SC_Label_AddToDictionary");
          }

          @Override
          protected void execAction() throws ProcessingException {
            //TODO: add a search dialog to add categories. Check for unique category. Recreate deleted rows
            MessageBox.showOkMessage("TODO", "To be implemented", "add category with id 1");
            addRowsByMatrix(new Object[]{new Object[]{1L, "Category id 1"}});
          }
        }

        @Order(20.0)
        public class DeleteMenu extends AbstractMenu {

          @Override
          protected String getConfiguredText() {
            return ScoutTexts.get("DeleteMenu");
          }

          @Override
          protected boolean getConfiguredMultiSelectionAction() {
            return true;
          }

          @Override
          protected void execAction() throws ProcessingException {
            deleteRows(getSelectedRows());
          }
        }
      }
    }

    @Order(140.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(150.0)
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

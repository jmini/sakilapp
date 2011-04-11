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
package net.sakilapp.client.ui.searchforms;

import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.ResetButton;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.SearchButton;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.FilmIdBox;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.FilmIdBox.FilmIdFrom;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.FilmIdBox.FilmIdTo;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.TitleField;
import net.sakilapp.shared.Texts;
import net.sakilapp.shared.formdata.FilmsSearchFormData;
import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.lookup.LanguageLookupCall;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.FormData.SdkCommand;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractSearchForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractResetButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractSearchButton;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tabbox.AbstractTabBox;
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;

//TODO: reorganize fields.
@FormData(value = FilmsSearchFormData.class, sdkCommand = SdkCommand.CREATE)
public class FilmsSearchForm extends AbstractSearchForm {

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Films");
  }

  public FilmsSearchForm() throws ProcessingException {
    super();
  }

  public FieldBox getFieldBox() {
    return getFieldByClass(FieldBox.class);
  }

  public FilmIdBox getFilmIdBox() {
    return getFieldByClass(FilmIdBox.class);
  }

  public FilmIdFrom getFilmIdFrom() {
    return getFieldByClass(FilmIdFrom.class);
  }

  public FilmIdTo getFilmIdTo() {
    return getFieldByClass(FilmIdTo.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public ResetButton getResetButton() {
    return getFieldByClass(ResetButton.class);
  }

  public SearchButton getSearchButton() {
    return getFieldByClass(SearchButton.class);
  }

  public TabBox getTabBox() {
    return getFieldByClass(TabBox.class);
  }

  public TitleField getTitleField() {
    return getFieldByClass(TitleField.class);
  }

  @Override
  protected void execResetSearchFilter(SearchFilter searchFilter) throws ProcessingException {
    super.execResetSearchFilter(searchFilter);
    FilmsSearchFormData formData = new FilmsSearchFormData();
    exportFormData(formData);
    searchFilter.setFormData(formData);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class TabBox extends AbstractTabBox {

      @Order(10.0)
      public class FieldBox extends AbstractGroupBox {

        @Override
        public String getConfiguredLabel() {
          return Texts.get("searchCriteria");
        }

        @Order(10.0)
        public class FilmIdBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("Id");
          }

          @Order(10.0)
          public class FilmIdFrom extends AbstractLongField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("from");
            }
          }

          @Order(20.0)
          public class FilmIdTo extends AbstractLongField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("to");
            }
          }
        }

        @Order(20.0)
        public class TitleField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return ScoutTexts.get("Title");
          }
        }

        @Order(30.0)
        public class ReleaseYearBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("ReleaseYear");
          }

          @Order(10.0)
          public class ReleaseYearFrom extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("from");
            }
          }

          @Order(20.0)
          public class ReleaseYearTo extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("to");
            }
          }
        }

        @Order(40.0)
        public class LanguageField extends AbstractSmartField<Long> {

          @Override
          protected String getConfiguredLabel() {
            return ScoutTexts.get("Language");
          }

          @Override
          protected Class<? extends LookupCall> getConfiguredLookupCall() {
            return LanguageLookupCall.class;
          }
        }

        @Order(50.0)
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

        @Order(60.0)
        public class LengthField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("Length");
          }
        }

        @Order(70.0)
        public class RentalPriceField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("RentalPrice");
          }
        }

        @Order(80.0)
        public class ReplacementCostField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("ReplacementCost");
          }
        }

        @Order(90.0)
        public class RatingField extends AbstractListBox<String> {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("Rating");
          }

          @Override
          protected Class<? extends ICodeType> getConfiguredCodeType() {
            return RatingCodeType.class;
          }
        }

        @Order(100.0)
        public class SpecialFeaturesField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("SpecialFeatures");
          }
        }

        @Order(110.0)
        public class LastUpdateBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return Texts.get("LastUpdate");
          }

          @Order(10.0)
          public class LastUpdateFrom extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("from");
            }
          }

          @Order(20.0)
          public class LastUpdateTo extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return ScoutTexts.get("to");
            }
          }
        }
      }
    }

    @Order(20.0)
    public class ResetButton extends AbstractResetButton {
    }

    @Order(30.0)
    public class SearchButton extends AbstractSearchButton {
    }
  }

  @Override
  public void startSearch() throws ProcessingException {
    startInternal(new SearchHandler());
  }

  public class SearchHandler extends AbstractFormHandler {

  }
}

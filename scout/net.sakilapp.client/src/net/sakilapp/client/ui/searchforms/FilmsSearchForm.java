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
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.LanguageField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.LengthField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.OriginalLanguageField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.RatingField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.ReleaseYearBox;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.ReleaseYearBox.ReleaseYearFrom;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.ReleaseYearBox.ReleaseYearTo;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.RentalPriceField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.RentalPriceField.RentalDurationField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.RentalPriceField.RentalRateField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.ReplacementCostField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.SpecialFeaturesField;
import net.sakilapp.client.ui.searchforms.FilmsSearchForm.MainBox.TabBox.FieldBox.TitleField;
import net.sakilapp.shared.formdata.FilmsSearchFormData;
import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.code.SpecialFeatureCodeType;
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
import org.eclipse.scout.rt.client.ui.form.fields.doublefield.AbstractDoubleField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tabbox.AbstractTabBox;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;

//TODO: reorganize fields.
@FormData(value = FilmsSearchFormData.class, sdkCommand = SdkCommand.CREATE)
public class FilmsSearchForm extends AbstractSearchForm {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Films");
  }

  /**
   * reset the search form and set filmId as new value.
   * 
   * @param filmId
   *          id of the film
   */
  public void resetAndSelectFilm(Long filmId) throws ProcessingException {
    doReset();
    getFilmIdFrom().setValue(filmId);
    getFilmIdTo().setValue(filmId);
    doSaveWithoutMarkerChange();
    resetSearchFilter();
  }

  public FilmsSearchForm() throws ProcessingException {
    super();
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

  public TitleField getTitleField() {
    return getFieldByClass(TitleField.class);
  }

  public ReleaseYearBox getReleaseYearBox() {
    return getFieldByClass(ReleaseYearBox.class);
  }

  public ReleaseYearFrom getReleaseYearFrom() {
    return getFieldByClass(ReleaseYearFrom.class);
  }

  public ReleaseYearTo getReleaseYearTo() {
    return getFieldByClass(ReleaseYearTo.class);
  }

  public LanguageField getLanguageField() {
    return getFieldByClass(LanguageField.class);
  }

  public OriginalLanguageField getOriginalLanguageField() {
    return getFieldByClass(OriginalLanguageField.class);
  }

  public LengthField getLengthField() {
    return getFieldByClass(LengthField.class);
  }

  public RentalPriceField getRentalPriceField() {
    return getFieldByClass(RentalPriceField.class);
  }

  public RentalRateField getRentalRateField() {
    return getFieldByClass(RentalRateField.class);
  }

  public RentalDurationField getRentalDurationField() {
    return getFieldByClass(RentalDurationField.class);
  }

  public ReplacementCostField getReplacementCostField() {
    return getFieldByClass(ReplacementCostField.class);
  }

  public RatingField getRatingField() {
    return getFieldByClass(RatingField.class);
  }

  public SpecialFeaturesField getSpecialFeaturesField() {
    return getFieldByClass(SpecialFeaturesField.class);
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
          return TEXTS.get("searchCriteria");
        }

        @Order(10.0)
        public class FilmIdBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Id");
          }

          @Order(10.0)
          public class FilmIdFrom extends AbstractLongField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }
          }

          @Order(20.0)
          public class FilmIdTo extends AbstractLongField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
            }
          }
        }

        @Order(20.0)
        public class TitleField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Title");
          }
        }

        @Order(30.0)
        public class ReleaseYearBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("ReleaseYear");
          }

          @Order(10.0)
          public class ReleaseYearFrom extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }
          }

          @Order(20.0)
          public class ReleaseYearTo extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
            }
          }
        }

        @Order(40.0)
        public class LanguageField extends AbstractListBox<Long> {

          @Override
          protected int getConfiguredGridH() {
            return 4;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Language");
          }

          @Override
          protected Class<? extends LookupCall> getConfiguredLookupCall() {
            return LanguageLookupCall.class;
          }
        }

        @Order(50.0)
        public class OriginalLanguageField extends AbstractListBox<Long> {

          @Override
          protected int getConfiguredGridH() {
            return 4;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("OriginalLanguage");
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
            return TEXTS.get("Length");
          }
        }

        @Order(70.0)
        public class RentalPriceField extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("RentalPrice");
          }

          //TODO: from - to
          @Order(10.0)
          public class RentalRateField extends AbstractDoubleField {
          }

          @Order(20.0)
          public class RentalDurationField extends AbstractIntegerField {
          }
        }

        @Order(80.0)
        public class ReplacementCostField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("ReplacementCost");
          }
        }

        @Order(90.0)
        public class RatingField extends AbstractListBox<String> {

          @Override
          protected int getConfiguredGridH() {
            return 4;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Rating");
          }

          @Override
          protected Class<? extends ICodeType> getConfiguredCodeType() {
            return RatingCodeType.class;
          }
        }

        @Order(100.0)
        public class SpecialFeaturesField extends AbstractListBox<String> {

          @Override
          protected int getConfiguredGridH() {
            return 4;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("SpecialFeatures");
          }

          @Override
          protected Class<? extends ICodeType> getConfiguredCodeType() {
            return SpecialFeatureCodeType.class;
          }
        }

        @Order(110.0)
        public class LastUpdateBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("LastUpdate");
          }

          @Order(10.0)
          public class LastUpdateFrom extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }
          }

          @Order(20.0)
          public class LastUpdateTo extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
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

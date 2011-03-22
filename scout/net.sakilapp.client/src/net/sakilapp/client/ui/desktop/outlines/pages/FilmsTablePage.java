package net.sakilapp.client.ui.desktop.outlines.pages;

import net.sakilapp.client.ui.searchforms.FilmsSearchForm;
import net.sakilapp.shared.Icons;
import net.sakilapp.shared.Texts;
import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.lookup.LanguageLookupCall;
import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.cell.Cell;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractDateColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractSmartColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.ISearchForm;
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;
import org.eclipse.scout.service.SERVICES;

public class FilmsTablePage extends AbstractPageWithTable<FilmsTablePage.Table> {

  @Override
  protected boolean getConfiguredSearchRequired() {
    return true;
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("AllFilms");
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.Folder;
  }

  @Override
  protected Class<? extends ISearchForm> getConfiguredSearchForm() {
    return FilmsSearchForm.class;
  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    //TODO: add a search Form and use it.
    return SERVICES.getService(ICatalogOutlineService.class).loadFilms(filter);
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    public LastUpdateColumn getLastUpdateColumn() {
      return getColumnSet().getColumnByClass(LastUpdateColumn.class);
    }

    public FilmIdColumn getFilmIdColumn() {
      return getColumnSet().getColumnByClass(FilmIdColumn.class);
    }

    public TitleColumn getTitleColumn() {
      return getColumnSet().getColumnByClass(TitleColumn.class);
    }

    public LanguageColumn getLanguageColumn() {
      return getColumnSet().getColumnByClass(LanguageColumn.class);
    }

    public LengthColumn getLengthColumn() {
      return getColumnSet().getColumnByClass(LengthColumn.class);
    }

    public OriginalLanguageColumn getOriginalLanguageColumn() {
      return getColumnSet().getColumnByClass(OriginalLanguageColumn.class);
    }

    public RatingColumn getRatingColumn() {
      return getColumnSet().getColumnByClass(RatingColumn.class);
    }

    public ReleaseYearColumn getReleaseYearColumn() {
      return getColumnSet().getColumnByClass(ReleaseYearColumn.class);
    }

    public RentalPriceColumn getRentalPriceColumn() {
      return getColumnSet().getColumnByClass(RentalPriceColumn.class);
    }

    public ReplacementCostColumn getReplacementCostColumn() {
      return getColumnSet().getColumnByClass(ReplacementCostColumn.class);
    }

    public SpecialFeaturesColumn getSpecialFeatureColumn() {
      return getColumnSet().getColumnByClass(SpecialFeaturesColumn.class);
    }

    @Order(10.0)
    public class FilmIdColumn extends AbstractLongColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Id");
      }

      @Override
      protected int getConfiguredWidth() {
        return 60;
      }
    }

    @Order(20.0)
    public class TitleColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return ScoutTexts.get("Title");
      }

      @Override
      protected int getConfiguredWidth() {
        return 150;
      }
    }

    @Order(40.0)
    public class ReleaseYearColumn extends AbstractDateColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("ReleaseYear");
      }

      @Override
      protected String getConfiguredFormat() {
        return "yyyy";
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(50.0)
    public class LanguageColumn extends AbstractSmartColumn<Long> {

      @Override
      protected String getConfiguredHeaderText() {
        return ScoutTexts.get("Language");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return LanguageLookupCall.class;
      }

      @Override
      protected int getConfiguredWidth() {
        return 80;
      }
    }

    @Order(60.0)
    public class OriginalLanguageColumn extends AbstractSmartColumn<Long> {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("OriginalLanguage");
      }

      @Override
      protected Class<? extends LookupCall> getConfiguredLookupCall() {
        return LanguageLookupCall.class;
      }

      @Override
      protected int getConfiguredWidth() {
        return 130;
      }
    }

    @Order(70.0)
    public class LengthColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Length");
      }

      @Override
      protected int getConfiguredWidth() {
        return 60;
      }

    }

    @Order(80.0)
    public class RentalPriceColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("RentalPrice");
      }

      @Override
      protected int getConfiguredWidth() {
        return 110;
      }

    }

    @Order(90.0)
    public class ReplacementCostColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("ReplacementCost");
      }

      @Override
      protected int getConfiguredWidth() {
        return 130;
      }

      @Override
      protected void execDecorateCell(Cell cell, ITableRow row) throws ProcessingException {
        if (getValue(row) != null) {
          cell.setText(cell.getText() + "$");
        }
      }
    }

    @Order(100.0)
    public class RatingColumn extends AbstractSmartColumn<String> {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Rating");
      }

      @Override
      protected Class<? extends ICodeType> getConfiguredCodeType() {
        return RatingCodeType.class;
      }

      @Override
      protected int getConfiguredWidth() {
        return 60;
      }
    }

    @Order(110.0)
    public class SpecialFeaturesColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("SpecialFeatures");
      }

      @Override
      protected int getConfiguredWidth() {
        return 170;
      }

    }

    @Order(120.0)
    public class LastUpdateColumn extends AbstractDateColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("LastUpdate");
      }

      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }

      @Override
      protected int getConfiguredWidth() {
        return 110;
      }
    }
  }
}

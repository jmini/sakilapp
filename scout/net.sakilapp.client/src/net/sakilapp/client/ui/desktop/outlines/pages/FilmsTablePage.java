package net.sakilapp.client.ui.desktop.outlines.pages;

import net.sakilapp.shared.Texts;
import net.sakilapp.shared.services.outline.ICatalogOutlineService;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.SERVICES;

public class FilmsTablePage extends AbstractPageWithTable<FilmsTablePage.Table> {

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("AllFilms");
  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    //TODO: add a search Form and use it.
    return SERVICES.getService(ICatalogOutlineService.class).loadFilms();
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    public TitleColumn getTitleColumn() {
      return getColumnSet().getColumnByClass(TitleColumn.class);
    }

    public FilmIdColumn getFilmIdColumn() {
      return getColumnSet().getColumnByClass(FilmIdColumn.class);
    }

    @Order(10.0)
    public class FilmIdColumn extends AbstractLongColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Id");
      }
    }

    @Order(20.0)
    public class TitleColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return ScoutTexts.get("Title");
      }
    }
  }
}

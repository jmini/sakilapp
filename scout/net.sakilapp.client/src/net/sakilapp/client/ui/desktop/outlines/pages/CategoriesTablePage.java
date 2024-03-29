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
package net.sakilapp.client.ui.desktop.outlines.pages;

import net.sakilapp.client.ui.forms.CategoryForm;
import net.sakilapp.client.ui.searchforms.CategoriesSearchForm;
import net.sakilapp.shared.Texts;
import net.sakilapp.shared.services.outline.ICatalogOutlineService;
import net.sakilapp.shared.services.process.ICategoryProcessService;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractDateColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.ISearchForm;
import org.eclipse.scout.rt.client.ui.messagebox.MessageBox;
import org.eclipse.scout.rt.shared.AbstractIcons;
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.SERVICES;

public class CategoriesTablePage extends AbstractPageWithTable<CategoriesTablePage.Table> {
  private final boolean m_usedInSelectForm;

  public CategoriesTablePage(boolean usedInSelectForm) {
    m_usedInSelectForm = usedInSelectForm;
  }

  @Override
  protected String getConfiguredIconId() {
    return AbstractIcons.Folder;
  }

  @Override
  protected Class<? extends ISearchForm> getConfiguredSearchForm() {
    return CategoriesSearchForm.class;
  }

  protected CategoriesSearchForm getSearchForm() {
    return (CategoriesSearchForm) getSearchFormInternal();
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("ByCategory");
  }

  @Override
  protected IPage execCreateVirtualChildPage(ITableRow row) throws ProcessingException {
    if (m_usedInSelectForm) {
      return null;
    }
    return super.execCreateVirtualChildPage(row);
  }

  @Override
  protected IPage execCreateChildPage(ITableRow row) throws ProcessingException {
    if (m_usedInSelectForm) {
      return null;
    }
    FilmsTablePage page = new FilmsTablePage();
    page.setCategoryId(getTable().getCategoryIdColumn().getValue(row));
    return page;
  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    return SERVICES.getService(ICatalogOutlineService.class).loadCategories(filter);
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    @Override
    protected String getConfiguredDefaultIconId() {
      return AbstractIcons.Folder;
    }

    public CategoryIdColumn getCategoryIdColumn() {
      return getColumnSet().getColumnByClass(CategoryIdColumn.class);
    }

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    public LastUpdateColumn getLastUpdateColumn() {
      return getColumnSet().getColumnByClass(LastUpdateColumn.class);
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

    @Order(30.0)
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
        return 160;
      }
    }

    @Order(10.0)
    public class NewMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return ScoutTexts.get("NewMenu");
      }

      @Override
      protected boolean getConfiguredEmptySpaceAction() {
        return true;
      }

      @Override
      protected boolean getConfiguredSingleSelectionAction() {
        return false;
      }

      @Override
      protected void execAction() throws ProcessingException {
        CategoryForm form = new CategoryForm();
        form.startNew();
        form.waitFor();
        if (form.isFormStored()) {
          getSearchForm().resetAndSelectCategory(form.getMetadataBox().getIdField().getValue());
          reloadPage();
        }
      }
    }

    @Order(20.0)
    public class EditMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return ScoutTexts.get("EditMenu");
      }

      @Override
      protected void execAction() throws ProcessingException {
        CategoryForm form = new CategoryForm();
        form.setCategoryId(getCategoryIdColumn().getSelectedValue());
        form.startModify();
        form.waitFor();
        if (form.isFormStored()) {
          reloadPage();
        }
      }
    }

    @Order(30.0)
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
        if (MessageBox.showDeleteConfirmationMessage(Texts.get("Categories"), getTable().getNameColumn().getSelectedValues())) {
          boolean result = SERVICES.getService(ICategoryProcessService.class).delete(getTable().getCategoryIdColumn().getSelectedValues());
          if (result) {
            reloadPage();
          }
        }
      }
    }
  }
}

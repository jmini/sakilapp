package net.sakilapp.client.ui.desktop.outlines;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import net.sakilapp.shared.Texts;
import net.sakilapp.client.ui.desktop.outlines.pages.FilmsTablePage;
import java.util.Collection;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;

public class CatalogOutline extends AbstractOutline{

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Catalog");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
  FilmsTablePage filmsTablePage = new FilmsTablePage();
    pageList.add(filmsTablePage);
  
  }
}

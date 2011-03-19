package net.sakilapp.shared.services.outline;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.service.IService;

public interface ICatalogOutlineService extends IService {

  public Object[][] loadFilms(SearchFilter filter) throws ProcessingException;
}

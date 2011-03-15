package net.sakilapp.shared.services.outline;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.service.IService;

public interface ICatalogOutlineService extends IService {

  public Object[][] loadFilms() throws ProcessingException;
}

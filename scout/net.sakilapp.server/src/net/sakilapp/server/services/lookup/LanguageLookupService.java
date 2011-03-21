package net.sakilapp.server.services.lookup;

import net.sakilapp.shared.services.lookup.ILanguageLookupService;

import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

public class LanguageLookupService extends AbstractSqlLookupService implements ILanguageLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "select language_id, name, null, null, null, null, null, 1, null, 1 from language " +
        "<key>where language_id = :key</key>" +
        "<text>where name like concat('%',:text,'%')</text>";
  }

}

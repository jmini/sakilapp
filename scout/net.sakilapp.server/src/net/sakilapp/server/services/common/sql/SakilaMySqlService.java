package net.sakilapp.server.services.common.sql;

import org.eclipse.scout.rt.server.services.common.jdbc.AbstractSqlService;
import org.eclipse.scout.rt.server.services.common.jdbc.style.ISqlStyle;
import org.eclipse.scout.service.IService;

public class SakilaMySqlService extends AbstractSqlService implements IService {

  @Override
  protected Class<? extends ISqlStyle> getConfiguredSqlStyle() {
    return MysqlSqlStyle.class;
  }

  @Override
  protected String getConfiguredJdbcDriverName() {
    return "com.mysql.jdbc.Driver";
  }

  @Override
  protected String getConfiguredJdbcMappingName() {
    return "jdbc:mysql://localhost:3306/sakila";
  }

  @Override
  protected String getConfiguredUsername() {
    return "root";
  }

  @Override
  protected String getConfiguredPassword() {
    return "";
  }
}

package net.sakilapp.server.services.common.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.scout.rt.server.services.common.jdbc.style.AbstractSqlStyle;

/**
 * Scout SqlStyle for MySql.
 * This should be part of the package: org.eclipse.scout.rt.server.services.common.jdbc.style
 */
public class MysqlSqlStyle extends AbstractSqlStyle {
  private static final long serialVersionUID = 1L;

  public void testConnection(Connection conn) throws SQLException {
    Statement testStatement = null;
    try {
      testStatement = conn.createStatement();
      testStatement.execute("SELECT 1 FROM DUAL");
    }
    finally {
      if (testStatement != null) try {
        testStatement.close();
      }
      catch (Throwable t) {
      }
    }
  }

  public boolean isBlobEnabled() {
    return false;
  }

  public boolean isClobEnabled() {
    return false;
  }

  public boolean isLargeString(String s) {
    return (s.length() > 4000);
  }

  @Override
  protected int getMaxListSize() {
    return 1000;
  }

  @Override
  public String getNvlToken() {
    return "IFNULL";
  }

  //TODO: modify all the create functions with the concat function
  @Override
  public String createContains(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat('%'," + adaptBindName(bindName) + ",'%'))";
  }

}

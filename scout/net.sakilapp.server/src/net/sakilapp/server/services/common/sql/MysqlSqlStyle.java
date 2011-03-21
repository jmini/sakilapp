package net.sakilapp.server.services.common.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.scout.rt.server.services.common.jdbc.style.AbstractSqlStyle;

/**
 * Scout SqlStyle for MySql.
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

  @Override
  public String createStartsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat(" + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createNotStartsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat(" + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createEndsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat('%'," + adaptBindName(bindName) + "))";
  }

  @Override
  public String createNotEndsWith(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat('%'," + adaptBindName(bindName) + "))";
  }

  @Override
  public String createContains(String attribute, String bindName) {
    return "upper(" + attribute + ") like upper(concat('%'," + adaptBindName(bindName) + ",'%'))";
  }

  @Override
  public String createNotContains(String attribute, String bindName) {
    return "upper(" + attribute + ") not like upper(concat('%'," + adaptBindName(bindName) + ",'%'))";
  }
}

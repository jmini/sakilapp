package net.sakilapp.shared.services.code;

import net.sakilapp.shared.Texts;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class RatingCodeType extends AbstractCodeType<String> {
  private static final long serialVersionUID = 1L;
  public static final String ID = "Rating";

  public RatingCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return Texts.get("Rating");
  }

  @Override
  public String getId() {
    return ID;
  }

  @Order(10.0)
  public class PGCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "PG";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return Texts.get("PG");
    }
  }

  @Order(20.0)
  public class GCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "G";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return Texts.get("G");
    }
  }

  @Order(30.0)
  public class NC17Code extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "NC-17";

    @Override
    protected String getConfiguredText() {
      return Texts.get("NC17");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(40.0)
  public class PG13Code extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "PG-13";

    @Override
    protected String getConfiguredText() {
      return Texts.get("PG13");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(50.0)
  public class RCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public static final String KEY = "R";

    @Override
    public String getId() {
      return KEY;
    }

    @Override
    protected String getConfiguredText() {
      return Texts.get("R");
    }
  }

}

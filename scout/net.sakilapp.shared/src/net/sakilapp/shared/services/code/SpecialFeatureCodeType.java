package net.sakilapp.shared.services.code;

import net.sakilapp.shared.Texts;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class SpecialFeatureCodeType extends AbstractCodeType<String> {
  private static final long serialVersionUID = 1L;
  public static final String CODETYPE_ID = "SpecialFeature";

  public SpecialFeatureCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return Texts.get("SpecialFeature");
  }

  @Override
  public String getId() {
    return CODETYPE_ID;
  }

  @Order(10.0)
  public class TrailersCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Trailers";

    @Override
    protected String getConfiguredText() {
      return Texts.get("Trailers");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(20.0)
  public class CommentariesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Commentaries";

    @Override
    protected String getConfiguredText() {
      return Texts.get("Commentaries");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(30.0)
  public class DeletedScenesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Deleted Scenes";

    @Override
    protected String getConfiguredText() {
      return Texts.get("DeletedScenes");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }

  @Order(40.0)
  public class BehindTheScenesCode extends AbstractCode<String> {
    private static final long serialVersionUID = 1L;
    public final String KEY = "Behind the Scenes";

    @Override
    protected String getConfiguredText() {
      return Texts.get("BehindTheScenes");
    }

    @Override
    public String getId() {
      return KEY;
    }
  }
}

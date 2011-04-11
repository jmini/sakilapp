package net.sakilapp.shared.formdata;

import java.util.Date;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;

public abstract class AbstractMetadataBoxData extends AbstractFormFieldData {
  private static final long serialVersionUID = 1L;

  public AbstractMetadataBoxData() {
  }

  public Id getId() {
    return getFieldByClass(Id.class);
  }

  public LastUpdate getLastUpdate() {
    return getFieldByClass(LastUpdate.class);
  }

  public class Id extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public Id() {
    }
  }

  public class LastUpdate extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdate() {
    }
  }
}

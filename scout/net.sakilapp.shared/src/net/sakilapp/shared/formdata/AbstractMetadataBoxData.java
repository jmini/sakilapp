package net.sakilapp.shared.formdata;

import java.util.Date;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

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

  public static class Id extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public Id() {
    }
  }

  public static class LastUpdate extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdate() {
    }
  }
}

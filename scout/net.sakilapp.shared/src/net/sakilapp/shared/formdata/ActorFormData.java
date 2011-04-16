package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

public class ActorFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public ActorFormData() {
  }

  public FirstName getFirstName() {
    return getFieldByClass(FirstName.class);
  }

  public LastName getLastName() {
    return getFieldByClass(LastName.class);
  }

  public MetadataBox getMetadataBox() {
    return getFieldByClass(MetadataBox.class);
  }

  public class FirstName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public FirstName() {
    }
  }

  public class LastName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public LastName() {
    }
  }

  public class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }
}

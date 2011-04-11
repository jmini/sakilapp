package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

public class CategoryFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public CategoryFormData() {
  }

  public CategoryName getCategoryName() {
    return getFieldByClass(CategoryName.class);
  }

  public MetadataBox getMetadataBox() {
    return getFieldByClass(MetadataBox.class);
  }

  public class CategoryName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public CategoryName() {
    }
  }

  public class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }
}

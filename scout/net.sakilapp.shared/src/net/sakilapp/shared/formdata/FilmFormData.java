package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

public class FilmFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public FilmFormData() {
  }

  public MetadataBox getMetadataBox() {
    return getFieldByClass(MetadataBox.class);
  }

  public class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }
}

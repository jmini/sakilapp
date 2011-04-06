package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.commons.annotations.FormDataChecksum;

@FormDataChecksum(938296025l)
public class FilmsSearchFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public FilmsSearchFormData() {
  }

  public FilmIdFrom getFilmIdFrom() {
    return getFieldByClass(FilmIdFrom.class);
  }

  public FilmIdTo getFilmIdTo() {
    return getFieldByClass(FilmIdTo.class);
  }

  public Title getTitle() {
    return getFieldByClass(Title.class);
  }

  public class FilmIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public FilmIdFrom() {
    }

  }

  public class FilmIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public FilmIdTo() {
    }

  }

  public class Title extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Title() {
    }

  }
}

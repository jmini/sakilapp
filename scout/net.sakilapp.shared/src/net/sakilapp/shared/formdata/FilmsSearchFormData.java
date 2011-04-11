package net.sakilapp.shared.formdata;

import java.util.Date;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

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

  public Language getLanguage() {
    return getFieldByClass(Language.class);
  }

  public LastUpdateFrom getLastUpdateFrom() {
    return getFieldByClass(LastUpdateFrom.class);
  }

  public LastUpdateTo getLastUpdateTo() {
    return getFieldByClass(LastUpdateTo.class);
  }

  public Length getLength() {
    return getFieldByClass(Length.class);
  }

  public OriginalLanguage getOriginalLanguage() {
    return getFieldByClass(OriginalLanguage.class);
  }

  public Rating getRating() {
    return getFieldByClass(Rating.class);
  }

  public ReleaseYearFrom getReleaseYearFrom() {
    return getFieldByClass(ReleaseYearFrom.class);
  }

  public ReleaseYearTo getReleaseYearTo() {
    return getFieldByClass(ReleaseYearTo.class);
  }

  public RentalPrice getRentalPrice() {
    return getFieldByClass(RentalPrice.class);
  }

  public ReplacementCost getReplacementCost() {
    return getFieldByClass(ReplacementCost.class);
  }

  public SpecialFeatures getSpecialFeatures() {
    return getFieldByClass(SpecialFeatures.class);
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

  public class Language extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public Language() {
    }
  }

  public class LastUpdateFrom extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdateFrom() {
    }
  }

  public class LastUpdateTo extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdateTo() {
    }
  }

  public class Length extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Length() {
    }
  }

  public class OriginalLanguage extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public OriginalLanguage() {
    }
  }

  public class Rating extends AbstractValueFieldData<String[]> {
    private static final long serialVersionUID = 1L;

    public Rating() {
    }
  }

  public class ReleaseYearFrom extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public ReleaseYearFrom() {
    }
  }

  public class ReleaseYearTo extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public ReleaseYearTo() {
    }
  }

  public class RentalPrice extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public RentalPrice() {
    }
  }

  public class ReplacementCost extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public ReplacementCost() {
    }
  }

  public class SpecialFeatures extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public SpecialFeatures() {
    }
  }

  public class Title extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Title() {
    }
  }
}

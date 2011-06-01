package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

public class FilmFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public FilmFormData() {
  }

  public Description getDescription() {
    return getFieldByClass(Description.class);
  }

  public Language getLanguage() {
    return getFieldByClass(Language.class);
  }

  public Length getLength() {
    return getFieldByClass(Length.class);
  }

  public MetadataBox getMetadataBox() {
    return getFieldByClass(MetadataBox.class);
  }

  public OriginalLanguage getOriginalLanguage() {
    return getFieldByClass(OriginalLanguage.class);
  }

  public Rating getRating() {
    return getFieldByClass(Rating.class);
  }

  public ReleaseYear getReleaseYear() {
    return getFieldByClass(ReleaseYear.class);
  }

  public RentalDuration getRentalDuration() {
    return getFieldByClass(RentalDuration.class);
  }

  public RentalRate getRentalRate() {
    return getFieldByClass(RentalRate.class);
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

  public class Description extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Description() {
    }
  }

  public class Language extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public Language() {
    }
  }

  public class Length extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public Length() {
    }
  }

  public class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }

  public class OriginalLanguage extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public OriginalLanguage() {
    }
  }

  public class Rating extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Rating() {
    }
  }

  public class ReleaseYear extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public ReleaseYear() {
    }
  }

  public class RentalDuration extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public RentalDuration() {
    }
  }

  public class RentalRate extends AbstractValueFieldData<Double> {
    private static final long serialVersionUID = 1L;

    public RentalRate() {
    }
  }

  public class ReplacementCost extends AbstractValueFieldData<Double> {
    private static final long serialVersionUID = 1L;

    public ReplacementCost() {
    }
  }

  public class SpecialFeatures extends AbstractValueFieldData<String[]> {
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

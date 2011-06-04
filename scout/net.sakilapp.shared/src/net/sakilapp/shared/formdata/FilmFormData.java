package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.tablefield.AbstractTableFieldData;

public class FilmFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public FilmFormData() {
  }

  public ActorsTable getActorsTable() {
    return getFieldByClass(ActorsTable.class);
  }

  public CategoriesTable getCategoriesTable() {
    return getFieldByClass(CategoriesTable.class);
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

  public class ActorsTable extends AbstractTableFieldData {
    private static final long serialVersionUID = 1L;

    public ActorsTable() {
    }

    public void setActorId(int row, Long actorId) {
      setValueInternal(row, 0, actorId);
    }

    public Long getActorId(int row) {
      return (Long) getValueInternal(row, 0);
    }

    public void setFirstName(int row, String firstName) {
      setValueInternal(row, 1, firstName);
    }

    public String getFirstName(int row) {
      return (String) getValueInternal(row, 1);
    }

    public void setLastName(int row, String lastName) {
      setValueInternal(row, 2, lastName);
    }

    public String getLastName(int row) {
      return (String) getValueInternal(row, 2);
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case 0:
          return getActorId(row);
        case 1:
          return getFirstName(row);
        case 2:
          return getLastName(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case 0:
          setActorId(row, (Long) value);
          break;
        case 1:
          setFirstName(row, (String) value);
          break;
        case 2:
          setLastName(row, (String) value);
          break;
      }
    }
  }

  public class CategoriesTable extends AbstractTableFieldData {
    private static final long serialVersionUID = 1L;

    public CategoriesTable() {
    }

    public void setCategoryId(int row, Long categoryId) {
      setValueInternal(row, 0, categoryId);
    }

    public Long getCategoryId(int row) {
      return (Long) getValueInternal(row, 0);
    }

    public void setName(int row, String name) {
      setValueInternal(row, 1, name);
    }

    public String getName(int row) {
      return (String) getValueInternal(row, 1);
    }

    @Override
    public int getColumnCount() {
      return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case 0:
          return getCategoryId(row);
        case 1:
          return getName(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case 0:
          setCategoryId(row, (Long) value);
          break;
        case 1:
          setName(row, (String) value);
          break;
      }
    }
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

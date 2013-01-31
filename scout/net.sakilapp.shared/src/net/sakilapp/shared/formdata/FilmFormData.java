package net.sakilapp.shared.formdata;

import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.code.SpecialFeatureCodeType;
import net.sakilapp.shared.services.lookup.LanguageLookupCall;
import net.sakilapp.shared.services.lookup.YearLookupCall;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
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

  public static class ActorsTable extends AbstractTableFieldData {
    private static final long serialVersionUID = 1L;

    public ActorsTable() {
    }

    public static final int ACTOR_ID_COLUMN_ID = 0;
    public static final int FIRST_NAME_COLUMN_ID = 1;
    public static final int LAST_NAME_COLUMN_ID = 2;

    public void setActorId(int row, Long actorId) {
      setValueInternal(row, ACTOR_ID_COLUMN_ID, actorId);
    }

    public Long getActorId(int row) {
      return (Long) getValueInternal(row, ACTOR_ID_COLUMN_ID);
    }

    public void setFirstName(int row, String firstName) {
      setValueInternal(row, FIRST_NAME_COLUMN_ID, firstName);
    }

    public String getFirstName(int row) {
      return (String) getValueInternal(row, FIRST_NAME_COLUMN_ID);
    }

    public void setLastName(int row, String lastName) {
      setValueInternal(row, LAST_NAME_COLUMN_ID, lastName);
    }

    public String getLastName(int row) {
      return (String) getValueInternal(row, LAST_NAME_COLUMN_ID);
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case ACTOR_ID_COLUMN_ID:
          return getActorId(row);
        case FIRST_NAME_COLUMN_ID:
          return getFirstName(row);
        case LAST_NAME_COLUMN_ID:
          return getLastName(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case ACTOR_ID_COLUMN_ID:
          setActorId(row, (Long) value);
          break;
        case FIRST_NAME_COLUMN_ID:
          setFirstName(row, (String) value);
          break;
        case LAST_NAME_COLUMN_ID:
          setLastName(row, (String) value);
          break;
      }
    }
  }

  public static class CategoriesTable extends AbstractTableFieldData {
    private static final long serialVersionUID = 1L;

    public CategoriesTable() {
    }

    public static final int CATEGORY_ID_COLUMN_ID = 0;
    public static final int NAME_COLUMN_ID = 1;

    public void setCategoryId(int row, Long categoryId) {
      setValueInternal(row, CATEGORY_ID_COLUMN_ID, categoryId);
    }

    public Long getCategoryId(int row) {
      return (Long) getValueInternal(row, CATEGORY_ID_COLUMN_ID);
    }

    public void setName(int row, String name) {
      setValueInternal(row, NAME_COLUMN_ID, name);
    }

    public String getName(int row) {
      return (String) getValueInternal(row, NAME_COLUMN_ID);
    }

    @Override
    public int getColumnCount() {
      return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
      switch (column) {
        case CATEGORY_ID_COLUMN_ID:
          return getCategoryId(row);
        case NAME_COLUMN_ID:
          return getName(row);
        default:
          return null;
      }
    }

    @Override
    public void setValueAt(int row, int column, Object value) {
      switch (column) {
        case CATEGORY_ID_COLUMN_ID:
          setCategoryId(row, (Long) value);
          break;
        case NAME_COLUMN_ID:
          setName(row, (String) value);
          break;
      }
    }
  }

  public static class Description extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Description() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Language extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public Language() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.LOOKUP_CALL, LanguageLookupCall.class);
      ruleMap.put(ValidationRule.MANDATORY, true);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }

  public static class Length extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public Length() {
    }
  }

  public static class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }

  public static class OriginalLanguage extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public OriginalLanguage() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.LOOKUP_CALL, LanguageLookupCall.class);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }

  public static class Rating extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Rating() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.CODE_TYPE, RatingCodeType.class);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }

  public static class ReleaseYear extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public ReleaseYear() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.LOOKUP_CALL, YearLookupCall.class);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }

  public static class RentalDuration extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public RentalDuration() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MANDATORY, true);
    }
  }

  public static class RentalRate extends AbstractValueFieldData<Double> {
    private static final long serialVersionUID = 1L;

    public RentalRate() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MANDATORY, true);
    }
  }

  public static class ReplacementCost extends AbstractValueFieldData<Double> {
    private static final long serialVersionUID = 1L;

    public ReplacementCost() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MANDATORY, true);
    }
  }

  public static class SpecialFeatures extends AbstractValueFieldData<String[]> {
    private static final long serialVersionUID = 1L;

    public SpecialFeatures() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.CODE_TYPE, SpecialFeatureCodeType.class);
    }
  }

  public static class Title extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Title() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(java.util.Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MANDATORY, true);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}

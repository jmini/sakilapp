package net.sakilapp.shared.formdata;

import java.util.Date;

import net.sakilapp.shared.services.code.RatingCodeType;
import net.sakilapp.shared.services.code.SpecialFeatureCodeType;
import net.sakilapp.shared.services.lookup.LanguageLookupCall;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

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

  public static class FilmIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public FilmIdFrom() {
    }
  }

  public static class FilmIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public FilmIdTo() {
    }
  }

  public static class Language extends AbstractValueFieldData<Long[]> {
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
    }
  }

  public static class LastUpdateFrom extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdateFrom() {
    }
  }

  public static class LastUpdateTo extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public LastUpdateTo() {
    }
  }

  public static class Length extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Length() {
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

  public static class OriginalLanguage extends AbstractValueFieldData<Long[]> {
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
    }
  }

  public static class Rating extends AbstractValueFieldData<String[]> {
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
    }
  }

  public static class ReleaseYearFrom extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public ReleaseYearFrom() {
    }
  }

  public static class ReleaseYearTo extends AbstractValueFieldData<Date> {
    private static final long serialVersionUID = 1L;

    public ReleaseYearTo() {
    }
  }

  public static class RentalDuration extends AbstractValueFieldData<Integer> {
    private static final long serialVersionUID = 1L;

    public RentalDuration() {
    }
  }

  public static class RentalRate extends AbstractValueFieldData<Double> {
    private static final long serialVersionUID = 1L;

    public RentalRate() {
    }
  }

  public static class ReplacementCost extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public ReplacementCost() {
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
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}

package net.sakilapp.shared.formdata;

import java.util.Date;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

public class CategoriesSearchFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public CategoriesSearchFormData() {
  }

  public CategoryIdFrom getCategoryIdFrom() {
    return getFieldByClass(CategoryIdFrom.class);
  }

  public CategoryIdTo getCategoryIdTo() {
    return getFieldByClass(CategoryIdTo.class);
  }

  public LastUpdateFrom getLastUpdateFrom() {
    return getFieldByClass(LastUpdateFrom.class);
  }

  public LastUpdateTo getLastUpdateTo() {
    return getFieldByClass(LastUpdateTo.class);
  }

  public Name getName() {
    return getFieldByClass(Name.class);
  }

  public static class CategoryIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public CategoryIdFrom() {
    }
  }

  public static class CategoryIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public CategoryIdTo() {
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

  public static class Name extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Name() {
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

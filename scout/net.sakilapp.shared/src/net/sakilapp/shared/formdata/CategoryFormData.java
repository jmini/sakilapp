package net.sakilapp.shared.formdata;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

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

  public static class CategoryName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public CategoryName() {
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

  public static class MetadataBox extends AbstractMetadataBoxData {
    private static final long serialVersionUID = 1L;

    public MetadataBox() {
    }
  }
}

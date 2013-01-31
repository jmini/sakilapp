package net.sakilapp.shared.formdata;

import java.util.Date;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

public class ActorsSearchFormData extends AbstractFormData {
  private static final long serialVersionUID = 1L;

  public ActorsSearchFormData() {
  }

  public ActorIdFrom getActorIdFrom() {
    return getFieldByClass(ActorIdFrom.class);
  }

  public ActorIdTo getActorIdTo() {
    return getFieldByClass(ActorIdTo.class);
  }

  public FirstName getFirstName() {
    return getFieldByClass(FirstName.class);
  }

  public LastName getLastName() {
    return getFieldByClass(LastName.class);
  }

  public LastUpdateFrom getLastUpdateFrom() {
    return getFieldByClass(LastUpdateFrom.class);
  }

  public LastUpdateTo getLastUpdateTo() {
    return getFieldByClass(LastUpdateTo.class);
  }

  public static class ActorIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public ActorIdFrom() {
    }
  }

  public static class ActorIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public ActorIdTo() {
    }
  }

  public static class FirstName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public FirstName() {
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

  public static class LastName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public LastName() {
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
}

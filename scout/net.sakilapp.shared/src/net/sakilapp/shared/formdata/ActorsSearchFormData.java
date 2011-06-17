package net.sakilapp.shared.formdata;

import java.util.Date;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;

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

  public class ActorIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public ActorIdFrom() {
    }
  }

  public class ActorIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public ActorIdTo() {
    }
  }

  public class FirstName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public FirstName() {
    }
  }

  public class LastName extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public LastName() {
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
}

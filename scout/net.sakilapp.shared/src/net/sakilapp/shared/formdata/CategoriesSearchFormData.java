package net.sakilapp.shared.formdata;

import java.util.Date;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.commons.annotations.FormDataChecksum;

@FormDataChecksum(2116434561l)
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

  public class CategoryIdFrom extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public CategoryIdFrom() {
    }

  }

  public class CategoryIdTo extends AbstractValueFieldData<Long> {
    private static final long serialVersionUID = 1L;

    public CategoryIdTo() {
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

  public class Name extends AbstractValueFieldData<String> {
    private static final long serialVersionUID = 1L;

    public Name() {
    }

  }
}

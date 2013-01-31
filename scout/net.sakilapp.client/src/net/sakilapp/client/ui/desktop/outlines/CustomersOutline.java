package net.sakilapp.client.ui.desktop.outlines;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.shared.TEXTS;

public class CustomersOutline extends AbstractOutline{

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Customers");
  }
}

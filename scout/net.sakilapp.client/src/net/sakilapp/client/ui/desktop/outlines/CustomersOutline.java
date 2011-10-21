package net.sakilapp.client.ui.desktop.outlines;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import net.sakilapp.shared.Texts;

public class CustomersOutline extends AbstractOutline{

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Customers");
  }
}

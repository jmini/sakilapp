package net.sakilapp.client.ui.desktop.outlines;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import net.sakilapp.shared.Texts;

public class RetailOutline extends AbstractOutline{

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Retail");
  }
}

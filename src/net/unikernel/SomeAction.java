/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikernel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionRegistration;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionID;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Edit",
id = "net.unikernel.SomeAction")
@ActionRegistration(iconBase = "net/unikernel/gnome_mime_text_x_pascal.png",
displayName = "#CTL_SomeAction")
@ActionReferences(
{
	@ActionReference(path = "Menu/Edit", position = 100),
	@ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_SomeAction=Some")
public final class SomeAction implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO implement action body
	}
}

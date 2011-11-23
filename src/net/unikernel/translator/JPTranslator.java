package net.unikernel.translator;

import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import net.unikernel.jcctranslator.PascalParser;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.openide.windows.IOProvider;

/**
 *
 * @author mcangel
 */
public class JPTranslator extends Parser
{
	private Snapshot snapshot;
	private PascalParser pascalParser;

	@Override
	public void parse(Snapshot snapshot, Task task, SourceModificationEvent event)
	{
		this.snapshot = snapshot;
		Reader reader = new StringReader(snapshot.getText().toString());
		if (pascalParser == null)
		{
			pascalParser = new PascalParser(reader);
		}
		else
		{
			pascalParser.ReInit(reader);
		}
		try
		{
//DEBUG
			IOProvider.getDefault().getStdOut().println("Translated code:");
			IOProvider.getDefault().getStdOut().println(pascalParser.parse());
		}
		catch (net.unikernel.jcctranslator.ParseException ex)
		{
			Logger.getLogger(JPTranslator.class.getName()).log(Level.WARNING, null, ex);
		}
	}

	@Override
	public Result getResult(Task task)
	{
		return new JPTranslatorResult(snapshot, pascalParser);
	}

	@Override
	public void addChangeListener(ChangeListener changeListener)
	{
	}

	@Override
	public void removeChangeListener(ChangeListener changeListener)
	{
	}

	public static class JPTranslatorResult extends Result
	{
		private PascalParser pascalParser;
		private boolean valid = true;

		JPTranslatorResult(Snapshot snapshot, PascalParser pascalParser)
		{
			super(snapshot);
			this.pascalParser = pascalParser;
		}

		public PascalParser getJavaParser() throws org.netbeans.modules.parsing.spi.ParseException
		{
			if (!valid)
			{
				throw new org.netbeans.modules.parsing.spi.ParseException();
			}
			return pascalParser;
		}

		@Override
		protected void invalidate()
		{
			valid = false;
		}
	}
}
package net.unikernel.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import net.unikernel.jccparser.PascalParser;
import net.unikernel.jccparser.SimpleNode;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 *
 * @author mcangel
 */
public class JPParser extends Parser
{
	private Snapshot snapshot;
	private PascalParser pascalParser;

	@Override
	public void parse(Snapshot snapshot, Task task, SourceModificationEvent event)
	{
		this.snapshot = snapshot;
		Reader reader = new StringReader(snapshot.getText().toString());
		pascalParser = new PascalParser(reader);
		try
		{
			SimpleNode node = pascalParser.parse();
//DEBUG
			node.dump("");
		}
		catch (net.unikernel.jccparser.ParseException ex)
		{
			Logger.getLogger(JPParser.class.getName()).log(Level.WARNING, null, ex);
		}
	}

	@Override
	public Result getResult(Task task)
	{
		return new JPParserResult(snapshot, pascalParser);
	}

	@Override
	public void cancel()
	{
	}

	@Override
	public void addChangeListener(ChangeListener changeListener)
	{
	}

	@Override
	public void removeChangeListener(ChangeListener changeListener)
	{
	}

	public static class JPParserResult extends Result
	{
		private PascalParser pascalParser;
		private boolean valid = true;

		JPParserResult(Snapshot snapshot, PascalParser pascalParser)
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
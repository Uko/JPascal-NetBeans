package net.unikernel.parser;

import java.util.Collection;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;

/**
 *
 * @author mcangel
 */
public class JPParserFactory extends ParserFactory
{

	@Override
	public Parser createParser(Collection<Snapshot> clctn)
	{
		return new JPParser();
	}
	
}

package net.unikernel.translator;

import java.util.Collection;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;

/**
 *
 * @author mcangel
 */
public class JPTranslatorFactory extends ParserFactory
{

	@Override
	public Parser createParser(Collection<Snapshot> clctn)
	{
		return new JPTranslator();
	}
	
}

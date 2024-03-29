package net.unikernel.parser;

import java.util.Collection;
import java.util.Collections;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

/**
 *
 * @author mcangel
 */
public class SyntaxErrorsHighlightingTaskFactory extends TaskFactory
{
	@Override
	public Collection<? extends SchedulerTask> create (Snapshot snapshot)
	{
		return Collections.singleton(new SyntaxErrorsHighlightingTask());
	}
}

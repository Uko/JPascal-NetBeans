/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikernel.lexer;

import net.unikernel.jcclexer.JavaCharStream;
import net.unikernel.jcclexer.PascalTokenManager;
import net.unikernel.jcclexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author mcangel
 */
class JPLexer implements Lexer<JPTokenId>
{
	private LexerRestartInfo<JPTokenId> info;
	private PascalTokenManager pascalTokenManager;

	JPLexer(LexerRestartInfo<JPTokenId> info)
	{
		this.info = info;
		JavaCharStream stream = new JavaCharStream(info.input());
		pascalTokenManager = new PascalTokenManager(stream);
	}

	@Override
	public org.netbeans.api.lexer.Token<JPTokenId> nextToken()
	{
		Token token = pascalTokenManager.getNextToken();
		if (info.input().readLength() < 1)
		{
			return null;
		}
		return info.tokenFactory().createToken(JPLanguageHierarchy.getToken(token.kind));
	}

	@Override
	public Object state()
	{
		return null;
	}

	@Override
	public void release()
	{
	}
}
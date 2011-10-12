/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikernel.lexer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author mcangel
 */
public class JPLanguageHierarchy extends LanguageHierarchy<JPTokenId>
{

	private static List<JPTokenId> tokens;
	private static Map<Integer, JPTokenId> idToToken;

	private static void init()
	{
		tokens = Arrays.<JPTokenId>asList(new JPTokenId[]
				{
					new JPTokenId("EOF", "whitespace", 0),
					new JPTokenId("WHITESPACE", "whitespace", 1),
					new JPTokenId("MULTI_LINE_COMMENT", "comment", 2),
					new JPTokenId("MULTI", "comment", 3),
					new JPTokenId("LPAREN", "operator", 4),
					new JPTokenId("RPAREN", "operator", 5),
					new JPTokenId("COLON", "separator", 6),
					new JPTokenId("SEMICOLON", "separator", 7),
					new JPTokenId("DOT", "literal", 8),
					new JPTokenId("COMMA", "separator", 9),
					new JPTokenId("PLUS", "operator", 10),
					new JPTokenId("MINUS", "operator", 11),
					new JPTokenId("MULTIPLY", "operator", 12),
					new JPTokenId("DIVIDE", "operator", 13),
					new JPTokenId("ASSIGN", "operator", 14),
					new JPTokenId("PROGRAM", "keyword", 15),
					new JPTokenId("VAR", "keyword", 16),
					new JPTokenId("INTEGER", "type", 17),
					new JPTokenId("REAL", "type", 18),
					new JPTokenId("BEGIN", "keyword", 19),
					new JPTokenId("END", "keyword", 20),
					new JPTokenId("FOR", "keyword", 21),
					new JPTokenId("TO", "keyword", 22),
					new JPTokenId("DOWNTO", "keyword", 23),
					new JPTokenId("WRITE", "keyword", 24),
					new JPTokenId("WRITELN", "keyword", 25),
					new JPTokenId("READ", "keyword", 26),
					new JPTokenId("READLN", "keyword", 27),
					new JPTokenId("ID", "identifier", 28),
					new JPTokenId("LETTER", "literal", 29),
					new JPTokenId("DIGIT", "literal", 30),
					new JPTokenId("DIGITS", "literal", 31),
					new JPTokenId("SIGN", "operator", 32)
				});
		idToToken = new HashMap<Integer, JPTokenId>();
		for (JPTokenId token : tokens)
		{
			idToToken.put(token.ordinal(), token);
		}
	}

	static synchronized JPTokenId getToken(int id)
	{
		if (idToToken == null)
		{
			init();
		}
		return idToToken.get(id);
	}

	@Override
	protected synchronized Collection<JPTokenId> createTokenIds()
	{
		if (tokens == null)
		{
			init();
		}
		return tokens;
	}

	@Override
	protected synchronized Lexer<JPTokenId> createLexer(LexerRestartInfo<JPTokenId> info)
	{
		return new JPLexer(info);
	}

	@Override
	protected String mimeType()
	{
		return "text/x-pascal";
	}
	
}

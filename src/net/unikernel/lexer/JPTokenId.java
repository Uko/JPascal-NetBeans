/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikernel.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author mcangel
 */
public class JPTokenId implements TokenId
{
	private static final Language<JPTokenId> language = new JPLanguageHierarchy().language();
	
	private final String name;
	private final String primaryCategory;
	private final int id;

	JPTokenId(String name, String primaryCategory, int id)
	{
		this.name = name;
		this.primaryCategory = primaryCategory;
		this.id = id;
	}

	@Override
	public String primaryCategory()
	{
		return primaryCategory;
	}

	@Override
	public int ordinal()
	{
		return id;
	}

	@Override
	public String name()
	{
		return name;
	}

	public static final Language<JPTokenId> getLanguage()
	{
		return language;
	}
}

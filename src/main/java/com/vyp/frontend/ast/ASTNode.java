package com.vyp.frontend.ast;

import com.vyp.frontend.ast.SourceLocation;;

public interface ASTNode {
	
	SourceLocation getSourceLocation();
	//set location
	void setSourceLocation(SourceLocation sourceLocation);

}

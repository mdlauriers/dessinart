/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TRandomdeuxcinqcinq extends Token
{
    public TRandomdeuxcinqcinq()
    {
        super.setText("random255");
    }

    public TRandomdeuxcinqcinq(int line, int pos)
    {
        super.setText("random255");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TRandomdeuxcinqcinq(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRandomdeuxcinqcinq(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TRandomdeuxcinqcinq text.");
    }
}

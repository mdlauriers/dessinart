/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TDraw extends Token
{
    public TDraw()
    {
        super.setText("draw");
    }

    public TDraw(int line, int pos)
    {
        super.setText("draw");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDraw(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDraw(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDraw text.");
    }
}

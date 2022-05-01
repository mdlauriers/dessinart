/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TDrawTo extends Token
{
    public TDrawTo()
    {
        super.setText("drawTo");
    }

    public TDrawTo(int line, int pos)
    {
        super.setText("drawTo");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDrawTo(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDrawTo(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDrawTo text.");
    }
}

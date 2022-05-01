/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TColor extends Token
{
    public TColor()
    {
        super.setText("color");
    }

    public TColor(int line, int pos)
    {
        super.setText("color");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TColor(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTColor(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TColor text.");
    }
}

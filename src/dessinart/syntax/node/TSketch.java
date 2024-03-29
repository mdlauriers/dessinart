/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TSketch extends Token
{
    public TSketch()
    {
        super.setText("sketch");
    }

    public TSketch(int line, int pos)
    {
        super.setText("sketch");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSketch(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSketch(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSketch text.");
    }
}

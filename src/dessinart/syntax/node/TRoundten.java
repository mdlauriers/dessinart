/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TRoundten extends Token
{
    public TRoundten()
    {
        super.setText("roundTen");
    }

    public TRoundten(int line, int pos)
    {
        super.setText("roundTen");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TRoundten(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRoundten(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TRoundten text.");
    }
}
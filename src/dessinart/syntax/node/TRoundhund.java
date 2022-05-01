/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TRoundhund extends Token
{
    public TRoundhund()
    {
        super.setText("roundHundred");
    }

    public TRoundhund(int line, int pos)
    {
        super.setText("roundHundred");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TRoundhund(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRoundhund(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TRoundhund text.");
    }
}
/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TLog extends Token
{
    public TLog()
    {
        super.setText("log");
    }

    public TLog(int line, int pos)
    {
        super.setText("log");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLog(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLog(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLog text.");
    }
}

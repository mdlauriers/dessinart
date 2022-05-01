/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import java.util.*;
import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class ABlock extends PBlock
{
    private final LinkedList<PInstr> _instrs_ = new LinkedList<PInstr>();

    public ABlock()
    {
        // Constructor
    }

    public ABlock(
        @SuppressWarnings("hiding") List<?> _instrs_)
    {
        // Constructor
        setInstrs(_instrs_);

    }

    @Override
    public Object clone()
    {
        return new ABlock(
            cloneList(this._instrs_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABlock(this);
    }

    public LinkedList<PInstr> getInstrs()
    {
        return this._instrs_;
    }

    public void setInstrs(List<?> list)
    {
        for(PInstr e : this._instrs_)
        {
            e.parent(null);
        }
        this._instrs_.clear();

        for(Object obj_e : list)
        {
            PInstr e = (PInstr) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._instrs_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instrs_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instrs_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PInstr> i = this._instrs_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PInstr) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}

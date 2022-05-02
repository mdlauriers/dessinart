/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AReturnInstr extends PInstr
{
    private TReturn _return_;
    private PExp _exp_;
    private TSc _sc_;

    public AReturnInstr()
    {
        // Constructor
    }

    public AReturnInstr(
        @SuppressWarnings("hiding") TReturn _return_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TSc _sc_)
    {
        // Constructor
        setReturn(_return_);

        setExp(_exp_);

        setSc(_sc_);

    }

    @Override
    public Object clone()
    {
        return new AReturnInstr(
            cloneNode(this._return_),
            cloneNode(this._exp_),
            cloneNode(this._sc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReturnInstr(this);
    }

    public TReturn getReturn()
    {
        return this._return_;
    }

    public void setReturn(TReturn node)
    {
        if(this._return_ != null)
        {
            this._return_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._return_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TSc getSc()
    {
        return this._sc_;
    }

    public void setSc(TSc node)
    {
        if(this._sc_ != null)
        {
            this._sc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._return_)
            + toString(this._exp_)
            + toString(this._sc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._return_ == child)
        {
            this._return_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._sc_ == child)
        {
            this._sc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._return_ == oldChild)
        {
            setReturn((TReturn) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._sc_ == oldChild)
        {
            setSc((TSc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

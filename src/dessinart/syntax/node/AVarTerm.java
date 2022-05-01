/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AVarTerm extends PTerm
{
    private TIdent _ident_;

    public AVarTerm()
    {
        // Constructor
    }

    public AVarTerm(
        @SuppressWarnings("hiding") TIdent _ident_)
    {
        // Constructor
        setIdent(_ident_);

    }

    @Override
    public Object clone()
    {
        return new AVarTerm(
            cloneNode(this._ident_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarTerm(this);
    }

    public TIdent getIdent()
    {
        return this._ident_;
    }

    public void setIdent(TIdent node)
    {
        if(this._ident_ != null)
        {
            this._ident_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ident_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ident_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ident_ == child)
        {
            this._ident_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ident_ == oldChild)
        {
            setIdent((TIdent) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

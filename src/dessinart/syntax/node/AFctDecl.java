/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AFctDecl extends PDecl
{
    private PFctdecl _fctdecl_;

    public AFctDecl()
    {
        // Constructor
    }

    public AFctDecl(
        @SuppressWarnings("hiding") PFctdecl _fctdecl_)
    {
        // Constructor
        setFctdecl(_fctdecl_);

    }

    @Override
    public Object clone()
    {
        return new AFctDecl(
            cloneNode(this._fctdecl_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFctDecl(this);
    }

    public PFctdecl getFctdecl()
    {
        return this._fctdecl_;
    }

    public void setFctdecl(PFctdecl node)
    {
        if(this._fctdecl_ != null)
        {
            this._fctdecl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fctdecl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._fctdecl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._fctdecl_ == child)
        {
            this._fctdecl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._fctdecl_ == oldChild)
        {
            setFctdecl((PFctdecl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

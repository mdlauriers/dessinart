/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AVariableDecl extends PDecl
{
    private PVardecl _vardecl_;
    private TSc _sc_;

    public AVariableDecl()
    {
        // Constructor
    }

    public AVariableDecl(
        @SuppressWarnings("hiding") PVardecl _vardecl_,
        @SuppressWarnings("hiding") TSc _sc_)
    {
        // Constructor
        setVardecl(_vardecl_);

        setSc(_sc_);

    }

    @Override
    public Object clone()
    {
        return new AVariableDecl(
            cloneNode(this._vardecl_),
            cloneNode(this._sc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableDecl(this);
    }

    public PVardecl getVardecl()
    {
        return this._vardecl_;
    }

    public void setVardecl(PVardecl node)
    {
        if(this._vardecl_ != null)
        {
            this._vardecl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._vardecl_ = node;
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
            + toString(this._vardecl_)
            + toString(this._sc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._vardecl_ == child)
        {
            this._vardecl_ = null;
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
        if(this._vardecl_ == oldChild)
        {
            setVardecl((PVardecl) newChild);
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
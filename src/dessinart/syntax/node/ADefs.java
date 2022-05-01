/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class ADefs extends PDefs
{
    private PDefcan _defcan_;
    private PDefpen _defpen_;

    public ADefs()
    {
        // Constructor
    }

    public ADefs(
        @SuppressWarnings("hiding") PDefcan _defcan_,
        @SuppressWarnings("hiding") PDefpen _defpen_)
    {
        // Constructor
        setDefcan(_defcan_);

        setDefpen(_defpen_);

    }

    @Override
    public Object clone()
    {
        return new ADefs(
            cloneNode(this._defcan_),
            cloneNode(this._defpen_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefs(this);
    }

    public PDefcan getDefcan()
    {
        return this._defcan_;
    }

    public void setDefcan(PDefcan node)
    {
        if(this._defcan_ != null)
        {
            this._defcan_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._defcan_ = node;
    }

    public PDefpen getDefpen()
    {
        return this._defpen_;
    }

    public void setDefpen(PDefpen node)
    {
        if(this._defpen_ != null)
        {
            this._defpen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._defpen_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._defcan_)
            + toString(this._defpen_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._defcan_ == child)
        {
            this._defcan_ = null;
            return;
        }

        if(this._defpen_ == child)
        {
            this._defpen_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._defcan_ == oldChild)
        {
            setDefcan((PDefcan) newChild);
            return;
        }

        if(this._defpen_ == oldChild)
        {
            setDefpen((PDefpen) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
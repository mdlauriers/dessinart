/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AColorType extends PType
{
    private TColor _color_;

    public AColorType()
    {
        // Constructor
    }

    public AColorType(
        @SuppressWarnings("hiding") TColor _color_)
    {
        // Constructor
        setColor(_color_);

    }

    @Override
    public Object clone()
    {
        return new AColorType(
            cloneNode(this._color_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAColorType(this);
    }

    public TColor getColor()
    {
        return this._color_;
    }

    public void setColor(TColor node)
    {
        if(this._color_ != null)
        {
            this._color_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._color_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._color_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._color_ == child)
        {
            this._color_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._color_ == oldChild)
        {
            setColor((TColor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

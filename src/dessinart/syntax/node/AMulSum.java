/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AMulSum extends PSum
{
    private PSum _left_;
    private TStar _star_;
    private PNeg _right_;

    public AMulSum()
    {
        // Constructor
    }

    public AMulSum(
        @SuppressWarnings("hiding") PSum _left_,
        @SuppressWarnings("hiding") TStar _star_,
        @SuppressWarnings("hiding") PNeg _right_)
    {
        // Constructor
        setLeft(_left_);

        setStar(_star_);

        setRight(_right_);

    }

    @Override
    public Object clone()
    {
        return new AMulSum(
            cloneNode(this._left_),
            cloneNode(this._star_),
            cloneNode(this._right_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMulSum(this);
    }

    public PSum getLeft()
    {
        return this._left_;
    }

    public void setLeft(PSum node)
    {
        if(this._left_ != null)
        {
            this._left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._left_ = node;
    }

    public TStar getStar()
    {
        return this._star_;
    }

    public void setStar(TStar node)
    {
        if(this._star_ != null)
        {
            this._star_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._star_ = node;
    }

    public PNeg getRight()
    {
        return this._right_;
    }

    public void setRight(PNeg node)
    {
        if(this._right_ != null)
        {
            this._right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._right_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._left_)
            + toString(this._star_)
            + toString(this._right_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._left_ == child)
        {
            this._left_ = null;
            return;
        }

        if(this._star_ == child)
        {
            this._star_ = null;
            return;
        }

        if(this._right_ == child)
        {
            this._right_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._left_ == oldChild)
        {
            setLeft((PSum) newChild);
            return;
        }

        if(this._star_ == oldChild)
        {
            setStar((TStar) newChild);
            return;
        }

        if(this._right_ == oldChild)
        {
            setRight((PNeg) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AMain extends PMain
{
    private TDessinart _dessinart_;
    private TLBr _lBr_;
    private PBlock _block_;
    private TRBr _rBr_;

    public AMain()
    {
        // Constructor
    }

    public AMain(
        @SuppressWarnings("hiding") TDessinart _dessinart_,
        @SuppressWarnings("hiding") TLBr _lBr_,
        @SuppressWarnings("hiding") PBlock _block_,
        @SuppressWarnings("hiding") TRBr _rBr_)
    {
        // Constructor
        setDessinart(_dessinart_);

        setLBr(_lBr_);

        setBlock(_block_);

        setRBr(_rBr_);

    }

    @Override
    public Object clone()
    {
        return new AMain(
            cloneNode(this._dessinart_),
            cloneNode(this._lBr_),
            cloneNode(this._block_),
            cloneNode(this._rBr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMain(this);
    }

    public TDessinart getDessinart()
    {
        return this._dessinart_;
    }

    public void setDessinart(TDessinart node)
    {
        if(this._dessinart_ != null)
        {
            this._dessinart_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dessinart_ = node;
    }

    public TLBr getLBr()
    {
        return this._lBr_;
    }

    public void setLBr(TLBr node)
    {
        if(this._lBr_ != null)
        {
            this._lBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBr_ = node;
    }

    public PBlock getBlock()
    {
        return this._block_;
    }

    public void setBlock(PBlock node)
    {
        if(this._block_ != null)
        {
            this._block_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._block_ = node;
    }

    public TRBr getRBr()
    {
        return this._rBr_;
    }

    public void setRBr(TRBr node)
    {
        if(this._rBr_ != null)
        {
            this._rBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dessinart_)
            + toString(this._lBr_)
            + toString(this._block_)
            + toString(this._rBr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dessinart_ == child)
        {
            this._dessinart_ = null;
            return;
        }

        if(this._lBr_ == child)
        {
            this._lBr_ = null;
            return;
        }

        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        if(this._rBr_ == child)
        {
            this._rBr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dessinart_ == oldChild)
        {
            setDessinart((TDessinart) newChild);
            return;
        }

        if(this._lBr_ == oldChild)
        {
            setLBr((TLBr) newChild);
            return;
        }

        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        if(this._rBr_ == oldChild)
        {
            setRBr((TRBr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

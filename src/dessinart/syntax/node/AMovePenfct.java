/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class AMovePenfct extends PPenfct
{
    private TMove _move_;
    private TLPar _lPar_;
    private PExp _distX_;
    private TComma _comma_;
    private PExp _distY_;
    private TRPar _rPar_;

    public AMovePenfct()
    {
        // Constructor
    }

    public AMovePenfct(
        @SuppressWarnings("hiding") TMove _move_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PExp _distX_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PExp _distY_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setMove(_move_);

        setLPar(_lPar_);

        setDistX(_distX_);

        setComma(_comma_);

        setDistY(_distY_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new AMovePenfct(
            cloneNode(this._move_),
            cloneNode(this._lPar_),
            cloneNode(this._distX_),
            cloneNode(this._comma_),
            cloneNode(this._distY_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMovePenfct(this);
    }

    public TMove getMove()
    {
        return this._move_;
    }

    public void setMove(TMove node)
    {
        if(this._move_ != null)
        {
            this._move_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._move_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PExp getDistX()
    {
        return this._distX_;
    }

    public void setDistX(PExp node)
    {
        if(this._distX_ != null)
        {
            this._distX_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._distX_ = node;
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PExp getDistY()
    {
        return this._distY_;
    }

    public void setDistY(PExp node)
    {
        if(this._distY_ != null)
        {
            this._distY_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._distY_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._move_)
            + toString(this._lPar_)
            + toString(this._distX_)
            + toString(this._comma_)
            + toString(this._distY_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._move_ == child)
        {
            this._move_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._distX_ == child)
        {
            this._distX_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._distY_ == child)
        {
            this._distY_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._move_ == oldChild)
        {
            setMove((TMove) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._distX_ == oldChild)
        {
            setDistX((PExp) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._distY_ == oldChild)
        {
            setDistY((PExp) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class APowerMathfcts extends PMathfcts
{
    private TPower _power_;
    private TLPar _lPar_;
    private PExp _base_;
    private TComma _comma_;
    private PExp _expos_;
    private TRPar _rPar_;

    public APowerMathfcts()
    {
        // Constructor
    }

    public APowerMathfcts(
        @SuppressWarnings("hiding") TPower _power_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PExp _base_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PExp _expos_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setPower(_power_);

        setLPar(_lPar_);

        setBase(_base_);

        setComma(_comma_);

        setExpos(_expos_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new APowerMathfcts(
            cloneNode(this._power_),
            cloneNode(this._lPar_),
            cloneNode(this._base_),
            cloneNode(this._comma_),
            cloneNode(this._expos_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPowerMathfcts(this);
    }

    public TPower getPower()
    {
        return this._power_;
    }

    public void setPower(TPower node)
    {
        if(this._power_ != null)
        {
            this._power_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._power_ = node;
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

    public PExp getBase()
    {
        return this._base_;
    }

    public void setBase(PExp node)
    {
        if(this._base_ != null)
        {
            this._base_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._base_ = node;
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

    public PExp getExpos()
    {
        return this._expos_;
    }

    public void setExpos(PExp node)
    {
        if(this._expos_ != null)
        {
            this._expos_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expos_ = node;
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
            + toString(this._power_)
            + toString(this._lPar_)
            + toString(this._base_)
            + toString(this._comma_)
            + toString(this._expos_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._power_ == child)
        {
            this._power_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._base_ == child)
        {
            this._base_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._expos_ == child)
        {
            this._expos_ = null;
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
        if(this._power_ == oldChild)
        {
            setPower((TPower) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._base_ == oldChild)
        {
            setBase((PExp) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._expos_ == oldChild)
        {
            setExpos((PExp) newChild);
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

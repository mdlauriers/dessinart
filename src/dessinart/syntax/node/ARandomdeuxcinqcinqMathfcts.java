/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class ARandomdeuxcinqcinqMathfcts extends PMathfcts
{
    private TRandomdeuxcinqcinq _randomdeuxcinqcinq_;
    private TLPar _lPar_;
    private TRPar _rPar_;

    public ARandomdeuxcinqcinqMathfcts()
    {
        // Constructor
    }

    public ARandomdeuxcinqcinqMathfcts(
        @SuppressWarnings("hiding") TRandomdeuxcinqcinq _randomdeuxcinqcinq_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setRandomdeuxcinqcinq(_randomdeuxcinqcinq_);

        setLPar(_lPar_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new ARandomdeuxcinqcinqMathfcts(
            cloneNode(this._randomdeuxcinqcinq_),
            cloneNode(this._lPar_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARandomdeuxcinqcinqMathfcts(this);
    }

    public TRandomdeuxcinqcinq getRandomdeuxcinqcinq()
    {
        return this._randomdeuxcinqcinq_;
    }

    public void setRandomdeuxcinqcinq(TRandomdeuxcinqcinq node)
    {
        if(this._randomdeuxcinqcinq_ != null)
        {
            this._randomdeuxcinqcinq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._randomdeuxcinqcinq_ = node;
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
            + toString(this._randomdeuxcinqcinq_)
            + toString(this._lPar_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._randomdeuxcinqcinq_ == child)
        {
            this._randomdeuxcinqcinq_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
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
        if(this._randomdeuxcinqcinq_ == oldChild)
        {
            setRandomdeuxcinqcinq((TRandomdeuxcinqcinq) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
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
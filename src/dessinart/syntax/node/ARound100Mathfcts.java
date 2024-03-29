/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class ARound100Mathfcts extends PMathfcts
{
    private TRoundhund _roundhund_;
    private TLPar _lPar_;
    private PExp _valeur_;
    private TRPar _rPar_;

    public ARound100Mathfcts()
    {
        // Constructor
    }

    public ARound100Mathfcts(
        @SuppressWarnings("hiding") TRoundhund _roundhund_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PExp _valeur_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setRoundhund(_roundhund_);

        setLPar(_lPar_);

        setValeur(_valeur_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new ARound100Mathfcts(
            cloneNode(this._roundhund_),
            cloneNode(this._lPar_),
            cloneNode(this._valeur_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARound100Mathfcts(this);
    }

    public TRoundhund getRoundhund()
    {
        return this._roundhund_;
    }

    public void setRoundhund(TRoundhund node)
    {
        if(this._roundhund_ != null)
        {
            this._roundhund_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._roundhund_ = node;
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

    public PExp getValeur()
    {
        return this._valeur_;
    }

    public void setValeur(PExp node)
    {
        if(this._valeur_ != null)
        {
            this._valeur_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._valeur_ = node;
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
            + toString(this._roundhund_)
            + toString(this._lPar_)
            + toString(this._valeur_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._roundhund_ == child)
        {
            this._roundhund_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._valeur_ == child)
        {
            this._valeur_ = null;
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
        if(this._roundhund_ == oldChild)
        {
            setRoundhund((TRoundhund) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._valeur_ == oldChild)
        {
            setValeur((PExp) newChild);
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

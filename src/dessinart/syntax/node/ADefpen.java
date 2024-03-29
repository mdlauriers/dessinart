/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.node;

import dessinart.syntax.analysis.*;

@SuppressWarnings("nls")
public final class ADefpen extends PDefpen
{
    private TDefine _define_;
    private TPencil _pencil_;
    private TLPar _lPar_;
    private TNumber _width_;
    private TComma _comma1_;
    private TNumber _posx_;
    private TComma _comma2_;
    private TNumber _posy_;
    private TRPar _rPar_;
    private TSc _sc_;

    public ADefpen()
    {
        // Constructor
    }

    public ADefpen(
        @SuppressWarnings("hiding") TDefine _define_,
        @SuppressWarnings("hiding") TPencil _pencil_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") TNumber _width_,
        @SuppressWarnings("hiding") TComma _comma1_,
        @SuppressWarnings("hiding") TNumber _posx_,
        @SuppressWarnings("hiding") TComma _comma2_,
        @SuppressWarnings("hiding") TNumber _posy_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") TSc _sc_)
    {
        // Constructor
        setDefine(_define_);

        setPencil(_pencil_);

        setLPar(_lPar_);

        setWidth(_width_);

        setComma1(_comma1_);

        setPosx(_posx_);

        setComma2(_comma2_);

        setPosy(_posy_);

        setRPar(_rPar_);

        setSc(_sc_);

    }

    @Override
    public Object clone()
    {
        return new ADefpen(
            cloneNode(this._define_),
            cloneNode(this._pencil_),
            cloneNode(this._lPar_),
            cloneNode(this._width_),
            cloneNode(this._comma1_),
            cloneNode(this._posx_),
            cloneNode(this._comma2_),
            cloneNode(this._posy_),
            cloneNode(this._rPar_),
            cloneNode(this._sc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADefpen(this);
    }

    public TDefine getDefine()
    {
        return this._define_;
    }

    public void setDefine(TDefine node)
    {
        if(this._define_ != null)
        {
            this._define_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._define_ = node;
    }

    public TPencil getPencil()
    {
        return this._pencil_;
    }

    public void setPencil(TPencil node)
    {
        if(this._pencil_ != null)
        {
            this._pencil_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pencil_ = node;
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

    public TNumber getWidth()
    {
        return this._width_;
    }

    public void setWidth(TNumber node)
    {
        if(this._width_ != null)
        {
            this._width_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._width_ = node;
    }

    public TComma getComma1()
    {
        return this._comma1_;
    }

    public void setComma1(TComma node)
    {
        if(this._comma1_ != null)
        {
            this._comma1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma1_ = node;
    }

    public TNumber getPosx()
    {
        return this._posx_;
    }

    public void setPosx(TNumber node)
    {
        if(this._posx_ != null)
        {
            this._posx_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._posx_ = node;
    }

    public TComma getComma2()
    {
        return this._comma2_;
    }

    public void setComma2(TComma node)
    {
        if(this._comma2_ != null)
        {
            this._comma2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma2_ = node;
    }

    public TNumber getPosy()
    {
        return this._posy_;
    }

    public void setPosy(TNumber node)
    {
        if(this._posy_ != null)
        {
            this._posy_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._posy_ = node;
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
            + toString(this._define_)
            + toString(this._pencil_)
            + toString(this._lPar_)
            + toString(this._width_)
            + toString(this._comma1_)
            + toString(this._posx_)
            + toString(this._comma2_)
            + toString(this._posy_)
            + toString(this._rPar_)
            + toString(this._sc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._define_ == child)
        {
            this._define_ = null;
            return;
        }

        if(this._pencil_ == child)
        {
            this._pencil_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._width_ == child)
        {
            this._width_ = null;
            return;
        }

        if(this._comma1_ == child)
        {
            this._comma1_ = null;
            return;
        }

        if(this._posx_ == child)
        {
            this._posx_ = null;
            return;
        }

        if(this._comma2_ == child)
        {
            this._comma2_ = null;
            return;
        }

        if(this._posy_ == child)
        {
            this._posy_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
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
        if(this._define_ == oldChild)
        {
            setDefine((TDefine) newChild);
            return;
        }

        if(this._pencil_ == oldChild)
        {
            setPencil((TPencil) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._width_ == oldChild)
        {
            setWidth((TNumber) newChild);
            return;
        }

        if(this._comma1_ == oldChild)
        {
            setComma1((TComma) newChild);
            return;
        }

        if(this._posx_ == oldChild)
        {
            setPosx((TNumber) newChild);
            return;
        }

        if(this._comma2_ == oldChild)
        {
            setComma2((TComma) newChild);
            return;
        }

        if(this._posy_ == oldChild)
        {
            setPosy((TNumber) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
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

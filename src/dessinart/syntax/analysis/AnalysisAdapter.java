/* This file was generated by SableCC (http://www.sablecc.org/). */

package dessinart.syntax.analysis;

import java.util.*;
import dessinart.syntax.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefs(ADefs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefcan(ADefcan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefpen(ADefpen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMain(AMain node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlock(ABlock node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADeclInstr(ADeclInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignInstr(AAssignInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPenfctInstr(APenfctInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfInstr(AIfInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileInstr(AWhileInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReturnInstr(AReturnInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallInstr(ACallInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReplacePenfct(AReplacePenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMovePenfct(AMovePenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADrawabsPenfct(ADrawabsPenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADrawPenfct(ADrawPenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASetcolorPenfct(ASetcolorPenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASetwidthPenfct(ASetwidthPenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWaitPenfct(AWaitPenfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecls(ADecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFctDecl(AFctDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDecl(AVariableDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVardecl(AVardecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionFctdecl(AFunctionFctdecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASketchFctdecl(ASketchFctdecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParams(AParams node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAdditionalParam(AAdditionalParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParam(AParam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqExp(AEqExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALtExp(ALtExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGtExp(AGtExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleExp(ASimpleExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddSum(AAddSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubSum(ASubSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivSum(ADivSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMulSum(AMulSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModSum(AModSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleSum(ASimpleSum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotNeg(ANotNeg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermNeg(ATermNeg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumberTerm(ANumberTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegativeTerm(ANegativeTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarTerm(AVarTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABoolTerm(ABoolTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParTerm(AParTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAColorTerm(AColorTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMathfctsTerm(AMathfctsTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallTerm(ACallTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATrueBoole(ATrueBoole node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalseBoole(AFalseBoole node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAColorType(AColorType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArgs(AArgs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAdditionalArg(AAdditionalArg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArg(AArg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPowerMathfcts(APowerMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARound5Mathfcts(ARound5Mathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARound10Mathfcts(ARound10Mathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARound100Mathfcts(ARound100Mathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALogMathfcts(ALogMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASinMathfcts(ASinMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACosMathfcts(ACosMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATanMathfcts(ATanMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARandomdeuxcinqcinqMathfcts(ARandomdeuxcinqcinqMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARandomhundMathfcts(ARandomhundMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARandomtenMathfcts(ARandomtenMathfcts node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAssign(TAssign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDivide(TDivide node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLBr(TLBr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMod(TMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRBr(TRBr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStar(TStar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSc(TSc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEq(TEq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLt(TLt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGt(TGt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDo(TDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnd(TEnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFor(TFor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElif(TElif node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCanvas(TCanvas node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPencil(TPencil node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTColor(TColor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDefine(TDefine node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTImport(TImport node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDessinart(TDessinart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSketch(TSketch node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFunc(TFunc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDouble(TDouble node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBoolean(TBoolean node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReplace(TReplace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMove(TMove node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDraw(TDraw node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDrawTo(TDrawTo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSetColor(TSetColor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSetWidth(TSetWidth node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWait(TWait node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPower(TPower node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRoundfive(TRoundfive node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRoundten(TRoundten node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRoundhund(TRoundhund node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRandomdeuxcinqcinq(TRandomdeuxcinqcinq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRandomcent(TRandomcent node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRandomdix(TRandomdix node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSin(TSin node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCos(TCos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTan(TTan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLog(TLog node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentMulti(TCommentMulti node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdent(TIdent node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNumber(TNumber node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}

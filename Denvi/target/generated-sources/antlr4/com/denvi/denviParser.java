// Generated from com/denvi/denvi.g4 by ANTLR 4.13.1
package com.denvi;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class denviParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MUNDO=1, ACCION=2, METAACCION=3, PRINCIPAL=4, ESQUELETO=5, RETORNAR=6, 
		IGNOR=7, OBTIENEDE=8, INICIAR=9, ESTO=10, SUCESO=11, NIVEL=12, ZONA=13, 
		PORTAL=14, SITUAR=15, RETIRAR=16, VIAJAR=17, IMPORTAR=18, IMPCONS=19, 
		IMPCONSSL=20, OBTDATOS=21, ENT=22, DEC=23, CAD=24, CAR=25, BOO=26, TM=27, 
		NL=28, LT=29, AR=30, EVALUAR=31, ALTERNO=32, ALTERNATIVA=33, REPETICION=34, 
		VAL_BOO=35, VAL_NL=36, VAL_DEC=37, VAL_ENT=38, VAL_CAD=39, VAL_CAR=40, 
		VAL_TM=41, IMPORTINT=42, CONEE=43, CONEG=44, INCS=45, DECS=46, INCV=47, 
		DECV=48, ASIG=49, MA_IG=50, MEN_IG=51, COMP=52, DIF=53, OR=54, AND=55, 
		NOT=56, MA_Q=57, MEN_Q=58, OP_SUM=59, OP_REST=60, OP_MULT=61, OP_DIV=62, 
		OP_MOD=63, OP_COND=64, PAR_A=65, PAR_C=66, COR_A=67, COR_C=68, LLA_A=69, 
		LLA_C=70, CIER=71, COMA=72, PUNTO=73, DOB_P=74, IDE=75, IDECON=76, IDEEST=77, 
		IDEOBJ=78, COM_BLO=79, COM_SIM=80, WS=81;
	public static final int
		RULE_archivo = 0, RULE_archprin = 1, RULE_archclase = 2, RULE_importar = 3, 
		RULE_importext = 4, RULE_importint = 5, RULE_clasprin = 6, RULE_prog = 7, 
		RULE_escclase = 8, RULE_esccuerpo = 9, RULE_escmetodo = 10, RULE_cuerpometodo = 11, 
		RULE_escfuncion = 12, RULE_cuerpofuncion = 13, RULE_escretor = 14, RULE_parametro = 15, 
		RULE_decparam = 16, RULE_recparam = 17, RULE_declaobj = 18, RULE_llamfun = 19, 
		RULE_accmiem = 20, RULE_accmet = 21, RULE_miembro = 22, RULE_llamada = 23, 
		RULE_linin = 24, RULE_lincod = 25, RULE_declaracion = 26, RULE_asignacion = 27, 
		RULE_decla_glob = 28, RULE_asig_glob = 29, RULE_constante = 30, RULE_tipo = 31, 
		RULE_valor = 32, RULE_dato = 33, RULE_decar = 34, RULE_arreglo = 35, RULE_cont_arr = 36, 
		RULE_declt = 37, RULE_lista = 38, RULE_contev = 39, RULE_contevalt = 40, 
		RULE_contrep = 41, RULE_cuerpo = 42, RULE_contcon = 43, RULE_cuerpoev = 44, 
		RULE_cuerpoevalt = 45, RULE_cuerpoalt = 46, RULE_cuerporep = 47, RULE_cuerposuceso = 48, 
		RULE_escond = 49, RULE_esrep = 50, RULE_autoinc = 51, RULE_incre = 52, 
		RULE_increesp = 53, RULE_paso = 54, RULE_impcons = 55, RULE_impconssl = 56, 
		RULE_imprimible = 57, RULE_obtdatos = 58, RULE_escsuceso = 59, RULE_escnivel = 60, 
		RULE_propiedades = 61, RULE_propiedad = 62, RULE_cuerponivel = 63, RULE_subzona = 64, 
		RULE_enlace = 65, RULE_conexion = 66, RULE_destino = 67, RULE_situar = 68, 
		RULE_retirar = 69, RULE_viajar = 70, RULE_expresion = 71, RULE_logor = 72, 
		RULE_logand = 73, RULE_logig = 74, RULE_logrel = 75, RULE_logar = 76, 
		RULE_termino = 77, RULE_simbun = 78, RULE_valp = 79, RULE_base = 80, RULE_valsimple = 81;
	private static String[] makeRuleNames() {
		return new String[] {
			"archivo", "archprin", "archclase", "importar", "importext", "importint", 
			"clasprin", "prog", "escclase", "esccuerpo", "escmetodo", "cuerpometodo", 
			"escfuncion", "cuerpofuncion", "escretor", "parametro", "decparam", "recparam", 
			"declaobj", "llamfun", "accmiem", "accmet", "miembro", "llamada", "linin", 
			"lincod", "declaracion", "asignacion", "decla_glob", "asig_glob", "constante", 
			"tipo", "valor", "dato", "decar", "arreglo", "cont_arr", "declt", "lista", 
			"contev", "contevalt", "contrep", "cuerpo", "contcon", "cuerpoev", "cuerpoevalt", 
			"cuerpoalt", "cuerporep", "cuerposuceso", "escond", "esrep", "autoinc", 
			"incre", "increesp", "paso", "impcons", "impconssl", "imprimible", "obtdatos", 
			"escsuceso", "escnivel", "propiedades", "propiedad", "cuerponivel", "subzona", 
			"enlace", "conexion", "destino", "situar", "retirar", "viajar", "expresion", 
			"logor", "logand", "logig", "logrel", "logar", "termino", "simbun", "valp", 
			"base", "valsimple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Mundo'", "'Accion'", "'MetaAccion'", "'Principal'", "'Esqueleto'", 
			"'retornar'", "'IGNOR'", "'ObtieneDe'", "'iniciar'", "'@esto'", "'Suceso'", 
			"'Nivel'", "'Zona'", "'Portal'", "'Situar'", "'Retirar'", "'Viajar'", 
			"'Import'", "'ImpCons'", "'ImpConsSl'", "'ObtDatos'", "'ent'", "'dec'", 
			"'cad'", "'car'", "'boo'", "'tm'", "'nl'", "'lt'", "'ar'", "'ev'", "'evalt'", 
			"'alt'", "'rep'", null, "'nulo'", null, null, null, null, null, null, 
			"'-->'", "'->'", "'++'", "'--'", "'+?'", "'-?'", "':='", "'=>'", "'=<'", 
			"'=='", "'!='", "'||'", "'^'", "'!'", "'>'", "'<'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'?'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", 
			"','", "'.'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MUNDO", "ACCION", "METAACCION", "PRINCIPAL", "ESQUELETO", "RETORNAR", 
			"IGNOR", "OBTIENEDE", "INICIAR", "ESTO", "SUCESO", "NIVEL", "ZONA", "PORTAL", 
			"SITUAR", "RETIRAR", "VIAJAR", "IMPORTAR", "IMPCONS", "IMPCONSSL", "OBTDATOS", 
			"ENT", "DEC", "CAD", "CAR", "BOO", "TM", "NL", "LT", "AR", "EVALUAR", 
			"ALTERNO", "ALTERNATIVA", "REPETICION", "VAL_BOO", "VAL_NL", "VAL_DEC", 
			"VAL_ENT", "VAL_CAD", "VAL_CAR", "VAL_TM", "IMPORTINT", "CONEE", "CONEG", 
			"INCS", "DECS", "INCV", "DECV", "ASIG", "MA_IG", "MEN_IG", "COMP", "DIF", 
			"OR", "AND", "NOT", "MA_Q", "MEN_Q", "OP_SUM", "OP_REST", "OP_MULT", 
			"OP_DIV", "OP_MOD", "OP_COND", "PAR_A", "PAR_C", "COR_A", "COR_C", "LLA_A", 
			"LLA_C", "CIER", "COMA", "PUNTO", "DOB_P", "IDE", "IDECON", "IDEEST", 
			"IDEOBJ", "COM_BLO", "COM_SIM", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "denvi.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public denviParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArchivoContext extends ParserRuleContext {
		public ArchprinContext archprin() {
			return getRuleContext(ArchprinContext.class,0);
		}
		public ArchclaseContext archclase() {
			return getRuleContext(ArchclaseContext.class,0);
		}
		public ArchivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archivo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitArchivo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchivoContext archivo() throws RecognitionException {
		ArchivoContext _localctx = new ArchivoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_archivo);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				archprin();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				archclase();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArchprinContext extends ParserRuleContext {
		public ClasprinContext clasprin() {
			return getRuleContext(ClasprinContext.class,0);
		}
		public TerminalNode EOF() { return getToken(denviParser.EOF, 0); }
		public List<ImportarContext> importar() {
			return getRuleContexts(ImportarContext.class);
		}
		public ImportarContext importar(int i) {
			return getRuleContext(ImportarContext.class,i);
		}
		public ArchprinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archprin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitArchprin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchprinContext archprin() throws RecognitionException {
		ArchprinContext _localctx = new ArchprinContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_archprin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORTAR) {
				{
				{
				setState(168);
				importar();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			clasprin();
			setState(175);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArchclaseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(denviParser.EOF, 0); }
		public List<ImportarContext> importar() {
			return getRuleContexts(ImportarContext.class);
		}
		public ImportarContext importar(int i) {
			return getRuleContext(ImportarContext.class,i);
		}
		public List<EscclaseContext> escclase() {
			return getRuleContexts(EscclaseContext.class);
		}
		public EscclaseContext escclase(int i) {
			return getRuleContext(EscclaseContext.class,i);
		}
		public ArchclaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archclase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitArchclase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchclaseContext archclase() throws RecognitionException {
		ArchclaseContext _localctx = new ArchclaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_archclase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORTAR) {
				{
				{
				setState(177);
				importar();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				escclase();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ESQUELETO );
			setState(188);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportarContext extends ParserRuleContext {
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public ImportextContext importext() {
			return getRuleContext(ImportextContext.class,0);
		}
		public ImportintContext importint() {
			return getRuleContext(ImportintContext.class,0);
		}
		public ImportarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImportar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportarContext importar() throws RecognitionException {
		ImportarContext _localctx = new ImportarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(190);
				importext();
				}
				break;
			case 2:
				{
				setState(191);
				importint();
				}
				break;
			}
			setState(194);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportextContext extends ParserRuleContext {
		public TerminalNode IMPORTAR() { return getToken(denviParser.IMPORTAR, 0); }
		public TerminalNode VAL_CAD() { return getToken(denviParser.VAL_CAD, 0); }
		public ImportextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importext; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImportext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportextContext importext() throws RecognitionException {
		ImportextContext _localctx = new ImportextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IMPORTAR);
			setState(197);
			match(VAL_CAD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportintContext extends ParserRuleContext {
		public TerminalNode IMPORTAR() { return getToken(denviParser.IMPORTAR, 0); }
		public TerminalNode IMPORTINT() { return getToken(denviParser.IMPORTINT, 0); }
		public ImportintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImportint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportintContext importint() throws RecognitionException {
		ImportintContext _localctx = new ImportintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(IMPORTAR);
			setState(200);
			match(IMPORTINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClasprinContext extends ParserRuleContext {
		public TerminalNode ESQUELETO() { return getToken(denviParser.ESQUELETO, 0); }
		public TerminalNode PRINCIPAL() { return getToken(denviParser.PRINCIPAL, 0); }
		public TerminalNode CONEE() { return getToken(denviParser.CONEE, 0); }
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<EscmetodoContext> escmetodo() {
			return getRuleContexts(EscmetodoContext.class);
		}
		public EscmetodoContext escmetodo(int i) {
			return getRuleContext(EscmetodoContext.class,i);
		}
		public ClasprinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clasprin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitClasprin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClasprinContext clasprin() throws RecognitionException {
		ClasprinContext _localctx = new ClasprinContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_clasprin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ESQUELETO);
			setState(203);
			match(PRINCIPAL);
			setState(204);
			match(CONEE);
			setState(205);
			match(LLA_A);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==METAACCION) {
				{
				{
				setState(206);
				escmetodo();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			prog();
			setState(213);
			match(LLA_C);
			setState(214);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public List<EscfuncionContext> escfuncion() {
			return getRuleContexts(EscfuncionContext.class);
		}
		public EscfuncionContext escfuncion(int i) {
			return getRuleContext(EscfuncionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prog);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(IGNOR);
				setState(217);
				match(CIER);
				}
				break;
			case MUNDO:
			case ACCION:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(220);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MUNDO:
					case ESTO:
					case SUCESO:
					case NIVEL:
					case SITUAR:
					case RETIRAR:
					case VIAJAR:
					case IMPCONS:
					case IMPCONSSL:
					case OBTDATOS:
					case LT:
					case AR:
					case EVALUAR:
					case REPETICION:
					case PAR_A:
					case IDE:
					case IDECON:
					case IDEEST:
					case IDEOBJ:
						{
						setState(218);
						lincod();
						}
						break;
					case ACCION:
						{
						setState(219);
						escfuncion();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(222); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872134L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0) );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscclaseContext extends ParserRuleContext {
		public TerminalNode ESQUELETO() { return getToken(denviParser.ESQUELETO, 0); }
		public List<TerminalNode> IDEEST() { return getTokens(denviParser.IDEEST); }
		public TerminalNode IDEEST(int i) {
			return getToken(denviParser.IDEEST, i);
		}
		public List<TerminalNode> CONEE() { return getTokens(denviParser.CONEE); }
		public TerminalNode CONEE(int i) {
			return getToken(denviParser.CONEE, i);
		}
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public EsccuerpoContext esccuerpo() {
			return getRuleContext(EsccuerpoContext.class,0);
		}
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public TerminalNode OBTIENEDE() { return getToken(denviParser.OBTIENEDE, 0); }
		public DecparamContext decparam() {
			return getRuleContext(DecparamContext.class,0);
		}
		public EscclaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escclase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscclase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscclaseContext escclase() throws RecognitionException {
		EscclaseContext _localctx = new EscclaseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_escclase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(ESQUELETO);
			setState(227);
			match(IDEEST);
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(228);
				match(CONEE);
				setState(229);
				match(OBTIENEDE);
				setState(230);
				match(IDEEST);
				}
				break;
			}
			setState(233);
			match(CONEE);
			setState(234);
			match(PAR_A);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & 351843720888323L) != 0)) {
				{
				setState(235);
				decparam();
				}
			}

			setState(238);
			match(PAR_C);
			setState(239);
			esccuerpo();
			setState(240);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EsccuerpoContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<EscmetodoContext> escmetodo() {
			return getRuleContexts(EscmetodoContext.class);
		}
		public EscmetodoContext escmetodo(int i) {
			return getRuleContext(EscmetodoContext.class,i);
		}
		public EsccuerpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_esccuerpo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEsccuerpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EsccuerpoContext esccuerpo() throws RecognitionException {
		EsccuerpoContext _localctx = new EsccuerpoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_esccuerpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(LLA_A);
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(243);
				match(IGNOR);
				setState(244);
				match(CIER);
				}
				break;
			case METAACCION:
				{
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(245);
					escmetodo();
					}
					}
					setState(248); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==METAACCION );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(252);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscmetodoContext extends ParserRuleContext {
		public TerminalNode METAACCION() { return getToken(denviParser.METAACCION, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode CONEE() { return getToken(denviParser.CONEE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public CuerpometodoContext cuerpometodo() {
			return getRuleContext(CuerpometodoContext.class,0);
		}
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public DecparamContext decparam() {
			return getRuleContext(DecparamContext.class,0);
		}
		public EscmetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escmetodo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscmetodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscmetodoContext escmetodo() throws RecognitionException {
		EscmetodoContext _localctx = new EscmetodoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_escmetodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(METAACCION);
			setState(255);
			match(IDEEST);
			setState(256);
			match(CONEE);
			setState(257);
			match(PAR_A);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & 351843720888323L) != 0)) {
				{
				setState(258);
				decparam();
				}
			}

			setState(261);
			match(PAR_C);
			setState(262);
			cuerpometodo();
			setState(263);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpometodoContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public List<EscfuncionContext> escfuncion() {
			return getRuleContexts(EscfuncionContext.class);
		}
		public EscfuncionContext escfuncion(int i) {
			return getRuleContext(EscfuncionContext.class,i);
		}
		public CuerpometodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpometodo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpometodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpometodoContext cuerpometodo() throws RecognitionException {
		CuerpometodoContext _localctx = new CuerpometodoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cuerpometodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LLA_A);
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(266);
				match(IGNOR);
				setState(267);
				match(CIER);
				}
				break;
			case MUNDO:
			case ACCION:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(270); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(270);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MUNDO:
					case ESTO:
					case SUCESO:
					case NIVEL:
					case SITUAR:
					case RETIRAR:
					case VIAJAR:
					case IMPCONS:
					case IMPCONSSL:
					case OBTDATOS:
					case LT:
					case AR:
					case EVALUAR:
					case REPETICION:
					case PAR_A:
					case IDE:
					case IDECON:
					case IDEEST:
					case IDEOBJ:
						{
						setState(268);
						lincod();
						}
						break;
					case ACCION:
						{
						setState(269);
						escfuncion();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(272); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872134L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0) );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(276);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscfuncionContext extends ParserRuleContext {
		public TerminalNode ACCION() { return getToken(denviParser.ACCION, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode CONEE() { return getToken(denviParser.CONEE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public CuerpofuncionContext cuerpofuncion() {
			return getRuleContext(CuerpofuncionContext.class,0);
		}
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public DecparamContext decparam() {
			return getRuleContext(DecparamContext.class,0);
		}
		public EscfuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escfuncion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscfuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscfuncionContext escfuncion() throws RecognitionException {
		EscfuncionContext _localctx = new EscfuncionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_escfuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ACCION);
			setState(279);
			match(IDEEST);
			setState(280);
			match(CONEE);
			setState(281);
			match(PAR_A);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & 351843720888323L) != 0)) {
				{
				setState(282);
				decparam();
				}
			}

			setState(285);
			match(PAR_C);
			setState(286);
			cuerpofuncion();
			setState(287);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpofuncionContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerpofuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpofuncion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpofuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpofuncionContext cuerpofuncion() throws RecognitionException {
		CuerpofuncionContext _localctx = new CuerpofuncionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cuerpofuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LLA_A);
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(290);
				match(IGNOR);
				setState(291);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(292);
					lincod();
					}
					}
					setState(295); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0) );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(299);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscretorContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode PUNTO() { return getToken(denviParser.PUNTO, 0); }
		public TerminalNode RETORNAR() { return getToken(denviParser.RETORNAR, 0); }
		public DatoContext dato() {
			return getRuleContext(DatoContext.class,0);
		}
		public EscretorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escretor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscretor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscretorContext escretor() throws RecognitionException {
		EscretorContext _localctx = new EscretorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_escretor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(PAR_A);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801444214634972160L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15381L) != 0)) {
				{
				setState(302);
				dato();
				}
			}

			setState(305);
			match(PAR_C);
			setState(306);
			match(PUNTO);
			setState(307);
			match(RETORNAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode AR() { return getToken(denviParser.AR, 0); }
		public TerminalNode LT() { return getToken(denviParser.LT, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parametro);
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(IDE);
				setState(310);
				match(PAR_A);
				setState(311);
				tipo();
				setState(312);
				match(PAR_C);
				}
				break;
			case AR:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(AR);
				setState(315);
				match(IDE);
				setState(316);
				match(PAR_A);
				setState(317);
				tipo();
				setState(318);
				match(PAR_C);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(LT);
				setState(321);
				match(IDE);
				setState(322);
				match(PAR_A);
				setState(323);
				tipo();
				setState(324);
				match(PAR_C);
				}
				break;
			case IDEEST:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				match(IDEEST);
				setState(327);
				match(IDEOBJ);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecparamContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public DecparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decparam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDecparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecparamContext decparam() throws RecognitionException {
		DecparamContext _localctx = new DecparamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_decparam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			parametro();
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(331);
				match(COMA);
				setState(332);
				parametro();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecparamContext extends ParserRuleContext {
		public List<DatoContext> dato() {
			return getRuleContexts(DatoContext.class);
		}
		public DatoContext dato(int i) {
			return getRuleContext(DatoContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public RecparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recparam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitRecparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecparamContext recparam() throws RecognitionException {
		RecparamContext _localctx = new RecparamContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_recparam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			dato();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(339);
				match(COMA);
				setState(340);
				dato();
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaobjContext extends ParserRuleContext {
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public TerminalNode INICIAR() { return getToken(denviParser.INICIAR, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public RecparamContext recparam() {
			return getRuleContext(RecparamContext.class,0);
		}
		public DeclaobjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaobj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDeclaobj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaobjContext declaobj() throws RecognitionException {
		DeclaobjContext _localctx = new DeclaobjContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaobj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(IDEEST);
			setState(347);
			match(IDEOBJ);
			setState(348);
			match(ASIG);
			setState(349);
			match(INICIAR);
			setState(350);
			match(PAR_A);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801444214634972160L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15381L) != 0)) {
				{
				setState(351);
				recparam();
				}
			}

			setState(354);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamfunContext extends ParserRuleContext {
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public RecparamContext recparam() {
			return getRuleContext(RecparamContext.class,0);
		}
		public LlamfunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamfun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLlamfun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamfunContext llamfun() throws RecognitionException {
		LlamfunContext _localctx = new LlamfunContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_llamfun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(IDEEST);
			setState(357);
			match(PAR_A);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801444214634972160L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15381L) != 0)) {
				{
				setState(358);
				recparam();
				}
			}

			setState(361);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccmiemContext extends ParserRuleContext {
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode ESTO() { return getToken(denviParser.ESTO, 0); }
		public List<TerminalNode> PUNTO() { return getTokens(denviParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(denviParser.PUNTO, i);
		}
		public List<TerminalNode> IDE() { return getTokens(denviParser.IDE); }
		public TerminalNode IDE(int i) {
			return getToken(denviParser.IDE, i);
		}
		public AccmiemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accmiem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAccmiem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccmiemContext accmiem() throws RecognitionException {
		AccmiemContext _localctx = new AccmiemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_accmiem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !(_la==ESTO || _la==IDEOBJ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(364);
				match(PUNTO);
				setState(365);
				match(IDE);
				}
				}
				setState(368); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PUNTO );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccmetContext extends ParserRuleContext {
		public List<TerminalNode> PUNTO() { return getTokens(denviParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(denviParser.PUNTO, i);
		}
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode ESTO() { return getToken(denviParser.ESTO, 0); }
		public LlamfunContext llamfun() {
			return getRuleContext(LlamfunContext.class,0);
		}
		public List<MiembroContext> miembro() {
			return getRuleContexts(MiembroContext.class);
		}
		public MiembroContext miembro(int i) {
			return getRuleContext(MiembroContext.class,i);
		}
		public RecparamContext recparam() {
			return getRuleContext(RecparamContext.class,0);
		}
		public AccmetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accmet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAccmet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccmetContext accmet() throws RecognitionException {
		AccmetContext _localctx = new AccmetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_accmet);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDEOBJ:
				{
				setState(370);
				match(IDEOBJ);
				}
				break;
			case ESTO:
				{
				setState(371);
				match(ESTO);
				}
				break;
			case IDEEST:
				{
				setState(372);
				llamfun();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(375);
					match(PUNTO);
					setState(376);
					miembro();
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(382);
			match(PUNTO);
			setState(383);
			match(IDEEST);
			setState(384);
			match(PAR_A);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801444214634972160L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15381L) != 0)) {
				{
				setState(385);
				recparam();
				}
			}

			setState(388);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MiembroContext extends ParserRuleContext {
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public RecparamContext recparam() {
			return getRuleContext(RecparamContext.class,0);
		}
		public MiembroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_miembro; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitMiembro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MiembroContext miembro() throws RecognitionException {
		MiembroContext _localctx = new MiembroContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_miembro);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				match(IDE);
				}
				break;
			case IDECON:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(IDECON);
				}
				break;
			case IDEEST:
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
				match(IDEEST);
				setState(393);
				match(PAR_A);
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801444214634972160L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15381L) != 0)) {
					{
					setState(394);
					recparam();
					}
				}

				setState(397);
				match(PAR_C);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaContext extends ParserRuleContext {
		public LlamfunContext llamfun() {
			return getRuleContext(LlamfunContext.class,0);
		}
		public AccmetContext accmet() {
			return getRuleContext(AccmetContext.class,0);
		}
		public LlamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaContext llamada() throws RecognitionException {
		LlamadaContext _localctx = new LlamadaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_llamada);
		try {
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				llamfun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				accmet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LininContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public DecarContext decar() {
			return getRuleContext(DecarContext.class,0);
		}
		public DecltContext declt() {
			return getRuleContext(DecltContext.class,0);
		}
		public DeclaobjContext declaobj() {
			return getRuleContext(DeclaobjContext.class,0);
		}
		public Decla_globContext decla_glob() {
			return getRuleContext(Decla_globContext.class,0);
		}
		public Asig_globContext asig_glob() {
			return getRuleContext(Asig_globContext.class,0);
		}
		public ImpconsContext impcons() {
			return getRuleContext(ImpconsContext.class,0);
		}
		public ImpconsslContext impconssl() {
			return getRuleContext(ImpconsslContext.class,0);
		}
		public ObtdatosContext obtdatos() {
			return getRuleContext(ObtdatosContext.class,0);
		}
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public EscretorContext escretor() {
			return getRuleContext(EscretorContext.class,0);
		}
		public EscondContext escond() {
			return getRuleContext(EscondContext.class,0);
		}
		public EsrepContext esrep() {
			return getRuleContext(EsrepContext.class,0);
		}
		public EscsucesoContext escsuceso() {
			return getRuleContext(EscsucesoContext.class,0);
		}
		public EscnivelContext escnivel() {
			return getRuleContext(EscnivelContext.class,0);
		}
		public ConexionContext conexion() {
			return getRuleContext(ConexionContext.class,0);
		}
		public SituarContext situar() {
			return getRuleContext(SituarContext.class,0);
		}
		public RetirarContext retirar() {
			return getRuleContext(RetirarContext.class,0);
		}
		public ViajarContext viajar() {
			return getRuleContext(ViajarContext.class,0);
		}
		public LininContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLinin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LininContext linin() throws RecognitionException {
		LininContext _localctx = new LininContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_linin);
		try {
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(406);
				constante();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(407);
				decar();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(408);
				declt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(409);
				declaobj();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(410);
				decla_glob();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(411);
				asig_glob();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(412);
				impcons();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(413);
				impconssl();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(414);
				obtdatos();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(415);
				llamada();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(416);
				escretor();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(417);
				escond();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(418);
				esrep();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(419);
				escsuceso();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(420);
				escnivel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(421);
				conexion();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(422);
				situar();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(423);
				retirar();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(424);
				viajar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LincodContext extends ParserRuleContext {
		public LininContext linin() {
			return getRuleContext(LininContext.class,0);
		}
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public LincodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lincod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLincod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LincodContext lincod() throws RecognitionException {
		LincodContext _localctx = new LincodContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_lincod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			linin();
			setState(428);
			match(CIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionAsigContext extends DeclaracionContext {
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionAsigContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDeclaracionAsig(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSimpleContext extends DeclaracionContext {
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public DeclaracionSimpleContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDeclaracionSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declaracion);
		try {
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new DeclaracionSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(IDE);
				setState(431);
				match(PAR_A);
				setState(432);
				tipo();
				setState(433);
				match(PAR_C);
				}
				break;
			case 2:
				_localctx = new DeclaracionAsigContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				match(IDE);
				setState(436);
				match(PAR_A);
				setState(437);
				tipo();
				setState(438);
				match(PAR_C);
				setState(439);
				match(ASIG);
				setState(440);
				expresion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsigMiembroContext extends AsignacionContext {
		public AccmiemContext accmiem() {
			return getRuleContext(AccmiemContext.class,0);
		}
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public DatoContext dato() {
			return getRuleContext(DatoContext.class,0);
		}
		public AutoincContext autoinc() {
			return getRuleContext(AutoincContext.class,0);
		}
		public AsigMiembroContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAsigMiembro(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsigVarContext extends AsignacionContext {
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public DatoContext dato() {
			return getRuleContext(DatoContext.class,0);
		}
		public AutoincContext autoinc() {
			return getRuleContext(AutoincContext.class,0);
		}
		public AsigVarContext(AsignacionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAsigVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_asignacion);
		try {
			setState(456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				_localctx = new AsigVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				match(IDE);
				setState(445);
				match(ASIG);
				setState(448);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ESTO:
				case VAL_BOO:
				case VAL_NL:
				case VAL_DEC:
				case VAL_ENT:
				case VAL_CAD:
				case VAL_CAR:
				case VAL_TM:
				case NOT:
				case OP_SUM:
				case OP_REST:
				case PAR_A:
				case COR_A:
				case LLA_A:
				case IDE:
				case IDECON:
				case IDEEST:
				case IDEOBJ:
					{
					setState(446);
					dato();
					}
					break;
				case INCS:
				case DECS:
				case INCV:
				case DECV:
					{
					setState(447);
					autoinc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ESTO:
			case IDEOBJ:
				_localctx = new AsigMiembroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				accmiem();
				setState(451);
				match(ASIG);
				setState(454);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ESTO:
				case VAL_BOO:
				case VAL_NL:
				case VAL_DEC:
				case VAL_ENT:
				case VAL_CAD:
				case VAL_CAR:
				case VAL_TM:
				case NOT:
				case OP_SUM:
				case OP_REST:
				case PAR_A:
				case COR_A:
				case LLA_A:
				case IDE:
				case IDECON:
				case IDEEST:
				case IDEOBJ:
					{
					setState(452);
					dato();
					}
					break;
				case INCS:
				case DECS:
				case INCV:
				case DECV:
					{
					setState(453);
					autoinc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decla_globContext extends ParserRuleContext {
		public TerminalNode MUNDO() { return getToken(denviParser.MUNDO, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public DecarContext decar() {
			return getRuleContext(DecarContext.class,0);
		}
		public DecltContext declt() {
			return getRuleContext(DecltContext.class,0);
		}
		public DeclaobjContext declaobj() {
			return getRuleContext(DeclaobjContext.class,0);
		}
		public Decla_globContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decla_glob; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDecla_glob(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decla_globContext decla_glob() throws RecognitionException {
		Decla_globContext _localctx = new Decla_globContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_decla_glob);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(MUNDO);
			setState(464);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				{
				setState(459);
				declaracion();
				}
				break;
			case IDECON:
				{
				setState(460);
				constante();
				}
				break;
			case AR:
				{
				setState(461);
				decar();
				}
				break;
			case LT:
				{
				setState(462);
				declt();
				}
				break;
			case IDEEST:
				{
				setState(463);
				declaobj();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Asig_globContext extends ParserRuleContext {
		public TerminalNode MUNDO() { return getToken(denviParser.MUNDO, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public Asig_globContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asig_glob; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAsig_glob(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asig_globContext asig_glob() throws RecognitionException {
		Asig_globContext _localctx = new Asig_globContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_asig_glob);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(MUNDO);
			setState(467);
			asignacion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstanteContext extends ParserRuleContext {
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constante; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitConstante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstanteContext constante() throws RecognitionException {
		ConstanteContext _localctx = new ConstanteContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_constante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(IDECON);
			setState(470);
			match(PAR_A);
			setState(471);
			tipo();
			setState(472);
			match(PAR_C);
			setState(473);
			match(ASIG);
			setState(474);
			expresion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode ENT() { return getToken(denviParser.ENT, 0); }
		public TerminalNode DEC() { return getToken(denviParser.DEC, 0); }
		public TerminalNode CAD() { return getToken(denviParser.CAD, 0); }
		public TerminalNode CAR() { return getToken(denviParser.CAR, 0); }
		public TerminalNode BOO() { return getToken(denviParser.BOO, 0); }
		public TerminalNode TM() { return getToken(denviParser.TM, 0); }
		public TerminalNode NL() { return getToken(denviParser.NL, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 532676608L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public TerminalNode VAL_ENT() { return getToken(denviParser.VAL_ENT, 0); }
		public TerminalNode VAL_DEC() { return getToken(denviParser.VAL_DEC, 0); }
		public TerminalNode VAL_CAD() { return getToken(denviParser.VAL_CAD, 0); }
		public TerminalNode VAL_CAR() { return getToken(denviParser.VAL_CAR, 0); }
		public TerminalNode VAL_BOO() { return getToken(denviParser.VAL_BOO, 0); }
		public TerminalNode VAL_TM() { return getToken(denviParser.VAL_TM, 0); }
		public TerminalNode VAL_NL() { return getToken(denviParser.VAL_NL, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4363686772736L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatoContext extends ParserRuleContext {
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dato; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatoContext dato() throws RecognitionException {
		DatoContext _localctx = new DatoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dato);
		try {
			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COR_A:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				arreglo();
				}
				break;
			case LLA_A:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				lista();
				}
				break;
			case ESTO:
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
			case NOT:
			case OP_SUM:
			case OP_REST:
			case PAR_A:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				expresion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecarContext extends ParserRuleContext {
		public TerminalNode AR() { return getToken(denviParser.AR, 0); }
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public DecarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDecar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecarContext decar() throws RecognitionException {
		DecarContext _localctx = new DecarContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_decar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(AR);
			setState(501);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				{
				setState(486);
				match(IDE);
				setState(487);
				match(PAR_A);
				setState(488);
				tipo();
				setState(489);
				match(PAR_C);
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIG) {
					{
					setState(490);
					match(ASIG);
					setState(491);
					arreglo();
					}
				}

				}
				break;
			case IDECON:
				{
				setState(494);
				match(IDECON);
				setState(495);
				match(PAR_A);
				setState(496);
				tipo();
				setState(497);
				match(PAR_C);
				setState(498);
				match(ASIG);
				setState(499);
				arreglo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArregloContext extends ParserRuleContext {
		public TerminalNode COR_A() { return getToken(denviParser.COR_A, 0); }
		public TerminalNode COR_C() { return getToken(denviParser.COR_C, 0); }
		public List<Cont_arrContext> cont_arr() {
			return getRuleContexts(Cont_arrContext.class);
		}
		public Cont_arrContext cont_arr(int i) {
			return getRuleContext(Cont_arrContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public ArregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arreglo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArregloContext arreglo() throws RecognitionException {
		ArregloContext _localctx = new ArregloContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(COR_A);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 3302829850751L) != 0)) {
				{
				setState(504);
				cont_arr();
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(505);
					match(COMA);
					setState(506);
					cont_arr();
					}
					}
					setState(511);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(514);
			match(COR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cont_arrContext extends ParserRuleContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public ArregloContext arreglo() {
			return getRuleContext(ArregloContext.class,0);
		}
		public Cont_arrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cont_arr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCont_arr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cont_arrContext cont_arr() throws RecognitionException {
		Cont_arrContext _localctx = new Cont_arrContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cont_arr);
		try {
			setState(520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				valor();
				}
				break;
			case IDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				match(IDE);
				}
				break;
			case IDECON:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				match(IDECON);
				}
				break;
			case COR_A:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				arreglo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecltContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(denviParser.LT, 0); }
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public TerminalNode ASIG() { return getToken(denviParser.ASIG, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public DecltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDeclt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecltContext declt() throws RecognitionException {
		DecltContext _localctx = new DecltContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_declt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			match(LT);
			setState(538);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				{
				setState(523);
				match(IDE);
				setState(524);
				match(PAR_A);
				setState(525);
				tipo();
				setState(526);
				match(PAR_C);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIG) {
					{
					setState(527);
					match(ASIG);
					setState(528);
					lista();
					}
				}

				}
				break;
			case IDECON:
				{
				setState(531);
				match(IDECON);
				setState(532);
				match(PAR_A);
				setState(533);
				tipo();
				setState(534);
				match(PAR_C);
				setState(535);
				match(ASIG);
				setState(536);
				lista();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public List<TerminalNode> IDE() { return getTokens(denviParser.IDE); }
		public TerminalNode IDE(int i) {
			return getToken(denviParser.IDE, i);
		}
		public List<TerminalNode> IDECON() { return getTokens(denviParser.IDECON); }
		public TerminalNode IDECON(int i) {
			return getToken(denviParser.IDECON, i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public ListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaContext lista() throws RecognitionException {
		ListaContext _localctx = new ListaContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_lista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(LLA_A);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 3298534883455L) != 0)) {
				{
				setState(544);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAL_BOO:
				case VAL_NL:
				case VAL_DEC:
				case VAL_ENT:
				case VAL_CAD:
				case VAL_CAR:
				case VAL_TM:
					{
					setState(541);
					valor();
					}
					break;
				case IDE:
					{
					setState(542);
					match(IDE);
					}
					break;
				case IDECON:
					{
					setState(543);
					match(IDECON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(546);
					match(COMA);
					setState(550);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VAL_BOO:
					case VAL_NL:
					case VAL_DEC:
					case VAL_ENT:
					case VAL_CAD:
					case VAL_CAR:
					case VAL_TM:
						{
						setState(547);
						valor();
						}
						break;
					case IDE:
						{
						setState(548);
						match(IDE);
						}
						break;
					case IDECON:
						{
						setState(549);
						match(IDECON);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(556);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(559);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContevContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode OP_COND() { return getToken(denviParser.OP_COND, 0); }
		public CuerpoevContext cuerpoev() {
			return getRuleContext(CuerpoevContext.class,0);
		}
		public ContevContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contev; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitContev(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContevContext contev() throws RecognitionException {
		ContevContext _localctx = new ContevContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_contev);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(PAR_A);
			setState(562);
			expresion();
			setState(563);
			match(PAR_C);
			setState(564);
			match(OP_COND);
			setState(565);
			cuerpoev();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContevaltContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode OP_COND() { return getToken(denviParser.OP_COND, 0); }
		public CuerpoevaltContext cuerpoevalt() {
			return getRuleContext(CuerpoevaltContext.class,0);
		}
		public ContevaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contevalt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitContevalt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContevaltContext contevalt() throws RecognitionException {
		ContevaltContext _localctx = new ContevaltContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_contevalt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			match(PAR_A);
			setState(568);
			expresion();
			setState(569);
			match(PAR_C);
			setState(570);
			match(OP_COND);
			setState(571);
			cuerpoevalt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContrepContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode OP_COND() { return getToken(denviParser.OP_COND, 0); }
		public CuerporepContext cuerporep() {
			return getRuleContext(CuerporepContext.class,0);
		}
		public ContrepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contrep; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitContrep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContrepContext contrep() throws RecognitionException {
		ContrepContext _localctx = new ContrepContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_contrep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			match(PAR_A);
			setState(574);
			expresion();
			setState(575);
			match(PAR_C);
			setState(576);
			match(OP_COND);
			setState(577);
			cuerporep();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpoContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoContext cuerpo() throws RecognitionException {
		CuerpoContext _localctx = new CuerpoContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_cuerpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(LLA_A);
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(580);
				match(IGNOR);
				setState(581);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(582);
					lincod();
					}
					}
					setState(587);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(590);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContconContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode OP_COND() { return getToken(denviParser.OP_COND, 0); }
		public CuerpoContext cuerpo() {
			return getRuleContext(CuerpoContext.class,0);
		}
		public ContconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contcon; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitContcon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContconContext contcon() throws RecognitionException {
		ContconContext _localctx = new ContconContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_contcon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(PAR_A);
			setState(593);
			expresion();
			setState(594);
			match(PAR_C);
			setState(595);
			match(OP_COND);
			setState(596);
			cuerpo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpoevContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerpoevContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpoev; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpoev(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoevContext cuerpoev() throws RecognitionException {
		CuerpoevContext _localctx = new CuerpoevContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_cuerpoev);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			match(LLA_A);
			setState(607);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(599);
				match(IGNOR);
				setState(600);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(601);
					lincod();
					}
					}
					setState(606);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(609);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpoevaltContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerpoevaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpoevalt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpoevalt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoevaltContext cuerpoevalt() throws RecognitionException {
		CuerpoevaltContext _localctx = new CuerpoevaltContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_cuerpoevalt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(LLA_A);
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(612);
				match(IGNOR);
				setState(613);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(614);
					lincod();
					}
					}
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(622);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerpoaltContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerpoaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerpoalt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerpoalt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerpoaltContext cuerpoalt() throws RecognitionException {
		CuerpoaltContext _localctx = new CuerpoaltContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_cuerpoalt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(LLA_A);
			setState(633);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(625);
				match(IGNOR);
				setState(626);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(627);
					lincod();
					}
					}
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(635);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerporepContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerporepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerporep; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerporep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerporepContext cuerporep() throws RecognitionException {
		CuerporepContext _localctx = new CuerporepContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_cuerporep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(LLA_A);
			setState(646);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(638);
				match(IGNOR);
				setState(639);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(640);
					lincod();
					}
					}
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(648);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerposucesoContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerposucesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerposuceso; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerposuceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerposucesoContext cuerposuceso() throws RecognitionException {
		CuerposucesoContext _localctx = new CuerposucesoContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_cuerposuceso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(LLA_A);
			setState(659);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(651);
				match(IGNOR);
				setState(652);
				match(CIER);
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(653);
					lincod();
					}
					}
					setState(658);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(661);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscondContext extends ParserRuleContext {
		public TerminalNode EVALUAR() { return getToken(denviParser.EVALUAR, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ContevContext contev() {
			return getRuleContext(ContevContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public List<TerminalNode> CONEG() { return getTokens(denviParser.CONEG); }
		public TerminalNode CONEG(int i) {
			return getToken(denviParser.CONEG, i);
		}
		public List<TerminalNode> ALTERNO() { return getTokens(denviParser.ALTERNO); }
		public TerminalNode ALTERNO(int i) {
			return getToken(denviParser.ALTERNO, i);
		}
		public List<ContevaltContext> contevalt() {
			return getRuleContexts(ContevaltContext.class);
		}
		public ContevaltContext contevalt(int i) {
			return getRuleContext(ContevaltContext.class,i);
		}
		public TerminalNode ALTERNATIVA() { return getToken(denviParser.ALTERNATIVA, 0); }
		public CuerpoaltContext cuerpoalt() {
			return getRuleContext(CuerpoaltContext.class,0);
		}
		public EscondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscondContext escond() throws RecognitionException {
		EscondContext _localctx = new EscondContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_escond);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(EVALUAR);
			setState(664);
			match(PAR_A);
			setState(665);
			contev();
			setState(671);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(666);
					match(CONEG);
					setState(667);
					match(ALTERNO);
					setState(668);
					contevalt();
					}
					} 
				}
				setState(673);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONEG) {
				{
				setState(674);
				match(CONEG);
				setState(675);
				match(ALTERNATIVA);
				setState(676);
				cuerpoalt();
				}
			}

			setState(679);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EsrepContext extends ParserRuleContext {
		public EsrepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_esrep; }
	 
		public EsrepContext() { }
		public void copyFrom(EsrepContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepAsignacionContext extends EsrepContext {
		public TerminalNode REPETICION() { return getToken(denviParser.REPETICION, 0); }
		public List<TerminalNode> PAR_A() { return getTokens(denviParser.PAR_A); }
		public TerminalNode PAR_A(int i) {
			return getToken(denviParser.PAR_A, i);
		}
		public List<TerminalNode> PAR_C() { return getTokens(denviParser.PAR_C); }
		public TerminalNode PAR_C(int i) {
			return getToken(denviParser.PAR_C, i);
		}
		public TerminalNode CONEG() { return getToken(denviParser.CONEG, 0); }
		public ContrepContext contrep() {
			return getRuleContext(ContrepContext.class,0);
		}
		public TerminalNode DOB_P() { return getToken(denviParser.DOB_P, 0); }
		public IncreespContext increesp() {
			return getRuleContext(IncreespContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public RepAsignacionContext(EsrepContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitRepAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepDeclaracionContext extends EsrepContext {
		public TerminalNode REPETICION() { return getToken(denviParser.REPETICION, 0); }
		public List<TerminalNode> PAR_A() { return getTokens(denviParser.PAR_A); }
		public TerminalNode PAR_A(int i) {
			return getToken(denviParser.PAR_A, i);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<TerminalNode> PAR_C() { return getTokens(denviParser.PAR_C); }
		public TerminalNode PAR_C(int i) {
			return getToken(denviParser.PAR_C, i);
		}
		public TerminalNode CONEG() { return getToken(denviParser.CONEG, 0); }
		public ContrepContext contrep() {
			return getRuleContext(ContrepContext.class,0);
		}
		public TerminalNode DOB_P() { return getToken(denviParser.DOB_P, 0); }
		public IncreContext incre() {
			return getRuleContext(IncreContext.class,0);
		}
		public RepDeclaracionContext(EsrepContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitRepDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EsrepContext esrep() throws RecognitionException {
		EsrepContext _localctx = new EsrepContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_esrep);
		try {
			setState(706);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				_localctx = new RepDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				match(REPETICION);
				setState(682);
				match(PAR_A);
				setState(683);
				match(PAR_A);
				setState(684);
				declaracion();
				setState(685);
				match(PAR_C);
				setState(686);
				match(CONEG);
				setState(687);
				contrep();
				setState(688);
				match(DOB_P);
				setState(689);
				incre();
				setState(690);
				match(PAR_C);
				}
				break;
			case 2:
				_localctx = new RepAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(692);
				match(REPETICION);
				setState(693);
				match(PAR_A);
				setState(694);
				match(PAR_A);
				setState(697);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(695);
					asignacion();
					}
					break;
				case 2:
					{
					setState(696);
					match(IDE);
					}
					break;
				}
				setState(699);
				match(PAR_C);
				setState(700);
				match(CONEG);
				setState(701);
				contrep();
				setState(702);
				match(DOB_P);
				setState(703);
				increesp();
				setState(704);
				match(PAR_C);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AutoincContext extends ParserRuleContext {
		public AutoincContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoinc; }
	 
		public AutoincContext() { }
		public void copyFrom(AutoincContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AutoIncPasoContext extends AutoincContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public PasoContext paso() {
			return getRuleContext(PasoContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode INCV() { return getToken(denviParser.INCV, 0); }
		public TerminalNode DECV() { return getToken(denviParser.DECV, 0); }
		public AutoIncPasoContext(AutoincContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAutoIncPaso(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AutoIncSimpleContext extends AutoincContext {
		public TerminalNode INCS() { return getToken(denviParser.INCS, 0); }
		public TerminalNode DECS() { return getToken(denviParser.DECS, 0); }
		public AutoIncSimpleContext(AutoincContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitAutoIncSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutoincContext autoinc() throws RecognitionException {
		AutoincContext _localctx = new AutoincContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_autoinc);
		int _la;
		try {
			setState(714);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCS:
			case DECS:
				_localctx = new AutoIncSimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(708);
				_la = _input.LA(1);
				if ( !(_la==INCS || _la==DECS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case INCV:
			case DECV:
				_localctx = new AutoIncPasoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(709);
				_la = _input.LA(1);
				if ( !(_la==INCV || _la==DECV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(710);
				match(PAR_A);
				setState(711);
				paso();
				setState(712);
				match(PAR_C);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncreContext extends ParserRuleContext {
		public AutoincContext autoinc() {
			return getRuleContext(AutoincContext.class,0);
		}
		public IncreespContext increesp() {
			return getRuleContext(IncreespContext.class,0);
		}
		public IncreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incre; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitIncre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncreContext incre() throws RecognitionException {
		IncreContext _localctx = new IncreContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_incre);
		try {
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(716);
				autoinc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(717);
				increesp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncreespContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public TerminalNode INCS() { return getToken(denviParser.INCS, 0); }
		public TerminalNode DECS() { return getToken(denviParser.DECS, 0); }
		public PasoContext paso() {
			return getRuleContext(PasoContext.class,0);
		}
		public TerminalNode COMA() { return getToken(denviParser.COMA, 0); }
		public TerminalNode INCV() { return getToken(denviParser.INCV, 0); }
		public TerminalNode DECV() { return getToken(denviParser.DECV, 0); }
		public IncreespContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increesp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitIncreesp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncreespContext increesp() throws RecognitionException {
		IncreespContext _localctx = new IncreespContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_increesp);
		int _la;
		try {
			setState(731);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCS:
			case DECS:
				enterOuterAlt(_localctx, 1);
				{
				setState(720);
				_la = _input.LA(1);
				if ( !(_la==INCS || _la==DECS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(721);
				match(PAR_A);
				setState(722);
				match(IDE);
				setState(723);
				match(PAR_C);
				}
				break;
			case INCV:
			case DECV:
				enterOuterAlt(_localctx, 2);
				{
				setState(724);
				_la = _input.LA(1);
				if ( !(_la==INCV || _la==DECV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(725);
				match(PAR_A);
				setState(726);
				paso();
				setState(727);
				match(COMA);
				setState(728);
				match(IDE);
				setState(729);
				match(PAR_C);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PasoContext extends ParserRuleContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public PasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paso; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitPaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PasoContext paso() throws RecognitionException {
		PasoContext _localctx = new PasoContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_paso);
		try {
			setState(736);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				valor();
				}
				break;
			case IDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				match(IDE);
				}
				break;
			case IDECON:
				enterOuterAlt(_localctx, 3);
				{
				setState(735);
				match(IDECON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImpconsContext extends ParserRuleContext {
		public TerminalNode IMPCONS() { return getToken(denviParser.IMPCONS, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public List<ImprimibleContext> imprimible() {
			return getRuleContexts(ImprimibleContext.class);
		}
		public ImprimibleContext imprimible(int i) {
			return getRuleContext(ImprimibleContext.class,i);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public List<TerminalNode> CONEG() { return getTokens(denviParser.CONEG); }
		public TerminalNode CONEG(int i) {
			return getToken(denviParser.CONEG, i);
		}
		public ImpconsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impcons; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImpcons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpconsContext impcons() throws RecognitionException {
		ImpconsContext _localctx = new ImpconsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_impcons);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			match(IMPCONS);
			setState(739);
			match(PAR_A);
			setState(740);
			imprimible();
			setState(745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONEG) {
				{
				{
				setState(741);
				match(CONEG);
				setState(742);
				imprimible();
				}
				}
				setState(747);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(748);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImpconsslContext extends ParserRuleContext {
		public TerminalNode IMPCONSSL() { return getToken(denviParser.IMPCONSSL, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public List<ImprimibleContext> imprimible() {
			return getRuleContexts(ImprimibleContext.class);
		}
		public ImprimibleContext imprimible(int i) {
			return getRuleContext(ImprimibleContext.class,i);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public List<TerminalNode> CONEG() { return getTokens(denviParser.CONEG); }
		public TerminalNode CONEG(int i) {
			return getToken(denviParser.CONEG, i);
		}
		public ImpconsslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impconssl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImpconssl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpconsslContext impconssl() throws RecognitionException {
		ImpconsslContext _localctx = new ImpconsslContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_impconssl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			match(IMPCONSSL);
			setState(751);
			match(PAR_A);
			setState(752);
			imprimible();
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONEG) {
				{
				{
				setState(753);
				match(CONEG);
				setState(754);
				imprimible();
				}
				}
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(760);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImprimibleContext extends ParserRuleContext {
		public DatoContext dato() {
			return getRuleContext(DatoContext.class,0);
		}
		public ImprimibleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imprimible; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitImprimible(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImprimibleContext imprimible() throws RecognitionException {
		ImprimibleContext _localctx = new ImprimibleContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_imprimible);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			dato();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObtdatosContext extends ParserRuleContext {
		public TerminalNode OBTDATOS() { return getToken(denviParser.OBTDATOS, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode DOB_P() { return getToken(denviParser.DOB_P, 0); }
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public ObtdatosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obtdatos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitObtdatos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObtdatosContext obtdatos() throws RecognitionException {
		ObtdatosContext _localctx = new ObtdatosContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_obtdatos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			match(OBTDATOS);
			setState(765);
			match(PAR_A);
			setState(766);
			tipo();
			setState(767);
			match(DOB_P);
			setState(768);
			match(IDE);
			setState(769);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscsucesoContext extends ParserRuleContext {
		public TerminalNode SUCESO() { return getToken(denviParser.SUCESO, 0); }
		public List<TerminalNode> PAR_A() { return getTokens(denviParser.PAR_A); }
		public TerminalNode PAR_A(int i) {
			return getToken(denviParser.PAR_A, i);
		}
		public List<TerminalNode> PAR_C() { return getTokens(denviParser.PAR_C); }
		public TerminalNode PAR_C(int i) {
			return getToken(denviParser.PAR_C, i);
		}
		public TerminalNode CONEG() { return getToken(denviParser.CONEG, 0); }
		public CuerposucesoContext cuerposuceso() {
			return getRuleContext(CuerposucesoContext.class,0);
		}
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode COMA() { return getToken(denviParser.COMA, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public EscsucesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escsuceso; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscsuceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscsucesoContext escsuceso() throws RecognitionException {
		EscsucesoContext _localctx = new EscsucesoContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_escsuceso);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
			match(SUCESO);
			setState(772);
			match(PAR_A);
			setState(773);
			match(PAR_A);
			setState(778);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(774);
				match(IDEOBJ);
				setState(775);
				match(COMA);
				setState(776);
				match(IDEEST);
				}
				break;
			case 2:
				{
				setState(777);
				expresion();
				}
				break;
			}
			setState(780);
			match(PAR_C);
			setState(781);
			match(CONEG);
			setState(782);
			cuerposuceso();
			setState(783);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscnivelContext extends ParserRuleContext {
		public TerminalNode NIVEL() { return getToken(denviParser.NIVEL, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode CONEG() { return getToken(denviParser.CONEG, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public PropiedadesContext propiedades() {
			return getRuleContext(PropiedadesContext.class,0);
		}
		public CuerponivelContext cuerponivel() {
			return getRuleContext(CuerponivelContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public EnlaceContext enlace() {
			return getRuleContext(EnlaceContext.class,0);
		}
		public EscnivelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escnivel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEscnivel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscnivelContext escnivel() throws RecognitionException {
		EscnivelContext _localctx = new EscnivelContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_escnivel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			match(NIVEL);
			setState(786);
			match(IDEEST);
			setState(787);
			match(CONEG);
			setState(788);
			match(PAR_A);
			setState(789);
			propiedades();
			setState(790);
			cuerponivel();
			setState(791);
			match(PAR_C);
			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO) {
				{
				setState(792);
				enlace();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropiedadesContext extends ParserRuleContext {
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public List<PropiedadContext> propiedad() {
			return getRuleContexts(PropiedadContext.class);
		}
		public PropiedadContext propiedad(int i) {
			return getRuleContext(PropiedadContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public PropiedadesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propiedades; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitPropiedades(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropiedadesContext propiedades() throws RecognitionException {
		PropiedadesContext _localctx = new PropiedadesContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_propiedades);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			match(PAR_A);
			setState(804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDE || _la==IDECON) {
				{
				setState(796);
				propiedad();
				setState(801);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(797);
					match(COMA);
					setState(798);
					propiedad();
					}
					}
					setState(803);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(806);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropiedadContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public ConstanteContext constante() {
			return getRuleContext(ConstanteContext.class,0);
		}
		public PropiedadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propiedad; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitPropiedad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropiedadContext propiedad() throws RecognitionException {
		PropiedadContext _localctx = new PropiedadContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_propiedad);
		try {
			setState(810);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDE:
				enterOuterAlt(_localctx, 1);
				{
				setState(808);
				declaracion();
				}
				break;
			case IDECON:
				enterOuterAlt(_localctx, 2);
				{
				setState(809);
				constante();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CuerponivelContext extends ParserRuleContext {
		public TerminalNode LLA_A() { return getToken(denviParser.LLA_A, 0); }
		public TerminalNode LLA_C() { return getToken(denviParser.LLA_C, 0); }
		public TerminalNode IGNOR() { return getToken(denviParser.IGNOR, 0); }
		public TerminalNode CIER() { return getToken(denviParser.CIER, 0); }
		public List<SubzonaContext> subzona() {
			return getRuleContexts(SubzonaContext.class);
		}
		public SubzonaContext subzona(int i) {
			return getRuleContext(SubzonaContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public List<LincodContext> lincod() {
			return getRuleContexts(LincodContext.class);
		}
		public LincodContext lincod(int i) {
			return getRuleContext(LincodContext.class,i);
		}
		public CuerponivelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuerponivel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitCuerponivel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuerponivelContext cuerponivel() throws RecognitionException {
		CuerponivelContext _localctx = new CuerponivelContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_cuerponivel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
			match(LLA_A);
			setState(829);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IGNOR:
				{
				setState(813);
				match(IGNOR);
				setState(814);
				match(CIER);
				}
				break;
			case ZONA:
				{
				setState(815);
				subzona();
				setState(820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(816);
					match(COMA);
					setState(817);
					subzona();
					}
					}
					setState(822);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case MUNDO:
			case ESTO:
			case SUCESO:
			case NIVEL:
			case SITUAR:
			case RETIRAR:
			case VIAJAR:
			case IMPCONS:
			case IMPCONSSL:
			case OBTDATOS:
			case LT:
			case AR:
			case EVALUAR:
			case REPETICION:
			case PAR_A:
			case LLA_C:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				{
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20941872130L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 15361L) != 0)) {
					{
					{
					setState(823);
					lincod();
					}
					}
					setState(828);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(831);
			match(LLA_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubzonaContext extends ParserRuleContext {
		public TerminalNode ZONA() { return getToken(denviParser.ZONA, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode CONEG() { return getToken(denviParser.CONEG, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public PropiedadesContext propiedades() {
			return getRuleContext(PropiedadesContext.class,0);
		}
		public CuerponivelContext cuerponivel() {
			return getRuleContext(CuerponivelContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public SubzonaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subzona; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitSubzona(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubzonaContext subzona() throws RecognitionException {
		SubzonaContext _localctx = new SubzonaContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_subzona);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			match(ZONA);
			setState(834);
			match(IDEEST);
			setState(835);
			match(CONEG);
			setState(836);
			match(PAR_A);
			setState(837);
			propiedades();
			setState(838);
			cuerponivel();
			setState(839);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnlaceContext extends ParserRuleContext {
		public TerminalNode PUNTO() { return getToken(denviParser.PUNTO, 0); }
		public TerminalNode PORTAL() { return getToken(denviParser.PORTAL, 0); }
		public TerminalNode CONEE() { return getToken(denviParser.CONEE, 0); }
		public DestinoContext destino() {
			return getRuleContext(DestinoContext.class,0);
		}
		public EnlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enlace; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitEnlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnlaceContext enlace() throws RecognitionException {
		EnlaceContext _localctx = new EnlaceContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_enlace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(PUNTO);
			setState(842);
			match(PORTAL);
			setState(843);
			match(CONEE);
			setState(844);
			destino();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConexionContext extends ParserRuleContext {
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public EnlaceContext enlace() {
			return getRuleContext(EnlaceContext.class,0);
		}
		public ConexionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conexion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitConexion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConexionContext conexion() throws RecognitionException {
		ConexionContext _localctx = new ConexionContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_conexion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			match(IDEEST);
			setState(847);
			enlace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestinoContext extends ParserRuleContext {
		public List<TerminalNode> IDEEST() { return getTokens(denviParser.IDEEST); }
		public TerminalNode IDEEST(int i) {
			return getToken(denviParser.IDEEST, i);
		}
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public List<TerminalNode> COMA() { return getTokens(denviParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(denviParser.COMA, i);
		}
		public DestinoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destino; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitDestino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestinoContext destino() throws RecognitionException {
		DestinoContext _localctx = new DestinoContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_destino);
		int _la;
		try {
			setState(860);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDEEST:
				enterOuterAlt(_localctx, 1);
				{
				setState(849);
				match(IDEEST);
				}
				break;
			case PAR_A:
				enterOuterAlt(_localctx, 2);
				{
				setState(850);
				match(PAR_A);
				setState(851);
				match(IDEEST);
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(852);
					match(COMA);
					setState(853);
					match(IDEEST);
					}
					}
					setState(858);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(859);
				match(PAR_C);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SituarContext extends ParserRuleContext {
		public TerminalNode SITUAR() { return getToken(denviParser.SITUAR, 0); }
		public List<TerminalNode> PAR_A() { return getTokens(denviParser.PAR_A); }
		public TerminalNode PAR_A(int i) {
			return getToken(denviParser.PAR_A, i);
		}
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public List<TerminalNode> CONEG() { return getTokens(denviParser.CONEG); }
		public TerminalNode CONEG(int i) {
			return getToken(denviParser.CONEG, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode COMA() { return getToken(denviParser.COMA, 0); }
		public List<TerminalNode> PAR_C() { return getTokens(denviParser.PAR_C); }
		public TerminalNode PAR_C(int i) {
			return getToken(denviParser.PAR_C, i);
		}
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public SituarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_situar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitSituar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SituarContext situar() throws RecognitionException {
		SituarContext _localctx = new SituarContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_situar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
			match(SITUAR);
			setState(863);
			match(PAR_A);
			setState(864);
			match(IDEOBJ);
			setState(865);
			match(CONEG);
			setState(866);
			match(PAR_A);
			setState(867);
			expresion();
			setState(868);
			match(COMA);
			setState(869);
			expresion();
			setState(870);
			match(PAR_C);
			setState(873);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONEG) {
				{
				setState(871);
				match(CONEG);
				setState(872);
				match(IDEEST);
				}
			}

			setState(875);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RetirarContext extends ParserRuleContext {
		public TerminalNode RETIRAR() { return getToken(denviParser.RETIRAR, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public RetirarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retirar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitRetirar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetirarContext retirar() throws RecognitionException {
		RetirarContext _localctx = new RetirarContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_retirar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			match(RETIRAR);
			setState(878);
			match(PAR_A);
			setState(879);
			match(IDEOBJ);
			setState(880);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ViajarContext extends ParserRuleContext {
		public TerminalNode VIAJAR() { return getToken(denviParser.VIAJAR, 0); }
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public TerminalNode IDEEST() { return getToken(denviParser.IDEEST, 0); }
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public ViajarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viajar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitViajar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViajarContext viajar() throws RecognitionException {
		ViajarContext _localctx = new ViajarContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_viajar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
			match(VIAJAR);
			setState(883);
			match(PAR_A);
			setState(884);
			match(IDEEST);
			setState(885);
			match(PAR_C);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public LogorContext logor() {
			return getRuleContext(LogorContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			logor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogorContext extends ParserRuleContext {
		public List<LogandContext> logand() {
			return getRuleContexts(LogandContext.class);
		}
		public LogandContext logand(int i) {
			return getRuleContext(LogandContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(denviParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(denviParser.OR, i);
		}
		public LogorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLogor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogorContext logor() throws RecognitionException {
		LogorContext _localctx = new LogorContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_logor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889);
			logand();
			setState(894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(890);
				match(OR);
				setState(891);
				logand();
				}
				}
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogandContext extends ParserRuleContext {
		public List<LogigContext> logig() {
			return getRuleContexts(LogigContext.class);
		}
		public LogigContext logig(int i) {
			return getRuleContext(LogigContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(denviParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(denviParser.AND, i);
		}
		public LogandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLogand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogandContext logand() throws RecognitionException {
		LogandContext _localctx = new LogandContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_logand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(897);
			logig();
			setState(902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(898);
				match(AND);
				setState(899);
				logig();
				}
				}
				setState(904);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogigContext extends ParserRuleContext {
		public List<LogrelContext> logrel() {
			return getRuleContexts(LogrelContext.class);
		}
		public LogrelContext logrel(int i) {
			return getRuleContext(LogrelContext.class,i);
		}
		public List<TerminalNode> COMP() { return getTokens(denviParser.COMP); }
		public TerminalNode COMP(int i) {
			return getToken(denviParser.COMP, i);
		}
		public List<TerminalNode> DIF() { return getTokens(denviParser.DIF); }
		public TerminalNode DIF(int i) {
			return getToken(denviParser.DIF, i);
		}
		public LogigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logig; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLogig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogigContext logig() throws RecognitionException {
		LogigContext _localctx = new LogigContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_logig);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			logrel();
			setState(910);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMP || _la==DIF) {
				{
				{
				setState(906);
				_la = _input.LA(1);
				if ( !(_la==COMP || _la==DIF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(907);
				logrel();
				}
				}
				setState(912);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogrelContext extends ParserRuleContext {
		public List<LogarContext> logar() {
			return getRuleContexts(LogarContext.class);
		}
		public LogarContext logar(int i) {
			return getRuleContext(LogarContext.class,i);
		}
		public List<TerminalNode> MEN_Q() { return getTokens(denviParser.MEN_Q); }
		public TerminalNode MEN_Q(int i) {
			return getToken(denviParser.MEN_Q, i);
		}
		public List<TerminalNode> MA_Q() { return getTokens(denviParser.MA_Q); }
		public TerminalNode MA_Q(int i) {
			return getToken(denviParser.MA_Q, i);
		}
		public List<TerminalNode> MEN_IG() { return getTokens(denviParser.MEN_IG); }
		public TerminalNode MEN_IG(int i) {
			return getToken(denviParser.MEN_IG, i);
		}
		public List<TerminalNode> MA_IG() { return getTokens(denviParser.MA_IG); }
		public TerminalNode MA_IG(int i) {
			return getToken(denviParser.MA_IG, i);
		}
		public LogrelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logrel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLogrel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogrelContext logrel() throws RecognitionException {
		LogrelContext _localctx = new LogrelContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_logrel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			logar();
			setState(918);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 435723263948095488L) != 0)) {
				{
				{
				setState(914);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 435723263948095488L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(915);
				logar();
				}
				}
				setState(920);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogarContext extends ParserRuleContext {
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> OP_SUM() { return getTokens(denviParser.OP_SUM); }
		public TerminalNode OP_SUM(int i) {
			return getToken(denviParser.OP_SUM, i);
		}
		public List<TerminalNode> OP_REST() { return getTokens(denviParser.OP_REST); }
		public TerminalNode OP_REST(int i) {
			return getToken(denviParser.OP_REST, i);
		}
		public LogarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitLogar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogarContext logar() throws RecognitionException {
		LogarContext _localctx = new LogarContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_logar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			termino();
			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUM || _la==OP_REST) {
				{
				{
				setState(922);
				_la = _input.LA(1);
				if ( !(_la==OP_SUM || _la==OP_REST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(923);
				termino();
				}
				}
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TerminoContext extends ParserRuleContext {
		public List<SimbunContext> simbun() {
			return getRuleContexts(SimbunContext.class);
		}
		public SimbunContext simbun(int i) {
			return getRuleContext(SimbunContext.class,i);
		}
		public List<TerminalNode> OP_MULT() { return getTokens(denviParser.OP_MULT); }
		public TerminalNode OP_MULT(int i) {
			return getToken(denviParser.OP_MULT, i);
		}
		public List<TerminalNode> OP_DIV() { return getTokens(denviParser.OP_DIV); }
		public TerminalNode OP_DIV(int i) {
			return getToken(denviParser.OP_DIV, i);
		}
		public List<TerminalNode> OP_MOD() { return getTokens(denviParser.OP_MOD); }
		public TerminalNode OP_MOD(int i) {
			return getToken(denviParser.OP_MOD, i);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitTermino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			simbun();
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305843009213693952L) != 0)) {
				{
				{
				setState(930);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305843009213693952L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(931);
				simbun();
				}
				}
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimbunContext extends ParserRuleContext {
		public SimbunContext simbun() {
			return getRuleContext(SimbunContext.class,0);
		}
		public TerminalNode NOT() { return getToken(denviParser.NOT, 0); }
		public TerminalNode OP_REST() { return getToken(denviParser.OP_REST, 0); }
		public TerminalNode OP_SUM() { return getToken(denviParser.OP_SUM, 0); }
		public ValpContext valp() {
			return getRuleContext(ValpContext.class,0);
		}
		public SimbunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simbun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitSimbun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimbunContext simbun() throws RecognitionException {
		SimbunContext _localctx = new SimbunContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_simbun);
		int _la;
		try {
			setState(940);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case OP_SUM:
			case OP_REST:
				enterOuterAlt(_localctx, 1);
				{
				setState(937);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1801439850948198400L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(938);
				simbun();
				}
				break;
			case ESTO:
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
			case PAR_A:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				enterOuterAlt(_localctx, 2);
				{
				setState(939);
				valp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValpContext extends ParserRuleContext {
		public BaseContext base() {
			return getRuleContext(BaseContext.class,0);
		}
		public List<TerminalNode> PUNTO() { return getTokens(denviParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(denviParser.PUNTO, i);
		}
		public List<MiembroContext> miembro() {
			return getRuleContexts(MiembroContext.class);
		}
		public MiembroContext miembro(int i) {
			return getRuleContext(MiembroContext.class,i);
		}
		public ValpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitValp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValpContext valp() throws RecognitionException {
		ValpContext _localctx = new ValpContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_valp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			base();
			setState(947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO) {
				{
				{
				setState(943);
				match(PUNTO);
				setState(944);
				miembro();
				}
				}
				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BaseContext extends ParserRuleContext {
		public ValsimpleContext valsimple() {
			return getRuleContext(ValsimpleContext.class,0);
		}
		public TerminalNode PAR_A() { return getToken(denviParser.PAR_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAR_C() { return getToken(denviParser.PAR_C, 0); }
		public BaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseContext base() throws RecognitionException {
		BaseContext _localctx = new BaseContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_base);
		try {
			setState(955);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
			case IDE:
			case IDECON:
			case IDEEST:
			case IDEOBJ:
				enterOuterAlt(_localctx, 1);
				{
				setState(950);
				valsimple();
				}
				break;
			case PAR_A:
				enterOuterAlt(_localctx, 2);
				{
				setState(951);
				match(PAR_A);
				setState(952);
				expresion();
				setState(953);
				match(PAR_C);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValsimpleContext extends ParserRuleContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalNode IDE() { return getToken(denviParser.IDE, 0); }
		public TerminalNode IDECON() { return getToken(denviParser.IDECON, 0); }
		public TerminalNode IDEOBJ() { return getToken(denviParser.IDEOBJ, 0); }
		public TerminalNode ESTO() { return getToken(denviParser.ESTO, 0); }
		public LlamfunContext llamfun() {
			return getRuleContext(LlamfunContext.class,0);
		}
		public ValsimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valsimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof denviVisitor ) return ((denviVisitor<? extends T>)visitor).visitValsimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValsimpleContext valsimple() throws RecognitionException {
		ValsimpleContext _localctx = new ValsimpleContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_valsimple);
		try {
			setState(963);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_BOO:
			case VAL_NL:
			case VAL_DEC:
			case VAL_ENT:
			case VAL_CAD:
			case VAL_CAR:
			case VAL_TM:
				enterOuterAlt(_localctx, 1);
				{
				setState(957);
				valor();
				}
				break;
			case IDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(958);
				match(IDE);
				}
				break;
			case IDECON:
				enterOuterAlt(_localctx, 3);
				{
				setState(959);
				match(IDECON);
				}
				break;
			case IDEOBJ:
				enterOuterAlt(_localctx, 4);
				{
				setState(960);
				match(IDEOBJ);
				}
				break;
			case ESTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(961);
				match(ESTO);
				}
				break;
			case IDEEST:
				enterOuterAlt(_localctx, 6);
				{
				setState(962);
				llamfun();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001Q\u03c6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0001\u0000\u0001\u0000\u0003\u0000\u00a7\b\u0000"+
		"\u0001\u0001\u0005\u0001\u00aa\b\u0001\n\u0001\f\u0001\u00ad\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002\u00b3\b\u0002\n"+
		"\u0002\f\u0002\u00b6\t\u0002\u0001\u0002\u0004\u0002\u00b9\b\u0002\u000b"+
		"\u0002\f\u0002\u00ba\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u00c1\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00d0\b\u0006\n\u0006\f\u0006"+
		"\u00d3\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u00dd\b\u0007\u000b\u0007"+
		"\f\u0007\u00de\u0003\u0007\u00e1\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00e8\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ed\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004"+
		"\t\u00f7\b\t\u000b\t\f\t\u00f8\u0003\t\u00fb\b\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0104\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0004\u000b\u010f\b\u000b\u000b\u000b\f\u000b\u0110\u0003\u000b\u0113"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u011c\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0004\r\u0126\b\r\u000b\r\f\r\u0127\u0003\r\u012a\b\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u0130\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0149\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u014e\b\u0010\n\u0010"+
		"\f\u0010\u0151\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u0156\b\u0011\n\u0011\f\u0011\u0159\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0161\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0168"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0004"+
		"\u0014\u016f\b\u0014\u000b\u0014\f\u0014\u0170\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0176\b\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u017a\b\u0015\n\u0015\f\u0015\u017d\t\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0183\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u018c"+
		"\b\u0016\u0001\u0016\u0003\u0016\u018f\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0193\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u01aa\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u01bb\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01c1\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01c7\b\u001b"+
		"\u0003\u001b\u01c9\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u01d1\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!"+
		"\u0001!\u0001!\u0003!\u01e4\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0003\"\u01ed\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u01f6\b\"\u0001#\u0001#\u0001#\u0001#\u0005"+
		"#\u01fc\b#\n#\f#\u01ff\t#\u0003#\u0201\b#\u0001#\u0001#\u0001$\u0001$"+
		"\u0001$\u0001$\u0003$\u0209\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u0212\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u021b\b%\u0001&\u0001&\u0001&\u0001&\u0003&\u0221\b&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u0227\b&\u0005&\u0229\b&\n&\f&\u022c\t&\u0003&"+
		"\u022e\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0005*\u0248\b*\n*\f*\u024b"+
		"\t*\u0003*\u024d\b*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001,\u0001,\u0001,\u0001,\u0005,\u025b\b,\n,\f,\u025e\t,\u0003,\u0260"+
		"\b,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0005-\u0268\b-\n-\f-\u026b"+
		"\t-\u0003-\u026d\b-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0005.\u0275"+
		"\b.\n.\f.\u0278\t.\u0003.\u027a\b.\u0001.\u0001.\u0001/\u0001/\u0001/"+
		"\u0001/\u0005/\u0282\b/\n/\f/\u0285\t/\u0003/\u0287\b/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u00010\u00050\u028f\b0\n0\f0\u0292\t0\u00030\u0294\b0"+
		"\u00010\u00010\u00011\u00011\u00011\u00011\u00011\u00011\u00051\u029e"+
		"\b1\n1\f1\u02a1\t1\u00011\u00011\u00011\u00031\u02a6\b1\u00011\u00011"+
		"\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u02ba\b2\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00032\u02c3\b2\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00033\u02cb\b3\u00014\u00014\u00034\u02cf\b4\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00035\u02dc\b5\u00016\u00016\u00016\u00036\u02e1\b6\u00017\u00017\u0001"+
		"7\u00017\u00017\u00057\u02e8\b7\n7\f7\u02eb\t7\u00017\u00017\u00018\u0001"+
		"8\u00018\u00018\u00018\u00058\u02f4\b8\n8\f8\u02f7\t8\u00018\u00018\u0001"+
		"9\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u030b\b;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0003<\u031a\b<\u0001=\u0001=\u0001=\u0001=\u0005=\u0320\b=\n=\f=\u0323"+
		"\t=\u0003=\u0325\b=\u0001=\u0001=\u0001>\u0001>\u0003>\u032b\b>\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0005?\u0333\b?\n?\f?\u0336\t?\u0001"+
		"?\u0005?\u0339\b?\n?\f?\u033c\t?\u0003?\u033e\b?\u0001?\u0001?\u0001@"+
		"\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001"+
		"C\u0005C\u0357\bC\nC\fC\u035a\tC\u0001C\u0003C\u035d\bC\u0001D\u0001D"+
		"\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0003"+
		"D\u036a\bD\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001H\u0005H\u037d"+
		"\bH\nH\fH\u0380\tH\u0001I\u0001I\u0001I\u0005I\u0385\bI\nI\fI\u0388\t"+
		"I\u0001J\u0001J\u0001J\u0005J\u038d\bJ\nJ\fJ\u0390\tJ\u0001K\u0001K\u0001"+
		"K\u0005K\u0395\bK\nK\fK\u0398\tK\u0001L\u0001L\u0001L\u0005L\u039d\bL"+
		"\nL\fL\u03a0\tL\u0001M\u0001M\u0001M\u0005M\u03a5\bM\nM\fM\u03a8\tM\u0001"+
		"N\u0001N\u0001N\u0003N\u03ad\bN\u0001O\u0001O\u0001O\u0005O\u03b2\bO\n"+
		"O\fO\u03b5\tO\u0001P\u0001P\u0001P\u0001P\u0001P\u0003P\u03bc\bP\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u03c4\bQ\u0001Q\u0000\u0000"+
		"R\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u0000\n\u0002\u0000\n\nNN\u0001\u0000\u0016\u001c"+
		"\u0001\u0000#)\u0001\u0000-.\u0001\u0000/0\u0001\u000045\u0002\u00002"+
		"39:\u0001\u0000;<\u0001\u0000=?\u0002\u000088;<\u03f6\u0000\u00a6\u0001"+
		"\u0000\u0000\u0000\u0002\u00ab\u0001\u0000\u0000\u0000\u0004\u00b4\u0001"+
		"\u0000\u0000\u0000\u0006\u00c0\u0001\u0000\u0000\u0000\b\u00c4\u0001\u0000"+
		"\u0000\u0000\n\u00c7\u0001\u0000\u0000\u0000\f\u00ca\u0001\u0000\u0000"+
		"\u0000\u000e\u00e0\u0001\u0000\u0000\u0000\u0010\u00e2\u0001\u0000\u0000"+
		"\u0000\u0012\u00f2\u0001\u0000\u0000\u0000\u0014\u00fe\u0001\u0000\u0000"+
		"\u0000\u0016\u0109\u0001\u0000\u0000\u0000\u0018\u0116\u0001\u0000\u0000"+
		"\u0000\u001a\u0121\u0001\u0000\u0000\u0000\u001c\u012d\u0001\u0000\u0000"+
		"\u0000\u001e\u0148\u0001\u0000\u0000\u0000 \u014a\u0001\u0000\u0000\u0000"+
		"\"\u0152\u0001\u0000\u0000\u0000$\u015a\u0001\u0000\u0000\u0000&\u0164"+
		"\u0001\u0000\u0000\u0000(\u016b\u0001\u0000\u0000\u0000*\u0175\u0001\u0000"+
		"\u0000\u0000,\u018e\u0001\u0000\u0000\u0000.\u0192\u0001\u0000\u0000\u0000"+
		"0\u01a9\u0001\u0000\u0000\u00002\u01ab\u0001\u0000\u0000\u00004\u01ba"+
		"\u0001\u0000\u0000\u00006\u01c8\u0001\u0000\u0000\u00008\u01ca\u0001\u0000"+
		"\u0000\u0000:\u01d2\u0001\u0000\u0000\u0000<\u01d5\u0001\u0000\u0000\u0000"+
		">\u01dc\u0001\u0000\u0000\u0000@\u01de\u0001\u0000\u0000\u0000B\u01e3"+
		"\u0001\u0000\u0000\u0000D\u01e5\u0001\u0000\u0000\u0000F\u01f7\u0001\u0000"+
		"\u0000\u0000H\u0208\u0001\u0000\u0000\u0000J\u020a\u0001\u0000\u0000\u0000"+
		"L\u021c\u0001\u0000\u0000\u0000N\u0231\u0001\u0000\u0000\u0000P\u0237"+
		"\u0001\u0000\u0000\u0000R\u023d\u0001\u0000\u0000\u0000T\u0243\u0001\u0000"+
		"\u0000\u0000V\u0250\u0001\u0000\u0000\u0000X\u0256\u0001\u0000\u0000\u0000"+
		"Z\u0263\u0001\u0000\u0000\u0000\\\u0270\u0001\u0000\u0000\u0000^\u027d"+
		"\u0001\u0000\u0000\u0000`\u028a\u0001\u0000\u0000\u0000b\u0297\u0001\u0000"+
		"\u0000\u0000d\u02c2\u0001\u0000\u0000\u0000f\u02ca\u0001\u0000\u0000\u0000"+
		"h\u02ce\u0001\u0000\u0000\u0000j\u02db\u0001\u0000\u0000\u0000l\u02e0"+
		"\u0001\u0000\u0000\u0000n\u02e2\u0001\u0000\u0000\u0000p\u02ee\u0001\u0000"+
		"\u0000\u0000r\u02fa\u0001\u0000\u0000\u0000t\u02fc\u0001\u0000\u0000\u0000"+
		"v\u0303\u0001\u0000\u0000\u0000x\u0311\u0001\u0000\u0000\u0000z\u031b"+
		"\u0001\u0000\u0000\u0000|\u032a\u0001\u0000\u0000\u0000~\u032c\u0001\u0000"+
		"\u0000\u0000\u0080\u0341\u0001\u0000\u0000\u0000\u0082\u0349\u0001\u0000"+
		"\u0000\u0000\u0084\u034e\u0001\u0000\u0000\u0000\u0086\u035c\u0001\u0000"+
		"\u0000\u0000\u0088\u035e\u0001\u0000\u0000\u0000\u008a\u036d\u0001\u0000"+
		"\u0000\u0000\u008c\u0372\u0001\u0000\u0000\u0000\u008e\u0377\u0001\u0000"+
		"\u0000\u0000\u0090\u0379\u0001\u0000\u0000\u0000\u0092\u0381\u0001\u0000"+
		"\u0000\u0000\u0094\u0389\u0001\u0000\u0000\u0000\u0096\u0391\u0001\u0000"+
		"\u0000\u0000\u0098\u0399\u0001\u0000\u0000\u0000\u009a\u03a1\u0001\u0000"+
		"\u0000\u0000\u009c\u03ac\u0001\u0000\u0000\u0000\u009e\u03ae\u0001\u0000"+
		"\u0000\u0000\u00a0\u03bb\u0001\u0000\u0000\u0000\u00a2\u03c3\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0003\u0002\u0001\u0000\u00a5\u00a7\u0003\u0004"+
		"\u0002\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u0001\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u0006"+
		"\u0003\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0003\f\u0006\u0000\u00af\u00b0\u0005\u0000\u0000"+
		"\u0001\u00b0\u0003\u0001\u0000\u0000\u0000\u00b1\u00b3\u0003\u0006\u0003"+
		"\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b9\u0003\u0010\b\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0005\u0000\u0000\u0001\u00bd\u0005\u0001\u0000\u0000\u0000"+
		"\u00be\u00c1\u0003\b\u0004\u0000\u00bf\u00c1\u0003\n\u0005\u0000\u00c0"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005G\u0000\u0000\u00c3\u0007"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0012\u0000\u0000\u00c5\u00c6"+
		"\u0005\'\u0000\u0000\u00c6\t\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		"\u0012\u0000\u0000\u00c8\u00c9\u0005*\u0000\u0000\u00c9\u000b\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000\u00cb\u00cc\u0005\u0004"+
		"\u0000\u0000\u00cc\u00cd\u0005+\u0000\u0000\u00cd\u00d1\u0005E\u0000\u0000"+
		"\u00ce\u00d0\u0003\u0014\n\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003\u000e\u0007\u0000\u00d5"+
		"\u00d6\u0005F\u0000\u0000\u00d6\u00d7\u0005G\u0000\u0000\u00d7\r\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005\u0007\u0000\u0000\u00d9\u00e1\u0005"+
		"G\u0000\u0000\u00da\u00dd\u00032\u0019\u0000\u00db\u00dd\u0003\u0018\f"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e0\u00d8\u0001\u0000\u0000\u0000\u00e0\u00dc\u0001\u0000\u0000"+
		"\u0000\u00e1\u000f\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0005\u0000"+
		"\u0000\u00e3\u00e7\u0005M\u0000\u0000\u00e4\u00e5\u0005+\u0000\u0000\u00e5"+
		"\u00e6\u0005\b\u0000\u0000\u00e6\u00e8\u0005M\u0000\u0000\u00e7\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005+\u0000\u0000\u00ea\u00ec\u0005"+
		"A\u0000\u0000\u00eb\u00ed\u0003 \u0010\u0000\u00ec\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005B\u0000\u0000\u00ef\u00f0\u0003\u0012\t\u0000"+
		"\u00f0\u00f1\u0005G\u0000\u0000\u00f1\u0011\u0001\u0000\u0000\u0000\u00f2"+
		"\u00fa\u0005E\u0000\u0000\u00f3\u00f4\u0005\u0007\u0000\u0000\u00f4\u00fb"+
		"\u0005G\u0000\u0000\u00f5\u00f7\u0003\u0014\n\u0000\u00f6\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f3\u0001\u0000\u0000\u0000\u00fa\u00f6\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005"+
		"F\u0000\u0000\u00fd\u0013\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u0003"+
		"\u0000\u0000\u00ff\u0100\u0005M\u0000\u0000\u0100\u0101\u0005+\u0000\u0000"+
		"\u0101\u0103\u0005A\u0000\u0000\u0102\u0104\u0003 \u0010\u0000\u0103\u0102"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0005B\u0000\u0000\u0106\u0107\u0003"+
		"\u0016\u000b\u0000\u0107\u0108\u0005G\u0000\u0000\u0108\u0015\u0001\u0000"+
		"\u0000\u0000\u0109\u0112\u0005E\u0000\u0000\u010a\u010b\u0005\u0007\u0000"+
		"\u0000\u010b\u0113\u0005G\u0000\u0000\u010c\u010f\u00032\u0019\u0000\u010d"+
		"\u010f\u0003\u0018\f\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u010e"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113"+
		"\u0001\u0000\u0000\u0000\u0112\u010a\u0001\u0000\u0000\u0000\u0112\u010e"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005F\u0000\u0000\u0115\u0017\u0001\u0000\u0000\u0000\u0116\u0117\u0005"+
		"\u0002\u0000\u0000\u0117\u0118\u0005M\u0000\u0000\u0118\u0119\u0005+\u0000"+
		"\u0000\u0119\u011b\u0005A\u0000\u0000\u011a\u011c\u0003 \u0010\u0000\u011b"+
		"\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0005B\u0000\u0000\u011e\u011f"+
		"\u0003\u001a\r\u0000\u011f\u0120\u0005G\u0000\u0000\u0120\u0019\u0001"+
		"\u0000\u0000\u0000\u0121\u0129\u0005E\u0000\u0000\u0122\u0123\u0005\u0007"+
		"\u0000\u0000\u0123\u012a\u0005G\u0000\u0000\u0124\u0126\u00032\u0019\u0000"+
		"\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0122\u0001\u0000\u0000\u0000"+
		"\u0129\u0125\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0005F\u0000\u0000\u012c\u001b\u0001\u0000\u0000\u0000\u012d"+
		"\u012f\u0005A\u0000\u0000\u012e\u0130\u0003B!\u0000\u012f\u012e\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0001"+
		"\u0000\u0000\u0000\u0131\u0132\u0005B\u0000\u0000\u0132\u0133\u0005I\u0000"+
		"\u0000\u0133\u0134\u0005\u0006\u0000\u0000\u0134\u001d\u0001\u0000\u0000"+
		"\u0000\u0135\u0136\u0005K\u0000\u0000\u0136\u0137\u0005A\u0000\u0000\u0137"+
		"\u0138\u0003>\u001f\u0000\u0138\u0139\u0005B\u0000\u0000\u0139\u0149\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0005\u001e\u0000\u0000\u013b\u013c\u0005"+
		"K\u0000\u0000\u013c\u013d\u0005A\u0000\u0000\u013d\u013e\u0003>\u001f"+
		"\u0000\u013e\u013f\u0005B\u0000\u0000\u013f\u0149\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0005\u001d\u0000\u0000\u0141\u0142\u0005K\u0000\u0000\u0142"+
		"\u0143\u0005A\u0000\u0000\u0143\u0144\u0003>\u001f\u0000\u0144\u0145\u0005"+
		"B\u0000\u0000\u0145\u0149\u0001\u0000\u0000\u0000\u0146\u0147\u0005M\u0000"+
		"\u0000\u0147\u0149\u0005N\u0000\u0000\u0148\u0135\u0001\u0000\u0000\u0000"+
		"\u0148\u013a\u0001\u0000\u0000\u0000\u0148\u0140\u0001\u0000\u0000\u0000"+
		"\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u001f\u0001\u0000\u0000\u0000"+
		"\u014a\u014f\u0003\u001e\u000f\u0000\u014b\u014c\u0005H\u0000\u0000\u014c"+
		"\u014e\u0003\u001e\u000f\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014e"+
		"\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0001\u0000\u0000\u0000\u0150!\u0001\u0000\u0000\u0000\u0151\u014f"+
		"\u0001\u0000\u0000\u0000\u0152\u0157\u0003B!\u0000\u0153\u0154\u0005H"+
		"\u0000\u0000\u0154\u0156\u0003B!\u0000\u0155\u0153\u0001\u0000\u0000\u0000"+
		"\u0156\u0159\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000"+
		"\u0157\u0158\u0001\u0000\u0000\u0000\u0158#\u0001\u0000\u0000\u0000\u0159"+
		"\u0157\u0001\u0000\u0000\u0000\u015a\u015b\u0005M\u0000\u0000\u015b\u015c"+
		"\u0005N\u0000\u0000\u015c\u015d\u00051\u0000\u0000\u015d\u015e\u0005\t"+
		"\u0000\u0000\u015e\u0160\u0005A\u0000\u0000\u015f\u0161\u0003\"\u0011"+
		"\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0005B\u0000\u0000"+
		"\u0163%\u0001\u0000\u0000\u0000\u0164\u0165\u0005M\u0000\u0000\u0165\u0167"+
		"\u0005A\u0000\u0000\u0166\u0168\u0003\"\u0011\u0000\u0167\u0166\u0001"+
		"\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169\u0001"+
		"\u0000\u0000\u0000\u0169\u016a\u0005B\u0000\u0000\u016a\'\u0001\u0000"+
		"\u0000\u0000\u016b\u016e\u0007\u0000\u0000\u0000\u016c\u016d\u0005I\u0000"+
		"\u0000\u016d\u016f\u0005K\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0171\u0001\u0000\u0000\u0000\u0171)\u0001\u0000\u0000\u0000\u0172"+
		"\u0176\u0005N\u0000\u0000\u0173\u0176\u0005\n\u0000\u0000\u0174\u0176"+
		"\u0003&\u0013\u0000\u0175\u0172\u0001\u0000\u0000\u0000\u0175\u0173\u0001"+
		"\u0000\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0176\u017b\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0005I\u0000\u0000\u0178\u017a\u0003,\u0016"+
		"\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000"+
		"\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000"+
		"\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000"+
		"\u0000\u017e\u017f\u0005I\u0000\u0000\u017f\u0180\u0005M\u0000\u0000\u0180"+
		"\u0182\u0005A\u0000\u0000\u0181\u0183\u0003\"\u0011\u0000\u0182\u0181"+
		"\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184"+
		"\u0001\u0000\u0000\u0000\u0184\u0185\u0005B\u0000\u0000\u0185+\u0001\u0000"+
		"\u0000\u0000\u0186\u018f\u0005K\u0000\u0000\u0187\u018f\u0005L\u0000\u0000"+
		"\u0188\u0189\u0005M\u0000\u0000\u0189\u018b\u0005A\u0000\u0000\u018a\u018c"+
		"\u0003\"\u0011\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018b\u018c\u0001"+
		"\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018f\u0005"+
		"B\u0000\u0000\u018e\u0186\u0001\u0000\u0000\u0000\u018e\u0187\u0001\u0000"+
		"\u0000\u0000\u018e\u0188\u0001\u0000\u0000\u0000\u018f-\u0001\u0000\u0000"+
		"\u0000\u0190\u0193\u0003&\u0013\u0000\u0191\u0193\u0003*\u0015\u0000\u0192"+
		"\u0190\u0001\u0000\u0000\u0000\u0192\u0191\u0001\u0000\u0000\u0000\u0193"+
		"/\u0001\u0000\u0000\u0000\u0194\u01aa\u00034\u001a\u0000\u0195\u01aa\u0003"+
		"6\u001b\u0000\u0196\u01aa\u0003<\u001e\u0000\u0197\u01aa\u0003D\"\u0000"+
		"\u0198\u01aa\u0003J%\u0000\u0199\u01aa\u0003$\u0012\u0000\u019a\u01aa"+
		"\u00038\u001c\u0000\u019b\u01aa\u0003:\u001d\u0000\u019c\u01aa\u0003n"+
		"7\u0000\u019d\u01aa\u0003p8\u0000\u019e\u01aa\u0003t:\u0000\u019f\u01aa"+
		"\u0003.\u0017\u0000\u01a0\u01aa\u0003\u001c\u000e\u0000\u01a1\u01aa\u0003"+
		"b1\u0000\u01a2\u01aa\u0003d2\u0000\u01a3\u01aa\u0003v;\u0000\u01a4\u01aa"+
		"\u0003x<\u0000\u01a5\u01aa\u0003\u0084B\u0000\u01a6\u01aa\u0003\u0088"+
		"D\u0000\u01a7\u01aa\u0003\u008aE\u0000\u01a8\u01aa\u0003\u008cF\u0000"+
		"\u01a9\u0194\u0001\u0000\u0000\u0000\u01a9\u0195\u0001\u0000\u0000\u0000"+
		"\u01a9\u0196\u0001\u0000\u0000\u0000\u01a9\u0197\u0001\u0000\u0000\u0000"+
		"\u01a9\u0198\u0001\u0000\u0000\u0000\u01a9\u0199\u0001\u0000\u0000\u0000"+
		"\u01a9\u019a\u0001\u0000\u0000\u0000\u01a9\u019b\u0001\u0000\u0000\u0000"+
		"\u01a9\u019c\u0001\u0000\u0000\u0000\u01a9\u019d\u0001\u0000\u0000\u0000"+
		"\u01a9\u019e\u0001\u0000\u0000\u0000\u01a9\u019f\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a0\u0001\u0000\u0000\u0000\u01a9\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a2\u0001\u0000\u0000\u0000\u01a9\u01a3\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a4\u0001\u0000\u0000\u0000\u01a9\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a6\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a8\u0001\u0000\u0000\u0000\u01aa1\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ac\u00030\u0018\u0000\u01ac\u01ad\u0005G\u0000\u0000\u01ad3\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0005K\u0000\u0000\u01af\u01b0\u0005A\u0000"+
		"\u0000\u01b0\u01b1\u0003>\u001f\u0000\u01b1\u01b2\u0005B\u0000\u0000\u01b2"+
		"\u01bb\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005K\u0000\u0000\u01b4\u01b5"+
		"\u0005A\u0000\u0000\u01b5\u01b6\u0003>\u001f\u0000\u01b6\u01b7\u0005B"+
		"\u0000\u0000\u01b7\u01b8\u00051\u0000\u0000\u01b8\u01b9\u0003\u008eG\u0000"+
		"\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01ae\u0001\u0000\u0000\u0000"+
		"\u01ba\u01b3\u0001\u0000\u0000\u0000\u01bb5\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bd\u0005K\u0000\u0000\u01bd\u01c0\u00051\u0000\u0000\u01be\u01c1\u0003"+
		"B!\u0000\u01bf\u01c1\u0003f3\u0000\u01c0\u01be\u0001\u0000\u0000\u0000"+
		"\u01c0\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c2\u01c3\u0003(\u0014\u0000\u01c3\u01c6\u00051\u0000\u0000\u01c4\u01c7"+
		"\u0003B!\u0000\u01c5\u01c7\u0003f3\u0000\u01c6\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c9\u0001\u0000\u0000"+
		"\u0000\u01c8\u01bc\u0001\u0000\u0000\u0000\u01c8\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c97\u0001\u0000\u0000\u0000\u01ca\u01d0\u0005\u0001\u0000\u0000"+
		"\u01cb\u01d1\u00034\u001a\u0000\u01cc\u01d1\u0003<\u001e\u0000\u01cd\u01d1"+
		"\u0003D\"\u0000\u01ce\u01d1\u0003J%\u0000\u01cf\u01d1\u0003$\u0012\u0000"+
		"\u01d0\u01cb\u0001\u0000\u0000\u0000\u01d0\u01cc\u0001\u0000\u0000\u0000"+
		"\u01d0\u01cd\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000"+
		"\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d19\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0005\u0001\u0000\u0000\u01d3\u01d4\u00036\u001b\u0000\u01d4;\u0001"+
		"\u0000\u0000\u0000\u01d5\u01d6\u0005L\u0000\u0000\u01d6\u01d7\u0005A\u0000"+
		"\u0000\u01d7\u01d8\u0003>\u001f\u0000\u01d8\u01d9\u0005B\u0000\u0000\u01d9"+
		"\u01da\u00051\u0000\u0000\u01da\u01db\u0003\u008eG\u0000\u01db=\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0007\u0001\u0000\u0000\u01dd?\u0001\u0000"+
		"\u0000\u0000\u01de\u01df\u0007\u0002\u0000\u0000\u01dfA\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e4\u0003F#\u0000\u01e1\u01e4\u0003L&\u0000\u01e2\u01e4"+
		"\u0003\u008eG\u0000\u01e3\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001"+
		"\u0000\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4C\u0001\u0000"+
		"\u0000\u0000\u01e5\u01f5\u0005\u001e\u0000\u0000\u01e6\u01e7\u0005K\u0000"+
		"\u0000\u01e7\u01e8\u0005A\u0000\u0000\u01e8\u01e9\u0003>\u001f\u0000\u01e9"+
		"\u01ec\u0005B\u0000\u0000\u01ea\u01eb\u00051\u0000\u0000\u01eb\u01ed\u0003"+
		"F#\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000"+
		"\u0000\u01ed\u01f6\u0001\u0000\u0000\u0000\u01ee\u01ef\u0005L\u0000\u0000"+
		"\u01ef\u01f0\u0005A\u0000\u0000\u01f0\u01f1\u0003>\u001f\u0000\u01f1\u01f2"+
		"\u0005B\u0000\u0000\u01f2\u01f3\u00051\u0000\u0000\u01f3\u01f4\u0003F"+
		"#\u0000\u01f4\u01f6\u0001\u0000\u0000\u0000\u01f5\u01e6\u0001\u0000\u0000"+
		"\u0000\u01f5\u01ee\u0001\u0000\u0000\u0000\u01f6E\u0001\u0000\u0000\u0000"+
		"\u01f7\u0200\u0005C\u0000\u0000\u01f8\u01fd\u0003H$\u0000\u01f9\u01fa"+
		"\u0005H\u0000\u0000\u01fa\u01fc\u0003H$\u0000\u01fb\u01f9\u0001\u0000"+
		"\u0000\u0000\u01fc\u01ff\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u0201\u0001\u0000"+
		"\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000\u0000\u0200\u01f8\u0001\u0000"+
		"\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000"+
		"\u0000\u0000\u0202\u0203\u0005D\u0000\u0000\u0203G\u0001\u0000\u0000\u0000"+
		"\u0204\u0209\u0003@ \u0000\u0205\u0209\u0005K\u0000\u0000\u0206\u0209"+
		"\u0005L\u0000\u0000\u0207\u0209\u0003F#\u0000\u0208\u0204\u0001\u0000"+
		"\u0000\u0000\u0208\u0205\u0001\u0000\u0000\u0000\u0208\u0206\u0001\u0000"+
		"\u0000\u0000\u0208\u0207\u0001\u0000\u0000\u0000\u0209I\u0001\u0000\u0000"+
		"\u0000\u020a\u021a\u0005\u001d\u0000\u0000\u020b\u020c\u0005K\u0000\u0000"+
		"\u020c\u020d\u0005A\u0000\u0000\u020d\u020e\u0003>\u001f\u0000\u020e\u0211"+
		"\u0005B\u0000\u0000\u020f\u0210\u00051\u0000\u0000\u0210\u0212\u0003L"+
		"&\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000"+
		"\u0000\u0212\u021b\u0001\u0000\u0000\u0000\u0213\u0214\u0005L\u0000\u0000"+
		"\u0214\u0215\u0005A\u0000\u0000\u0215\u0216\u0003>\u001f\u0000\u0216\u0217"+
		"\u0005B\u0000\u0000\u0217\u0218\u00051\u0000\u0000\u0218\u0219\u0003L"+
		"&\u0000\u0219\u021b\u0001\u0000\u0000\u0000\u021a\u020b\u0001\u0000\u0000"+
		"\u0000\u021a\u0213\u0001\u0000\u0000\u0000\u021bK\u0001\u0000\u0000\u0000"+
		"\u021c\u022d\u0005E\u0000\u0000\u021d\u0221\u0003@ \u0000\u021e\u0221"+
		"\u0005K\u0000\u0000\u021f\u0221\u0005L\u0000\u0000\u0220\u021d\u0001\u0000"+
		"\u0000\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0220\u021f\u0001\u0000"+
		"\u0000\u0000\u0221\u022a\u0001\u0000\u0000\u0000\u0222\u0226\u0005H\u0000"+
		"\u0000\u0223\u0227\u0003@ \u0000\u0224\u0227\u0005K\u0000\u0000\u0225"+
		"\u0227\u0005L\u0000\u0000\u0226\u0223\u0001\u0000\u0000\u0000\u0226\u0224"+
		"\u0001\u0000\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u0227\u0229"+
		"\u0001\u0000\u0000\u0000\u0228\u0222\u0001\u0000\u0000\u0000\u0229\u022c"+
		"\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022a\u022b"+
		"\u0001\u0000\u0000\u0000\u022b\u022e\u0001\u0000\u0000\u0000\u022c\u022a"+
		"\u0001\u0000\u0000\u0000\u022d\u0220\u0001\u0000\u0000\u0000\u022d\u022e"+
		"\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0230"+
		"\u0005F\u0000\u0000\u0230M\u0001\u0000\u0000\u0000\u0231\u0232\u0005A"+
		"\u0000\u0000\u0232\u0233\u0003\u008eG\u0000\u0233\u0234\u0005B\u0000\u0000"+
		"\u0234\u0235\u0005@\u0000\u0000\u0235\u0236\u0003X,\u0000\u0236O\u0001"+
		"\u0000\u0000\u0000\u0237\u0238\u0005A\u0000\u0000\u0238\u0239\u0003\u008e"+
		"G\u0000\u0239\u023a\u0005B\u0000\u0000\u023a\u023b\u0005@\u0000\u0000"+
		"\u023b\u023c\u0003Z-\u0000\u023cQ\u0001\u0000\u0000\u0000\u023d\u023e"+
		"\u0005A\u0000\u0000\u023e\u023f\u0003\u008eG\u0000\u023f\u0240\u0005B"+
		"\u0000\u0000\u0240\u0241\u0005@\u0000\u0000\u0241\u0242\u0003^/\u0000"+
		"\u0242S\u0001\u0000\u0000\u0000\u0243\u024c\u0005E\u0000\u0000\u0244\u0245"+
		"\u0005\u0007\u0000\u0000\u0245\u024d\u0005G\u0000\u0000\u0246\u0248\u0003"+
		"2\u0019\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u024b\u0001\u0000"+
		"\u0000\u0000\u0249\u0247\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000"+
		"\u0000\u0000\u024a\u024d\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000"+
		"\u0000\u0000\u024c\u0244\u0001\u0000\u0000\u0000\u024c\u0249\u0001\u0000"+
		"\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e\u024f\u0005F\u0000"+
		"\u0000\u024fU\u0001\u0000\u0000\u0000\u0250\u0251\u0005A\u0000\u0000\u0251"+
		"\u0252\u0003\u008eG\u0000\u0252\u0253\u0005B\u0000\u0000\u0253\u0254\u0005"+
		"@\u0000\u0000\u0254\u0255\u0003T*\u0000\u0255W\u0001\u0000\u0000\u0000"+
		"\u0256\u025f\u0005E\u0000\u0000\u0257\u0258\u0005\u0007\u0000\u0000\u0258"+
		"\u0260\u0005G\u0000\u0000\u0259\u025b\u00032\u0019\u0000\u025a\u0259\u0001"+
		"\u0000\u0000\u0000\u025b\u025e\u0001\u0000\u0000\u0000\u025c\u025a\u0001"+
		"\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000\u0000\u025d\u0260\u0001"+
		"\u0000\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025f\u0257\u0001"+
		"\u0000\u0000\u0000\u025f\u025c\u0001\u0000\u0000\u0000\u0260\u0261\u0001"+
		"\u0000\u0000\u0000\u0261\u0262\u0005F\u0000\u0000\u0262Y\u0001\u0000\u0000"+
		"\u0000\u0263\u026c\u0005E\u0000\u0000\u0264\u0265\u0005\u0007\u0000\u0000"+
		"\u0265\u026d\u0005G\u0000\u0000\u0266\u0268\u00032\u0019\u0000\u0267\u0266"+
		"\u0001\u0000\u0000\u0000\u0268\u026b\u0001\u0000\u0000\u0000\u0269\u0267"+
		"\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000\u026a\u026d"+
		"\u0001\u0000\u0000\u0000\u026b\u0269\u0001\u0000\u0000\u0000\u026c\u0264"+
		"\u0001\u0000\u0000\u0000\u026c\u0269\u0001\u0000\u0000\u0000\u026d\u026e"+
		"\u0001\u0000\u0000\u0000\u026e\u026f\u0005F\u0000\u0000\u026f[\u0001\u0000"+
		"\u0000\u0000\u0270\u0279\u0005E\u0000\u0000\u0271\u0272\u0005\u0007\u0000"+
		"\u0000\u0272\u027a\u0005G\u0000\u0000\u0273\u0275\u00032\u0019\u0000\u0274"+
		"\u0273\u0001\u0000\u0000\u0000\u0275\u0278\u0001\u0000\u0000\u0000\u0276"+
		"\u0274\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000\u0000\u0000\u0277"+
		"\u027a\u0001\u0000\u0000\u0000\u0278\u0276\u0001\u0000\u0000\u0000\u0279"+
		"\u0271\u0001\u0000\u0000\u0000\u0279\u0276\u0001\u0000\u0000\u0000\u027a"+
		"\u027b\u0001\u0000\u0000\u0000\u027b\u027c\u0005F\u0000\u0000\u027c]\u0001"+
		"\u0000\u0000\u0000\u027d\u0286\u0005E\u0000\u0000\u027e\u027f\u0005\u0007"+
		"\u0000\u0000\u027f\u0287\u0005G\u0000\u0000\u0280\u0282\u00032\u0019\u0000"+
		"\u0281\u0280\u0001\u0000\u0000\u0000\u0282\u0285\u0001\u0000\u0000\u0000"+
		"\u0283\u0281\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000"+
		"\u0284\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000"+
		"\u0286\u027e\u0001\u0000\u0000\u0000\u0286\u0283\u0001\u0000\u0000\u0000"+
		"\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0005F\u0000\u0000\u0289"+
		"_\u0001\u0000\u0000\u0000\u028a\u0293\u0005E\u0000\u0000\u028b\u028c\u0005"+
		"\u0007\u0000\u0000\u028c\u0294\u0005G\u0000\u0000\u028d\u028f\u00032\u0019"+
		"\u0000\u028e\u028d\u0001\u0000\u0000\u0000\u028f\u0292\u0001\u0000\u0000"+
		"\u0000\u0290\u028e\u0001\u0000\u0000\u0000\u0290\u0291\u0001\u0000\u0000"+
		"\u0000\u0291\u0294\u0001\u0000\u0000\u0000\u0292\u0290\u0001\u0000\u0000"+
		"\u0000\u0293\u028b\u0001\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000"+
		"\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296\u0005F\u0000\u0000"+
		"\u0296a\u0001\u0000\u0000\u0000\u0297\u0298\u0005\u001f\u0000\u0000\u0298"+
		"\u0299\u0005A\u0000\u0000\u0299\u029f\u0003N\'\u0000\u029a\u029b\u0005"+
		",\u0000\u0000\u029b\u029c\u0005 \u0000\u0000\u029c\u029e\u0003P(\u0000"+
		"\u029d\u029a\u0001\u0000\u0000\u0000\u029e\u02a1\u0001\u0000\u0000\u0000"+
		"\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a5\u0001\u0000\u0000\u0000\u02a1\u029f\u0001\u0000\u0000\u0000"+
		"\u02a2\u02a3\u0005,\u0000\u0000\u02a3\u02a4\u0005!\u0000\u0000\u02a4\u02a6"+
		"\u0003\\.\u0000\u02a5\u02a2\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000\u0000\u02a7\u02a8\u0005"+
		"B\u0000\u0000\u02a8c\u0001\u0000\u0000\u0000\u02a9\u02aa\u0005\"\u0000"+
		"\u0000\u02aa\u02ab\u0005A\u0000\u0000\u02ab\u02ac\u0005A\u0000\u0000\u02ac"+
		"\u02ad\u00034\u001a\u0000\u02ad\u02ae\u0005B\u0000\u0000\u02ae\u02af\u0005"+
		",\u0000\u0000\u02af\u02b0\u0003R)\u0000\u02b0\u02b1\u0005J\u0000\u0000"+
		"\u02b1\u02b2\u0003h4\u0000\u02b2\u02b3\u0005B\u0000\u0000\u02b3\u02c3"+
		"\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005\"\u0000\u0000\u02b5\u02b6\u0005"+
		"A\u0000\u0000\u02b6\u02b9\u0005A\u0000\u0000\u02b7\u02ba\u00036\u001b"+
		"\u0000\u02b8\u02ba\u0005K\u0000\u0000\u02b9\u02b7\u0001\u0000\u0000\u0000"+
		"\u02b9\u02b8\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000"+
		"\u02bb\u02bc\u0005B\u0000\u0000\u02bc\u02bd\u0005,\u0000\u0000\u02bd\u02be"+
		"\u0003R)\u0000\u02be\u02bf\u0005J\u0000\u0000\u02bf\u02c0\u0003j5\u0000"+
		"\u02c0\u02c1\u0005B\u0000\u0000\u02c1\u02c3\u0001\u0000\u0000\u0000\u02c2"+
		"\u02a9\u0001\u0000\u0000\u0000\u02c2\u02b4\u0001\u0000\u0000\u0000\u02c3"+
		"e\u0001\u0000\u0000\u0000\u02c4\u02cb\u0007\u0003\u0000\u0000\u02c5\u02c6"+
		"\u0007\u0004\u0000\u0000\u02c6\u02c7\u0005A\u0000\u0000\u02c7\u02c8\u0003"+
		"l6\u0000\u02c8\u02c9\u0005B\u0000\u0000\u02c9\u02cb\u0001\u0000\u0000"+
		"\u0000\u02ca\u02c4\u0001\u0000\u0000\u0000\u02ca\u02c5\u0001\u0000\u0000"+
		"\u0000\u02cbg\u0001\u0000\u0000\u0000\u02cc\u02cf\u0003f3\u0000\u02cd"+
		"\u02cf\u0003j5\u0000\u02ce\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cd\u0001"+
		"\u0000\u0000\u0000\u02cfi\u0001\u0000\u0000\u0000\u02d0\u02d1\u0007\u0003"+
		"\u0000\u0000\u02d1\u02d2\u0005A\u0000\u0000\u02d2\u02d3\u0005K\u0000\u0000"+
		"\u02d3\u02dc\u0005B\u0000\u0000\u02d4\u02d5\u0007\u0004\u0000\u0000\u02d5"+
		"\u02d6\u0005A\u0000\u0000\u02d6\u02d7\u0003l6\u0000\u02d7\u02d8\u0005"+
		"H\u0000\u0000\u02d8\u02d9\u0005K\u0000\u0000\u02d9\u02da\u0005B\u0000"+
		"\u0000\u02da\u02dc\u0001\u0000\u0000\u0000\u02db\u02d0\u0001\u0000\u0000"+
		"\u0000\u02db\u02d4\u0001\u0000\u0000\u0000\u02dck\u0001\u0000\u0000\u0000"+
		"\u02dd\u02e1\u0003@ \u0000\u02de\u02e1\u0005K\u0000\u0000\u02df\u02e1"+
		"\u0005L\u0000\u0000\u02e0\u02dd\u0001\u0000\u0000\u0000\u02e0\u02de\u0001"+
		"\u0000\u0000\u0000\u02e0\u02df\u0001\u0000\u0000\u0000\u02e1m\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e3\u0005\u0013\u0000\u0000\u02e3\u02e4\u0005A\u0000"+
		"\u0000\u02e4\u02e9\u0003r9\u0000\u02e5\u02e6\u0005,\u0000\u0000\u02e6"+
		"\u02e8\u0003r9\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000\u02e8\u02eb\u0001"+
		"\u0000\u0000\u0000\u02e9\u02e7\u0001\u0000\u0000\u0000\u02e9\u02ea\u0001"+
		"\u0000\u0000\u0000\u02ea\u02ec\u0001\u0000\u0000\u0000\u02eb\u02e9\u0001"+
		"\u0000\u0000\u0000\u02ec\u02ed\u0005B\u0000\u0000\u02edo\u0001\u0000\u0000"+
		"\u0000\u02ee\u02ef\u0005\u0014\u0000\u0000\u02ef\u02f0\u0005A\u0000\u0000"+
		"\u02f0\u02f5\u0003r9\u0000\u02f1\u02f2\u0005,\u0000\u0000\u02f2\u02f4"+
		"\u0003r9\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000\u02f4\u02f7\u0001\u0000"+
		"\u0000\u0000\u02f5\u02f3\u0001\u0000\u0000\u0000\u02f5\u02f6\u0001\u0000"+
		"\u0000\u0000\u02f6\u02f8\u0001\u0000\u0000\u0000\u02f7\u02f5\u0001\u0000"+
		"\u0000\u0000\u02f8\u02f9\u0005B\u0000\u0000\u02f9q\u0001\u0000\u0000\u0000"+
		"\u02fa\u02fb\u0003B!\u0000\u02fbs\u0001\u0000\u0000\u0000\u02fc\u02fd"+
		"\u0005\u0015\u0000\u0000\u02fd\u02fe\u0005A\u0000\u0000\u02fe\u02ff\u0003"+
		">\u001f\u0000\u02ff\u0300\u0005J\u0000\u0000\u0300\u0301\u0005K\u0000"+
		"\u0000\u0301\u0302\u0005B\u0000\u0000\u0302u\u0001\u0000\u0000\u0000\u0303"+
		"\u0304\u0005\u000b\u0000\u0000\u0304\u0305\u0005A\u0000\u0000\u0305\u030a"+
		"\u0005A\u0000\u0000\u0306\u0307\u0005N\u0000\u0000\u0307\u0308\u0005H"+
		"\u0000\u0000\u0308\u030b\u0005M\u0000\u0000\u0309\u030b\u0003\u008eG\u0000"+
		"\u030a\u0306\u0001\u0000\u0000\u0000\u030a\u0309\u0001\u0000\u0000\u0000"+
		"\u030b\u030c\u0001\u0000\u0000\u0000\u030c\u030d\u0005B\u0000\u0000\u030d"+
		"\u030e\u0005,\u0000\u0000\u030e\u030f\u0003`0\u0000\u030f\u0310\u0005"+
		"B\u0000\u0000\u0310w\u0001\u0000\u0000\u0000\u0311\u0312\u0005\f\u0000"+
		"\u0000\u0312\u0313\u0005M\u0000\u0000\u0313\u0314\u0005,\u0000\u0000\u0314"+
		"\u0315\u0005A\u0000\u0000\u0315\u0316\u0003z=\u0000\u0316\u0317\u0003"+
		"~?\u0000\u0317\u0319\u0005B\u0000\u0000\u0318\u031a\u0003\u0082A\u0000"+
		"\u0319\u0318\u0001\u0000\u0000\u0000\u0319\u031a\u0001\u0000\u0000\u0000"+
		"\u031ay\u0001\u0000\u0000\u0000\u031b\u0324\u0005A\u0000\u0000\u031c\u0321"+
		"\u0003|>\u0000\u031d\u031e\u0005H\u0000\u0000\u031e\u0320\u0003|>\u0000"+
		"\u031f\u031d\u0001\u0000\u0000\u0000\u0320\u0323\u0001\u0000\u0000\u0000"+
		"\u0321\u031f\u0001\u0000\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000"+
		"\u0322\u0325\u0001\u0000\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000"+
		"\u0324\u031c\u0001\u0000\u0000\u0000\u0324\u0325\u0001\u0000\u0000\u0000"+
		"\u0325\u0326\u0001\u0000\u0000\u0000\u0326\u0327\u0005B\u0000\u0000\u0327"+
		"{\u0001\u0000\u0000\u0000\u0328\u032b\u00034\u001a\u0000\u0329\u032b\u0003"+
		"<\u001e\u0000\u032a\u0328\u0001\u0000\u0000\u0000\u032a\u0329\u0001\u0000"+
		"\u0000\u0000\u032b}\u0001\u0000\u0000\u0000\u032c\u033d\u0005E\u0000\u0000"+
		"\u032d\u032e\u0005\u0007\u0000\u0000\u032e\u033e\u0005G\u0000\u0000\u032f"+
		"\u0334\u0003\u0080@\u0000\u0330\u0331\u0005H\u0000\u0000\u0331\u0333\u0003"+
		"\u0080@\u0000\u0332\u0330\u0001\u0000\u0000\u0000\u0333\u0336\u0001\u0000"+
		"\u0000\u0000\u0334\u0332\u0001\u0000\u0000\u0000\u0334\u0335\u0001\u0000"+
		"\u0000\u0000\u0335\u033e\u0001\u0000\u0000\u0000\u0336\u0334\u0001\u0000"+
		"\u0000\u0000\u0337\u0339\u00032\u0019\u0000\u0338\u0337\u0001\u0000\u0000"+
		"\u0000\u0339\u033c\u0001\u0000\u0000\u0000\u033a\u0338\u0001\u0000\u0000"+
		"\u0000\u033a\u033b\u0001\u0000\u0000\u0000\u033b\u033e\u0001\u0000\u0000"+
		"\u0000\u033c\u033a\u0001\u0000\u0000\u0000\u033d\u032d\u0001\u0000\u0000"+
		"\u0000\u033d\u032f\u0001\u0000\u0000\u0000\u033d\u033a\u0001\u0000\u0000"+
		"\u0000\u033e\u033f\u0001\u0000\u0000\u0000\u033f\u0340\u0005F\u0000\u0000"+
		"\u0340\u007f\u0001\u0000\u0000\u0000\u0341\u0342\u0005\r\u0000\u0000\u0342"+
		"\u0343\u0005M\u0000\u0000\u0343\u0344\u0005,\u0000\u0000\u0344\u0345\u0005"+
		"A\u0000\u0000\u0345\u0346\u0003z=\u0000\u0346\u0347\u0003~?\u0000\u0347"+
		"\u0348\u0005B\u0000\u0000\u0348\u0081\u0001\u0000\u0000\u0000\u0349\u034a"+
		"\u0005I\u0000\u0000\u034a\u034b\u0005\u000e\u0000\u0000\u034b\u034c\u0005"+
		"+\u0000\u0000\u034c\u034d\u0003\u0086C\u0000\u034d\u0083\u0001\u0000\u0000"+
		"\u0000\u034e\u034f\u0005M\u0000\u0000\u034f\u0350\u0003\u0082A\u0000\u0350"+
		"\u0085\u0001\u0000\u0000\u0000\u0351\u035d\u0005M\u0000\u0000\u0352\u0353"+
		"\u0005A\u0000\u0000\u0353\u0358\u0005M\u0000\u0000\u0354\u0355\u0005H"+
		"\u0000\u0000\u0355\u0357\u0005M\u0000\u0000\u0356\u0354\u0001\u0000\u0000"+
		"\u0000\u0357\u035a\u0001\u0000\u0000\u0000\u0358\u0356\u0001\u0000\u0000"+
		"\u0000\u0358\u0359\u0001\u0000\u0000\u0000\u0359\u035b\u0001\u0000\u0000"+
		"\u0000\u035a\u0358\u0001\u0000\u0000\u0000\u035b\u035d\u0005B\u0000\u0000"+
		"\u035c\u0351\u0001\u0000\u0000\u0000\u035c\u0352\u0001\u0000\u0000\u0000"+
		"\u035d\u0087\u0001\u0000\u0000\u0000\u035e\u035f\u0005\u000f\u0000\u0000"+
		"\u035f\u0360\u0005A\u0000\u0000\u0360\u0361\u0005N\u0000\u0000\u0361\u0362"+
		"\u0005,\u0000\u0000\u0362\u0363\u0005A\u0000\u0000\u0363\u0364\u0003\u008e"+
		"G\u0000\u0364\u0365\u0005H\u0000\u0000\u0365\u0366\u0003\u008eG\u0000"+
		"\u0366\u0369\u0005B\u0000\u0000\u0367\u0368\u0005,\u0000\u0000\u0368\u036a"+
		"\u0005M\u0000\u0000\u0369\u0367\u0001\u0000\u0000\u0000\u0369\u036a\u0001"+
		"\u0000\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b\u036c\u0005"+
		"B\u0000\u0000\u036c\u0089\u0001\u0000\u0000\u0000\u036d\u036e\u0005\u0010"+
		"\u0000\u0000\u036e\u036f\u0005A\u0000\u0000\u036f\u0370\u0005N\u0000\u0000"+
		"\u0370\u0371\u0005B\u0000\u0000\u0371\u008b\u0001\u0000\u0000\u0000\u0372"+
		"\u0373\u0005\u0011\u0000\u0000\u0373\u0374\u0005A\u0000\u0000\u0374\u0375"+
		"\u0005M\u0000\u0000\u0375\u0376\u0005B\u0000\u0000\u0376\u008d\u0001\u0000"+
		"\u0000\u0000\u0377\u0378\u0003\u0090H\u0000\u0378\u008f\u0001\u0000\u0000"+
		"\u0000\u0379\u037e\u0003\u0092I\u0000\u037a\u037b\u00056\u0000\u0000\u037b"+
		"\u037d\u0003\u0092I\u0000\u037c\u037a\u0001\u0000\u0000\u0000\u037d\u0380"+
		"\u0001\u0000\u0000\u0000\u037e\u037c\u0001\u0000\u0000\u0000\u037e\u037f"+
		"\u0001\u0000\u0000\u0000\u037f\u0091\u0001\u0000\u0000\u0000\u0380\u037e"+
		"\u0001\u0000\u0000\u0000\u0381\u0386\u0003\u0094J\u0000\u0382\u0383\u0005"+
		"7\u0000\u0000\u0383\u0385\u0003\u0094J\u0000\u0384\u0382\u0001\u0000\u0000"+
		"\u0000\u0385\u0388\u0001\u0000\u0000\u0000\u0386\u0384\u0001\u0000\u0000"+
		"\u0000\u0386\u0387\u0001\u0000\u0000\u0000\u0387\u0093\u0001\u0000\u0000"+
		"\u0000\u0388\u0386\u0001\u0000\u0000\u0000\u0389\u038e\u0003\u0096K\u0000"+
		"\u038a\u038b\u0007\u0005\u0000\u0000\u038b\u038d\u0003\u0096K\u0000\u038c"+
		"\u038a\u0001\u0000\u0000\u0000\u038d\u0390\u0001\u0000\u0000\u0000\u038e"+
		"\u038c\u0001\u0000\u0000\u0000\u038e\u038f\u0001\u0000\u0000\u0000\u038f"+
		"\u0095\u0001\u0000\u0000\u0000\u0390\u038e\u0001\u0000\u0000\u0000\u0391"+
		"\u0396\u0003\u0098L\u0000\u0392\u0393\u0007\u0006\u0000\u0000\u0393\u0395"+
		"\u0003\u0098L\u0000\u0394\u0392\u0001\u0000\u0000\u0000\u0395\u0398\u0001"+
		"\u0000\u0000\u0000\u0396\u0394\u0001\u0000\u0000\u0000\u0396\u0397\u0001"+
		"\u0000\u0000\u0000\u0397\u0097\u0001\u0000\u0000\u0000\u0398\u0396\u0001"+
		"\u0000\u0000\u0000\u0399\u039e\u0003\u009aM\u0000\u039a\u039b\u0007\u0007"+
		"\u0000\u0000\u039b\u039d\u0003\u009aM\u0000\u039c\u039a\u0001\u0000\u0000"+
		"\u0000\u039d\u03a0\u0001\u0000\u0000\u0000\u039e\u039c\u0001\u0000\u0000"+
		"\u0000\u039e\u039f\u0001\u0000\u0000\u0000\u039f\u0099\u0001\u0000\u0000"+
		"\u0000\u03a0\u039e\u0001\u0000\u0000\u0000\u03a1\u03a6\u0003\u009cN\u0000"+
		"\u03a2\u03a3\u0007\b\u0000\u0000\u03a3\u03a5\u0003\u009cN\u0000\u03a4"+
		"\u03a2\u0001\u0000\u0000\u0000\u03a5\u03a8\u0001\u0000\u0000\u0000\u03a6"+
		"\u03a4\u0001\u0000\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7"+
		"\u009b\u0001\u0000\u0000\u0000\u03a8\u03a6\u0001\u0000\u0000\u0000\u03a9"+
		"\u03aa\u0007\t\u0000\u0000\u03aa\u03ad\u0003\u009cN\u0000\u03ab\u03ad"+
		"\u0003\u009eO\u0000\u03ac\u03a9\u0001\u0000\u0000\u0000\u03ac\u03ab\u0001"+
		"\u0000\u0000\u0000\u03ad\u009d\u0001\u0000\u0000\u0000\u03ae\u03b3\u0003"+
		"\u00a0P\u0000\u03af\u03b0\u0005I\u0000\u0000\u03b0\u03b2\u0003,\u0016"+
		"\u0000\u03b1\u03af\u0001\u0000\u0000\u0000\u03b2\u03b5\u0001\u0000\u0000"+
		"\u0000\u03b3\u03b1\u0001\u0000\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000"+
		"\u0000\u03b4\u009f\u0001\u0000\u0000\u0000\u03b5\u03b3\u0001\u0000\u0000"+
		"\u0000\u03b6\u03bc\u0003\u00a2Q\u0000\u03b7\u03b8\u0005A\u0000\u0000\u03b8"+
		"\u03b9\u0003\u008eG\u0000\u03b9\u03ba\u0005B\u0000\u0000\u03ba\u03bc\u0001"+
		"\u0000\u0000\u0000\u03bb\u03b6\u0001\u0000\u0000\u0000\u03bb\u03b7\u0001"+
		"\u0000\u0000\u0000\u03bc\u00a1\u0001\u0000\u0000\u0000\u03bd\u03c4\u0003"+
		"@ \u0000\u03be\u03c4\u0005K\u0000\u0000\u03bf\u03c4\u0005L\u0000\u0000"+
		"\u03c0\u03c4\u0005N\u0000\u0000\u03c1\u03c4\u0005\n\u0000\u0000\u03c2"+
		"\u03c4\u0003&\u0013\u0000\u03c3\u03bd\u0001\u0000\u0000\u0000\u03c3\u03be"+
		"\u0001\u0000\u0000\u0000\u03c3\u03bf\u0001\u0000\u0000\u0000\u03c3\u03c0"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c1\u0001\u0000\u0000\u0000\u03c3\u03c2"+
		"\u0001\u0000\u0000\u0000\u03c4\u00a3\u0001\u0000\u0000\u0000^\u00a6\u00ab"+
		"\u00b4\u00ba\u00c0\u00d1\u00dc\u00de\u00e0\u00e7\u00ec\u00f8\u00fa\u0103"+
		"\u010e\u0110\u0112\u011b\u0127\u0129\u012f\u0148\u014f\u0157\u0160\u0167"+
		"\u0170\u0175\u017b\u0182\u018b\u018e\u0192\u01a9\u01ba\u01c0\u01c6\u01c8"+
		"\u01d0\u01e3\u01ec\u01f5\u01fd\u0200\u0208\u0211\u021a\u0220\u0226\u022a"+
		"\u022d\u0249\u024c\u025c\u025f\u0269\u026c\u0276\u0279\u0283\u0286\u0290"+
		"\u0293\u029f\u02a5\u02b9\u02c2\u02ca\u02ce\u02db\u02e0\u02e9\u02f5\u030a"+
		"\u0319\u0321\u0324\u032a\u0334\u033a\u033d\u0358\u035c\u0369\u037e\u0386"+
		"\u038e\u0396\u039e\u03a6\u03ac\u03b3\u03bb\u03c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
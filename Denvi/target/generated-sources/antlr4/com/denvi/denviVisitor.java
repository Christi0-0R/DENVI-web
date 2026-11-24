// Generated from com/denvi/denvi.g4 by ANTLR 4.13.1
package com.denvi;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link denviParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface denviVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link denviParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(denviParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#archprin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchprin(denviParser.ArchprinContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#archclase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchclase(denviParser.ArchclaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#importar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportar(denviParser.ImportarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#importext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportext(denviParser.ImportextContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#importint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportint(denviParser.ImportintContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#clasprin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasprin(denviParser.ClasprinContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(denviParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escclase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscclase(denviParser.EscclaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#esccuerpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsccuerpo(denviParser.EsccuerpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escmetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscmetodo(denviParser.EscmetodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpometodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpometodo(denviParser.CuerpometodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escfuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscfuncion(denviParser.EscfuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpofuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpofuncion(denviParser.CuerpofuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escretor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscretor(denviParser.EscretorContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(denviParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#decparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecparam(denviParser.DecparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#recparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecparam(denviParser.RecparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#declaobj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaobj(denviParser.DeclaobjContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#llamfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamfun(denviParser.LlamfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#accmiem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccmiem(denviParser.AccmiemContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#accmet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccmet(denviParser.AccmetContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#miembro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiembro(denviParser.MiembroContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#llamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada(denviParser.LlamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#linin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinin(denviParser.LininContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#lincod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLincod(denviParser.LincodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclaracionSimple}
	 * labeled alternative in {@link denviParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionSimple(denviParser.DeclaracionSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclaracionAsig}
	 * labeled alternative in {@link denviParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionAsig(denviParser.DeclaracionAsigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AsigVar}
	 * labeled alternative in {@link denviParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigVar(denviParser.AsigVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AsigMiembro}
	 * labeled alternative in {@link denviParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsigMiembro(denviParser.AsigMiembroContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#decla_glob}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecla_glob(denviParser.Decla_globContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#asig_glob}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsig_glob(denviParser.Asig_globContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstante(denviParser.ConstanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(denviParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(denviParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#dato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDato(denviParser.DatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#decar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecar(denviParser.DecarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#arreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArreglo(denviParser.ArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cont_arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCont_arr(denviParser.Cont_arrContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#declt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclt(denviParser.DecltContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#lista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista(denviParser.ListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#contev}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContev(denviParser.ContevContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#contevalt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContevalt(denviParser.ContevaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#contrep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContrep(denviParser.ContrepContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpo(denviParser.CuerpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#contcon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContcon(denviParser.ContconContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpoev}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpoev(denviParser.CuerpoevContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpoevalt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpoevalt(denviParser.CuerpoevaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerpoalt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerpoalt(denviParser.CuerpoaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerporep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerporep(denviParser.CuerporepContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerposuceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerposuceso(denviParser.CuerposucesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscond(denviParser.EscondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepDeclaracion}
	 * labeled alternative in {@link denviParser#esrep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepDeclaracion(denviParser.RepDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepAsignacion}
	 * labeled alternative in {@link denviParser#esrep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepAsignacion(denviParser.RepAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AutoIncSimple}
	 * labeled alternative in {@link denviParser#autoinc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncSimple(denviParser.AutoIncSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AutoIncPaso}
	 * labeled alternative in {@link denviParser#autoinc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncPaso(denviParser.AutoIncPasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#incre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncre(denviParser.IncreContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#increesp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncreesp(denviParser.IncreespContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#paso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPaso(denviParser.PasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#impcons}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpcons(denviParser.ImpconsContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#impconssl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpconssl(denviParser.ImpconsslContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#imprimible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprimible(denviParser.ImprimibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#obtdatos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObtdatos(denviParser.ObtdatosContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escsuceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscsuceso(denviParser.EscsucesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#escnivel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscnivel(denviParser.EscnivelContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#propiedades}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropiedades(denviParser.PropiedadesContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#propiedad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropiedad(denviParser.PropiedadContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#cuerponivel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuerponivel(denviParser.CuerponivelContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#subzona}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubzona(denviParser.SubzonaContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#enlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnlace(denviParser.EnlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#conexion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConexion(denviParser.ConexionContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#destino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestino(denviParser.DestinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#situar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSituar(denviParser.SituarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#retirar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetirar(denviParser.RetirarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#viajar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViajar(denviParser.ViajarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(denviParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#logor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogor(denviParser.LogorContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#logand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogand(denviParser.LogandContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#logig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogig(denviParser.LogigContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#logrel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogrel(denviParser.LogrelContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#logar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogar(denviParser.LogarContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(denviParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#simbun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimbun(denviParser.SimbunContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#valp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValp(denviParser.ValpContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(denviParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link denviParser#valsimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValsimple(denviParser.ValsimpleContext ctx);
}
package br.com.feliperudolfe.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.feliperudolfe.comum.modelo.Entidade;
import br.com.feliperudolfe.modelo.tipo.Criticidades;
import br.com.feliperudolfe.modelo.tipo.Relevancias;
import br.com.feliperudolfe.modelo.tipo.Resultados;

@Entity
@Table(name = "tb_resultados")
public class Resultado extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -4239543768746643669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "suiteClass", nullable = false)
	private String suiteClass;

	@Column(name = "testCaseClass", nullable = false)
	private String testCaseClass;

	@Column(name = "ucId", nullable = false)
	private String ucId;

	@Column(name = "ucDescription", nullable = false)
	private String ucDescription;

	@Column(name = "tcId", nullable = false)
	private String tcId;

	@Column(name = "tcDescription", nullable = false)
	private String tcDescription;

	@Column(name = "idDataset", nullable = false)
	private String idDataset;

	@Column(name = "csvPath", nullable = false)
	private String csvPath;

	@Column(name = "sqlPathSuite", length = 4096)
	private String sqlPathSuite;

	@Column(name = "sqlPathTC", length = 4096)
	private String sqlPathTC;

	@Column(name = "headerDataset", nullable = false, length = 4096)
	private String headerDataset;

	@Column(name = "lineDataset", nullable = false, length = 4096)
	private String lineDataset;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Date date;

	@Temporal(TemporalType.TIME)
	@Column(name = "startTime", nullable = false)
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "finalTime", nullable = false)
	private Date finalTime;

	@Column(name = "executionTime", nullable = false)
	private Long executionTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "avaliable", nullable = false)
	private Resultados avaliable;

	@Enumerated(EnumType.STRING)
	@Column(name = "relevance", nullable = false)
	private Relevancias relevance;

	@Enumerated(EnumType.STRING)
	@Column(name = "criticity", nullable = false)
	private Criticidades criticity;

//	@Lob
//	@Column(name = "screenBase64")
//	private String screenBase64;

	@Column(name = "motive")
	private String motive;

	@Column(name = "preCondition", nullable = false)
	private String preCondition;

	@Column(name = "procedimento", nullable = false)
	private String procedimento;

	@Column(name = "posCondition", nullable = false)
	private String posCondition;

	@Column(name = "incremento", nullable = false)
	private int incremento;

	@Column(name = "navegador", nullable = false)
	private String navegador;

	@Column(name = "sistemaOperacional", nullable = false)
	private String sistemaOperacional;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSuiteClass() {
		return suiteClass;
	}

	public void setSuiteClass(String suiteClass) {
		this.suiteClass = suiteClass;
	}

	public String getTestCaseClass() {
		return testCaseClass;
	}

	public void setTestCaseClass(String testCaseClass) {
		this.testCaseClass = testCaseClass;
	}

	public String getUcId() {
		return ucId;
	}

	public void setUcId(String ucId) {
		this.ucId = ucId;
	}

	public String getUcDescription() {
		return ucDescription;
	}

	public void setUcDescription(String ucDescription) {
		this.ucDescription = ucDescription;
	}

	public String getTcId() {
		return tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getTcDescription() {
		return tcDescription;
	}

	public void setTcDescription(String tcDescription) {
		this.tcDescription = tcDescription;
	}

	public String getIdDataset() {
		return idDataset;
	}

	public void setIdDataset(String idDataset) {
		this.idDataset = idDataset;
	}

	public String getCsvPath() {
		return csvPath;
	}

	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}

	public String getSqlPathSuite() {
		return sqlPathSuite;
	}

	public void setSqlPathSuite(String sqlPathSuite) {
		this.sqlPathSuite = sqlPathSuite;
	}

	public String getSqlPathTC() {
		return sqlPathTC;
	}

	public void setSqlPathTC(String sqlPathTC) {
		this.sqlPathTC = sqlPathTC;
	}

	public String getHeaderDataset() {
		return headerDataset;
	}

	public void setHeaderDataset(String headerDataset) {
		this.headerDataset = headerDataset;
	}

	public String getLineDataset() {
		return lineDataset;
	}

	public void setLineDataset(String lineDataset) {
		this.lineDataset = lineDataset;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Date finalTime) {
		this.finalTime = finalTime;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public Resultados getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(Resultados avaliable) {
		this.avaliable = avaliable;
	}

	public Relevancias getRelevance() {
		return relevance;
	}

	public void setRelevance(Relevancias relevance) {
		this.relevance = relevance;
	}

	public Criticidades getCriticity() {
		return criticity;
	}

	public void setCriticity(Criticidades criticity) {
		this.criticity = criticity;
	}

//	public String getScreenBase64() {
//		return screenBase64;
//	}
//
//	public void setScreenBase64(String screenBase64) {
//		this.screenBase64 = screenBase64;
//	}

	public String getMotive() {
		return motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	public String getPreCondition() {
		return preCondition;
	}

	public void setPreCondition(String preCondition) {
		this.preCondition = preCondition;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public String getPosCondition() {
		return posCondition;
	}

	public void setPosCondition(String posCondition) {
		this.posCondition = posCondition;
	}

	public int getIncremento() {
		return incremento;
	}

	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}

	public String getNavegador() {
		return navegador;
	}

	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

}
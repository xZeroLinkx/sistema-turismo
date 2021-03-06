/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 14/05/2019
Resumo: Classe que representa o contrato do cliente com um pacote do servi�o
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contrato")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codContrato;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="pacote")
	private Pacote pacote;
	
	public Contrato(){
		
	}

	public Contrato(Integer codContrato, Date data, Cliente cliente, Pacote pacote) {
		super();
		this.codContrato = codContrato;
		this.data = data;
		this.cliente = cliente;
		cliente.addContrato(this);
		this.pacote = pacote;
		pacote.addContrato(this);
	}

	public Integer getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(Integer codContrato) {
		this.codContrato = codContrato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codContrato == null) ? 0 : codContrato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (codContrato == null) {
			if (other.codContrato != null)
				return false;
		} else if (!codContrato.equals(other.codContrato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [codContrato=" + codContrato + ", data=" + data + "]";
	}
}

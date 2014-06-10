package com.leilaopecuario.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "dados_lance_leilao")
public class InformacoesLanceLeilao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "foreign")
	@GenericGenerator(name = "foreign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "leilao") })
	@Column(name = "codigo_leilao")
	private Integer codigoLeilao;

//	@Column(name = "lance_inicial")
//	private Double lanceInicial;

	@Column(name = "quantidade_lances_efetuados")
	private Integer quantidadeLancesEfetuados;

	@Column(name = "lance_vencedor_atual")
	private Double lanceAtual;

	@ManyToOne
	private Usuario usuario;

	@PrimaryKeyJoinColumn
	@OneToOne
	private Leilao leilao;

	public Integer getCodigoLeilao() {
		return codigoLeilao;
	}

	public void setCodigoLeilao(Integer codigoLeilao) {
		this.codigoLeilao = codigoLeilao;
	}


	public Integer getQuantidadeLancesEfetuados() {
		return quantidadeLancesEfetuados;
	}

	public void setQuantidadeLancesEfetuados(Integer quantidadeLancesEfetuados) {
		this.quantidadeLancesEfetuados = quantidadeLancesEfetuados;
	}

	public Double getLanceAtual() {
		return lanceAtual;
	}

	public void setLanceAtual(Double lanceAtual) {
		this.lanceAtual = lanceAtual;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoLeilao == null) ? 0 : codigoLeilao.hashCode());
		result = prime * result + ((lanceAtual == null) ? 0 : lanceAtual.hashCode());
		result = prime * result + ((leilao == null) ? 0 : leilao.hashCode());
		result = prime * result + ((quantidadeLancesEfetuados == null) ? 0 : quantidadeLancesEfetuados.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		InformacoesLanceLeilao other = (InformacoesLanceLeilao) obj;
		if (codigoLeilao == null) {
			if (other.codigoLeilao != null)
				return false;
		} else if (!codigoLeilao.equals(other.codigoLeilao))
			return false;
		if (lanceAtual == null) {
			if (other.lanceAtual != null)
				return false;
		} else if (!lanceAtual.equals(other.lanceAtual))
			return false;
		if (leilao == null) {
			if (other.leilao != null)
				return false;
		} else if (!leilao.equals(other.leilao))
			return false;
		if (quantidadeLancesEfetuados == null) {
			if (other.quantidadeLancesEfetuados != null)
				return false;
		} else if (!quantidadeLancesEfetuados.equals(other.quantidadeLancesEfetuados))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

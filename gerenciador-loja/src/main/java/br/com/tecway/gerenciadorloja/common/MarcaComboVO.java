package br.com.tecway.gerenciadorloja.common;

/**
 * 
 * @author Ricardo Cafalchio
 * @since 26/11/2013
 */
public class MarcaComboVO {

	private Integer codigo;
	private String nome;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}

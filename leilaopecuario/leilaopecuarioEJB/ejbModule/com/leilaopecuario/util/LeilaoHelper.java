package com.leilaopecuario.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.PropertyUtils;

import com.leilaopecuario.entidades.Animal;
import com.leilaopecuario.entidades.Contato;
import com.leilaopecuario.entidades.Empresa;
import com.leilaopecuario.entidades.Endereco;
import com.leilaopecuario.entidades.InformacoesFotos;
import com.leilaopecuario.entidades.InformacoesLanceLeilao;
import com.leilaopecuario.entidades.Leilao;
import com.leilaopecuario.entidades.Usuario;
import com.leilaopecuario.entidades.Vacina;
import com.leilaopecuario.vo.AnimalVO;
import com.leilaopecuario.vo.CaminhoFotoVO;
import com.leilaopecuario.vo.ContatoVO;
import com.leilaopecuario.vo.EmpresaVO;
import com.leilaopecuario.vo.EnderecoVO;
import com.leilaopecuario.vo.InformacoesLancesVO;
import com.leilaopecuario.vo.LeilaoVO;
import com.leilaopecuario.vo.UsuarioVO;
import com.leilaopecuario.vo.VacinaVO;

public class LeilaoHelper {

	public static LeilaoVO copiaLeilaoParaLeilaoVO(Leilao leilao) throws Exception {

		LeilaoVO leilaoVO = null;

		if (leilao != null) {
			leilaoVO = new LeilaoVO();
			leilaoVO.setAnimalVO(LeilaoHelper.copiaAnimalParaAnimalVO(leilao.getAnimal()));
			leilaoVO.setCaminhosFotos(LeilaoHelper.copiaCaminhoFotosParaCaminhoFotosVO(leilao.getCaminhoFotos()));
			leilaoVO.setCodigo(leilao.getCodigo());
			leilaoVO.setDataCadastro(leilao.getDataCadastro());
			leilaoVO.setDataEHoraFinal(leilao.getDataEHoraFinal());
			leilaoVO.setDescricao(leilao.getDescricao());
			leilaoVO.setInformacoesLances(LeilaoHelper.copiaInformacoesLanceLeilaoParaInformacoesLanceLeilaoVO(leilao
					.getInformacoesLanceLeilao()));
			leilaoVO.setLanceInicial(leilao.getLanceInicial());
			leilaoVO.setTitulo(leilao.getTitulo());
			leilaoVO.setUsuarioVO(LeilaoHelper.copiaUsuarioParaUsuarioVO(leilao.getUsuario()));
		}

		return leilaoVO;
	}

	public static UsuarioVO copiaUsuarioParaUsuarioVO(Usuario usuario) throws Exception {
		UsuarioVO usuarioVO = null;
		if (usuario != null) {
			usuarioVO = new UsuarioVO();
			usuarioVO.setCodigo(usuario.getCodigo());
			usuarioVO.setContato(LeilaoHelper.copiaContatoParaContatoVO(usuario.getContato()));
			usuarioVO.setDataNascimento(usuario.getDataNascimento());
			usuarioVO.setEmpresa(LeilaoHelper.copiaContatoParaContatoVO(usuario.getEmpresa()));
			usuarioVO.setEndereco(LeilaoHelper.copiaEnderecoParaEnderecoVO(usuario.getEndereco()));
			usuarioVO.setLogin(usuario.getLogin());
			usuarioVO.setNome(usuario.getNome());
			usuarioVO.setNumeroCpf(usuario.getCpf());
			usuarioVO.setSenha(usuario.getSenha());
		}
		return usuarioVO;
	}

	public static EnderecoVO copiaEnderecoParaEnderecoVO(Endereco endereco) throws Exception {
		EnderecoVO enderecoVO = null;
		if (endereco != null) {
			enderecoVO = new EnderecoVO();
			enderecoVO.setBairro(endereco.getBairro());
			enderecoVO.setCep(endereco.getCep());
			enderecoVO.setCidade(endereco.getCidade());
			enderecoVO.setLogradouro(endereco.getLogradouro());
			enderecoVO.setUf(endereco.getEstado().getUf());
		}
		return null;
	}

	public static EmpresaVO copiaContatoParaContatoVO(Empresa empresa) throws Exception {
		EmpresaVO empresaVO = null;
		if (empresa != null) {
			empresaVO = new EmpresaVO();
			PropertyUtils.copyProperties(empresaVO, empresa);
		}
		return empresaVO;
	}

	public static ContatoVO copiaContatoParaContatoVO(Contato contato) throws Exception {
		ContatoVO contatoVO = null;
		if (contato != null) {
			contatoVO = new ContatoVO();
			PropertyUtils.copyProperties(contatoVO, contato);
		}
		return contatoVO;
	}

	public static InformacoesLancesVO copiaInformacoesLanceLeilaoParaInformacoesLanceLeilaoVO(
			InformacoesLanceLeilao informacoesLanceLeilao) throws Exception {

		InformacoesLancesVO informacoesLancesVO = null;

		if (informacoesLanceLeilao != null) {
			informacoesLancesVO = new InformacoesLancesVO();
			informacoesLancesVO.setLanceAtual(informacoesLanceLeilao.getLanceAtual());
			informacoesLancesVO.setQuantidadeLancesEfetuados(informacoesLanceLeilao.getQuantidadeLancesEfetuados());
		}

		return informacoesLancesVO;
	}

	public static CaminhoFotoVO copiaCaminhoFotosParaCaminhoFotosVO(InformacoesFotos caminhoFotos) throws Exception {

		CaminhoFotoVO caminhoFotoVO = null;

		if (caminhoFotos != null) {
			caminhoFotoVO = new CaminhoFotoVO();
			PropertyUtils.copyProperties(caminhoFotoVO, caminhoFotos);
		}
		return caminhoFotoVO;
	}

	public static AnimalVO copiaAnimalParaAnimalVO(Animal animal) throws Exception {

		AnimalVO animalVO = null;

		if (animal != null) {
			animalVO = new AnimalVO();
			animalVO.setIdadeMeses(animal.getIdadeMeses());
			animalVO.setLocalidadeCriacao(animal.getLocalidadeCriacao());
			animalVO.setRaca(animal.getRaca());
			for (Vacina vacina : animal.getVacinas()) {
				animalVO.getVacinas().add(LeilaoHelper.copiaVacinaParaVacinaVO(vacina));
			}
		}
		return animalVO;
	}

	public static VacinaVO copiaVacinaParaVacinaVO(Vacina vacina) throws Exception {

		VacinaVO vacinaVO = null;

		if (vacina != null) {
			vacinaVO = new VacinaVO();
			vacinaVO.setCodigoVacina(vacina.getCodigoVacina());
			vacinaVO.setDescricaoVacina(vacina.getDescricaoVacina());
			vacinaVO.setNomeVacina(vacina.getNomeVacina());
			vacinaVO.setSigla(vacina.getSigla());
		}
		return vacinaVO;
	}
	
	/**
	 * Faz o parse de uma string para data
	 * 
	 * @param stringDt
	 *            String a transformar em data
	 * @param formato
	 *            Formato que ser� utilizado
	 * 
	 * @return java.util.Date Data parseada
	 */
	public static java.util.Date parseDateUtil(final String stringDt, final String formato) {

		try {
			if (stringDt == null || stringDt.trim().equals("")) {
				return null;
			}
			final DateFormat dateFormat = new SimpleDateFormat(formato);
			return dateFormat.parse(stringDt.trim());
		} catch (final Exception e) {
			return null;
		}
	}

}

package br.com.leilaopecuario.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.leilaopecuario.constantes.ConstantesMensagens;
import com.leilaopecuario.vo.LeilaoVO;
import com.leilaopecuario.vo.UsuarioVO;

@ManagedBean
@SessionScoped
public class ControladorLoginBean {

	private final static Logger LOGGER = Logger.getLogger(ControladorLoginBean.class);

	private UsuarioVO usuario = null;
	private LeilaoVO leilaoVO = null;

	public String logout() {

		String retorno = "";

		try {
			FacesContext.getCurrentInstance().addMessage("msg_cadastro",
					new FacesMessage(FacesMessage.SEVERITY_INFO, ConstantesMensagens.INFO_LOGOUT, ""));
			retorno = "index";
		} catch (Exception e) {
			LOGGER.error("Erro ao fechar a sess�o.");
		}finally{
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		}

		return retorno;
	}

	public UsuarioVO getUsuario() {
		if (this.usuario == null) {
			HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			this.usuario = (UsuarioVO) httpSession.getAttribute("usuario");
		}
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public LeilaoVO getLeilaoVO() {
		return leilaoVO;
	}

	public void setLeilaoVO(LeilaoVO leilaoVO) {
		this.leilaoVO = leilaoVO;
	}

}

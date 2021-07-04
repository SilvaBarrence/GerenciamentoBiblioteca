package com.apirest.bibliotecavirtual.config.validacao;

public class ErroDeCadastro {
	private String campo;
	private String erro;

	public ErroDeCadastro(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}

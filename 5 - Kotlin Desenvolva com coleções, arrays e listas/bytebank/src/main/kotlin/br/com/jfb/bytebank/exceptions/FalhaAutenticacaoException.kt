package br.com.jfb.bytebank.exceptions

class FalhaAutenticacaoException(
  mensagem: String = "Falha na autenticação"
) : Exception(mensagem)
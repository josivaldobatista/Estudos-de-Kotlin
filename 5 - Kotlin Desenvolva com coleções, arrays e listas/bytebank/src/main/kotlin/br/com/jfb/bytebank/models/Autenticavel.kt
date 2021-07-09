package br.com.jfb.bytebank.models

interface Autenticavel {

  fun autentica(senha: Int): Boolean
}
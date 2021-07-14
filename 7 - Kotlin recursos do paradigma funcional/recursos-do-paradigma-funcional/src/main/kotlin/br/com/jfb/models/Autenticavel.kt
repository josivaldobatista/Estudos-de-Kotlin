package br.com.jfb.models

interface Autenticavel {

    fun autentica(senha: Int): Boolean
}
package com.example.ecommerceccca

import org.springframework.stereotype.Component

@Component
class ValidateCPF {
    fun validate(originalCPF: String? = null): Boolean {
        originalCPF ?: return false.also { println("CPF nulo") }
        val cpf = originalCPF.replace(".", "").replace("-", "").also { println(it) }

        if (cpf.length != 11) {
            return false.also { println("Numeros de digitos diferente de 11") }
        }

        if (cpf[0] == cpf[1] && cpf[1] == cpf[2] && cpf[2] == cpf[3] && cpf[3] == cpf[4] && cpf[4] == cpf[5] && cpf[5] == cpf[6] && cpf[6] == cpf[7] && cpf[7] == cpf[8]) {
            return false.also { println("Todos os digitos sao iguais") }
        }

        return if (validateDigit1(cpf)) {
            validateDigit2(cpf)
        } else false

    }

    private fun validateDigit1(cpf: String): Boolean {
        var count = 10
        var dv1sum = 0
        for (n in cpf.toIntSublist(count - 1)) {
            dv1sum += n * count
            count -= 1
        }
        var resto = (dv1sum * 10) % 11
        if (resto == 10) {
            resto = 0
        }
        return resto == cpf[9].digitToInt()
    }

    private fun validateDigit2(cpf: String): Boolean {
        var count = 11
        var dv2sum = 0
        for (n in cpf.toIntSublist(count - 1)) {
            dv2sum += n * count
            count -= 1
        }
        var resto = (dv2sum * 10) % 11
        if (resto == 10) {
            resto = 0
        }
        return resto == cpf[10].digitToInt()
    }

    private fun String.toIntSublist(end: Int = 1) = this.map { it.digitToInt() }.subList(0, end)
}
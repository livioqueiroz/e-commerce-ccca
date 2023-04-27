package com.example.ecommerceccca

class ValidateCPF {
    fun validate(originalCPF: String?): Boolean {
        originalCPF?.let {
            val cpf = originalCPF.replace(".", "").replace("-", "").also { println(it) }
            if (cpf[0] == cpf[1] && cpf[1] == cpf[2] && cpf[2] == cpf[3] && cpf[3] == cpf[4] && cpf[4] == cpf[5] && cpf[5] == cpf[6] && cpf[6] == cpf[7] && cpf[7] == cpf[8]) {
                return false.also { println("Todos os digitos sao iguais")  }
            }
            if (cpf.length == 11) {
                val dv1 = cpf.get(9).digitToInt().also { print(it) }
                val dv2 = cpf.get(10).digitToInt().also { println(it) }
                val cpfArray = cpf.map { it.digitToInt() }.also { println("cpf list $it") }
                //verificando dv1
                var count = 10
                var dv1sum = 0
                for (n in cpfArray.subList(0, 9)) {
                    print("sum: $dv1sum + $n*$count = ")
                    dv1sum += n * count
                    count -= 1
                    println(dv1sum)
                }
                var resto = (dv1sum * 10) % 11
                println(resto)
                if (resto == 10 || resto == 11) {
                    resto = 0
                    println(resto)
                }

                if (resto != dv1) {
                    return false
                }
                //dv2
                count = 11
                var dv2sum = 0
                for (n in cpfArray.subList(0, 10)) {
                    print("sum2: $dv2sum + $n*$count = ")
                    dv2sum += n * count
                    count -= 1
                    println(dv2sum)
                }
                resto = (dv2sum * 10) % 11
                println(resto)
                if (resto == 10 || resto == 11) {
                    resto = 0
                    println(resto)
                }
                if (resto != dv2) {
                    return false
                } else return true
            } else return false.also { println("nao tem 11 digitos") }
        } ?: return false.also { println("cpf nulo") }
    }
}
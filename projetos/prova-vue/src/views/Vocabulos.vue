<template>
  <h1> Ola </h1>
    <div>
        <h4>CADASTRAR NOVO VOCÁBULO</h4>
        <div class="formulario">
            <div class="input-box">
                <label for="termo">Termo</label>
                <input type="text" name="termo" v-model="termo">
            </div>
            <div class="input-box">
                <label for="significado">Significado</label>
                <input type="text" name="significado" v-model="significado">
            </div>
            <div class="input-box">
                <label for="significado">Versão</label>
                <input type="number" name="significado" v-model="versao">
            </div>
            <div class="formulario-action">
                <button @click="cadastrar()">Cadastrar</button>
            </div>
        </div>
        <div>
            <div class="input-box">
                    <label for="significado">Termo</label>
                    <input type="text" name="significado" v-model="termo">
            </div>
            <div class="formulario-action">
                    <button @click="buscarTermo()">Buscar</button>
            </div>
            <h4>TODOS OS VOCÁBULOS</h4>
            <div v-if="!erro" class="todos">
                <table>
                    <thead>
                        <td>ID</td>
                        <td>TERMO</td>
                        <td>VERSÃO</td>
                        <td>SIGNIFICADO</td>
                    </thead>
                    <tbody>
                        <tr v-for="voc in vocabulos">
                            <td>{{ voc.id }}</td>
                            <td>{{ voc.termo }}</td>
                            <td>{{ voc.versao }}</td>
                            <td>{{ voc.significado }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div v-else="erro" class="todos">
                <p>{{ erro }}</p>
                <div>
                    <button @click="atualizar()">Retornar</button>
                </div>
            </div>

        </div>
    </div>
</template>


<script setup lang="ts">

import { onMounted, ref} from 'vue';
import axios from 'axios';

const vocabulos = ref([]);

const termo = ref("");
const significado = ref();
const versao = ref();
const erro = ref();

async function atualizar() {

     try {                                  // COLOCAR URL DO GITPOD SERVIDOR SPRING //
        vocabulos.value = (await axios.get("http://localhost:8080/vocabulo")).data;
    }
    catch (ex) {
        alert('DEU RUIM!!')
        erro.value = (ex as Error).message;
    }

}


async function buscarTermo() {
    try {                      
        console.log(termo.value)
                    // COLOCAR URL DO GITPOD SERVIDOR SPRING //
        vocabulos.value = (await axios.get(`http://localhost:8080/vocabulo/termo/${termo.value}`)).data;
        console.log(vocabulos)
    }
    catch (ex) {
        alert('DEU RUIM!!')
        erro.value = "Nenhum vocábulo foi encontrado para os critérios fornecidos";
    }

}



async function cadastrar(){
  try {
    
        await axios.post("http://localhost:8080/vocabulo",
    {
        termo: termo.value,
        significado: significado.value,
        versao: versao.value
    });
    
    alert("cadastrado");

    termo.value = '';
    significado.value = '';
    versao.value = '';


    } catch (e) {
        erro.value = (e as Error).message
    }
  atualizar();
}



onMounted(() => {
    atualizar();
})

</script>